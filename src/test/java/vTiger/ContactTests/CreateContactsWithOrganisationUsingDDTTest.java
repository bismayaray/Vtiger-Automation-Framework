package vTiger.ContactTests;

import static org.testng.Assert.fail;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.compress.archivers.zip.X000A_NTFS;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Ignore;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vTiger.GenericUtilities.BaseClass;
import vTiger.GenericUtilities.ExcelFileUtility;
import vTiger.GenericUtilities.JavaUtillity;
import vTiger.GenericUtilities.PropertyFileUtility;
import vTiger.GenericUtilities.WebDriverUtility;
import vTiger.ObjectRepository.ContactInfoPage;
import vTiger.ObjectRepository.ContactPage;
import vTiger.ObjectRepository.CreateNewContactPage;
import vTiger.ObjectRepository.CreateNewOrganizationPage;
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.LoginPage;
import vTiger.ObjectRepository.OrganizationInfoPage;
import vTiger.ObjectRepository.OrganizationPage;

	@Listeners(vTiger.GenericUtilities.ListenerImplementationClass.class)//Because listener will take only .class path
	public class CreateContactsWithOrganisationUsingDDTTest extends BaseClass
	{
	@Test/**(groups = "SmokeSuite")**/
	public void createContactsWithOrgTest() throws IOException
	{
		//step-1 Read the test data
				String LASTNAME = eUtil.readDataFromExcelFile("Contacts", 7, 2);
				String ORGNAME = eUtil.readDataFromExcelFile("Contacts", 7, 3)+jUtil.getRandomNumber();
				String LEADSOURCE = eUtil.readDataFromExcelFile("Contacts", 7,4 );
				
				//Step 5: Navigate to Organization link
				HomePage hp = new HomePage(driver);
				hp.clickOnOrganizationLink();
				Reporter.log("organisation is clicked",true); //true means it will print in report & console also 
				//Assert.fail();
			
				//Step 6: Click On create Organization look up image
				OrganizationPage op = new OrganizationPage(driver);
				op.clickOnCreateOrgLookUpImg();
				Reporter.log("create organisation lookup image is clicked",true);
				
				//Step 7: Create Organization with Mandatory details and Save
				CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
				cnop.createNewOrganization(ORGNAME);
				Reporter.log("organisation is created"+ ORGNAME,true);
				
				//Step 8 Validate Organization
				OrganizationInfoPage oip = new OrganizationInfoPage(driver);
				String orgHeader = oip.getOrganizationHeaderText();
				Assert.assertEquals(orgHeader.contains(ORGNAME), true);
		
				/**if(orgHeader.contains(ORGNAME))
				{
					System.out.println(orgHeader);
					System.out.println("organization created");
				}
				else
				{
					System.out.println("organization not created");
				}
				**/
				
				//Step 9: Navigate to Contacts link
				hp.clickOnContactsLink();
				Reporter.log("contacts link is clicked",true);
				
				//Step 10: Click on Create Contact look up image
				ContactPage cp = new ContactPage(driver);
				cp.ClickOnCreateContactLookupImg();
				Reporter.log("create contacts lookup image is clicked",true);
				
				//Step 11: Create Contact with mandatory fields
				CreateNewContactPage cncp = new CreateNewContactPage(driver);
				cncp.createNewContact(LASTNAME, ORGNAME, "Partner", driver);
				Reporter.log("new contacts with organization is created"+ LASTNAME,true);
				
					
				//Step 16: Validate for Contacts
				ContactInfoPage cip = new ContactInfoPage(driver);
				String contHeaderText = cip.getContHeaderText();
				Assert.assertTrue(contHeaderText.contains(LASTNAME));
			/**	if(contHeaderText.contains(LASTNAME))
				{
					System.out.println(contHeaderText);
					System.out.println("PASS");
				}
				else
				{
					System.out.println("FAIL");
				}
			**/
	     }
	//@Test/**(groups = "RegressionSuite")**/
	public void demo()
	{
		System.out.println("demo test run");
	}
	}
