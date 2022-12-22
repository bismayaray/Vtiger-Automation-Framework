package vTiger.Practise;

import org.testng.annotations.Test;

public class TestNGpractise
{
	@Test(priority = 1)
	public void createUser()
	{
		System.out.println("hii user is created");
	}
	@Test(invocationCount = 2)
	public void modifyUser()
	{
		System.out.println("user is modified");
	}
	@Test(dependsOnMethods = {"createUser","modifyUser"})
	public void deleteUser()
	{
		System.out.println("user is deleted");
	}

	@Test(enabled = false)
	public void listofUser()
	{
		System.out.println("user is modified");
		System.out.println("user is modified");
	}
}
