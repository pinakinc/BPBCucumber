package locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomepageLocators {

	@FindBy(how=How.XPATH,using="//span[@class='user-display']")
	public WebElement userDisplay;
	@FindBy(how=How.XPATH,using="//div[@role='listbox']")
	public WebElement logOutDiv;
	@FindBy(how=How.XPATH,using="//span[text()='Log Out']")
	public WebElement logOutSpan;
	

}
