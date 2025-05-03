import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Shoppingcart {

	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\My PC\\Documents\\chromedriver-win64\\chromedriver.exe" );
		WebDriver driver = new ChromeDriver();
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));//explicit wait
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));//implicit wait
		
		String[] itemsNeeded = {"Cucumber","Brocolli", "Beetroot"};
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		Thread.sleep(3000);
		addItems(driver, itemsNeeded);//a method also called as utility
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));
		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("button.promoBtn")).click();
		
		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));//explicit wait
		System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());
		Assert.assertEquals(driver.findElement(By.cssSelector("span.promoInfo")).getText(), "Code applied ..!" );
			
	}
		
	
	
	public static void addItems(WebDriver driver, String[] itemsNeeded) 
	{
		int j = 0;
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
		
		for(int i=0; i<products.size(); i++) 
		{
			String[] name = products.get(i).getText().split("-");//format the actaual vegetable name
			String formattedName = name[0].trim();
			
			//first lets convert that array to arraylist as it has some methods like contains
			List itemsNeededList = Arrays.asList(itemsNeeded);
					
			//check whether name you extracted is present in array or not
			if(itemsNeededList.contains(formattedName)) 
			{
				j++;
				//click on Add to cart
				//this locator has text so when the other item gets added then for some secs it becomes added so basically the index would be counted igoring thata item resuting in wrong item ,->
				//driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				if(j==itemsNeededList.size())
				{
					break;
				}
				
			}
		}
	}

}