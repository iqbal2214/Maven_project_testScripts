package practice;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoibiboHotel {
 public static void main(String[] args) throws AWTException, Throwable {
	 WebDriverManager.chromedriver().setup();
	 WebDriver driver= new ChromeDriver();
	 
	//WebDriverManager.edgedriver().setup();
	//WebDriver driver= new EdgeDriver();
	
	String checkinMonth="March 2022";
	String checkoutMonth="April 2022";
	int checkinDate=31;
	int checkoutDate=1;
	int child1Age=1;
	int child2Age=3;
	int child3Age=5;
	
	int children=3;
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.get("https://www.goibibo.com/hotels/");
	driver.manage().window().maximize();
	
	driver.findElement(By.name("CountryType")).click();
	
	driver.findElement(By.xpath("//input[@id='downshift-1-input']")).sendKeys("Bangalore") ;
	Robot robo=new Robot();
	
	Thread.sleep(2000);
	robo.keyPress(KeyEvent.VK_DOWN);
	
	robo.keyRelease(KeyEvent.VK_DOWN);
	robo.keyPress(KeyEvent.VK_ENTER);
	robo.keyRelease(KeyEvent.VK_ENTER);
	
	driver.findElement(By.xpath("//div[@data-testid='openCheckinCalendar']")).click();
	
	driver.findElement(By.xpath("//span[text()='"+checkinMonth+"']/ancestor::div[@class='dcalendar-newstyles__CalenderMonthContainer-sc-1i003by-2 kCupBq']/descendant::span[text()='"+checkinDate+"']")).click();
	
	driver.findElement(By.xpath("//span[text()='"+checkoutMonth+"']/ancestor::div[@class='dcalendar-newstyles__CalenderMonthContainer-sc-1i003by-2 kCupBq']/descendant::span[text()='"+checkoutDate+"']")).click();
	
	driver.findElement(By.xpath("//input[@value='2 Adults | 0 Child | 1 Room ']")).click();
	for(int i=1;i<=children;i++) {
		driver.findElement(By.xpath("//span[text()='(0-12 yr)']/ancestor::div[@class='dwebCommonstyles__CenteredDivWrap-sc-112ty3f-1 PaxWidgetstyles__ContentItemWrapperDiv-sc-gv3w6r-2 ibYPGm fAmNIr']/descendant::span[text()='+']")).click();
	}
	
	driver.findElement(By.xpath("//span[text()='Child ' and text()='1']/ancestor::div[@class='dwebCommonstyles__CenteredDivWrap-sc-112ty3f-1 PaxWidgetstyles__ContentItemWrapperDiv-sc-gv3w6r-2 ibYPGm fAmNIr']/descendant::h4[text()='Select']")).click();
	driver.findElement(By.xpath("//li[text()='"+child1Age+"']")).click();
	driver.findElement(By.xpath("//span[text()='Child ' and text()='2']/ancestor::div[@class='dwebCommonstyles__CenteredDivWrap-sc-112ty3f-1 PaxWidgetstyles__ContentItemWrapperDiv-sc-gv3w6r-2 ibYPGm fAmNIr']/descendant::h4[text()='Select']")).click();
	driver.findElement(By.xpath("//li[text()='"+child2Age+"']")).click();
	driver.findElement(By.xpath("//span[text()='Child ' and text()='3']/ancestor::div[@class='dwebCommonstyles__CenteredDivWrap-sc-112ty3f-1 PaxWidgetstyles__ContentItemWrapperDiv-sc-gv3w6r-2 ibYPGm fAmNIr']/descendant::h4[text()='Select']")).click();
	driver.findElement(By.xpath("//li[text()='"+child3Age+"']")).click();
	
	driver.findElement(By.xpath("//button[text()='Done']")).click();
	driver.findElement(By.xpath("//button[text()='Search Hotels']")).click();
	
	List <WebElement> allHotels=driver.findElements(By.xpath("//h4[@itemprop='name']"));
	for(WebElement hotel:allHotels) {
		System.out.println(hotel.getText());
	}
	driver.close();
 }
}
