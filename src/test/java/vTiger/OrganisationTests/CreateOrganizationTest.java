package vTiger.OrganisationTests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
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

public class CreateOrganizationTest extends BaseClass
{
    @Test
    public void createOrgnizationTest() throws IOException
    {
		/*Excel File - Test Data*/
		String ORGNAME = eUtil.readDataFromExcelFile("Organisations",4,2)+jUtil.getRandomNumber();
		String INDUSTRYTYPE = eUtil.readDataFromExcelFile("Organisations",4,3);

		//Step 4: Click on Organizations Link
		HomePage hp = new HomePage(driver);
		hp.clickOnOrganizationLink();
		
		//Step 5: click on create organization lookup image
		OrganizationPage op = new OrganizationPage(driver);
		op.clickOnCreateOrgLookUpImg();
		
		//Step 6: Create new organization with mandatory information and save
		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
		//cnop.createNewOrganization(ORGNAME);
		cnop.createNewOrganization(ORGNAME, "Consulting");
		
		
		//Step 7: Validate:
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String OrgHeader = oip.getOrganizationHeaderText();
		Assert.assertEquals(OrgHeader.contains(ORGNAME), true);
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
