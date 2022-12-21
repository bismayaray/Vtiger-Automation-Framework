package vTiger.OrganisationTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vTiger.GenericUtilities.BaseClass;
import vTiger.GenericUtilities.ExcelFileUtility;
import vTiger.GenericUtilities.JavaUtillity;
import vTiger.GenericUtilities.PropertyFileUtility;
import vTiger.GenericUtilities.WebDriverUtility;
import vTiger.ObjectRepository.CreateNewOrganizationPage;
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.LoginPage;
import vTiger.ObjectRepository.OrganizationInfoPage;
import vTiger.ObjectRepository.OrganizationPage;

public class CreateMultipleOrganisationWithDataprovider extends BaseClass
{

	@Test(dataProvider = "OrgData")
	public void createMultipleOrg(String ORGNAME, String INDUSTRY) throws IOException
	{
		//step-1 read data into data provider
		String ORGMNAME = ORGNAME+jUtil.getRandomNumber();
	
		//Step 4: Click on Organizations Link
		HomePage hp = new HomePage(driver);
		hp.clickOnOrganizationLink();
		
		//Step 5: click on create organization lookup image
		OrganizationPage op = new OrganizationPage(driver);
		op.clickOnCreateOrgLookUpImg();
		
		//Step 6: Create new organization with mandatory information and save
		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
		//cnop.createNewOrganization(ORGNAME);
		cnop.createNewOrganization(ORGMNAME, INDUSTRY);
		
		
		//Step 7: Validate:
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String OrgHeader = oip.getOrganizationHeaderText();
		Assert.assertEquals(OrgHeader.contains(ORGMNAME), true);
	/**	if(OrgHeader.contains(ORGMNAME))
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
	
	/*Excel File DataProvider- Test Data*/
	@DataProvider(name="OrgData")
	public Object[][] getData() throws EncryptedDocumentException, IOException
	{
		return eUtil.readMultipleDataIntoDataprovider("MultipleOrganisation");
	}

}
