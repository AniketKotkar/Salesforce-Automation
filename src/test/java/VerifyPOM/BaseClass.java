package VerifyPOM;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import POM.ClinicalSiteCreation;
import POM.LoginPage;
import POM.LoginPageEmerson;
import POM.ProjectAccountCreation;
import POM.ProjectTeamRecordCreation;
import POM.VisitCreation;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	 public static WebDriver driver;
	 public static ChromeOptions options;
	 public static ExtentHtmlReporter HtmlReporter;
	 public static ExtentReports report;
	 public static ExtentTest test;

     LoginPage lg  ;
     LoginPageEmerson lg2  ;
     VisitCreation vs;
     ClinicalSiteCreation cc;
     ProjectAccountCreation pac;
     ProjectTeamRecordCreation ptc;
	@BeforeTest
	void launchBrowser() {
		WebDriverManager.chromedriver().setup();	
		options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);
		driver.get("https://test.salesforce.com/");
	    driver.manage().window().maximize();
	    driver.manage().deleteAllCookies();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
	    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
	    driver.navigate().refresh();
	    HtmlReporter = new ExtentHtmlReporter("C:\\Testing\\Salesforcetask (1)\\Salesforcetask\\Extent Report\\report.html");
	    HtmlReporter.config().setTheme(Theme.DARK);  	
		report = new ExtentReports();  	
	    report.attachReporter(HtmlReporter);
	};
	
	@BeforeClass
	void objects ()
	{
		 lg=new LoginPage(driver);
		 lg2=new LoginPageEmerson(driver);
		 vs= new  VisitCreation (driver);
		 cc=new ClinicalSiteCreation(driver);
		 pac=new ProjectAccountCreation (driver);
		 ptc=new ProjectTeamRecordCreation (driver);		
	}
    @AfterMethod
    void screen(ITestResult result) throws IOException
    {
    	File file1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    //	String path0 = "C:\\Users\\areya\\Downloads\\Salesforcetasksh (1)\\Salesforcetask\\screenshot\\"+result.getMethod().getMethodName()+"failed.png";
    	String path0 = "C:\\Testing\\Salesforcetask (1)\\Salesforcetask\\screenshot\\failed.png";
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
    			File file2 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
  //  	    	String path00 = "C:\\Users\\areya\\Downloads\\Salesforcetasksh (1)\\Salesforcetask\\screenshot\\"+result.getMethod().getMethodName()+"passed.png";
    	    	String path00 = "C:\\Testing\\Salesforcetask (1)\\Salesforcetask\\screenshot\\passed.png";
    	    	File path01 =new File(path00);
    	    	FileHandler.copy(file2, path01);
    			if (result.getStatus()== ITestResult.SUCCESS)
    			{
        			test.pass("Test case is pass",MediaEntityBuilder.createScreenCaptureFromPath(path00).build());
        			test.log(Status.PASS, result.getName());
        		//	test.log(Status.PASS, result.getThrowable());		
        		}
    			 test.pass("Test case is passed");
    		}
    		report.flush();
    }
    @AfterTest
    void quiteBrowser()
    {
          driver.quit();
    }
}
