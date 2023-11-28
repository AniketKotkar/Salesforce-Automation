package POM;

import java.io.FileReader;
import java.io.IOException;
import java.net.SocketException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import utility.Wait;

public class LoginPageEmerson {
	@FindBy(xpath="//input[@class='input r4 wide mb16 mt8 username']")public WebElement username_click;
	@FindBy(xpath="//input[@class='input r4 wide mb16 mt8 password']")public WebElement password_click;
	@FindBy(xpath="//input[@class='button r4 wide primary']")public WebElement loginbtn_click;
	@FindBy(xpath="(//a[@class='al-menu-item slds-p-vertical--xxx-small'])[1]")public WebElement Sales_center_click;
	@FindBy(xpath="(//one-app-nav-bar-item-root[@class='navItem slds-context-bar__item slds-shrink-none'])[3]")WebElement Lead_click;
	@FindBy(xpath="(//a[@class='forceActionLink'])[1]")WebElement New_click;
	@FindBy(xpath="(//span[@class='slds-radio--faux'])[2]")WebElement Discrete_automation_click;
	@FindBy(xpath="(//span[@class=' label bBody'])[5]")WebElement Next_click;
	@FindBy(xpath="(//button[@class='slds-combobox__input slds-input_faux slds-combobox__input-value'])[1]")WebElement Salutaion_click;
	@FindBy(xpath="(//span[@class='slds-media__body'])[2]")WebElement Mr_click;
	@FindBy(xpath="(//div[@part='input-text']//div[@class='slds-form-element__control slds-grow'])[2]")WebElement Firstname_click;
	@FindBy(xpath="(//div[@part='input-text']//div[@class='slds-form-element__control slds-grow'])[3]")WebElement Lastname_click;
	@FindBy(xpath="//div//input[@class='slds-combobox__input slds-input']")WebElement Address_click;
	
	@FindBy(xpath="//div//span//lightning-base-combobox-formatted-text[@title='100 Pine Street']")WebElement _100_Pine_Street_click;
	
	
	
	
	
	
	
	
	
//	@FindBy(xpath="(//div[@part='input-text']//div[@class='slds-form-element__control slds-grow'])[4]")WebElement City_click;
//	@FindBy(xpath="(//div[@part='input-text']//div[@class='slds-form-element__control slds-grow'])[5]")WebElement state_click;
//	@FindBy(xpath="(//div[@part='input-text']//div[@class='slds-form-element__control slds-grow'])[6]")WebElement Zipcode_click;
	@FindBy(xpath="(//div[@part='input-text']//div[@class='slds-form-element__control slds-grow'])[7]")WebElement Country_click;
	@FindBy(xpath="(//div[@part='input-text']//div[@class='slds-form-element__control slds-grow'])[7]//input")WebElement Country2_click;
	
	

	@FindBy(xpath="(//div[@part='input-text']//div[@class='slds-form-element__control slds-grow'])[8]")WebElement Company_click;
	@FindBy(xpath="(//div[@part='input-text']//div[@class='slds-form-element__control slds-grow'])[9]")WebElement Email_click;
	
	@FindBy(xpath="(//button[@class='slds-combobox__input slds-input_faux slds-combobox__input-value'])[3]")WebElement CustomerType_click;
	@FindBy(xpath="//div//lightning-base-combobox-item//span[@class='slds-media__body']//span[@title='Assembler']")WebElement Assembler_click;
	
	@FindBy(xpath="(//button[@class='slds-combobox__input slds-input_faux slds-combobox__input-value'])[4]")WebElement MarketSegment_click;
	@FindBy(xpath="//div//lightning-base-combobox-item//span[@class='slds-media__body']//span[@title='Factory Automation']")WebElement FactoryAuto_click;
	
	
	
	@FindBy(xpath="(//button[@class='slds-combobox__input slds-input_faux slds-combobox__input-value'])[5]")WebElement MarketsubSegment_click;
	@FindBy(xpath="//div//lightning-base-combobox-item//span[@class='slds-media__body']//span[@title='Automotive']")WebElement Automotive_click;
	@FindBy(xpath="//lightning-button//button[@class='slds-button slds-button_brand' and @name='SaveEdit']")WebElement Save_click;
	
	
	@FindBy(xpath="(//a[@class='tabHeader slds-path__link'])[5]")WebElement Qualified_click;
//	@FindBy(xpath="(//li[@class='slds-is-incomplete slds-path__item runtime_sales_pathassistantPathAssistantTab'])[4]")WebElement Qualified_click;
	
	@FindBy(xpath="(//span[@class='uiOutputText'])[1]")WebElement Markstatus_click;
	@FindBy(xpath="(//a[@class='tabHeader slds-path__link'])[6]")WebElement converted_click;
//	@FindBy(xpath="(//li[@class='slds-is-incomplete slds-path__item runtime_sales_pathassistantPathAssistantTab'])[5]")WebElement converted_click;
	@FindBy(xpath="(//span[@class='uiOutputText'])[1]")WebElement Convertedstatus_click;
	@FindBy(xpath="//span//button[@class='slds-button slds-button_brand']")WebElement Convert_click;
	
	@FindBy(xpath="//div//button[@class='slds-button slds-button_brand']")WebElement Go_To_Leads_click;
	@FindBy(xpath="//h2[@class='title slds-text-heading--medium slds-hyphenate']")WebElement Get_Title1;
	@FindBy(xpath="//div[@class='title']//h2")WebElement Get_Title2;
	
	//div[@class='title']//h2
	
	
	String username;
	String password;
	String Day3;
	String latestDate;
	public WebDriver driver;
	@FindBy(xpath="//div[@class='slds-icon-waffle']")WebElement ClickOnDots;
	@FindBy(xpath="//input[contains(@placeholder,'Search apps and items...')]")WebElement SearchButton;
	@FindBy(xpath="//one-app-nav-bar-item-root[@class='navItem slds-context-bar__item slds-shrink-none']")WebElement MainSchedule_click;
	public LoginPageEmerson (WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	public void LoginDeal2() throws CsvValidationException, IOException, InterruptedException,SocketException{
		String CSV = "C:\\Testing\\Salesforcetask (1)\\Salesforcetask\\Emerson-credentials.csv";
		CSVReader reader = new CSVReader(new FileReader(CSV));
	    String[] cell;
	    while((cell=reader.readNext())!=null) 
		{ 
			   for(int i=0; i<1 ; i++)
			{
			    username = cell[i];
			    password = cell[i+1];
			}
		}
	    username_click.sendKeys(username);
	    Thread.sleep(2000);
	    password_click.sendKeys(password);
		Thread.sleep(2000);
		loginbtn_click.click();
	//	Thread.sleep(10000);
		Wait.explicitWait_clickAction(driver, ClickOnDots);
		Wait.explicitWait_clickAction(driver, SearchButton);
		Wait.explicitWait_sendkAction(driver, SearchButton, "Sales Center");
		SearchButton.sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		Wait.explicitWait_clickAction(driver, Lead_click);
		Wait.explicitWait_clickAction(driver, New_click);
		Wait.explicitWait_clickAction(driver, Discrete_automation_click);
		Wait.explicitWait_clickAction(driver, Next_click);
		Wait.explicitWait_clickAction(driver, Salutaion_click);
		Wait.explicitWait_clickAction(driver, Mr_click);
		Wait.explicitWait_clickAction(driver, Firstname_click);
		Wait.explicitWait_sendkAction(driver, Firstname_click, "Andrew");
		Wait.explicitWait_clickAction(driver, Lastname_click);
		Wait.explicitWait_sendkAction(driver, Lastname_click, "Dixon");
		Wait.explicitWait_clickAction(driver, Address_click);
		Wait.explicitWait_sendkAction(driver, Address_click, "100 Pine Street");
		Wait.explicitWait_clickAction(driver, _100_Pine_Street_click);
		Thread.sleep(2000);
		Wait.explicitWait_clickAction(driver, Country_click);
		Thread.sleep(2000);
		Country2_click.clear();
		Wait.explicitWait_sendkAction(driver, Country2_click, "US");
		Wait.explicitWait_clickAction(driver, Company_click);
		Wait.explicitWait_sendkAction(driver, Company_click, "Syneoshealth");
		Wait.explicitWait_clickAction(driver, Email_click);
		Wait.explicitWait_sendkAction(driver, Email_click, "andrew.dixon@syneosgmail.invalid");
		Wait.explicitWait_clickAction(driver, CustomerType_click);
		Wait.explicitWait_clickAction(driver, Assembler_click);
		Wait.explicitWait_clickAction(driver, MarketSegment_click);
		Wait.explicitWait_clickAction(driver, FactoryAuto_click);
		Wait.explicitWait_clickAction(driver, MarketsubSegment_click);
		Wait.explicitWait_clickAction(driver, Automotive_click);
		Wait.explicitWait_clickAction(driver, Save_click);
		Thread.sleep(10000);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", Qualified_click);
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", Markstatus_click);
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", converted_click);
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", Convertedstatus_click);
		Thread.sleep(5000);
		System.out.println(Get_Title1.getText());
		Thread.sleep(2000);
		Wait.explicitWait_clickAction(driver, Convert_click);
		Thread.sleep(10000);
		System.out.println("Task is ended");
	}
}
