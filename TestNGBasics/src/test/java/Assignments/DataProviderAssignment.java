package Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import package1.DataProviders;

public class DataProviderAssignment {
	
WebDriver driver;
	
	@BeforeMethod
	public void Frames() {
		WebDriverManager.chromedriver().setup(); 
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		
	}
	
	@Test(dataProvider = "Form with validations Datas", dataProviderClass = DataProviders1.class)
	public void Testcase1(String Fname, String Lname, String Username, String City, String State, String Zip) {
		driver.get("https://selenium.obsqurazone.com/form-submit.php");
		WebElement FirstName = driver.findElement(By.xpath("//input[@id='validationCustom01']"));
		FirstName.sendKeys(Fname);
		WebElement LastName = driver.findElement(By.xpath("//input[@id='validationCustom02']"));
		LastName.sendKeys(Lname);
		WebElement UserName = driver.findElement(By.xpath("//input[@id='validationCustomUsername']"));
		UserName.sendKeys(Username);
		WebElement CityElement = driver.findElement(By.xpath("//input[@id='validationCustom03']"));
		CityElement.sendKeys(City);
		WebElement stateElement = driver.findElement(By.xpath("//input[@id='validationCustom04']"));
		stateElement.sendKeys(State);
		WebElement Zipcode = driver.findElement(By.xpath("//input[@id='validationCustom05']"));
		Zipcode.sendKeys(Zip);
		WebElement Checkbox = driver.findElement(By.xpath("//input[@id='invalidCheck']"));
		Checkbox.click();
		WebElement SubmitButton = driver.findElement(By.xpath("//button[text()='Submit form']"));
		SubmitButton.click();
		WebElement SucessMsg = driver.findElement(By.xpath("//div[text()='Form has been submitted successfully!']"));
		System.out.println(SucessMsg.getText());
		
	}

}
