package pageobjectspf;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import cucumber.api.java.After;
import locators.HomepageLocators;
import singletondriver.SingletonDriver;

public class HomepagePF extends AbstractBasePagePF{

	HomepageLocators homepageLocators;
	
	public HomepagePF() {
		super();
		homepageLocators = new HomepageLocators();
		PageFactory.initElements(SingletonDriver.getInstance().getDrvr(), homepageLocators);
	}

	
	public HomepagePF verifyUser(String userDisplayText) {
		Assert.assertEquals(homepageLocators.userDisplay.getText(), userDisplayText);
		return new HomepagePF();
	}
	
	public void logOut() {
		homepageLocators.logOutDiv.click();
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
