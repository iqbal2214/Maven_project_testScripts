package practice;

import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateCamgaign {
	public static void main(String[] args) throws Throwable {
	
	FileInputStream fis=new FileInputStream(".\\src\\main\\resources\\CommonData\\common.properties");
	Properties probj=new Properties();
	probj.load(fis);
	String browser=probj.getProperty("browser");
	String url=probj.getProperty("url");
	String username=probj.getProperty("username");
	String password=probj.getProperty("password");
	
	FileInputStream fis1=new FileInputStream("D:\\software\\eclipse-jee-oxygen-3a-win32-x86_64\\workspace2\\crm.com.autodeskFramework\\script_data.xlsx");
	Workbook book=WorkbookFactory.create(fis1);
	String campaignname=book.getSheet("Sheet1").getRow(9).getCell(3).getStringCellValue();
	String product=book.getSheet("Sheet1").getRow(10).getCell(3).getStringCellValue();

	Random r=new Random();
	int unq=r.nextInt(1000);
	campaignname=campaignname+unq;
	
	WebDriver driver=null;
	if(browser.equals("chrome")) {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get(url);	
	}else if (browser.equals("edge")) {
		WebDriverManager.edgedriver().setup();
		driver=new EdgeDriver();
		driver.get(url);
	}else {
		System.out.println("enter valid browser name");
	}
	
	System.out.println("browser launched successfully");
	
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	System.out.println("browser launched is "+ browser);
	
	driver.findElement(By.name("user_name")).sendKeys(username);
	driver.findElement(By.name("user_password")).sendKeys(password);
	driver.findElement(By.id("submitButton")).click();
	
	System.out.println("login successfully");
	
	WebElement more=driver.findElement(By.xpath("//td[@class='tabUnSelected' and @onmouseover]"));
	Actions act=new Actions(driver);
	act.moveToElement(more).perform();
	driver.findElement(By.linkText("Campaigns")).click();
	driver.findElement(By.xpath("//img[@title='Create Campaign...']")).click();
	driver.findElement(By.xpath("//img[@src='themes/softed/images/select.gif']")).click();
	driver.findElement(By.name("campaignname")).sendKeys(campaignname);
	
	String mainid=driver.getWindowHandle();
	Set<String> allid = driver.getWindowHandles();
	for(String id:allid)
	{
		if(!mainid.equals(id))
		{
			driver.switchTo().window(id);
		}
	}
	
	List<WebElement> table = driver.findElements(By.xpath("//a[contains(@onclick,'set_return')]"));
	
	for(WebElement ele:table)
	{
		if(ele.getText().contains(product))
		{
			ele.click();
			break;
		}
	}
	driver.switchTo().window(mainid);
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	
	String text=driver.findElement(By.className("dvHeaderText")).getText();
	if(text.contains(campaignname)) {
	System.out.println("campaign creation succesfully");
	}else {
		System.out.println("contact creation failed");
	}
	
	Thread.sleep(2000);
	WebElement signout=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	act=new Actions(driver);
	act.moveToElement(signout).perform();
	driver.findElement(By.xpath("//a[text()='Sign Out']")).click();	
	
	System.out.println("logout successfully");
	
	driver.close();
	
	System.out.println("========browser closed========");
	
}

}
