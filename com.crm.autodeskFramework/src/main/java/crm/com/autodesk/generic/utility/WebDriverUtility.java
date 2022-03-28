package crm.com.autodesk.generic.utility;

import java.io.File;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

import io.github.bonigarcia.wdm.WebDriverManager;



public class WebDriverUtility {
	/**
	 * it contains WebDriver specific reusable actions
	 * @author iqbal
	 * @param driver
	 */
	
	public void waitForPageToLoad(WebDriver driver,int waittime) {
		/**
		 * wait to load before identifying any synchronized element in DOM (html)
		 */
		driver.manage().timeouts().implicitlyWait(waittime,TimeUnit.SECONDS);
		
		
	}
	public void waitForElementToBeClickable(WebDriver driver,int waittime,WebElement element)
	{
		WebDriverWait wait1=new WebDriverWait(driver, waittime);
		wait1.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void mouseOverToElement(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	public void switchToWindow(WebDriver driver, String partialLinkText)
	{
		Set<String> allid = driver.getWindowHandles();
		Iterator<String> it= allid.iterator();
			while(it.hasNext()) {
				String window_id=it.next();
				driver.switchTo().window(window_id);
				if(driver.getTitle().contains(partialLinkText))
				{
					
					break;
				}
			}
	}
	
	/**
	 *  wait for page to load before identifying any assynchronized[java scripts actions] element in DOM[HTML-Doccument]
	 * @param driver
	 */
	public void waitForPageToLoadForJSElement(WebDriver driver ) {
		driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
	}
	
	/**
	 * used to wait for element to be clickable in GUI, & check for specific element for 500 milliseconds
	 * @param driver
	 * @param element
	 * @param pollingTime
	 * @throws Throwable
	 */
	public void waitForElementWithCustomTimeOut(WebDriver driver, WebElement element, int pollingTime) throws Throwable {
		FluentWait wait=new FluentWait(driver);
		wait.pollingEvery(pollingTime, TimeUnit.SECONDS);
		wait.wait(20);
		wait.until(ExpectedConditions.elementToBeClickable(element));	
	}
	
	/**
	 * used to Switch to Alert Window and click on OK button
	 * @param driver
	 */
	public void switchToAlertWindowAndAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	
	/**
	 * is used to switch to Alert Window and Click on Cancel
	 * @param driver
	 */
	public void switchToAlertWindowAndDismiss(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	
	/**
	 * used to switch to frame window based on index
	 * @param driver
	 * @param index
	 */
	public void switchToFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}
	
	/**
	 * used to switch to Frame Window based on id or name attribute
	 * @param driver
	 * @param id_name_at_attribute
	 */
	public void switchToFrame(WebDriver driver, String id_name_at_attribute) {
		driver.switchTo().frame(id_name_at_attribute);
	}
	
	/**
	 * used to select the value from the DropDown based on index
	 * @param element
	 * @param index
	 */
	public void select(WebElement element, int index) {
		Select s=new Select(element);
		s.selectByIndex(index);
	}
	
	/**
	 * used to select value from DropDown based on
	 * @param element
	 * @param visibleText
	 */
	public void selectFromList(WebElement element, String text){
		Select s=new Select(element);
		s.selectByVisibleText(text);
	}
	
	/**
	 * used to perform right click on specific element
	 * @param driver
	 * @param element
	 */
	public void rightClickOnElement(WebDriver driver, WebElement element) {
		Actions act=new Actions(driver);
		act.contextClick(element).perform();
	}
	
	/**
	 *   
	 * @param driver
	 * @param javascript
	 */
	public void executeJavaScript(WebDriver driver,String javascript) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeAsyncScript(javascript, null);
	}
	
	public void waitAndClick(WebDriver driver, WebElement element) throws InterruptedException {
		int count=0;
		while(count<20) {
			try {
				element.click();
				break;
			}catch(Throwable e) {
				Thread.sleep(1000);
				count++;
			}
		}
	}
	
	/**
	 * used to take screenshot by providing name
	 * @param driver
	 * @param screenshotName
	 * @throws Throwable
	 */
	public void takeScreenShot(WebDriver driver,String screenshotName) throws Throwable {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File newfile=new File("./screenshot/"+screenshotName+".PNG");
		Files.copy(src, newfile);
	}
	
	public String takeScreenShotwithReturnPath(WebDriver driver,String screenshotName) throws Throwable {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		String date=new JavaUtilities().getSystemDateAndTime().replace(":", "_");
		File newfile=new File("./screenshot/"+screenshotName+date+".PNG");
		Files.copy(src, newfile);
		return newfile.getAbsolutePath();
	}
	
	/**
	 * used to pass Enter key appertain into browser
	 * @param driver
	 */
	public void passEnterKey(WebDriver driver) {
		Actions act=new Actions(driver);
		act.sendKeys(Keys.ENTER);
	}
	
	public WebDriver lauchBrowserWithUrl(String nameofbrowser,String url) throws Throwable {
		WebDriver driver=null;
		if(nameofbrowser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			driver.get(url);
		}else if(nameofbrowser.equals("edge")) {
			WebDriverManager.edgedriver().setup();	
			driver=new EdgeDriver();
			driver.get(url);
		}else if(nameofbrowser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();	
			driver=new FirefoxDriver();
			driver.get(url);
		}else {
			System.out.println("browser not supported");
		}
		return driver;

	}
	
	public void maximize(WebDriver driver) {
		driver.manage().window().maximize();
	}
	
	
}
