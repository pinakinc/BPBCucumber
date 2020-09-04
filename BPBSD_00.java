public class BPBSD_00 {
	@Given("^I open the \"([^\"]*)\" browser on \"([^\"]*)\" and \"([^\"]*)\"$")
	public void i_open_the_browser(String browserName, String platform, String gridSetting) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		try {
			SingletonDriver.getInstance().setDrvr(browserName, platform, gridSetting, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
