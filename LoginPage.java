package pageobjects;

import org.openqa.selenium.By;

import singletondriver.SingletonDriver;

public class LoginPage {
	By email = By.name("email");
	By password = By.name("password");
	By btnLogin = By.xpath("//div[text()='Login']");
	public void enterUserName(String userName) {
		SingletonDriver.getInstance().getDrvr().findElement(email).sendKeys(userName);
	}
	public void enterPassword(String password) {
		SingletonDriver.getInstance().getDrvr().findElement(email).sendKeys(password);
	}
	public Homepage clickLogin() {
		SingletonDriver.getInstance().getDrvr().findElement(btnLogin).click();
		return new Homepage();
	}
}
