package Assignments;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FormSubmitExample {
	
WebDriver driver;


	
	@BeforeMethod
	public void LaunchingUrl() {
		WebDriverManager.chromedriver().setup(); 
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver=new ChromeDriver(options);
		driver.get("https://selenium.obsqurazone.com/ajax-form-submit.php");
		driver.manage().window().maximize();
		
		
	}
	
	@Test(priority = 1)
	public void VerifyWarningMessage() {
		WebElement SubmitButton = driver.findElement(By.xpath("//input[@value='Submit']"));
		SubmitButton.click();
		WebElement Message = driver.findElement(By.xpath("//div[contains(text(),'Please enter Subject.')]"));
		String expectedMsg = "Please enter Subject.";
		String actualMsg = Message.getText();
		System.out.println("Expected Warning Message is : " +expectedMsg);
		System.out.println("Actual Warning Message is : " +actualMsg);
		
		Assert.assertEquals(actualMsg, expectedMsg);
      
	}
	
	@Test(priority = 2)
	public void VerifyResult() {
		
		WebElement Subject = driver.findElement(By.xpath("//input[@id='subject']"));
		Subject.sendKeys("Test");
		WebElement Description = driver.findElement(By.xpath("//textarea[@id='description']"));
		Description.sendKeys("Hello Krishna");
		WebElement SubmitButton = driver.findElement(By.xpath("//input[@value='Submit']"));
		SubmitButton.click();
		
		WebElement loading = driver.findElement(By.xpath("//div[text()='Your request is under processing!']"));
		
		WebDriverWait Wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		
		
		//Wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[text()='Your request is under processing!']")));
		Wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Form has been submitted successfully!']")));
		WebElement Message = driver.findElement(By.xpath("//div[text()='Form has been submitted successfully!']"));
		String expectedResult = "Form has been submitted successfully!";	
		String actualResult = Message.getText();
		System.out.println("Expected Result is : " +expectedResult);
		System.out.println("Actual Result is : " +actualResult);
		
		Assert.assertEquals(actualResult, expectedResult);
		
	}
	
	@AfterMethod
	public void TerminatingChrome() {
	}

}
