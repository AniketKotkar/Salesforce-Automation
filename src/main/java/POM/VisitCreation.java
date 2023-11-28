package POM;

import java.time.Duration;
import java.util.List;
import java.io.FileReader;
import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import utility.Wait;

public class VisitCreation {
	WebDriver driver;
	@FindBy(xpath="//div[@class='slds-icon-waffle']")WebElement ClickOnDots;
	@FindBy(xpath="//input[contains(@placeholder,'Search apps and items...')]")WebElement SearchButton;
	@FindBy(xpath="//one-app-nav-bar-item-root[@class='navItem slds-context-bar__item slds-shrink-none']")WebElement MainSchedule_click;
	@FindBy(xpath="//iframe[@title='accessibility title']")WebElement Iframe;
	@FindBy(xpath="//li[@class='wt-Schedule']")WebElement Schedule_click;
	@FindBy(xpath="//tr[@id='sirenumHeaderRow']//th")WebElement validateuser_click;
	@FindBy(xpath="//a[@id='menuNextWeek']")WebElement next_click;
	@FindBy(xpath="//table//tr/following-sibling::tr[@id='lockedRowsPlaceholder']/following-sibling::tr/td[2]")WebElement date_click;
	@FindBy(xpath="//div[contains(text(),'New Visit')]")WebElement new_visit;
	@FindBy(xpath="(//table//tr/following-sibling::tr[@ID='sirenumRow_*']//td)[12]/div[2]")WebElement Sourcelocator;
	@FindBy(xpath="(//tr[@rownum='19']/td)[5]")WebElement Destinationlocator;
	@FindBy(xpath="//div[@class='sirenumFormElement'][4]//input")WebElement SelectProject;
	@FindBy(xpath="//div[@class='sirenumFormElement'][6]//input")WebElement VisitType;
	@FindBy(xpath="//div[@class='sirenumFormElement'][7]//input")WebElement VisitNumber ;
	@FindBy(xpath="//div[@class='sirenumFormElement'][8]//input")WebElement Participant ;
	@FindBy(xpath="//div[@class='sirenumFormElement'][9]//input")WebElement ParticipantLocation ;
	@FindBy(xpath="//*[@id='miniFormSave']")WebElement FormSave ;
	@FindBy(xpath="//*[@id='menuTopSave']")WebElement TopSave ;
	@FindBy(xpath="//span[@class='uiImage']")WebElement ClickonProfile ;
	@FindBy(xpath="//a[@class='profile-link-label logout uiOutputURL']")WebElement Logout ;
	@FindBy(xpath="//tr[@id='sirenumHeaderRow']")WebElement scale  ;
	@FindBy(xpath=" (//div[@id='pageMessages']//following-sibling::div)[2]]")WebElement success_msg ;
    String url ="https://illingworthresearchgroup--irgqa.sandbox.lightning.force.com/lightning/page/home";
    SoftAssert pick=new SoftAssert ();
    String username;
    String password;
    String Day3;
    String latestDate;
    String msg;
    
   
    
public VisitCreation(WebDriver driver) {
	PageFactory.initElements(driver, this);
	this.driver=driver;
	
}

public void VisitCreations() throws InterruptedException, CsvValidationException, IOException
{
    Thread.sleep(10000);
	String trim=driver.getCurrentUrl();
	pick.assertEquals(trim,url);
	pick.assertAll();
	Wait.explicitWait_clickAction(driver, ClickOnDots);
	Wait.explicitWait_clickAction(driver, SearchButton);
	Wait.explicitWait_sendkAction(driver, SearchButton, "Illingworth");
	SearchButton.sendKeys(Keys.ENTER);
	Thread.sleep(10000);
	Wait.explicitWait_clickAction(driver, MainSchedule_click);	
    Thread.sleep(20000);
    driver.switchTo().frame(Iframe);
	Thread.sleep(6000);
	String CSV2 = "C:\\Testing\\Salesforcetask (1)\\Salesforcetask\\Date.csv";
	CSVReader reader2 = new CSVReader(new FileReader(CSV2));
    String[] cell2;
    while((cell2=reader2.readNext())!=null) 
	{ 
		   for(int i=0; i<1 ; i++)
		{ 
			Day3    =cell2[i];
		    latestDate =cell2[i+1];
	    }
	}	   
   String ppp = Day3+","+latestDate ;
   Thread.sleep(3000);
   String Date= scale.getText();
   if(Date.contains(ppp))
   {System.out.println(ppp);}
   else {
	   next_click.click();
	   Thread.sleep(8000);
   }
   List<WebElement> xyz=driver.findElements(By.xpath("//table//tr//th[@id='sirenumStatus']/following-sibling::th"));
   System.out.println(xyz.size());  
   for (int i=1; i<=xyz.size(); i++)
   {
	   Thread.sleep(2000);
	   String Text =driver.findElement(By.xpath("(//table//tr//th[@id='sirenumStatus']/following-sibling::th)["+i+"]")).getText();
	   System.out.println(Text);
	   System.out.println(i);
	   if(Text.equalsIgnoreCase(ppp))
	   {
		   System.out.println(Text);
		   WebElement dad=driver.findElement(By.xpath("(//tr[@id='sirenumRow_*']/td)["+(i+1)+"]"));
		   Actions act1 = new Actions(driver);
		   act1.moveToElement(dad).contextClick().build().perform();
		   new_visit.click();
		   String CSV1 = "C:\\Testing\\Salesforcetask (1)\\Salesforcetask\\Visitdetails.csv";
		   CSVReader reader1 = new CSVReader(new FileReader(CSV1));
		   String[] cell1;
		   while((cell1=reader1.readNext())!=null)  
			{ 
				   for(int j=0; j<1 ; j++)
				{
				   String selectproject = cell1[j];
				   String visittype = cell1[j+1];
				   String visitnumber = cell1[j+2];
				   String noofParticipants = cell1[j+3];
				   String location = cell1[j+4];
			
				SelectProject.sendKeys(selectproject);
		    	Thread.sleep(4000);
		    	SelectProject.sendKeys(Keys.ENTER);
		      	Thread.sleep(4000);
		      	VisitType.sendKeys(visittype);
		    	Thread.sleep(5000);
		    	VisitType.sendKeys(Keys.ENTER);
		    	VisitNumber.sendKeys(visitnumber);
		    	VisitType.sendKeys(Keys.TAB);
		    	Thread.sleep(4000);
		    	Participant.sendKeys(noofParticipants);
		    	Thread.sleep(4000);
		    	Participant.sendKeys(Keys.ENTER);
		    	ParticipantLocation.sendKeys(location);
		    	Thread.sleep(3000);
		    	ParticipantLocation.sendKeys(Keys.ENTER);
		    	Thread.sleep(10000);
		    	Wait.explicitWait_clickAction(driver, FormSave);
		   
		    	Thread.sleep(15000);
		    	Wait.explicitWait_clickAction(driver, TopSave);
		    	
				}
			}
		    List <WebElement> boss = driver.findElements(By.xpath("(//tr[@id='sirenumRow_*']/td)["+(i+1)+"]/child::div"));
			Thread.sleep(10000);
		    System.out.println(boss.size());  
			WebElement Drag=driver.findElement(By.xpath("(//tr[@id='sirenumRow_*']/td)["+(i+1)+"]/child::div["+boss.size()+"]"));
		    WebElement Drop = driver.findElement(By.xpath("(//div//a[contains(text(),'Ranjitha Ravikumar')]/parent::div/parent::div/parent::td/following-sibling::td)["+i+"]"));  
		    act1.dragAndDrop(Drag,Drop).build().perform();
	   }   
   }
	Thread.sleep(8000);
	TopSave.click();
	Thread.sleep(8000);
	Assert.fail("Test case is failed");
	Thread.sleep(10000);
}   
}
