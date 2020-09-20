package utils;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class LoggerUtil {

private static boolean customRoot=false;
	
	public static Logger getCustomLogger(Class mycls){
		if(customRoot){
			return Logger.getLogger(mycls);
		}
		PropertyConfigurator.configure("log4j.properties");
		customRoot = true;
		return Logger.getLogger(mycls);
	}
}
