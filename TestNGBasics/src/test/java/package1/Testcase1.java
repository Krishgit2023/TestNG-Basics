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

public class Testcase1 {
	
WebDriver driver;
	
	@BeforeMethod
	public void LaunchingAmazon() {
		WebDriverManager.chromedriver().setup(); 
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver=new ChromeDriver(options);
		driver.get("https://selenium.obsqurazone.com/radio-button-demo.php");
		driver.manage().window().maximize();

}
	
	@Test
	public void VerifyRadioButton() {
		WebElement maleradioButton = driver.findElement(By.xpath("//input[@id='inlineRadio1']"));
		WebElement femaleradioButton = driver.findElement(By.xpath("//input[@id='inlineRadio2']"));
		boolean is_malebuttonselected = maleradioButton.isSelected();
		maleradioButton.click();
		Assert.assertTrue(is_malebuttonselected);
		
	}
	
	
}
