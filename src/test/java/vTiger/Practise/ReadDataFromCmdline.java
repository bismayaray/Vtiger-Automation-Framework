package vTiger.Practise;

import org.testng.annotations.Test;

public class ReadDataFromCmdline
{
	@Test
	public void readData()
	{
		String BROWSER = System.getProperty("browser");
		String USERNAME = System.getProperty("username");
		
		System.out.println(BROWSER);
		System.out.println(USERNAME);
	}

}
