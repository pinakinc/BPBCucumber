package pageobjects;

import org.openqa.selenium.By;

import singletondriver.SingletonDriver;

public class LoginPage extends AbstractBasePage{
	By email = By.name("email");
	By password = By.name("password");
	By btnLogin = By.xpath("//div[text()='Login']");
	public void enterUserName(String userName) {
		SingletonDriver.getInstance().getDrvr().findElement(email).sendKeys(userName);
	}
	public void enterPassword(String passwordtxt) {
		SingletonDriver.getInstance().getDrvr().findElement(password).sendKeys(passwordtxt);
	}
	public void clickLogin() {
		SingletonDriver.getInstance().getDrvr().findElement(btnLogin).click();
		//return new Homepage();
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
