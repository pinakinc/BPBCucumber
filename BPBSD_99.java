package stepdefinitions;

import cucumber.api.java.After;
import locators.HomepageLocators;
import singletondriver.SingletonDriver;

public class BPBSD_99 {

	@After
	public void tearDown() {
		System.out.println("In teardown");
		SingletonDriver.getInstance().getDrvr().close();
		SingletonDriver.getInstance().getDrvr().quit();

	}

}
