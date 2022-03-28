package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;

import crm.com.autodesk.generic.utility.WebDriverUtility;
/**
 * this class will launch vtiger, login to vtiger,go to contacts and click on last check box of the contact records
 * @author iqbal
 *
 */
public class clickOnLastCheckBox {
	public static void main(String[] args) throws Throwable {
		WebDriverUtility wUtils=new WebDriverUtility();
		WebDriver driver=wUtils.lauchBrowserWithUrl("chrome", "http://localhost:8888");
		HomePage home=new HomePage(driver);
		LoginPage login=new LoginPage(driver);
		wUtils.waitForPageToLoad(driver, 20);
		login.login("admin", "root");
		home.clickOnContactLink();
		
		driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[last()]/td[1 ]")).click();
}
}
