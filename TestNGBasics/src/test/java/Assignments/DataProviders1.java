package Assignments;

import org.testng.annotations.DataProvider;

public class DataProviders1 {
	
	@DataProvider(name="Form with validations Datas")
	public Object[][] DataProviderForms()
	{
		return new Object [][] {{"Krishna","Suresh", "Krishna@1", "Trivandrum", "Kerala", "695573"}, {"Krishna2","Suresh2", "Krishna@12", "Trivandrum2", "Kerala2", "695572"}, {"Krishna1","Suresh1", "Krishna@11", "Trivandrum1", "Kerala1", "695574"}};
	}
	

}
