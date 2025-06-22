package tesTngTutorial;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Day3 {
	
	@Test
	public void WebLoginCarLoan() {
		//selenium
		System.out.println("Weblogincar");
	}
	
	@Parameters({"URL"})
	@Test
	public void WebSignInLoan(String urlName) {
		System.out.println("WebSigninLog");
		System.out.println(urlName);
	}
	
	@Test(dependsOnMethods = {"WebLoginCarLoan"})
	public void BookCarLoan() {
		System.out.println("Book the car take loan");
	}
	
	@Test(enabled = true)
	public void AppLogin() {
		System.out.println("Login to this app");
	}
	
	@BeforeTest
	public void MobileLogincarLoan() {
		//Appium
		System.out.println("mobilelogincar");
	}
	
	@Test
	public void MobilesignincarLoan() {
		//Appium
		System.out.println("mobilesignincar");
	}
	
	@Test
	public void MobileLoan() {
		//Appium
		System.out.println("mobilecar");
	}
	//Have created above 3 test cases to practice exclusion of test cases via testng.xml using exclude on common Keyword level like above Mobile is common so Mobile.*
	
	@BeforeMethod
	public void beforeEvery() {
		System.out.println("I will execute before every method in day3 class");
	}
	
	@AfterMethod
	public void afterEvery() {
		System.out.println("I will execute after every method in day3 class");
	}
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("I will execute before executing any method in the class");
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("I will execute after executing every method in the class");
	}
	
	@Test(dataProvider = "getData")
	public void  MachineLoan(String username, String password) {
		System.out.println("Machine SignOut");
		System.out.println(username);
		System.out.println(password);
	}
	
	@Test(groups = {"Smoke"})
	public void LoginAPIcarLoan()
	{
		//Rest API automation
		System.out.println("apilogincar");
	}
	
	
	
	@DataProvider
	public Object[][] getData() {
		
		Object[][] data = new Object[3][2];
		
		data[0][0] = "firstsetusername";
		data[0][1] = "password";
		
		data[1][0] = "secondsetusername";
		data[1][1] = "secondpassword";
		
		data[2][0] = "thirdsetusername";
		data[2][1] = "thirdpassword";
		
		return data;
	}
}
