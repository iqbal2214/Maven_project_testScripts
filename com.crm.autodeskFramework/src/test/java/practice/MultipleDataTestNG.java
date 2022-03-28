package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultipleDataTestNG {
	/*to execute same script with multiple data*/
	//use @DataProvider annotation====>it will provide the data to @Test annotated method
	
	@Test(dataProvider="getData")
	public void createContactWithMultipleData(String lastName,String contactNum) throws Throwable {		
			WebDriverManager.chromedriver().setup();
			WebDriver driver=new ChromeDriver();
			driver.get("http://localhost:8888");;
		
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("root");
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		driver.findElement(By.name("lastname")).sendKeys(lastName);
		driver.findElement(By.id("mobile")).sendKeys(contactNum);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		
		WebElement signout=driver.findElement(By.xpath("//span[text()=' Administrator']/ancestor::tr/descendant::img[@src='themes/softed/images/user.PNG']"));
		Actions act=new Actions(driver);
		act.moveToElement(signout).perform();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();	
		driver.close();
	}
	
	
	@DataProvider
	public Object[][] getData() {
		Object[][] contactData=new Object[5][2];
		
		contactData[0][0]="Hussain";
		contactData[0][1]="7004171623";
		
		contactData[1][0]="datta";
		contactData[1][1]="8715412752";
		
		contactData[2][0]="haque";
		contactData[2][1]="9825264678";
		
		contactData[3][0]="s";
		contactData[3][1]="8255454756";
		
		contactData[4][0]="chittu";
		contactData[4][1]="8785876488";
		
		return contactData;
	}
}
