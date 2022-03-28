package practice;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.crm.ObjectRepository.LoginPage;

import crm.com.autodesk.generic.utility.ExcelUtility;
import crm.com.autodesk.generic.utility.FileUtility;
import crm.com.autodesk.generic.utility.JavaUtilities;
import crm.com.autodesk.generic.utility.WebDriverUtility;

public class CreateCampaignTest {
	public static void main(String[] args) throws Throwable {
		
		WebDriverUtility wbu=new WebDriverUtility();
		ExcelUtility eu=new ExcelUtility();
		FileUtility fu=new FileUtility();
		JavaUtilities ju=new JavaUtilities();
		
		String URL=fu.getPropertyFile("url");
		String BROWSER=fu.getPropertyFile("browser");
		String USERNAME=fu.getPropertyFile("username");
		String PASSWORD=fu.getPropertyFile("password");
		
		String CAMPAIGNNAME=eu.getExcelProperties("Sheet1", 9, 3);
		String PRODUCTNAME=eu.getExcelProperties("Sheet1", 7, 3);
	
		CAMPAIGNNAME=CAMPAIGNNAME+ju.getRandomNum();
		PRODUCTNAME=PRODUCTNAME+ju.getRandomNum();
		
		WebDriver driver = wbu.lauchBrowserWithUrl(BROWSER, URL);
		System.out.println("browser launched successfully");
		
		wbu.waitForPageToLoad(driver,20);
		
		System.out.println("browser launched is "+ BROWSER);
		
		LoginPage login=new LoginPage(driver);
		login.login(USERNAME, PASSWORD);
		
		
		System.out.println("login successfully");
		
		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
		driver.findElement(By.name("productname")).sendKeys(PRODUCTNAME);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		String text=driver.findElement(By.className("lvtHeaderText")).getText();
		if(text.contains(PRODUCTNAME)) {
		System.out.println("contact creation succesfully");
		}else {
			System.out.println("contact creation failed");
		}
		
		WebElement more=driver.findElement(By.xpath("//td[@class='tabUnSelected' and @onmouseover]"));
		wbu.mouseOverToElement(driver, more);
		driver.findElement(By.linkText("Campaigns")).click();
		driver.findElement(By.xpath("//img[@title='Create Campaign...']")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/select.gif']")).click();
		driver.findElement(By.name("campaignname")).sendKeys(CAMPAIGNNAME);
		
		wbu.switchToWindow(driver, "Accounts");
		
		driver.findElement(By.xpath("//input[@id='search_txt']")).sendKeys(PRODUCTNAME);	
		driver.findElement(By.xpath("//input[@name='search']")).click();
		driver.findElement(By.xpath("//a[text()='"+PRODUCTNAME+"']")).click();;
		wbu.switchToWindow(driver, "Contacts");
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		String text1=driver.findElement(By.className("dvHeaderText")).getText();
		if(text1.contains(CAMPAIGNNAME)) {
		System.out.println("campaign creation succesfully");
		}else {
			System.out.println("contact creation failed");
		}
		
		WebElement signout=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wbu.waitForElementToBeClickable(driver, 20, signout);
		wbu.mouseOverToElement(driver, signout);
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();	
		
		System.out.println("logout successfully");
		
		driver.close();
		
		System.out.println("========browser closed========");
		
	}

	}


