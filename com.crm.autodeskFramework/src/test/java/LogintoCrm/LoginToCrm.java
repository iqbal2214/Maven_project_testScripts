package LogintoCrm;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginToCrm {
	public static void main(String[] args) throws Throwable {
		WebDriverManager.chromedriver().setup();
		
		FileInputStream fis=new FileInputStream(".\\src\\main\\resources\\CommonData\\common.properties");
		Properties probj=new Properties();
		probj.load(fis);
		String browser=probj.getProperty("browser");
		String url=probj.getProperty("url");
		String username=probj.getProperty("username");
		String password=probj.getProperty("password");
		
		System.out.println(browser);
		System.out.println(url);
		System.out.println(username);
		System.out.println(password);
		
		WebDriver driver=null;
		if(browser.equals("chrome")) {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get(url);
  }else if 
		(browser.equals("firefox")) {
	  WebDriverManager.firefoxdriver().setup();
	  	driver=new FirefoxDriver();
	  	driver.get(url);
  }else if (browser.equals("msedge")) {
	  WebDriverManager.edgedriver().setup();
	  driver=new EdgeDriver();
	  	driver.get(url);
	}else {
		System.out.println("enter valid browser detail");
	}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("browser launched is "+browser);
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		driver.close();
		System.out.println("login successfull");
	}
}
