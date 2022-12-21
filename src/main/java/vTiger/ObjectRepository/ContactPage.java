package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage 
{
	//Declaration
	@FindBy(xpath= "//img[@alt='Create Contact...']")
	private WebElement CreateContactlookupImg;

	//Initialization
	public ContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	//Utilization
	public WebElement getCreateContactlookupImg() {
		return CreateContactlookupImg;
	}
	
	/**
	 * This method will click on create contact look up image
	 */
	//Business library
	public void ClickOnCreateContactLookupImg()
	{
		CreateContactlookupImg.click();
	}
}
