
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BPB_1{
	@Before
	public void setUp() {
		System.out.println("Before  any of the methods");
	}
	
	@After
	public void tearDown() {
		System.out.println("After all methods");
	}

	
	@Given("^User (?:navigates|goes) to the login page$")
	public void user_navigates_to_the_login_page() throws Throwable {
		System.out.println("Navigated to Login Page");
	}

	@When("^User enters \"(.*?)\" as username$")
	public void user_enters_admin_as_username(String userName) throws Throwable {
		System.out.println("UserName is: "+userName);
	}

	@And("^User enters \"(.*?)\" as password$")
	public void user_enters_admin_as_password(String password) throws Throwable {
		System.out.println("Password is: "+password);
	}

	@And("^User enters (\\d+) as pin$")
	public void user_enters_as_password(int pin) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Pin is: "+pin);
	}
	@And("^User clicks the Login button$")
	public void user_clicks_the_Login_button() throws Throwable {
		System.out.println("Login button clicked");
	}

	@Then("^User should be shown User Name on top left corner$")
	public void user_should_be_shown_User_Name_on_top_left_corner() throws Throwable {
		System.out.println("UserName verified");
	}



}
