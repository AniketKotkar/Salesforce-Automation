package VerifyPOM;


import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.opencsv.exceptions.CsvValidationException;

import POM.VisitCreation;
import io.github.bonigarcia.wdm.WebDriverManager;

public class VerifyVisitCreationClass {
	 public static WebDriver driver;
	 public static ChromeOptions options;
	 public static ExtentHtmlReporter HtmlReporter;
	 public static ExtentReports report;
	 public static ExtentTest test;

	@BeforeSuite
	void launchBrowser() {
		WebDriverManager.chromedriver().setup();	
		options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);
		driver.get("https://test.salesforce.com/");
	    driver.manage().window().maximize();
	    driver.manage().deleteAllCookies();
	    driver.navigate().refresh();
	    HtmlReporter = new ExtentHtmlReporter("C:\\Users\\areya\\Downloads\\Salesforcetasksh (1)\\Salesforcetask\\Extent Report\\report.html");
	    HtmlReporter.config().setTheme(Theme.DARK);  	
		report = new ExtentReports();  	
	    report.attachReporter(HtmlReporter);  
	};
	

	@Test
	void VerifyTask() throws InterruptedException, CsvValidationException, IOException {
	test = report.createTest("Verify Task").assignCategory("Visit Creation").assignAuthor("Shivam");
	
	 VisitCreation object1 = new  VisitCreation (driver);
	 object1.LoginDeal();
	
//     VisitCreation object2 = new  VisitCreation (driver);
//     object2.VisitCreations();
     
     VisitCreation object3 = new  VisitCreation (driver);
	 object3.ProjectTeamRecordCreation();
//	 
//     VisitCreation object4 = new  VisitCreation (driver);
//	 object4.ProjectAccountCreation();
//	 
//	 VisitCreation object5 = new  VisitCreation (driver);
//	 object5.ProjectCreation();
//	
    
	}
    @AfterMethod
    void screen(ITestResult result) throws IOException
    {
    	File file1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    	String path0 = "C:\\Users\\areya\\Downloads\\Salesforcetasksh (1)\\Salesforcetask\\screenshot\\failed.png";
    	File path =new File(path0);
    	FileHandler.copy(file1, path);
    	if (result.getStatus()== ITestResult.FAILURE)
    		{
    			test.fail("Test case is failed",MediaEntityBuilder.createScreenCaptureFromPath(path0).build());
    			test.log(Status.FAIL, result.getName());
    			test.log(Status.FAIL, result.getThrowable());				
    		}
    		else
    		{
    			 test.pass("Test case is passed");
    		}
    		report.flush();
    }
    @AfterClass
    void quiteBrowser()
    {
          driver.quit();
    }
    
}

