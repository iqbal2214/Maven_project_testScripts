package practice;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateOrg {
	public static void main(String[] args) throws IOException  {
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://localhost:8888");
		
		Random r=new Random();
		int num=r.nextInt(1000);
		fileExcelHandeling fx=new fileExcelHandeling();
		//String orgName= "newOrg"+num;
		String name=fx.accessExcelProperties("Sheet1", 1, 3);
		String orgName=name+num;
		
			
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("root");
		driver.findElement(By.id("submitButton")).click();
		
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
		
		WebElement wb=driver.findElement(By.xpath("//a[@src='themes/softed/images/user.PNG']"));
		Actions act=new Actions(driver);
		act.moveToElement(wb).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		
		driver.close();
	}

}
