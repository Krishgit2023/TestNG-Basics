package package1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Testcase2 {
	
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
	public void VerifyUsingsoftAssert() {
		driver.get("https://selenium.obsqurazone.com/simple-form-demo.php");
		WebElement enterMsg =driver.findElement(By.xpath("//input[@id='single-input-field']"));
		WebElement ShowMsgButton =driver.findElement(By.xpath("//button[@id='button-one']"));
		String expectedButtonMsg = "Show Message";
		String actualButtonMsg = ShowMsgButton.getText();
		
		SoftAssert softassert = new SoftAssert();
		softassert.assertTrue(enterMsg.isDisplayed());
		softassert.assertEquals(actualButtonMsg,expectedButtonMsg);
		softassert.assertAll();
		
	}

}
