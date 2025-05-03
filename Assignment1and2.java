import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment1and2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String name = "Zeenat Kausar";
		String email_id = "zkausar7642gmail.com";
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\My PC\\Documents\\chromedriver-win64\\chromedriver.exe" );
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.findElement(By.cssSelector("input[name = 'name']")).sendKeys(name);
		driver.findElement(By.cssSelector("input[name = 'email'] ")).sendKeys(email_id);
		driver.findElement(By.cssSelector("input[type = 'password'] ")).sendKeys("zee878");
		driver.findElement(By.cssSelector("input[id = 'exampleCheck1'] ")).click();
		
		driver.findElement(By.id("exampleFormControlSelect1")).click();
		//OR
		WebElement dropdown = driver.findElement(By.id("exampleFormControlSelect1"));
		Select abc = new Select(dropdown);
		abc.selectByVisibleText("Female");
		
		driver.findElement(By.id("inlineRadio2")).click();
		driver.findElement(By.name("bday")).sendKeys("12-8-2009");
		driver.findElement(By.cssSelector("input[type = 'submit']")).click();
		System.out.println(driver.findElement(By.cssSelector(".alert-success")).getText());
		

	}

}
