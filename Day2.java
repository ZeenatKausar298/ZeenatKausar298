package tesTngTutorial;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Day2 {
	
	@Parameters({"URL"})
	@Test(groups = {"Smoke"})
	public void sleep(String urlna) {
		System.out.println("Sleep deprived");
		System.out.println(urlna);
	}

}
