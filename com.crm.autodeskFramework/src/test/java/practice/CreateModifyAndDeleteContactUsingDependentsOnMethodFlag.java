package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateModifyAndDeleteContactUsingDependentsOnMethodFlag {
	
	WebDriver driver=null;
	String lastName="Singhaniya";
	String newLastName="Milan";
	@Test
	public void createContact() {
		
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			driver.get("http://localhost:8888");;
		
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		String lastName="Singhaniya";
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("root");
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		driver.findElement(By.name("lastname")).sendKeys(lastName);
		driver.findElement(By.id("mobile")).sendKeys("5468587654");
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		
		WebElement signout=driver.findElement(By.xpath("//span[text()=' Administrator']/ancestor::tr/descendant::img[@src='themes/softed/images/user.PNG']"));
		Actions act=new Actions(driver);
		act.moveToElement(signout).perform();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();	
	}
	
	@Test(dependsOnMethods = "createContact")
	public void modifyContact() throws Throwable {
		
		
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("root");
		driver.findElement(By.id("submitButton")).click();
		
		//WebDriverWait wait=new WebDriverWait(driver,20);
		//wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//input[@title='Save [Alt+S]']"))));
		driver.findElement(By.linkText("Contacts")).click();
		WebElement ele=driver.findElement(By.xpath("//b[text()='In']/ancestor::table[@class='searchUIBasic small']/descendant::select[@id='bas_searchfield']"));
		Select select=new Select(ele);
		select.selectByVisibleText("Last Name");
		driver.findElement(By.xpath("//input[@class='txtBox']")).sendKeys(lastName,Keys.ENTER);
		driver.findElement(By.xpath("//a[text()='"+lastName+"']")).click();
		driver.findElement(By.xpath("//input[@title='Edit [Alt+E]']")).click();
		driver.findElement(By.xpath("//input[@name='lastname']")).clear();
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(newLastName);
		driver.findElement(By.id("mobile")).clear();
		driver.findElement(By.id("mobile")).sendKeys("9826455785");
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		WebElement signout=driver.findElement(By.xpath("//span[text()=' Administrator']/ancestor::tr/descendant::img[@src='themes/softed/images/user.PNG']"));
		Actions act=new Actions(driver);
		act.moveToElement(signout).perform();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();	
		
	}
	
	@Test(dependsOnMethods = "modifyContact")
	public void deleteContact() {
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("root");
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("Contacts")).click();
		Select select=new Select(driver.findElement(By.xpath("//b[text()='In']/ancestor::table[@class='searchUIBasic small']/descendant::select[@id='bas_searchfield']")));
		select.selectByVisibleText("Last Name");
		driver.findElement(By.xpath("//input[@class='txtBox']")).sendKeys(lastName,Keys.ENTER);
		driver.findElement(By.xpath("//a[text()='"+lastName+"']")).click();
		driver.findElement(By.xpath("//input[@title='Delete [Alt+D]']")).click();
		driver.switchTo().alert().accept();
		
		if(driver.findElement(By.xpath("//a[@class='hdrLink']")).getText().equals("Contacts")) {
			System.out.println("deleted modified contact succesfully");
		}else {
			System.out.println("failed to delete modified contact");
		}
		
		WebElement signout=driver.findElement(By.xpath("//span[text()=' Administrator']/ancestor::tr/descendant::img[@src='themes/softed/images/user.PNG']"));
		Actions act=new Actions(driver);
		act.moveToElement(signout).perform();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();	
		
		driver.close();
	}

}
