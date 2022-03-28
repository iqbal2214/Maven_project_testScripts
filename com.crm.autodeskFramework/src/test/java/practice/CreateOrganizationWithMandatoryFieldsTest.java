package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import crm.com.autodesk.generic.utility.ExcelUtility;
import crm.com.autodesk.generic.utility.FileUtility;
import crm.com.autodesk.generic.utility.JavaUtilities;
import crm.com.autodesk.generic.utility.WebDriverUtility;

public class CreateOrganizationWithMandatoryFieldsTest {
	public static void main(String[] args) throws Throwable  {
		WebDriverUtility wbu=new WebDriverUtility();
		ExcelUtility eu=new ExcelUtility();
		FileUtility fu=new FileUtility();
		JavaUtilities ju=new JavaUtilities();
		
		String URL=fu.getPropertyFile("url");
		String BROWSER=fu.getPropertyFile("browser");
		String USERNAME=fu.getPropertyFile("username");
		String PASSWORD=fu.getPropertyFile("password");
		
		WebDriver driver=wbu.lauchBrowserWithUrl(BROWSER, URL);
		wbu.waitForPageToLoad(driver,20);

		String INDUSTRY=eu.getExcelProperties("Sheet1", 2, 3);
		String NAME=eu.getExcelProperties("Sheet1", 1, 3);
		String ORGNAME=NAME+ju.getRandomNum();
			
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(ORGNAME);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		WebElement ind=driver.findElement(By.name("industry"));
		wbu.selectFromList(ind, INDUSTRY);
		String text=driver.findElement(By.className("dvHeaderText")).getText();
		
		if(text.contains(ORGNAME))
		{
			System.out.println(ORGNAME+" Organization created and pass");
		}else{
			System.out.println(ORGNAME+" Organization created and fail");
		}
		
	
		WebElement signout=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wbu.waitForElementToBeClickable(driver, 10, signout);
		
		wbu.mouseOverToElement(driver, signout);
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();	
		
		driver.close();
	}


}
