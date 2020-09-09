package pageobjectspf;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import locators.LandingPageLocators;
import locators.LoginPageLocators;
import pageobjects.AbstractBasePage;
import singletondriver.SingletonDriver;

public class LoginPagePF extends AbstractBasePage{
	LoginPageLocators loginpageLocators;
	
	public LoginPagePF() {
		super();
		this.loginpageLocators = new LoginPageLocators();
		PageFactory.initElements(SingletonDriver.getInstance().getDrvr(), loginpageLocators);
	}

	public void enterUserName(String userName) {
		loginpageLocators.email.sendKeys(userName);
	}
	public void enterPassword(String passwordtxt) {
		loginpageLocators.password.sendKeys(passwordtxt);
	}
	public void clickLogin() {
		loginpageLocators.btnLogin.click();
	}
	@Override
	public void setPageTitle(String pageTitle) {
		this.pageTitle = pageTitle;
		
	}
	@Override
	public String getPageTitle() {
		return this.pageTitle;
	}
}
