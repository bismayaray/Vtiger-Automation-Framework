package vTiger.GenericUtilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * This class provides implementation to the ITestListener of TestNG
 * @author bismaya
 *
 */
public class ListenerImplementationClass implements ITestListener
{

	ExtentReports report;
	ExtentTest test;
	
	public void onTestStart(ITestResult result) 
	{
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+".....Test execution started.....");
		test = report.createTest(methodName);
	}

	public void onTestSuccess(ITestResult result) 
	{
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+"Test execution is successfull");
		test.log(Status.PASS,methodName+" -- Success");
	}

	/**
	 * This method is to take screenshot for failed test script
	 */
	public void onTestFailure(ITestResult result) 
	{
		WebDriverUtility wutil = new WebDriverUtility();
		JavaUtillity jUtil =new JavaUtillity();
		
		String methodName = result.getMethod().getMethodName();
		test.log(Status.FAIL,methodName+" -- Failed");
		test.log(Status.FAIL,result.getThrowable());
		
		
		String screenshotname = methodName+"-"+jUtil.getSystemDateInFormat();
		try {
			wutil.takeScreenShot(BaseClass.sDriver,screenshotname);
			}
		catch (IOException e) 
			{
			e.printStackTrace();
			}
	}

	public void onTestSkipped(ITestResult result) 
	{
		String methodName = result.getMethod().getMethodName();
		test.log(Status.SKIP,methodName  +"--skipped");
		test.log(Status.SKIP,result.getThrowable());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	public void onStart(ITestContext context)
	{
		System.out.println("Execution started");
		//step-1  create object of extent spark reporter class
		ExtentSparkReporter htmlReport= new ExtentSparkReporter(".\\ExtentReports\\Report "+new JavaUtillity());
		htmlReport.config().setDocumentTitle("execution Report");
		htmlReport.config().setTheme(Theme.DARK);
		htmlReport.config().setReportName("Vtiger Execution Report");
		
		//step-2  Attach the html report to extent report
		report = new ExtentReports();
		report.attachReporter(htmlReport);
		report.setSystemInfo("Base Platform","Windows");
		report.setSystemInfo("Base Browser","Firefox");
		report.setSystemInfo("Base Environment","Testing");
		report.setSystemInfo("Base URL","http://localhost:8888");
		report.setSystemInfo("Author","Bismaya");
	}

	public void onFinish(ITestContext context) 
	{
		System.out.println("Execution finished");
		
		//Flush the report - consolidate the status of every test script and generate the report
		report.flush();
	}
}
