package stepdefinitions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import constants.GLOBAL_DATA;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import singletondriver.SingletonDriver;
import utils.CucumberCustomReporter;
import utils.GenericHelper;

public class BPBSD_00 extends BaseSteps{
/*	@Given("^I open the \"([^\"]*)\" browser on \"([^\"]*)\" and \"([^\"]*)\"$")
	public void i_open_the_browser(String browserName, String platform, String gridSetting) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		try {
			SingletonDriver.getInstance().setDrvr(browserName, platform, gridSetting, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
*/
//	private static CucumberCustomReporter cucumberCustomReporter;
//	private static boolean isReportRunning;
//	private static GenericHelper genericHelper = new GenericHelper();
	@Before
	public void setUp(Scenario scenario) {
		System.out.println("Before  any of the methods");
		if(!isReportRunning) {
			cucumberCustomReporter=new CucumberCustomReporter("D:\\Data\\Log\\TestReport.html");
			isReportRunning = true;
		}
	}
	
/*	@After
	public void tearDown(Scenario scenario) throws IOException {
		System.out.println("After all methods");
		File screenPrint = null;
		String screenshotName = "D:\\Data\\Log\\"+scenario.getName().replaceAll(" ", "")+".jpeg";
		System.out.println(screenshotName);
		if (scenario.isFailed()){
			//screenPrint=((TakesScreenshot)SingletonDriver.getInstance().getDrvr()).getScreenshotAs(OutputType.FILE);
			genericHelper.takeScreenShot(screenshotName);
			
			//Added on 28-SEPT-2020
			byte[] screenPrint1 = ((TakesScreenshot)SingletonDriver.getInstance().getDrvr()).getScreenshotAs(OutputType.BYTES);
			scenario.embed(screenPrint1, "image/png");
			try {
				if (!(SingletonDriver.getInstance().getSessId()==null)) {
				SingletonDriver.getInstance().getDrvr().close();
				SingletonDriver.getInstance().getDrvr().quit();
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
			
		} else {
			try {
				if (!(SingletonDriver.getInstance().getSessId()==null)) {
				SingletonDriver.getInstance().getDrvr().close();
				SingletonDriver.getInstance().getDrvr().quit();
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//Added on 28-SEPT-2020
		}
//		FileUtils.copyFile(screenPrint, new File(screenshotName));
		cucumberCustomReporter.createTest(scenario, screenshotName);
		cucumberCustomReporter.writeReport();
		
	}
*/

}
