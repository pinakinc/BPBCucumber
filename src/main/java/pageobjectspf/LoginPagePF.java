package pageobjectspf;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;

import locators.LoginPageLocators;
import singletondriver.SingletonDriver;
import utils.LoggerUtil;

public class LoginPagePF extends AbstractBasePagePF{
	Logger logger = LoggerUtil.getCustomLogger(LoginPagePF.class);
	LoginPageLocators loginpageLocators;
	
	public LoginPagePF() {
		super();
		loginpageLocators = new LoginPageLocators();
		PageFactory.initElements(SingletonDriver.getInstance().getDrvr(), loginpageLocators);
	}

	public void enterUserName(String userName) {
		logger.info("Entering username");
		loginpageLocators.email.sendKeys(userName);
	}
	public void enterPassword(String passwordtxt) {
		logger.info("Entering password");
		loginpageLocators.password.sendKeys(passwordtxt);
	}
	public void clickLogin() {
		logger.info("Clicking Login button on Login screen");
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
