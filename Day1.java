package tesTngTutorial;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Day1 {
	
	@Test
	public void print() {
		System.out.println("Hello");
		Assert.assertTrue(false);
	}
	
	@Test(groups= {"Smoke"})
	public void second() {
		System.out.println("bye");
	}
	
	@BeforeTest
	public void first() {
		System.out.println("I will execute first");
	}
	
	@AfterTest
	public void last() {
		System.out.println("I will execute last");
	}
	//even though this is after test n should execute last still it comes end in output but among tests from the
	//same test module if any other test module is defined in the testng file then that test comes after this test
	
}
