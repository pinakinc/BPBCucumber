package stepdefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import pageobjects.LandingPage;
import pageobjects.LoginPage;
import singletondriver.SingletonDriver;

public class ParentStepDef {
	
	LandingPage landingPage;
	LoginPage loginPage;
	@Given("^User navigates to the landing page$")
	public void user_navigates_to_the_landing_page() throws Throwable {
		landingPage = new LandingPage();
		landingPage = landingPage.navigateURL();
	}
	
	@And("^clicks the Login button on the landing page$")
	public void clicks_the_Login_button_on_the_landing_page() throws Throwable {
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

}
