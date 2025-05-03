import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\My PC\\Documents\\chromedriver-win64\\chromedriver.exe" );
		WebDriver driver = new ChromeDriver();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));//explicit wait
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
		driver.findElement(By.id("password")).sendKeys("learning");
		driver.findElement(By.xpath("//input[@value='user']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("okayBtn")));
		driver.findElement(By.xpath("//button[@id='okayBtn']")).click();
		WebElement staticDropdown = driver.findElement(By.cssSelector("select.form-control"));
		Select dropdown = new Select(staticDropdown);
		dropdown.selectByIndex(2);
		System.out.println(dropdown.getFirstSelectedOption().getText());
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		driver.findElement(By.cssSelector("input[id='signInBtn']")).click();
		
		
		
		String[] itemsNeeded = {"iphone X","Samsung Note 8", "Nokia Edge", "Blackberry"};
		int j = 0;
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Checkout")));
	    List<WebElement> items = driver.findElements(By.cssSelector("h4.card-title"));
		for(int i=0; i<items.size(); i++)
		{
			System.out.println(items.get(i).getText());
			String name = items.get(i).getText();
			List itemsNeededList = Arrays.asList(itemsNeeded);
			if(itemsNeededList.contains(name))
			{
				j++;
				//driver.findElements(By.xpath("//button[@class='btn btn-info']")).get(i).click();
				List <WebElement> products = driver.findElements(By.cssSelector(".card-footer .btn-info"));
				products.get(i).click();
				if(j==itemsNeededList.size())
				{
					break;
				}
			}
		}
		driver.findElement(By.partialLinkText("Checkout")).click();
	}
}

/*public static void addProducts(WebDriver driver, String[] itemsNeeded) 
{
	int j = 0;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));//explicit wait
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Checkout")));
	
    List<WebElement> items = driver.findElements(By.cssSelector("h4.card-title"));
	for(int i=0; i<items.size(); i++)
	{
		System.out.println(items.get(i).getText());
		List itemsNeededList = Arrays.asList(itemsNeeded);
		if((itemsNeededList.contains(items)))
		{
			j++;
			//driver.findElements(By.xpath("//button[@class='btn btn-info']")).get(i).click();
			List <WebElement> products = driver.findElements(By.cssSelector(".card-footer .btn-info"));
			products.get(i).click();
			if(j==itemsNeededList.size())
			{
				break;
			}
		}
	}		
}*/