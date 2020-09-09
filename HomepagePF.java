package pageobjectspf;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import cucumber.api.java.After;
import locators.HomepageLocators;
import locators.LandingPageLocators;
import locators.LoginPageLocators;
import pageobjects.AbstractBasePage;
import singletondriver.SingletonDriver;

public class HomepagePF extends AbstractBasePagePF{

	HomepageLocators homepageLocators;
	
	public HomepagePF() {
		super();
		homepageLocators = new HomepageLocators();
		PageFactory.initElements(SingletonDriver.getInstance().getDrvr(), homepageLocators);
	}

	
	public void verifyUser(String userDisplayText) {
		System.out.println(homepageLocators.userDisplay.getText());
		Assert.assertEquals(homepageLocators.userDisplay.getText(), userDisplayText);
	}
	
	//@After
	public void logOut() {
		homepageLocators.logOutDiv.click();
		homepageLocators.logOutSpan.click();
		SingletonDriver.getInstance().getDrvr().close();
		SingletonDriver.getInstance().getDrvr().quit();
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
