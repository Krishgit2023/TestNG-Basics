package package1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FrameDemo {
	
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
	public void Testcase1() {
		driver.get("https://the-internet.herokuapp.com/nested_frames");
		// to switch frames
		driver.switchTo().frame("frame-top");
		driver.switchTo().frame("frame-middle");
		WebElement Middle = driver.findElement(By.xpath("//div[text()='MIDDLE']"));
		String text = Middle.getText();
		System.out.println(text);
	}
	
	

}
