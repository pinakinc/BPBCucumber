package stepdefinitions;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import locators.HomepageLocators;
import pageobjects.AbstractBasePage;
import singletondriver.SingletonDriver;
import utils.Assertions;

public class BPBSD_99 {

	@After
	public void tearDown(Scenario scenario) {
		System.out.println("In teardown");
		if (scenario.isFailed()) {
			System.out.println("In teardown failure");
			byte[] screenPrint = ((TakesScreenshot)SingletonDriver.getInstance().getDrvr()).getScreenshotAs(OutputType.BYTES);
			scenario.embed(screenPrint, "image/png");
		}

		try {
			if (!(SingletonDriver.getInstance().getSessId()==null)) {
			SingletonDriver.getInstance().getDrvr().close();
			SingletonDriver.getInstance().getDrvr().quit();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		Assertions.assertAll();

	}

}
