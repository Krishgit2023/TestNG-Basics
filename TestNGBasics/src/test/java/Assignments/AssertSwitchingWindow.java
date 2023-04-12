package Assignments;

import java.util.Iterator;
import java.util.Set;

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

public class AssertSwitchingWindow {
	
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
	public void VerifyToolTip() {
		driver.get("https://selenium.obsqurazone.com/window-popup.php");
		WebElement ToolTip = driver.findElement(By.xpath("//a[@id='windowMulti']"));
		String expectedToolTip = "Follow @obsqurazone";
		String actualToolTip = ToolTip.getAttribute("title");
		System.out.println("Expected: "  +expectedToolTip);
		System.out.println("Actual: "  +actualToolTip);
		Assert.assertEquals(actualToolTip, expectedToolTip);
	}
	
	@Test
	public void Testcase2() {
		driver.get("https://selenium.obsqurazone.com/window-popup.php");
		WebElement Button = driver.findElement(By.xpath("//a[@class='btn btn-primary windowSingle']"));
		Button.click();
		String ParentWindow = driver.getWindowHandle();
		Set<String> Windows = driver.getWindowHandles();
		Iterator<String> iterate=Windows.iterator();
		while(iterate.hasNext()) {
			String ChildWindow = iterate.next();
			if (!ParentWindow.equals(ChildWindow)) {
				driver.switchTo().window(ChildWindow);
				
			}
		}
		WebElement NewWindow = driver.findElement(By.xpath("//span[text()='Connect with Obsqura Zone on Facebook']"));
		System.out.println(NewWindow.getText());
		driver.close();
	}
	
	@AfterMethod
	public void TerminatingChrome() {
	}
}
