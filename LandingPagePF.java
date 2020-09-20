package pageobjectspf;


import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;

import locators.LandingPageLocators;
import singletondriver.SingletonDriver;
import utils.LoggerUtil;

public class LandingPagePF extends AbstractBasePagePF{
	
	Logger logger = LoggerUtil.getCustomLogger(LandingPagePF.class);
	
	LandingPageLocators landingpageLocators;
	
	
	
	public LandingPagePF() {
		super();
		landingpageLocators = new LandingPageLocators();
		PageFactory.initElements(SingletonDriver.getInstance().getDrvr(), landingpageLocators);
	}

	public void clickLogin() {
		logger.info("Clicking Login button on Landing page");
		landingpageLocators.btnLogin.click();
		
	}

	@Override
	public void setPageTitle(String pageTitle) {
		this.pageTitle=pageTitle;
		
	}

	@Override
	public String getPageTitle() {
		// TODO Auto-generated method stub
		return this.pageTitle;
	}
}
