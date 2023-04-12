package package1;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowSwitchingExample {
	
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
		driver.get("https://the-internet.herokuapp.com/windows");
		WebElement ClickHere = driver.findElement(By.xpath("//a[text()='Click Here']"));
		ClickHere.click();
		ClickHere.click();
		ClickHere.click();
		
		//to take session id of a particular window
		String ParentWindowID = driver.getWindowHandle();
		System.out.println(ParentWindowID);
		
		//to get id of all window---driver.getWindowHandles()---returns set
		
		Set<String> Windows = driver.getWindowHandles();
		System.out.println(Windows.size());
		
		//WebElement NewWindow = driver.findElement(By.xpath("//h3[text()='New Window']"));
		//System.out.println(NewWindow.getText());
		
		//to switch to child
		Iterator<String> iterate=Windows.iterator();
		while(iterate.hasNext()) {
			String ChildWindow = iterate.next();
			if (!ParentWindowID.equals(ChildWindow)) {
				driver.switchTo().window(ChildWindow);
				
			}
		}
		WebElement NewWindow = driver.findElement(By.xpath("//h3[text()='New Window']"));
				System.out.println(NewWindow.getText());
	}

}
