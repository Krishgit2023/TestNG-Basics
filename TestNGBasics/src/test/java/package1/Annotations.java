package package1;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Annotations {

	@BeforeSuite
	public void beforesuite() {
		System.out.println("Executing before suite annotation");
		
	}
	
	@BeforeTest
	public void beforetest() {
		System.out.println("Executing before test annotation");
		
	}
	
	@BeforeClass
	public void beforeclass() {
		System.out.println("Executing before class annotation");
		
	}
	
	@BeforeMethod
	public void beforemethod() {
		System.out.println("Executing before method annotation");
		
	}
	
	@Test
	public void Testcase1() {
		System.out.println("Executing Testcase1 ");
		
	}
	
	@AfterMethod
	public void aftermethod() {
		System.out.println("Executing after method annotation");
		
	}
	
	@AfterClass
	public void afterclass() {
		System.out.println("Executing after class annotation");
		
	}
	
	@AfterTest
	public void aftertest() {
		System.out.println("Executing after test annotation");
		
	}
	
	@AfterSuite
	public void aftersuite() {
		System.out.println("Executing after suite annotation");
		
	}
	
	@Test
	public void Testcase2() {
		System.out.println("Executing Testcase2 ");
		
	}
	
	
}
