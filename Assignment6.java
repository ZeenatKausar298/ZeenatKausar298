package assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\My PC\\Documents\\chromedriver-win64\\chromedriver.exe" );
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://qaclickacademy.com/practice.php/");
		driver.findElement(By.xpath("//input[@id='checkBoxOption2']")).click();
		System.out.println(driver.findElement(By.xpath("//input[@id='checkBoxOption2']")).getDomAttribute("value"));
		String label = driver.findElement(By.xpath("//input[@id='checkBoxOption2']")).getDomAttribute("value");
		System.out.println(label);
		
		driver.findElement(By.xpath("//select[@id='dropdown-class-example']")).click();
		WebElement dropdown = driver.findElement(By.xpath("//select[@id='dropdown-class-example']"));
		Select abc = new Select(dropdown);
		//abc.selectByVisibleText(label);
		abc.selectByValue(label);
		
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys(label);
		driver.findElement(By.xpath("//input[@id='alertbtn']")).click();
		System.out.println(driver.switchTo().alert().getText());
		
		if(driver.switchTo().alert().getText().contains(label))
		{
			System.out.println("True");
		}
		else 
			System.out.println("False");
	}

}
