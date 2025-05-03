import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Locators {

 public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\My PC\\Documents\\chromedriver-win64\\chromedriver.exe" );
		//WebDriver driver = new ChromeDriver();
	    System.setProperty("webdriver.gecko.driver", "C:\\Users\\My PC\\Documents\\geckodriver.exe" );
		WebDriver driver = new FirefoxDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/locatorspractice");
		driver.findElement(By.id("inputUsername")).sendKeys("zeenat");
		driver.findElement(By.name("inputPassword")).sendKeys("hello@zee");
		driver.findElement(By.className("signInBtn")).click();
		
		System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
		driver.findElement(By.linkText("Forgot your password?")).click();
        Thread.sleep(1000);
		
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Zeenat");
		driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("zeenatkausar29@gmail.com");
		driver.findElement(By.xpath("//input[@placeholder='Email']")).clear();
		driver.findElement(By.cssSelector("input[placeholder='Email")).sendKeys("zeenatkausar20@gmail.com");
		
		driver.findElement(By.xpath("//input[@placeholder='Phone Number']")).sendKeys("9870981524");
		driver.findElement(By.cssSelector("input[placeholder='Phone Number']")).clear();
		driver.findElement(By.cssSelector("input[type='text']:nth-child(4)")).sendKeys("789036543");
		driver.findElement(By.xpath("//input[@placeholder='Phone Number']")).clear();
		driver.findElement(By.xpath("//input[@type='text'][3]")).sendKeys("9800065478");
		driver.findElement(By.xpath("//input[@type='text'][3]")).clear();
		driver.findElement(By.xpath("//form/input[3]")).sendKeys("53673929029");
		//driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		driver.findElement(By.className("reset-pwd-btn")).click();
		System.out.println(driver.findElement(By.cssSelector("form p")).getText());
		driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();
		
		
		///Again loggin in using different locators.
		driver.findElement(By.cssSelector("#inputUsername")).sendKeys("Zeenat");
		driver.findElement(By.cssSelector("input[type*='pass")).sendKeys("rahulshettyacademy");
		Thread.sleep(1000);
		driver.findElement(By.id("chkboxOne")).click();
		driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();
	
		//driver.close();
	}
}