package pageobjectspf;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import cucumber.api.java.After;
import locators.HomepageLocators;
import singletondriver.SingletonDriver;
import utils.LoggerUtil;

public class HomepagePF extends AbstractBasePagePF{
	
	Logger logger = LoggerUtil.getCustomLogger(HomepagePF.class);

	HomepageLocators homepageLocators;
	
	public HomepagePF() {
		super();
		homepageLocators = new HomepageLocators();
		PageFactory.initElements(SingletonDriver.getInstance().getDrvr(), homepageLocators);
	}

	
	public HomepagePF verifyUser(String userDisplayText) {
		logger.info("Verifying user text");
		Assert.assertEquals(homepageLocators.userDisplay.getText(), userDisplayText);
		return new HomepagePF();
	}
	
	public void logOut() {
		logger.info("Clicking Logout Div");
		homepageLocators.logOutDiv.click();
		logger.info("Clicking Logout Span");
		homepageLocators.logOutSpan.click();

	}

	@Override
	public void setPageTitle(String title) {
		this.pageTitle=pageTitle;
		
	}

	@Override
	public String getPageTitle() {
		// TODO Auto-generated method stub
		return this.pageTitle;
	}
}
