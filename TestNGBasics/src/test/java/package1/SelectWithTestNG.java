package package1;

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

public class SelectWithTestNG {
	
	WebDriver driver;
	
	@BeforeMethod
	public void LaunchingAmazon() {
		WebDriverManager.chromedriver().setup(); 
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver=new ChromeDriver(options);
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		
	}
	
	@Test(priority = 3,enabled = false)
	public void VerifyAmazonTitle() {
		String expectedTitle= "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		String actualTitle= driver.getTitle();
		System.out.println("Expected Title is : " +expectedTitle);
		System.out.println("Actual Title is : " +actualTitle);
		
		Assert.assertEquals(actualTitle, expectedTitle);
		
		
	}
	
	@Test(priority = 1,enabled = true) //setting priority for running testcase and enabling testcase
	public void VerifyCurrentUrl() {
		String expectedUrl= "https://www.amazon.in/";
		String actualUrl= driver.getCurrentUrl();
		System.out.println("Expected Url is : " +expectedUrl);
		System.out.println("Current Url is : " +actualUrl);
		
		Assert.assertEquals(actualUrl, expectedUrl);
		System.out.println("Test Pass");
	}
	
	@Test(priority = 4,dependsOnMethods = "VerifyCurrentUrl") // if verifycurrenturl testcase is passed then only this tc will execute. otherwise will show as Skip
	public void VerifyTextHeaderTab() {
		WebElement TextCheck = driver.findElement(By.xpath("//a[text()='Amazon miniTV']"));
		String expectedText= "Amazon miniTV";
		String actualText= TextCheck.getText();
		System.out.println("Expected Text is : " +expectedText);
		System.out.println("Current Text is : " +actualText);
		
		Assert.assertEquals(actualText, expectedText, "Failed due to wrong expected");
	}
	
	@Test(priority = 2)
	public void VerifySearchButtonPresent() {
		WebElement SearchButton = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		System.out.println("Search Button is present: " +SearchButton.isDisplayed());
		
		Assert.assertTrue(SearchButton.isDisplayed());
		
		
	}
	
	@AfterMethod
	public void TerminatingChrome() {
	}
	
	
	

}
