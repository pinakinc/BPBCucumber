package pageobjects;

import constants.GLOBAL_DATA;
import singletondriver.SingletonDriver;

public class AbstractBasePage {

	public LandingPage navigateURL() {
		SingletonDriver.getInstance().getDrvr().navigate().to(GLOBAL_DATA.URL);
		return new LandingPage();
	}

}
