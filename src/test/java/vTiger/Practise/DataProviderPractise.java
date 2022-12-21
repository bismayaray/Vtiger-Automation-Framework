package vTiger.Practise;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractise 
{
	@Test(dataProvider = "getData")// OR we can write "PhoneData" instead of "getData"
	public void dataProviderPractise(String name,String model, int price,int Qty)
	{
		System.out.println("Run the Test "+name+","+model+""+price+""+Qty);
		
	}

	@DataProvider //(name="PhoneData")
	public Object[][] getData()
	{
		Object[][] data = new Object[3][4];
		
		data[0][0]="Samsung";
		data[0][1]= "A80";
		data[0][2]=10000;
		data[0][3]=20;
	
		data[1][0]="Apple";
		data[1][1]= "F30";
		data[1][2]=50000;
		data[1][3]=50;
		
		data[2][0]="Oppo";
		data[2][1]= "F19";
		data[2][2]=30000;
		data[2][3]=10;
		
		return data;	
	}
	
	@Test(dataProvider = "TVData")// OR we can write "TVData" instead of "getData"
	public void dataProviderPractise2(String name,String model, int price,int Qty)
	{
		System.out.println("Run the Test "+name+", "+model+",  "+price+", "+Qty);
		System.out.println(""+name+" "+model+" "+price+" "+Qty);
	}

	@DataProvider (name="TVData")
	public Object[][] getData2()
	{
		Object[][] data = new Object[3][4];
		
		data[0][0]="Samsung";
		data[0][1]= "QB10";
		data[0][2]=30000;
		data[0][3]=20;
	
		data[1][0]="LG";
		data[1][1]= "AB20";
		data[1][2]=50000;
		data[1][3]=50;
		
		data[2][0]="LINUX";
		data[2][1]= "D9090";
		data[2][2]=40000;
		data[2][3]=10;
		
		return data;	
	}
	
}
