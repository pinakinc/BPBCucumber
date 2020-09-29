package stepdefinitions;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import locators.HomepageLocators;
import pageobjects.AbstractBasePage;
import singletondriver.SingletonDriver;
import utils.Assertions;

public class BPBSD_99 extends BaseSteps{

	//@After
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
	
	@After
	public void tearDown1(Scenario scenario) throws IOException {
		System.out.println("After all methods");
		File screenPrint = null;
		String screenshotName = "D:\\Data\\Log\\"+scenario.getName().replaceAll(" ", "")+".jpeg";
		System.out.println(screenshotName);
		if (scenario.isFailed()){
			//screenPrint=((TakesScreenshot)SingletonDriver.getInstance().getDrvr()).getScreenshotAs(OutputType.FILE);
			genericHelper.takeScreenShot(screenshotName);
			
			//Added on 28-SEPT-2020
			byte[] screenPrint1 = ((TakesScreenshot)SingletonDriver.getInstance().getDrvr()).getScreenshotAs(OutputType.BYTES);
			scenario.embed(screenPrint1, "image/png");
			try {
				if (!(SingletonDriver.getInstance().getSessId()==null)) {
				SingletonDriver.getInstance().getDrvr().close();
				SingletonDriver.getInstance().getDrvr().quit();
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
			
		} else {
			try {
				if (!(SingletonDriver.getInstance().getSessId()==null)) {
				SingletonDriver.getInstance().getDrvr().close();
				SingletonDriver.getInstance().getDrvr().quit();
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//Added on 28-SEPT-2020
		}
//		FileUtils.copyFile(screenPrint, new File(screenshotName));
		cucumberCustomReporter.createCustomTest(scenario, screenshotName);
		cucumberCustomReporter.writeReport();
		
	}


}
