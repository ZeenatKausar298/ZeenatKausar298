import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Assignment4and5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\My PC\\Documents\\chromedriver-win64\\chromedriver.exe" );
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://the-internet.herokuapp.com/");
		driver.findElement(By.cssSelector("a[href='/windows']")).click();
		//ordriver.findElement(By.linkText("Multiple Windows")).click();
		
		driver.findElement(By.cssSelector("a[href$='/windows/new']")).click();
		//or driver.findElement(By.cssSelector("a[href*='windows']")).click();
		
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		
		String parentID = it.next();
		String childId = it.next();
		driver.switchTo().window(childId);
		System.out.println(driver.findElement(By.xpath("//div/h3")).getText());
		driver.switchTo().window(parentID);
		System.out.println(driver.findElement(By.xpath("//div/h3")).getText());
		//driver.switchTo().window();
		
		
		driver.findElement(By.partialLinkText("Nested")).click();	
		System.out.println(driver.findElements(By.tagName("frameset")).size());
		driver.switchTo().frame(driver.findElement(By.name("frame-top")));
		driver.switchTo().frame(driver.findElement(By.name("frame-middle")));
		System.out.println(driver.findElement(By.xpath("//div[@id='content']")).getText());
		
	}
}
