package vTiger.OrganisationTests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vTiger.GenericUtilities.BaseClass;
import vTiger.GenericUtilities.ExcelFileUtility;
import vTiger.GenericUtilities.JavaUtillity;
import vTiger.GenericUtilities.PropertyFileUtility;
import vTiger.GenericUtilities.WebDriverUtility;
import vTiger.ObjectRepository.CreateNewOrganizationPage;
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.OrganizationInfoPage;
import vTiger.ObjectRepository.OrganizationPage;

public class CreateOrganisationUsingDDT extends BaseClass
{
	@Test 
	public void createOrgUsingDDTTest() throws IOException
	{
		
		/*Excel file- Test data*/
		String ORGNAME = eUtil.readDataFromExcelFile("Organisations",1,2)+jUtil.getRandomNumber();
		
		//click on organization
		HomePage hp = new HomePage(driver);
		hp.clickOnOrganizationLink();
		Reporter.log("organisation link is clicked",true);
		
		//Step 5: click on create organization lookup image
		OrganizationPage op = new OrganizationPage(driver);
		op.clickOnCreateOrgLookUpImg();
		Reporter.log("create organisation lookup image is clicked",true);
				
		
		//create new organization with mandatory fields
		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
		cnop.createNewOrganizationWithAssign(ORGNAME);
		Reporter.log("new organisation is created",true);
		
		// Validate:
				OrganizationInfoPage oip = new OrganizationInfoPage(driver);
				String OrgHeader = oip.getOrganizationHeaderText();
				Assert.assertTrue(OrgHeader.contains(ORGNAME));
				/**if(OrgHeader.contains(ORGNAME))
				{
					System.out.println(OrgHeader);
					System.out.println("pass");
				}
				else
				{
					System.out.println("fail");
				}
				**/
	}
	
}












