package stepdefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageobjects.Homepage;
import pageobjects.LandingPage;
import pageobjects.LoginPage;
import singletondriver.SingletonDriver;

public class ParentStepDef {
	
	LandingPage landingPage;
	LoginPage loginPage;
	Homepage homePage;
	@Given("^User navigates to the landing page$")
	public void user_navigates_to_the_landing_page() throws Throwable {
		landingPage = new LandingPage();
		landingPage = landingPage.navigateURL();
	}
	
	@And("^clicks the Login button on the landing page$")
	public void clicks_the_Login_button_on_the_landing_page() throws Throwable {
		Thread.sleep(10000);
		loginPage = landingPage.clickLogin();
	}
	@And("^User enters \"(.*?)\" as username$")
	public void user_enters_admin_as_username(String userName) throws Throwable {
		System.out.println("UserName is: "+userName);
		loginPage.enterUserName(userName);
		
	}

	@And("^User enters \"(.*?)\" as password$")
	public void user_enters_admin_as_password(String password) throws Throwable {
		System.out.println("Password is: "+password);
		loginPage.enterPassword(password);
	}
	
	@And("^User clicks the Login button$")
	public void user_clicks_the_Login_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    homePage=loginPage.clickLogin();
	}
	
	@Then("^User should be shown User Name on top left corner$")
	public void user_should_be_shown_User_Name_on_top_left_corner() throws Throwable {
		System.out.println("UserName verified");
		homePage.verifyUser("Pinakin Chaubal");
		
	}
}
