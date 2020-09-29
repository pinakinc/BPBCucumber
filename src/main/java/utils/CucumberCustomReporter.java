package utils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;
import java.util.stream.Collectors;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import cucumber.api.Scenario;
import gherkin.formatter.model.Result;

public class CucumberCustomReporter {
	private ExtentHtmlReporter extentHtmlReporter;
	private ExtentReports extentReports;
	
	public CucumberCustomReporter(String location) {
		extentHtmlReporter = new ExtentHtmlReporter(new File(location)); 
		extentReports=new ExtentReports();
		extentReports.attachReporter(extentHtmlReporter);
	}
	
	public void createCustomTest(Scenario scenario,String screenshotFile) throws IOException {
		if (scenario!=null) {
			String testName = getScenarioTitle(scenario);
			String errMessage = fetchErrorMsg(scenario);
			System.out.println("Status of scenario: "+scenario.getStatus());
			System.out.println("Status of screenshotfile: "+screenshotFile);
			switch(scenario.getStatus().toUpperCase()) {
			case "PASSED":
				extentReports.createTest(testName).pass("passed");
				break;
			case "FAILED":
				System.out.println("in failed");
				//extentReports.createTest(testName).fail("failed").addScreenCaptureFromPath(getImageLocation(screenshotFile));
				extentReports.createTest(testName).fail(errMessage).addScreenCaptureFromPath(screenshotFile);
				break;
			default:
				extentReports.createTest(testName).fail("skipped");
			}
		}
	}
	
	private String fetchErrorMsg(Scenario scenario) {
		List<Result> testResults = null;
		List<Result> failedResults = null;
		try {
			Field stepResults = scenario.getClass().getDeclaredField("stepResults");
			//Bypass the security
			stepResults.setAccessible(true);
			testResults = (List<Result>)stepResults.get(scenario);
		} catch (NoSuchFieldException|SecurityException | IllegalArgumentException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		if (testResults != null && !testResults.isEmpty()) {
			//pick the results where error message is not null
			failedResults = testResults.stream().filter((a) -> {
				return a.getErrorMessage() != null;
			}).collect(Collectors.toList());
		}
		
		if (failedResults != null && !failedResults.isEmpty()) {
			return failedResults.get(0).getErrorMessage();
		}
		return "";
		
	}
	public void writeReport() {
		if (extentReports!=null) {
			extentReports.flush();
		}
	}
	private String getImageLocation(String absLoc) {
	//	System.out.println("yaha hai"+absLoc.replaceAll("\\", "//"));
	//	System.out.println("yaha hai"+ "file:///" + absLoc.replaceAll("\\", "//"));
	//	return "file:///" + absLoc.replaceAll("\\", "//");
	//	return "file:///" + absLoc;
		return absLoc;
		//return absLoc.replaceAll("\\", "//");
	}
	
	private String getScenarioTitle(Scenario scenario) {
		return scenario.getName().replaceAll(" ", ""); 
	}
}
