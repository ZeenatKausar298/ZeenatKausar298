import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class Locators2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String name = "Zeenat";
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\My PC\\Documents\\chromedriver-win64\\chromedriver.exe" );
		//WebDriver driver = new ChromeDriver();
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\My PC\\Documents\\geckodriver.exe" );
		WebDriver driver = new FirefoxDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/locatorspractice");
		driver.findElement(By.id("inputUsername")).sendKeys(name);
		driver.findElement(By.name("inputPassword")).sendKeys("rahulshettyacademy");
		driver.findElement(By.xpath("(//input[@type='checkbox'])[1]")).click();
		//OR//driver.findElement(By.xpath("//span/input[1]")).click();//cliking checkbox
		driver.findElement(By.xpath("//div/span[2]/input[1]")).click();//clicking checkbox
		driver.findElement(By.className("signInBtn")).click();//clicking checkbox
		
		System.out.println(driver.findElement(By.tagName("p")).getText());
		Thread.sleep(2000);
		Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), "You are successfully logged in.");
		System.out.println(driver.findElement(By.xpath("//div/h2")).getText());
        Assert.assertEquals(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText(), "Hello "+name+",");
        driver.findElement(By.xpath("//button[text()= 'Log Out']")).click();
        //driver.close();
	}

}
