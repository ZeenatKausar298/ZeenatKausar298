import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MethodsDemo2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String name = "Zeenat";
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\My PC\\Documents\\chromedriver-win64\\chromedriver.exe" );
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/locatorspractice");
		driver.findElement(By.id("inputUsername")).sendKeys(name);
		//driver.findElement(By.name("inputPassword")).sendKeys("rahulshettyacademy");//dont send manually
		String password = getPassword(driver);//we used static method
		driver.findElement(By.name("inputPassword")).sendKeys(password);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span/input[1]")).click();
		driver.findElement(By.xpath("//div/span[2]/input[1]")).click();
		driver.findElement(By.className("signInBtn")).click();

	}

	public static String getPassword(WebDriver driver) throws InterruptedException {
		driver.get("https://rahulshettyacademy.com/locatorspractice");
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		String passtext = driver.findElement(By.cssSelector("form p[class='infoMsg']")).getText();
		//String passtext = driver.findElement(By.cssSelector(" form p")).getText();
		String[] passwordArray = passtext.split("'");
		String[] passwordArray2 = passwordArray[1].split(" ' ");
		String password = passwordArray2[0];
		driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();
		return password;	
	}

}
