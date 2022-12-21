package vTiger.Practise;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionPractise 
{
	@Test
	public void assertPractise()
	{
		SoftAssert sa = new SoftAssert();
		System.out.println("step 1 ");
		System.out.println("step 2 ");
		Assert.assertEquals(true, true); //hard assert
		System.out.println("step 3 ");
		sa.assertEquals(true, true); // soft assert
		System.out.println("step 4 ");
		sa.assertTrue(true);  // soft assert
		System.out.println("step 5 ");
		System.out.println("step 6 ");
		sa.assertAll(); // need to write at last code for soft assert
	}
}
