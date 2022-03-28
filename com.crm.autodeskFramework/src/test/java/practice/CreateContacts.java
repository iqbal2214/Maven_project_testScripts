package practice;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;
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

public class CreateContacts {
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
		String firstname=book.getSheet("Sheet1").getRow(4).getCell(3).getStringCellValue();
		String lastname=book.getSheet("Sheet1").getRow(5).getCell(3).getStringCellValue();
		
		Random r=new Random();
		int unq=r.nextInt(1000);
		lastname=lastname+unq;
		
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
		
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		driver.findElement(By.name("firstname")).sendKeys(firstname);
		driver.findElement(By.name("lastname")).sendKeys(lastname);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		String text=driver.findElement(By.className("dvHeaderText")).getText();
		if(text.contains(lastname)) {
		System.out.println("contact creation succesfully");
		}else {
			System.out.println("contact creation failed");
		}
		
		Thread.sleep(2000);
		WebElement signout=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act=new Actions(driver);
		act.moveToElement(signout).perform();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();	
		
		System.out.println("logout successfully");
		
		driver.close();
		
		System.out.println("========browser closed========");
		
		
	}

}
