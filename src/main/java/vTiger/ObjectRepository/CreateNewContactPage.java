package vTiger.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vTiger.GenericUtilities.WebDriverUtility;

public class CreateNewContactPage extends WebDriverUtility
{
	//Declaration
	@FindBy(name="lastname")
	private WebElement lastnameEdt;
	
	@FindBy(name="leadsource")
	private WebElement leadsourceDropDown;
	
	@FindBy(xpath="//input[@name='account_name']/following-sibling::img[@alt='Select']")
	private WebElement OrganizationImg;
	
	@FindBy(id="search_txt")
	private WebElement searchEdt;
	
	@FindBy(name="search")
	private WebElement searchBtn;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;

	//Initialization
	public CreateNewContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	//Utilization
	public WebElement getLastnameEdt() {
		return lastnameEdt;
	}

	public WebElement getLeadsourceDropDown() {
		return leadsourceDropDown;
	}

	public WebElement getOrganizationImg() {
		return OrganizationImg;
	}

	public WebElement getSearchEdt() {
		return searchEdt;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
		//Business Library
		/**
		 * This method will create contact with mandatory details
		 * @param orgName
		 */
		public void createContact(String lastname)
		{
			lastnameEdt.sendKeys(lastname);
			saveBtn.click();
		}
		/**
		 * This method will create contact with organization
		 * @param lastname
		 * @param orgName
		 * @param driver
		 */
		public void createNewContact(String lastname, String orgName,String leadsourceName, WebDriver driver)
		{
			lastnameEdt.sendKeys(lastname);
			handleDropDown(leadsourceDropDown, leadsourceName);
			OrganizationImg.click();
			switchToWindow(driver,"Accounts");
			searchEdt.sendKeys(orgName);
			searchBtn.click();
			driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
			switchToWindow(driver,"Contacts");
			saveBtn.click();
		
		}
	
}