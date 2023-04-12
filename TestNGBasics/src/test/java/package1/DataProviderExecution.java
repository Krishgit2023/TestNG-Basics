package package1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataProviderExecution {
	
WebDriver driver;
	
	@BeforeMethod
	public void Frames() {
		WebDriverManager.chromedriver().setup(); 
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		
	}
	
	@Test(dataProvider = "Amazon Datas", dataProviderClass = DataProviders.class)
	public void TestCase1(String Product) {
		driver.get("https://www.amazon.in/");
		WebElement SearchField = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		SearchField.sendKeys(Product);
		WebElement SearchButton = driver.findElement(By.xpath("//input[@id='nav-search-submit-button']"));
		SearchButton.click();
		String Url = driver.getCurrentUrl();
		boolean s = Url.contains(Product);
		System.out.print(Product);
		Assert.assertTrue(s);
		
	}
	
	@Test(dataProvider = "Facebook Datas", dataProviderClass = DataProviders.class)
	public void VerifyFaceebookLogin(String Email, String Password, String Text) {
		driver.get("https://www.facebook.com/");
		WebElement emailField = driver.findElement(By.xpath("//input[@id='email']"));
		WebElement passwordField = driver.findElement(By.xpath("//input[@id='pass']"));
		emailField.sendKeys(Email);
		passwordField.sendKeys(Password);
		System.out.print(Email);
		System.out.print(Password);
		System.out.print(Text);
		
	}

}
