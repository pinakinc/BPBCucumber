package utils;

import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import cucumber.api.Scenario;

public class CucumberCustomReporter {
	private ExtentHtmlReporter extentHtmlReporter;
	private ExtentReports extentReports;
	
	public CucumberCustomReporter(String location) {
		extentHtmlReporter = new ExtentHtmlReporter(new File(location)); 
		extentReports=new ExtentReports();
		extentReports.attachReporter(extentHtmlReporter);
	}
	
	public void createTest(Scenario scenario,String screenshotFile) throws IOException {
		if (scenario!=null) {
			String testName = getScenarioTitle(scenario);
			System.out.println("Status of scenario: "+scenario.getStatus());
			System.out.println("Status of screenshotfile: "+screenshotFile);
			switch(scenario.getStatus().toUpperCase()) {
			case "PASSED":
				extentReports.createTest(testName).pass("passed");
				break;
			case "FAILED":
				System.out.println("in failed");
				extentReports.createTest(testName).fail("failed").addScreenCaptureFromPath(getImageLocation(screenshotFile));
				break;
			default:
				extentReports.createTest(testName).fail("skipped");
			}
		}
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
