package second;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\My PC\\Documents\\chromedriver-win64\\chromedriver.exe" );
		WebDriver driver = new ChromeDriver();
		driver.get("https://https://rahulshettyacademy.com/angularpractice/");
		WebElement nameEditBox = driver.findElement(By.cssSelector("[name='name']"));
		//System.out.println(driver.findElement(with(By.tagName("label")).above(nameEditBox)).getText());

	}

	private static Object with(By tagName) {
		// TODO Auto-generated method stub
		return null;
	}

}
