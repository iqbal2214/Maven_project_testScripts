package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class createOrganization {
	public static void main(String[] args) throws Throwable {
		WebDriver driver=null;
		
		FileInputStream fis=new FileInputStream(".\\src\\main\\resources\\CommonData\\common.properties");
		Properties probj=new Properties();
		probj.load(fis);
		
		FileInputStream fis1=new FileInputStream("D:\\software\\eclipse-jee-oxygen-3a-win32-x86_64\\workspace2\\crm.com.autodeskFramework\\script_data.xlsx");
		Workbook book=WorkbookFactory.create(fis1);
		DataFormatter format=new DataFormatter();
		String orgname=format.formatCellValue(book.getSheet("Sheet1").getRow(3).getCell(3));
		Sheet sh=book.getSheet("Sheet1");
		Row rw=sh.getRow(2);
		String industry=rw.getCell(3).getStringCellValue();
		
		System.out.println(industry);
		
		String browser=probj.getProperty("browser");
		String url=probj.getProperty("url");
		String username=probj.getProperty("username");
		String password=probj.getProperty("password");
		
		Random r=new Random();
		int unqno=r.nextInt(1000);
		
		orgname=orgname+unqno;
		System.out.println(orgname);
		
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
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		System.out.println("browser launched is "+ browser);
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys(orgname);
		WebElement ind=driver.findElement(By.name("industry"));
		Select s=new Select(ind);
		s.selectByVisibleText(industry);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();	
		String create=driver.findElement(By.className("dvHeaderText")).getText();
		if(create.contains(orgname))
		{
			System.out.println("====organization creation successfull====");
		}else {
			System.out.println("====organization creation failed====");
		}
		
		Thread.sleep(2000);
		WebElement signout=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act=new Actions(driver);
		act.moveToElement(signout).perform();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();		
		
		driver.close();
		
		System.out.println("========browser closed========");

	}

}
