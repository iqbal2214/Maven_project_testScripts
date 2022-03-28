package practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;

import crm.com.autodesk.generic.utility.WebDriverUtility;

public class ClickOnAllTheCheckBoxOfContactPage {
public static void main(String[] args) throws Throwable {
	WebDriverUtility wUtils=new WebDriverUtility();
	WebDriver driver=wUtils.lauchBrowserWithUrl("chrome", "http://localhost:8888");
	HomePage home=new HomePage(driver);
	LoginPage login=new LoginPage(driver);
	wUtils.waitForPageToLoad(driver, 20);
	login.login("admin", "root");
	home.clickOnContactLink();
	
		 List<WebElement> allchkbox = driver.findElements(By.xpath("//input[@name='selected_id']"));
		for(WebElement chkbox:allchkbox) {
			chkbox.click();
	}
}
}
