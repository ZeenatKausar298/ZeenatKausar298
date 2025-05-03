import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumIntroductiom {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Invoking browser
		//Chrome - ChromeDriver -> methods close
		//Firefox - FirefoxDriver -> Methods close
		//Irrespective of the browsers, the methods name for them are same
		//To make the methods dynamic for every browser webdriver methods must be used instead of its' own class method
		//But this Chromedriver.exe -> Chrome browser, step to invoke chrome driver
		
		//Ways to invoke the browser 
		// 1st done by selenium manager
		//2nd manually 
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\My PC\\Documents\\chromedriver-win64\\chromedriver.exe" );
	
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/");//getting url
		System.out.println(driver.getTitle());//getting title
		System.out.println(driver.getCurrentUrl());//validate if we are redirected to correct page
		driver.close(); //close the browser
		//driver.quit();
		//ChromeDriver driver = new ChromeDriver();
		
		
		
		//Firefox launch
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\My PC\\Documents\\geckodriver.exe" );
		WebDriver driver1 = new FirefoxDriver();
		driver1.get("https://rahulshettyacademy.com/");//getting url
		System.out.println(driver1.getTitle());//getting title
		System.out.println(driver1.getCurrentUrl());//validate if we are redirected to correct page
		driver1.close(); //close the browser
		
		
		//Microsoft edge 
		System.setProperty("webdriver.edge.driver", "C:\\Users\\My PC\\Documents\\msedgedriver.exe" );
		WebDriver driver2 = new EdgeDriver();
		driver2.get("https://rahulshettyacademy.com/");//getting url
		System.out.println(driver2.getTitle());//getting title
		System.out.println(driver2.getCurrentUrl());//validate if we are redirected to correct page
		driver2.close(); //close the browser
		
		
		
		
		
		
	}

}
