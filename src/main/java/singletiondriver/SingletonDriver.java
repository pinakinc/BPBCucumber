package singletondriver;

import java.io.FileInputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import constants.GLOBAL_DATA;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SingletonDriver {
	    // local variables are initialized
	    private static SingletonDriver instance = null;
	    private static final int IMPLCT_TIMEOUT = 60;

	    private ThreadLocal<WebDriver> webDriver =
	        new ThreadLocal<WebDriver>();
	    private ThreadLocal<String> sessId =
	        new ThreadLocal<String>();
	    private ThreadLocal<String> sBrwsr =
	        new ThreadLocal<String>();
	    private ThreadLocal<String> sPltfrm =
	        new ThreadLocal<String>();
	    private ThreadLocal<String> sVrsn =
	        new ThreadLocal<String>();

	    private String getEnv = null;
	    private Properties props = new Properties();
		private String remoteHubURL="http://192.168.0.20:4444/wd/hub";

	    // Private constructor in order to block instantiation of this class from outside
	    private SingletonDriver() {
	    }

	    /**
	     * getInstance method will fetch the active driver instance
	     *
	     * @return SingletoDriver
	     */
	    public static SingletonDriver getInstance() {
	        if ( instance == null ) {
	            instance = new SingletonDriver();
	        }

	        return instance;
	    }

	    /**
	     * setDrvr method to create driver instance
	     *
	     * @param browser
	     * @param environment
	     * @param platform
	     * @param optPreferences
	     * @throws Exception
	     */
	    @SafeVarargs
	    public final void setDrvr(String brwsr,
	                                String pltfrm,
	                                String envrnmnt,
	                                Map<String, Object>... optPrefs)
	                                throws Exception {

	        DesiredCapabilities caps = null;
	        String getPltfrm = null;
	        
	        props.load(new FileInputStream(GLOBAL_DATA.SE_PROPRTS));

	        switch (brwsr) {
	            case "firefox":
	                caps = DesiredCapabilities.firefox();

	                FirefoxOptions ffOpts = new FirefoxOptions();
	                FirefoxProfile ffProfile = new FirefoxProfile();

	                ffProfile.setPreference("browser.autofocus",
	                                         true);
	                ffProfile.setPreference("browser.tabs.remote.autostart.2", false);

	                caps.setCapability(FirefoxDriver.PROFILE,
	                                   ffProfile);
	                caps.setCapability("marionette",
	                                    true);

	                // then pass them to the local WebDriver
	                if ( envrnmnt.equalsIgnoreCase("local") ) {
	                	WebDriverManager.firefoxdriver().setup();
	                    webDriver.set(new 
	                    FirefoxDriver(ffOpts.merge(caps)));
	                }

	                break;
	            case "chrome":
	                caps = DesiredCapabilities.chrome();

	                ChromeOptions chOptions = new ChromeOptions();
	                Map<String, Object> chromePrefs =
	                    new HashMap<String, Object>();

	                chromePrefs.put("credentials_enable_service",
	                                 false);

	                chOptions.setExperimentalOption("prefs",
	                                                 chromePrefs);

	                chOptions.addArguments("--disable-plugins",
	                                       "--disable-extensions",
	                                       "--disable-popup-blocking");

	                caps.setCapability(ChromeOptions.CAPABILITY,
	                                   chOptions);
	                caps.setCapability("applicationCacheEnabled",
	                                    false);

	                if ( envrnmnt.equalsIgnoreCase("local") ) {
	                	WebDriverManager.chromedriver().setup();
	                    webDriver.set(new 
	                    ChromeDriver(chOptions.merge(caps)));
	                } 

	                break;
	            case "internet explorer":
	                caps = DesiredCapabilities.internetExplorer();

	                InternetExplorerOptions ieOpts =
	                    new InternetExplorerOptions();

	                ieOpts.requireWindowFocus();
	                ieOpts.merge(caps);

	                caps.setCapability("requireWindowFocus",
	                                    true);

	                if ( envrnmnt.equalsIgnoreCase("local") ) {
	                	WebDriverManager.iedriver().setup();
	                    webDriver.set(new InternetExplorerDriver(
	                                  ieOpts.merge(caps)));
	                }

	                break;
	        }
	        
	        if ( envrnmnt.equalsIgnoreCase("grid") ) {
	        	webDriver.set(new RemoteWebDriver(new URL(remoteHubURL),caps));
            }


	        getEnv = envrnmnt;
	        getPltfrm = pltfrm;

	        sessId.set(((RemoteWebDriver) webDriver.get())
	        .getSessionId().toString());

	        sBrwsr.set(caps.getBrowserName());
	        sVrsn.set(caps.getVersion());
	        sPltfrm.set(getPltfrm);

	        System.out.println("\n*** THE TEST ENVIRONMENT DETAILS ARE "
	                + getSessBrwsr().toUpperCase()
	                + "||" + getSessPltfrm().toUpperCase()
	                + "||" + getEnv.toUpperCase()
	                + "||Selenium Version is"
	                + props.getProperty("selenium.revision")
	                + "||Session ID="
	                + getSessId()
	                + "\n");

	        getDrvr().manage().timeouts().implicitlyWait(
	            IMPLCT_TIMEOUT, TimeUnit.SECONDS);
	        getDrvr().manage().window().maximize();
	    }

	    /**
	     * getDriver method to fetch active driver
	     *
	     * @return WebDriver
	     */
	    public WebDriver getDrvr() {
	        return webDriver.get();
	    }

	    /**
	     * closeDriver method to close active driver instance
	     *
	     */
	    public void closeDriver() {
	        try {
	            getDrvr().quit();
	        }

	        catch ( Exception e ) {
	            // do something
	        }
	    }

	    /**
	     * getSessionId method to retrieve active id
	     *
	     * @return String
	     * @throws Exception
	     */
	    public String getSessId() throws Exception {
	        return sessId.get();
	    }

	    /**
	     * getSessionBrowser method to retrieve active browser
	     * @return String
	     * @throws Exception
	     */
	    public String getSessBrwsr() throws Exception{
	        return sBrwsr.get();
	    }

	    /**
	     * getSessionVersion method to retrieve active version
	     *
	     * @return String
	     * @throws Exception
	     */
	    public String getSessVrsn() throws Exception {
	        return sVrsn.get();
	    }

	    /**
	     * getSessionPlatform method to retrieve active platform
	     * @return String
	     * @throws Exception
	     */
	    public String getSessPltfrm() throws Exception {
	        return sPltfrm.get();
	    }

	}

