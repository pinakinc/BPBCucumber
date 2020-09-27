package locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPageLocators {

	@FindBy(name="email")
	public WebElement email;
	@FindBy(name="password")
	public WebElement password;
	@FindBy(how=How.XPATH,using="//div[text()='Login']")
	public WebElement btnLogin;

}
