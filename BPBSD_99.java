public class BPBSD_99 {
	@After
	public void tearDown() {
		System.out.println("After all methods");
		SingletonDriver.getInstance().closeDriver();

	}


}
