package vTiger.Practise;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelsheetPractice {

	public static void main(String[] args) throws EncryptedDocumentException, IOException
	{
		//step-1 load file location into file input stream
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		
		//step-2 create a work book
		Workbook wb =WorkbookFactory.create(fis);
		
		//step-3 navigate to required sheet
		Sheet sh = wb.getSheet("Organisation");
		
		//step-4 navigate to required row
		Row rw = sh.getRow(1);
		
		//step-5 navigate to required cell
		Cell ce = rw.getCell(2);
		
		//step-6 capture the data present in the cell
		String value = ce.getStringCellValue();
		System.out.println(value);
		
		//OR
		String value1 = wb.getSheet("Organisation").getRow(1).getCell(2).getStringCellValue();
		System.out.println(value1);
	}
}
