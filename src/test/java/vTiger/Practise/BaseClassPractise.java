package vTiger.Practise;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class BaseClassPractise 
{
	@BeforeSuite
	public void bsConfig()
	{
		System.out.println("before suite");
	}

	@BeforeMethod
	public void bmConfig()
	{
		System.out.println("before method");
	}

	@BeforeClass
	public void bcConfig()
	{
		System.out.println("before class");
	}

	@Test
	public void test()
	{
		System.out.println("Test 1");
	}

	@AfterMethod
	public void amConfig()
	{
		System.out.println("after method");
	}
	
	@AfterClass
	public void acConfig()
	{
		System.out.println("after class");
	}

	@AfterSuite
	public void asConfig()
	{
		System.out.println("after suite");
	}

}
