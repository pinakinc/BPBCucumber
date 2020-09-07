package stepdefinitions;

import cucumber.api.java.en.Then;
import pageobjects.Homepage;

public class HomePageStepDef {
	Homepage homePage = new Homepage();
	@Then("^User should be shown \"(.*?)\" on top left corner$")
	public void user_should_be_shown_User_Name_on_top_left_corner(String userDisplayText) throws Throwable {
		System.out.println("UserName verified");
		homePage.verifyUser(userDisplayText);
	}
	
	

}
