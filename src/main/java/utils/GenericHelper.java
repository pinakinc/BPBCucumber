package utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import singletondriver.SingletonDriver;

public class GenericHelper {
	
	public String takeScrenShot(String aDir,String bFileName){
		/*
		 * If dir is present , then save the screen shot in the given dir
		 * Create the dir, take the screen shot and save the screen shot in the dir
		 *  File -> java framework
		 * 
		 * */
		
		File directory = new File(aDir);
		
		if(!directory.exists())
			directory.mkdirs();
		
		String aPath = directory.getAbsolutePath() + File.separator + bFileName;
		
		return takeScreenShot(aPath);
	}

	public String takeScreenShot(String aPath) {
		File screenshot = ((TakesScreenshot)SingletonDriver.getInstance().getDrvr()).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenshot, new File(aPath));
		} catch (IOException e) {
			e.printStackTrace();
			return "";
		}
		System.out.println("takeScreenShot: "+aPath);
		return aPath;
	}
	

}
