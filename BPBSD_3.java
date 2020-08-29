import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class BPB_3 {
	@Given("^a book named \"([^\"]*)\" by Pinakin Chaubal with following body$")
	public void a_book_named_by_Pinakin_Chaubal_with_following_body(String bookName, String description) throws Throwable {
		System.out.println("The name of the book is: "+bookName+" and the detail about the author is: "+description);
	}

		@Then("^Verify that \"([^\"]*)\" are able to Login to the System$")
		public void verify_that_are_able_to_Login_to_the_System(String userName) throws Throwable {
			System.out.println("UserName: "+userName);;
		}
		
/*		@And("^User (?:navigates|goes) to the login page$")
		public void user_navigates_to_the_login_page() throws Throwable {
			System.out.println("Navigated to Login Page");
		}
*/
}
