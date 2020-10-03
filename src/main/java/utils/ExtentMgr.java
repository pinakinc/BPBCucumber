package utils;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import singletondriver.SingletonDriver;

public class ExtentMgr {
	 
	static ExtentReports extentReports;
    static Date d = new Date();
	static String fileName = "Extent_" + d.toString().replace(":", "_").replace(" ", "_") + ".html";
    
    public synchronized static ExtentReports getReporter() {
        if (extentReports == null) {
        	
        	 ExtentHtmlReporter htmlReprtr = new ExtentHtmlReporter(System.getProperty("user.dir")+"/reports/"+fileName);
  	       
 	        
 	        
        	 htmlReprtr.config().setTheme(Theme.STANDARD);
        	 htmlReprtr.config().setDocumentTitle(fileName);
        	 htmlReprtr.config().setEncoding("utf-8");
        	 htmlReprtr.config().setReportName(fileName);
 	        
        	 extentReports = new ExtentReports();
        	 extentReports.attachReporter(htmlReprtr);
        	 extentReports.setSystemInfo("Automation Test Run", "Parallel Execution");
        	 extentReports.setSystemInfo("Organization", "BPB");
        	 extentReports.setSystemInfo("Build no", "BPB-TEST");
        }
        return extentReports;
    }
  
   
   public static String screenshotPath;
	public static String screenshotName;
	static int i=0;
	public static void captureScreenshot() {
		i = i + 1;
		File scrFile = ((TakesScreenshot) SingletonDriver.getInstance().getDrvr()).getScreenshotAs(OutputType.FILE);

		Date d = new Date();
		screenshotName = d.toString().replace(":", "_").replace(" ", "_") + "_"+i+".jpg";

		try {
			FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir") + "/reports/" + screenshotName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	
	}
	
	}

