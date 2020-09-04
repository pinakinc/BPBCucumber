public class BPBSD_4 {
	@Given("^I want to execute \"([^\"]*)\" test$")
	public void i_want_to_execute_test(String type) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    System.out.println("This test is of type: "+type);
	}
}
