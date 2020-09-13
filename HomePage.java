package pageobjects;

import org.openqa.selenium.By;
import org.testng.Assert;

import cucumber.api.java.After;
import singletondriver.SingletonDriver;

public class Homepage extends AbstractBasePage{

	By userDisplay = By.xpath("//span[@class='user-display']");
	By logOutDiv = By.xpath("//div[@role='listbox']");
	By logOutSpan = By.xpath("//span[text()='Log Out']");
	
	public void verifyUser(String userDisplayText) {
		System.out.println(SingletonDriver.getInstance().getDrvr().findElement(userDisplay).getText());
		Assert.assertEquals(SingletonDriver.getInstance().getDrvr().findElement(userDisplay).getText(), userDisplayText);
	}
	
//	@After
//	public void logOut() {
//		SingletonDriver.getInstance().getDrvr().findElement(logOutDiv).click();
//		SingletonDriver.getInstance().getDrvr().findElement(logOutSpan).click();
//		SingletonDriver.getInstance().getDrvr().close();
//		SingletonDriver.getInstance().getDrvr().quit();
//	}

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
