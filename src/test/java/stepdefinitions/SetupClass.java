package stepdefinitions;

import com.aventstack.extentreports.Status;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import utils.ExtentMgr;
import utils.ExtentTstClass;

public class SetupClass {
	
	Scenario scenario;
	static String scenarioNm;
	@Before
	public void setUp(Scenario scenario) {
		this.scenario = scenario;
		scenarioNm = scenario.getName();
		ExtentTstClass.startTest(scenarioNm);
		System.out.println("Scenario started: "+scenario.getName());
		ExtentTstClass.getTest().log(Status.INFO, "Scenario started: "+scenario.getName());
	}

}
