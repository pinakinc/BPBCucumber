package stepdefinitions;

import cucumber.api.java.en.Then;
import pageobjects.Homepage;
import pageobjectspf.HomepagePF;

public class HomePageStepDefPF {
	HomepagePF homePagePF = new HomepagePF();
	@Then("^The user should be shown \"(.*?)\" on top left corner$")
	public void user_should_be_shown_User_Name_on_top_left_corner(String userDisplayText) throws Throwable {
		System.out.println("UserName verified");
		homePagePF.verifyUser(userDisplayText);
	}
	
	

}
