package crm.com.autodesk.generic.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

//@Listeners(crm.com.autodesk.generic.utility.ImplimentationClassForITestListeners.class)
@Listeners(crm.com.autodesk.generic.utility.ExtentReport.class)
public class BaseClass {
	
	public WebDriver driver=null;
	public JavaUtilities javaUtils=new JavaUtilities();
	public ExcelUtility excelUtils=new ExcelUtility();
	public WebDriverUtility webdriverUtils=new WebDriverUtility();
	public FileUtility fileUtils=new FileUtility();
	public static WebDriver sDriver;
	
	
	
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("here it will connect to databases");
		
	}
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("for parallel Execution");
		
	}
	
	//@Parameters("browsername")
	@BeforeClass
	public void beforeClass() throws Throwable {
		String browser=fileUtils.getPropertyFile("browser");
		String url=fileUtils.getPropertyFile("url");
		if(browser.equals("chrome")) {
			
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			webdriverUtils.maximize(driver);
			webdriverUtils.waitForPageToLoad(driver, 20);
		
			driver.get(url);
		}else if(browser.equals("edge")) {
			WebDriverManager.edgedriver().setup();	
			driver=new EdgeDriver();
			webdriverUtils.maximize(driver);
			webdriverUtils.waitForPageToLoad(driver, 20);
			driver.get(url);
		}else if(browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();	
			driver=new FirefoxDriver();
			webdriverUtils.maximize(driver);
			webdriverUtils.waitForPageToLoad(driver, 20);
			driver.get(url);
		}else {
			System.out.println("browser not supported");
		}
		sDriver=driver;
	}
	
	
	@BeforeMethod
	public void beforeMethod() throws Throwable {
		LoginPage login=new LoginPage(driver);
		String userName=fileUtils.getPropertyFile("username");
		String passWord=fileUtils.getPropertyFile("password");
		login.login(userName, passWord);
	}
	
	@AfterMethod
	public void afterMethod() throws Throwable {
		HomePage home=new HomePage(driver);
		home.logout(driver);
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
	@AfterTest
	public void afterTest() {
		System.out.println("for close the parallel execution");
	}
	
	@AfterSuite
	public void afterSuite() {
		System.out.println("here we will disconnect the database");
	}
	
	
}
