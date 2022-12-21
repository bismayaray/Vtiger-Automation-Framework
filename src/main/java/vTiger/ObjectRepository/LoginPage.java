package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage //rule-1(class name end with page)
{
	//rule-2- Declaration
	@FindBy(name="user_name")
	private WebElement usernameEdt;
	
	@FindBy(name="user_password")
	private WebElement passwordEdt;
	
	@FindBy(id="submitButton")
	private WebElement submitBtn;
	
	//rule-3 - Initialization
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);	
	}

	//rule- 4 - Utilization
	public WebElement getUsernameEdt() {
		return usernameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}
	
	//rule-5 - Business library 
	/**
	 * This business library will perform login action
	 * @param Username
	 * @param Password
	 */
	public void loginToApp(String Username, String Password)
	{
		usernameEdt.sendKeys(Username);
		passwordEdt.sendKeys(Password);
		submitBtn.click();
	}
}
