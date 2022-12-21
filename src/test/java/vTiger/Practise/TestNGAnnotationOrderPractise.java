package vTiger.Practise;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestNGAnnotationOrderPractise 
{
	@BeforeSuite
	public void bsconfig()
	{
		System.out.println("before suite");
	}
	@BeforeClass
	public void bcconfig()
	{
		System.out.println("before class");
	}
	@BeforeMethod
	public void bmconfig()
	{
		System.out.println("before method");
	}
	
	@Test
	public void test1()
	{
		System.out.println("test 1 run  ");
	}
	@Test
	public void test2()
	{
		System.out.println("test 2 run");
	}
	
	@AfterMethod
	public void amconfig()
	{
		System.out.println("after method");
	}
	@AfterClass
	public void acconfig()
	{
		System.out.println("after class");
	}
	@AfterSuite
	public void asconfig()
	{
		System.out.println("after suite");
	}

}
