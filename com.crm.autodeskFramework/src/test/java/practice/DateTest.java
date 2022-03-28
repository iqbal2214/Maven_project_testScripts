package practice;

import java.util.Date;

import crm.com.autodesk.generic.utility.ExcelUtility;

public class DateTest {
	public static void main(String[] args) throws Throwable {
		Date date=new Date();
		String d=date.toString();
		String[] modified = d.split(" ");
		String YYYY=modified[5];
		String DD=modified[2];
		int MM=date.getMonth()+1;
		String time=modified[3];
		String newtime = time.replace(":", "-");
		
		System.out.println(newtime);
	
		ExcelUtility eul=new ExcelUtility();
		eul.setDataExcel("Sheet1", 10, 1, "checking");
		
		
	}

}
