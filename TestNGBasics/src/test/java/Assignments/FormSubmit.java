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

import io.github.bonigarcia.wdm.WebDriverManager;

public class FormSubmit {

WebDriver driver;
	
	@BeforeMethod
	public void LaunchingUrl() {
		WebDriverManager.chromedriver().setup(); 
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver=new ChromeDriver(options);
		driver.get("https://selenium.obsqurazone.com/form-submit.php");
		driver.manage().window().maximize();
	}
	
	@Test
	public void VerifyAgreeToTermsandConditionsDisplayed() {
		WebElement AgreeToTermsandConditionsCheckbox = driver.findElement(By.xpath("//input[@id='invalidCheck']"));
        System.out.println("Checkbox is present: " +AgreeToTermsandConditionsCheckbox.isDisplayed());
		
		Assert.assertTrue(AgreeToTermsandConditionsCheckbox.isDisplayed());
	}
	
	@Test
	public void VerifyHeaderText() {
		WebElement Header = driver.findElement(By.xpath("//div[contains(text(),'Form with validations')]"));
		String expectedText= "Form with validations";
		String actualText= Header.getText();
		System.out.println("Expected Text is : " +expectedText);
		System.out.println("Actual Text is : " +actualText);
		
		Assert.assertEquals(actualText, expectedText);
		
	}
	
	@Test
	public void VerifySuccessMessage() {
		WebElement FirstName = driver.findElement(By.xpath("//input[@id='validationCustom01']"));
		FirstName.sendKeys("Krishna");
		WebElement LastName = driver.findElement(By.xpath("//input[@id='validationCustom02']"));
		LastName.sendKeys("Suresh");
		WebElement UserName = driver.findElement(By.xpath("//input[@id='validationCustomUsername']"));
		UserName.sendKeys("Krishna123");
		WebElement City = driver.findElement(By.xpath("//input[@id='validationCustom03']"));
		City.sendKeys("Trivandrum");
		WebElement State = driver.findElement(By.xpath("//input[@id='validationCustom04']"));
		State.sendKeys("Kerala");
		WebElement Zip = driver.findElement(By.xpath("//input[@id='validationCustom05']"));
		Zip.sendKeys("695573");
		WebElement Checkbox = driver.findElement(By.xpath("//input[@id='invalidCheck']"));
		Checkbox.click();
		WebElement SubmitButton = driver.findElement(By.xpath("//button[text()='Submit form']"));
		SubmitButton.click();
		WebElement SuccessMessage = driver.findElement(By.xpath("//div[@id='message-one']"));
		String ExpectedSuccessMsg = "Form has been submitted successfully!";
		String ActualSuccessMsg = SuccessMessage.getText();
		System.out.println("Expected Success Message is : " +ExpectedSuccessMsg);
		System.out.println("Actual Success Message is : " +ActualSuccessMsg);
		
		Assert.assertEquals(ActualSuccessMsg, ExpectedSuccessMsg);
		
	}
	
	
	
	@AfterMethod
	public void TerminatingChrome() {
	}
}
