package stepdefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import pageobjects.LoginPage;
import pageobjectspf.LoginPagePF;
import utils.ExtentTstClass;

public class LoginStepDefPF {
	
	LoginPagePF loginPagePF = new LoginPagePF();
	@When("^The user enters \"(.*?)\" as username$")
	public void user_enters_admin_as_username(String userName) throws Throwable {
		System.out.println("UserName is: "+userName);
		ExtentTstClass.logInfo("UserName: "+userName);
		loginPagePF.enterUserName(userName);
	}

	@And("^The user enters \"(.*?)\" as password$")
	public void user_enters_admin_as_password(String password) throws Throwable {
		System.out.println("Password is: "+password);
		ExtentTstClass.logInfo("Password: "+password);
		loginPagePF.enterPassword(password);
	}

	@And("^The user clicks the Login button$")
	public void user_clicks_the_Login_button() throws Throwable {
		System.out.println("Login button clicked");
		ExtentTstClass.logInfo("Clicking Login");
		loginPagePF.clickLogin();
	}

}
