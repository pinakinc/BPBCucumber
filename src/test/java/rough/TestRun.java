public class TestRun {

	public static void main(String[] args) {
//		WebDriverManager.chromedriver().setup();
//		WebDriver chromeDriver = new ChromeDriver();
		try {
			SingletonDriver.getInstance().setDrvr("chrome", "windows", "local", null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
