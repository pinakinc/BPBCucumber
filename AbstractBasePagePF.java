package pageobjects;

import constants.GLOBAL_DATA;
import pageobjectspf.LandingPagePF;
import singletondriver.SingletonDriver;

public abstract class AbstractBasePagePF {
	protected String pageTitle; 
	
	 
	public LandingPagePF navigateURL() {
		SingletonDriver.getInstance().getDrvr().navigate().to(GLOBAL_DATA.URL);
		return new LandingPagePF();
	}

	public void openBrowser(String browserName, String platform, String gridSetting) {
		try {
			SingletonDriver.getInstance().setDrvr(browserName, platform, gridSetting, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public abstract void setPageTitle(String pageTitle);
	public abstract String getPageTitle();

}
