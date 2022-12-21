package vTiger.Practise;

import java.io.IOException;

import vTiger.GenericUtilities.ExcelFileUtility;
import vTiger.GenericUtilities.PropertyFileUtility;

public class GenericUtilityPractise 
{
	public static void main(String[] args) throws IOException 
	{
		//This will read the data from property file
		PropertyFileUtility putil = new PropertyFileUtility();
		String value = putil.readDataFromPropertyFile("browser");
		System.out.println(value);
		
		//This will read the data from excel file
		ExcelFileUtility eutil = new ExcelFileUtility();
		String data = eutil.readDataFromExcelFile("Organisation",1,2);
		System.out.println(data);
		int rowcount = eutil.getRowCount("Organisation");
		System.out.println(rowcount);
		
		//Below are writing the data into excel sheet

		eutil.writeDataintoExcelFile("Organisation", 1, 2, "Bismaya");
		System.out.println("Data is added");
	}

}
