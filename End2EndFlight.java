import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class End2EndFlight {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("//a[@value='BLR']")).click();
		Thread.sleep(2000);
		//THIS IS PARENT CHILD RELATIONSHIP
		driver.findElement(By.xpath("//div[@id = 'glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();
		//HANDLING CALENDER
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-active")).click();
		//HANDLING round trip calender
		
		
		if(driver.findElement(By.id("Div1")).getDomAttribute("Style").contains("0.5"))
		{
			System.out.println("Its disabled");
			Assert.assertTrue(true);
					
		}
		else 
		{
			Assert.assertTrue(false);
		}
		
		//selecting senior
		driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();
		
		//adding more passengers
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		int i= 1;
		while(i<5) {
			driver.findElement(By.id("hrefIncAdt")).click();
			i++;
		}
		driver.findElement(By.id("btnclosepaxoption")).click();
		
		
		//currency
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select dropdown = new Select(staticDropdown);//dropdown with select tsg
		dropdown.selectByIndex(1);
		
		//search
		driver.findElement(By.xpath("//input[@type='submit']")).click();
	}
		
}


