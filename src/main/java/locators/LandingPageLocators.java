package locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LandingPageLocators {

	@FindBy(how=How.XPATH,using="//a[@href='https://ui.freecrm.com']")
	public  WebElement btnLogin;
	

}
