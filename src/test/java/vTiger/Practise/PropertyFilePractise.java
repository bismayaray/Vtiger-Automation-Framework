package vTiger.Practise;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyFilePractise {

	public static void main(String[] args) throws IOException 
	{
		//step-1 load the file location into file input stream
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		
		//step-2 create the object of properties from java.util package
		Properties pobj = new Properties();
		
		//step-3 load the file input stream into properties
		pobj.load(fis);
		
		//read the values using key
		String value = pobj.getProperty("username");
		System.out.println(value);

	}

}
