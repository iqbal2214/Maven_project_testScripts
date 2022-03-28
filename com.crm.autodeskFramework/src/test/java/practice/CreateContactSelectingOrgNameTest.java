package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.crm.ObjectRepository.LoginPage;

import crm.com.autodesk.generic.utility.ExcelUtility;
import crm.com.autodesk.generic.utility.FileUtility;
import crm.com.autodesk.generic.utility.JavaUtilities;
import crm.com.autodesk.generic.utility.WebDriverUtility;

public class CreateContactSelectingOrgNameTest {

	public static void main(String[] args) throws Throwable {
		FileUtility fu=new FileUtility();
		ExcelUtility eu=new ExcelUtility();
		JavaUtilities ju=new JavaUtilities();
		WebDriverUtility wu=new WebDriverUtility();
		
		String BROWSER=fu.getPropertyFile("browser");
		String URL=fu.getPropertyFile("url");
		String USERNAME=fu.getPropertyFile("username");
		String PASSWORD=fu.getPropertyFile("password");
		
		String FIRSTNAME=eu.getExcelProperties("Sheet1", 4, 3);
		String LASTNAME=eu.getExcelProperties("Sheet1", 5, 3);
		String NAME=eu.getExcelProperties("Sheet1", 1, 3);
		
		
		LASTNAME=LASTNAME+ju.getRandomNum();
		String orgName=NAME+ju.getRandomNum();
		
		WebDriver driver = wu.lauchBrowserWithUrl(BROWSER, URL);
		
		System.out.println("browser launched successfully");
		
		driver.manage().window().maximize();
		wu.waitForPageToLoad(driver,20);
		
		System.out.println("browser launched is "+ BROWSER);
		
		LoginPage login=new LoginPage(driver);
		login.login(USERNAME, PASSWORD);
		
		System.out.println("login successfully");
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(orgName);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		String text=driver.findElement(By.className("dvHeaderText")).getText();
		
		if(text.contains(orgName))
		{
			System.out.println(orgName+" created and pass");
		}else{
			System.out.println(orgName+" created and fail");
		}
		
		wu.waitForElementToBeClickable(driver, 20, driver.findElement(By.linkText("Contacts")));
		
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		driver.findElement(By.name("firstname")).sendKeys(FIRSTNAME);
		driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
		driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img")).click();
	
		wu.switchToWindow(driver, "Accounts");
		
		driver.findElement(By.name("search_text")).sendKeys(orgName);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
		
		wu.switchToWindow(driver, "Contacts");
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();	
		String text1=driver.findElement(By.className("dvHeaderText")).getText();
		if(text1.contains(LASTNAME)) {
		System.out.println("contact creation succesfully");
		}else {
			System.out.println("contact creation failed");
		}
	
		WebElement signout=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wu.waitForElementToBeClickable(driver, 20, signout);
		wu.mouseOverToElement(driver, signout);
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();	
		
		System.out.println("logout successfully");
		
		driver.close();
		
		System.out.println("========browser closed========");		
	}

	}
