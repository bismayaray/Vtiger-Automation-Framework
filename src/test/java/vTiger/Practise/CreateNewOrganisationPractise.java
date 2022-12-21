package vTiger.Practise;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateNewOrganisationPractise {

	public static void main(String[] args) throws InterruptedException 
	{
		//launch browser
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://localhost:8888/index.php?action=Login&module=Users");
		
		//Login to application
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		//click on organization
		driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		
		//click on new organization image lookup
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		
		//create new organization with mandatory fields
		driver.findElement(By.name("accountname")).sendKeys("Jsp");
		driver.findElement(By.xpath("//input[@value='T']")).click();
		driver.findElement(By.name("button")).click();
		
		//sign out
		Thread.sleep(3000);
		Actions act = new Actions(driver);
		WebElement profilebtn = driver.findElement(By.xpath("(//td[@valign='bottom'])[2]"));
		act.moveToElement(profilebtn).perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	}
}
