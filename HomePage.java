package pageobjects;

import org.openqa.selenium.By;
import org.testng.Assert;

import singletondriver.SingletonDriver;

public class Homepage {

	By userDisplay = By.xpath("//span[@class='user-display']");
	
	public void verifyUser(String userDisplayText) {
		Assert.assertEquals(SingletonDriver.getInstance().getDrvr().findElement(userDisplay), userDisplayText);
	}
}
