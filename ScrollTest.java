import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class ScrollTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\My PC\\Documents\\chromedriver-win64\\chromedriver.exe" );
		WebDriver driver = new ChromeDriver();
		
		//write a script to sroll to avoid failure with no element exception
		//We use JavaScriptExecutor
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(3000);
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");
		
		//finding all elements from the table 
		int sum =0;
		List<WebElement>values = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
		for(int i=0; i<values.size(); i++) {
			sum = sum + Integer.parseInt(values.get(i).getText());
		}
		System.out.println(sum);
		Assert.assertEquals(sum, Integer.parseInt(driver.findElement(By.className("totalAmount")).getText().split(":")[1].trim()));
	}

}
