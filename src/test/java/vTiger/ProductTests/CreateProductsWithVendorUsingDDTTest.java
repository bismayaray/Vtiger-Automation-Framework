package vTiger.ProductTests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
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
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vTiger.GenericUtilities.ExcelFileUtility;
import vTiger.GenericUtilities.JavaUtillity;
import vTiger.GenericUtilities.PropertyFileUtility;
import vTiger.GenericUtilities.WebDriverUtility;

public class CreateProductsWithVendorUsingDDTTest 
{
	@Test
	public void createProductWithVendorUsingDDTTest() throws IOException
	{
		//Step 1: Create the necessary objects of all utilities
		PropertyFileUtility putil = new PropertyFileUtility();
		ExcelFileUtility eutil = new ExcelFileUtility();
		JavaUtillity jutil = new JavaUtillity();
		WebDriverUtility wutil = new WebDriverUtility();
		
		//Step 2: Read the required Data
		String BROWSER = putil.readDataFromPropertyFile("browser");
		String URL = putil.readDataFromPropertyFile("url");
		String USERNAME = putil.readDataFromPropertyFile("username");
		String PASSWORD = putil.readDataFromPropertyFile("password");
		
		      //for creating vendor name
		String VENDOR = eutil.readDataFromExcelFile("products",4,3)+jutil.getRandomNumber();
		      //for creating product name
		String PRODUCT = eutil.readDataFromExcelFile("products",4,2)+jutil.getRandomNumber();
		
		//Step 3: Launch the browser
		WebDriver driver = null;
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();	
		}
		else
		{
			System.out.println("browser name is invalid");
		}
		
		
		wutil.maximizewindow(driver);
		wutil.waitForPageLoad(driver);
		driver.get(URL);
		
		//Step 4: Login to Application
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		//Step 5: Navigate to Vendor
		WebElement MOREbtn = driver.findElement(By.xpath("//a[text()='More']"));
		wutil.mouseHoverAction(driver, MOREbtn);
		driver.findElement(By.name("Vendors")).click();
		//Step 6: Click On create vendor look up image
		driver.findElement(By.xpath("//img[@title='Create Vendor...']")).click();
		//Step 7: Create vendor with Mandatory details and Save
		driver.findElement(By.name("vendorname")).sendKeys(VENDOR);
		driver.findElement(By.name("button")).click();
		
		//Step 8 Validate the vendor
		String VendorHeader =driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
		if(VendorHeader.contains(VENDOR))
		{
			System.out.println(VendorHeader);
			System.out.println("vendor created successfully");
		}
		else
		{
			System.out.println("vendor creation failed");
		}
		
		//Step 9: Navigate to Products link
		driver.findElement(By.xpath("//a[text()='Products']/../a[1]")).click();
		//Step 10: Click on Create product look up image
		driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
		//Step 11: Create product with mandatory fields 
		driver.findElement(By.name("productname")).sendKeys(PRODUCT);
		//Step 12: Navigate to vendor look up image
		driver.findElement(By.xpath("//img[@alt='Select']")).click();
		//Step 13: Switch the control to vendor window
		wutil.switchToWindow(driver,"Vendors");
		driver.findElement(By.name("search_text")).sendKeys(VENDOR);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.xpath("//a[text()='"+VENDOR+"']")).click();//Dynamic Xpath - Xpath generated at run time
		//Step 14: Switch the control back to parent window product window
		wutil.switchToWindow(driver,"Products");
		//Step 15: save
		driver.findElement(By.name("button")).click();
		
		//Step 16: Validate for Products
		String ProductHeader =driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
		if(ProductHeader.contains(PRODUCT))
		{
			System.out.println(ProductHeader);
			System.out.println("product created successfully");
		}
		else
		{
			System.out.println("product creation failed");
		}
		
		//Step 17: Logout of Application
		WebElement profilebtn = driver.findElement(By.xpath("(//td[@valign='bottom'])[2]"));
		wutil.mouseHoverAction(driver, profilebtn);
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		
		driver.quit();
		
		
	}
}