package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SampleSeleniumTest {
	public static void main(String[] args) throws Throwable, IOException {
	WebDriver driver=new ChromeDriver();
	driver.get("http://localhost:8888");
	
	FileInputStream fis=new FileInputStream(".//src");
	Workbook book=WorkbookFactory.create(fis);
	Sheet sh=book.getSheet("Shhet1");
	Row row=sh.getRow(1);
	String data=row.getCell(2).getStringCellValue();
	
	FileInputStream fis1=new FileInputStream("./src");
	Properties probj=new Properties();
	probj.load(fis1);
	probj.getProperty("key");
	
	
	
}
}
