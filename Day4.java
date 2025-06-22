package tesTngTutorial;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Day4 {
	
	@BeforeSuite
	public void suiteFirst() {
		System.out.println("I will execute first as m in suite level");
	}
	
	@Parameters({"URL", "APIKey/username"})
	@Test
	public void tests(String urlnam, String key) {
		System.out.println("Just a test");
		System.out.println(urlnam);
		System.out.println(key);
	}
	
	@AfterSuite(groups = {"Smoke"})
	public void suiteLast() {
		System.out.println("I will execute last as m in suite level");
		
	}

}
