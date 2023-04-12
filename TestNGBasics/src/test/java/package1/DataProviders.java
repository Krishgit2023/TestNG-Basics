package package1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataProviders {
	
	@DataProvider(name="Amazon Datas")
	public Object[][] DataProviderAmazon()
	{
		return new Object [][] {{"Mobiles"},{"Toys"},{"Laptop"}, {"Headset"}};
	}
	
	@DataProvider(name="Facebook Datas")
	public Object[][] DataProviderFacebook()
	{
		return new Object [][] {{"Test@gmail.com","Test@123", "Krishna"}, {"Test1@gmail.com","Test@1234", "KrishnaS"}};
	}
	


}
