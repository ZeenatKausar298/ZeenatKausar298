package second;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class BrokenLinks {

	public static void main(String[] args) throws MalformedURLException, IOException, URISyntaxException, IllegalArgumentException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\My PC\\Documents\\chromedriver-win64\\chromedriver.exe" );
		WebDriver driver = new ChromeDriver();
		
		//Broken URL 
		//Step 1 is to get all urls tied up to the links using selenium
		//Java methods will call URL's and gets you the status code
		//if status code is >400 then that url is not working-> link which tied to url is broken
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		List<WebElement> links = driver.findElements(By.cssSelector("li[class='gf-li'] a"));
		SoftAssert a = new SoftAssert();
		for(WebElement link : links)
		{
			String url = link.getDomAttribute("href");
			//URI url2 = new URI(url);
			@SuppressWarnings("deprecation")
			HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();
			int resCode = conn.getResponseCode();
			System.out.println(resCode);
			if(resCode>400)
			{
				System.out.println("The link with text"+link.getText()+"is broken with code"+resCode);
				Assert.assertTrue(false);
				
			}
			//OR
			a.assertTrue(resCode<400, "The link with text"+link.getText()+"is broken with code"+resCode );
		}
		a.assertAll();
	}

}
