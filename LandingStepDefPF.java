package stepdefinitions;

import constants.GLOBAL_DATA;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import pageobjects.LandingPage;
import pageobjectspf.LandingPagePF;

public class LandingStepDefPF {
	
	LandingPagePF landingPagePF = new LandingPagePF();
	
	@Given("^The user opens the \"([^\"]*)\" browser on \"([^\"]*)\" and \"([^\"]*)\"$")
	public void i_open_the_browser_on_and(String browser, String platform, String gridSetting) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		//SingletonDriver.getInstance().setDrvr(browser, platform, gridSetting);
		landingPagePF.openBrowser(browser, platform, gridSetting);
	}

	@When("^The user navigates to the landing page$")
	public void user_navigates_to_the_landing_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
//		SingletonDriver.getInstance().getDrvr().get(GLOBAL_DATA.URL);
		landingPagePF = landingPagePF.navigateURL();
	}

	
	@When("^The user clicks the Login button on the landing page$")
	public void The_user_clicks_the_Login_button_on_the_landing_page() throws Throwable {
	    landingPagePF.clickLogin();
	}

}
