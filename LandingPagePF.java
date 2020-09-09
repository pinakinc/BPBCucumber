package pageobjectspf;


import org.openqa.selenium.support.PageFactory;

import locators.LandingPageLocators;
import singletondriver.SingletonDriver;

public class LandingPagePF extends AbstractBasePagePF{
	
	LandingPageLocators landingpageLocators;
	
	
	
	public LandingPagePF() {
		super();
		landingpageLocators = new LandingPageLocators();
		PageFactory.initElements(SingletonDriver.getInstance().getDrvr(), landingpageLocators);
		System.out.println("After init");
	}

	public void clickLogin() {
		System.out.println("Before click"+this.landingpageLocators.btnLogin.getText());
		landingpageLocators.btnLogin.click();
		System.out.println("After click");
	}

	@Override
	public void setPageTitle(String pageTitle) {
		this.pageTitle=pageTitle;
		
	}

	@Override
	public String getPageTitle() {
		// TODO Auto-generated method stub
		return this.pageTitle;
	}
}
