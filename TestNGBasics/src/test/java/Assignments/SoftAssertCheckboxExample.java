package Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SoftAssertCheckboxExample {
	
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
	public void VerifyCheckboxEnabled() {
		driver.get("https://selenium.obsqurazone.com/check-box-demo.php");
		String checkbox = "check-box-one";
		WebElement checkboxElement = driver.findElement(By.xpath("//input[@id='"+checkbox+"']"));
		checkbox = "check-box-two";
		checkboxElement = driver.findElement(By.xpath("//input[@id='"+checkbox+"']"));
		checkbox = "check-box-three";
		checkboxElement = driver.findElement(By.xpath("//input[@id='"+checkbox+"']"));
		checkbox = "check-box-four";
		checkboxElement = driver.findElement(By.xpath("//input[@id='"+checkbox+"']"));
		System.out.println("All check box is enabled: "+checkboxElement.isEnabled());
		
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(checkboxElement.isEnabled());
		
	}
	
	@AfterMethod
	public void TerminateChrome() {
		
	}

}
