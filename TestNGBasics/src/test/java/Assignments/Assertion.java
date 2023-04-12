package Assignments;

import java.awt.Button;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assertion {
	
WebDriver driver;
	
	@BeforeMethod
	public void LaunchingUrl() {
		WebDriverManager.chromedriver().setup(); 
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver=new ChromeDriver(options);
		driver.get("https://selenium.obsqurazone.com/check-box-demo.php");
		driver.manage().window().maximize();
		
	}
	
	@Test(priority = 1)
	public void VerifyButtonName() {
		WebElement ButtonTest1 = driver.findElement(By.xpath("//input[@id='button-two']"));
        System.out.println("Select All Button name is present: " +ButtonTest1.isDisplayed());
		
		Assert.assertTrue(ButtonTest1.isDisplayed());
		
	}
	
	@Test(priority = 2)
	public void VerifySelectAllButtonEnabled() {
		WebElement ButtonTest2 = driver.findElement(By.xpath("//input[@id='button-two']"));
        System.out.println("Select All Button is enabled: " +ButtonTest2.isEnabled());
		
		Assert.assertTrue(ButtonTest2.isEnabled());
	}
	
	@Test(priority = 3)
	public void VerifyAllCheckboxChecked() {
		WebElement selectAllCheckbox = driver.findElement(By.xpath("//input[@id='button-two']"));
		selectAllCheckbox.click();
		String checkbox = "check-box-one";
		WebElement checkboxElement = driver.findElement(By.xpath("//input[@id='"+checkbox+"']"));
		checkbox = "check-box-two";
		checkboxElement = driver.findElement(By.xpath("//input[@id='"+checkbox+"']"));
		checkbox = "check-box-three";
		checkboxElement = driver.findElement(By.xpath("//input[@id='"+checkbox+"']"));
		checkbox = "check-box-four";
		checkboxElement = driver.findElement(By.xpath("//input[@id='"+checkbox+"']"));
		System.out.println("All check box is checked: "+checkboxElement.isSelected());
		Assert.assertTrue(checkboxElement.isSelected());
		
		
	}
	
	@AfterMethod
	public void TerminatingChrome() {
	}

}
