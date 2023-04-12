 package Assignments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SoftAssertExample {
	
WebDriver driver;
	
	@BeforeMethod
	public void Frames() {
		WebDriverManager.chromedriver().setup(); 
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		
	}
	
	@Test
	public void VerifyTextUsingSoftAssert() {
		driver.get("https://selenium.obsqurazone.com/bootstrap-dual-list.php");
		List<WebElement> Options= driver.findElements(By.xpath("//select[@id='bootstrap-duallistbox-nonselected-list_duallistbox_demo1[]']"));
		String ExpectedText = "Option 1\r\n"
				+ "Option 2\r\n"
				+ "Option 4\r\n"
				+ "Option 5\r\n"
				+ "Option 7\r\n"
				+ "Option 8\r\n"
				+ "Option 9\r\n"
				+ "Option 10";
		System.out.println("Expected: "+ExpectedText);
		for(WebElement element:Options) {
			String Actualtext = element.getText();
			System.out.println("Actual: "+Actualtext);
			
			SoftAssert softAssert = new SoftAssert();
			softAssert.assertEquals(Actualtext, ExpectedText);
			softAssert.assertAll();
}
}
}
