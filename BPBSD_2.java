import java.util.List;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BPBSD_2 {
	
	@Then("^Verify that following users are able to Login$")
	public void verify_that_following_users_are_able_to_Login(DataTable loginDetails) throws Throwable {
		  List<List<String>> loginData = loginDetails.raw();
		  for (int i=1;i<loginData.size();i++) {
			  System.out.println("The usernames in the data table are "+loginData.get(i).get(0));
		  }
		}

	}





