package practice;

import java.io.IOException;

import crm.com.autodesk.generic.utility.ExcelUtility;
import crm.com.autodesk.generic.utility.JavaUtilities;

public class CheckExcel {
public static void main(String[] args) throws IOException {
	
	ExcelUtility excelUtils=new ExcelUtility();
	JavaUtilities javaUtils=new JavaUtilities();

	String PRODUCTNAME=excelUtils.getExcelProperties("Sheet3", 4, 4)+javaUtils.getRandomNum();
	String SELECTPRODUCT=excelUtils.getExcelProperties("Sheet3", 4, 3);
	String NEWPRODUCTNAME=excelUtils.getExcelProperties("Sheet3", 5, 4)+javaUtils.getRandomNum();
	String PRODUCTNUM=excelUtils.getExcelProperties("Sheet3", 6, 4);
	String SALESSTARTDATE=excelUtils.getExcelProperties("Sheet3", 8, 4);
	String PARTNUM=excelUtils.getExcelProperties("Sheet3", 9, 4);
	String MANUFACTURER=excelUtils.getExcelProperties("Sheet3", 10, 4);
	String PRODUCTCATAGORY=excelUtils.getExcelProperties("Sheet3", 11, 4);
	String SALESENDDATE=excelUtils.getExcelProperties("Sheet3", 12, 4);
	String SUPPORTSTARTDATE=excelUtils.getExcelProperties("Sheet3", 13, 4);
	String SUPPORTEXPIRYDATE=excelUtils.getExcelProperties("Sheet3", 14, 4);
	String VENDORNUM=excelUtils.getExcelProperties("Sheet3", 15, 4);
	String PRODUCTSHEET=excelUtils.getExcelProperties("Sheet3", 21, 4);
	String MFRPARTNUM=excelUtils.getExcelProperties("Sheet3", 22, 4);
	String SERIALNUM=excelUtils.getExcelProperties("Sheet3", 23, 4);
	String VENDORNAME=excelUtils.getExcelProperties("Sheet3", 18, 4)+javaUtils.getRandomNum();
	
	String FIRSTNAME=excelUtils.getExcelProperties("Sheet1", 4, 3);
	String LASTNAME=excelUtils.getExcelProperties("Sheet1", 5, 3);
	String NAME=excelUtils.getExcelProperties("Sheet1", 1, 3);
	String INDUSTRY=excelUtils.getExcelProperties("Sheet1", 2, 3);
	
	String PRODUCTNAME1=excelUtils.getExcelProperties("Sheet2", 5, 3);
	String DESCRIPTION=excelUtils.getExcelProperties("Sheet2", 6, 3);
	
	String campaignName=excelUtils.getExcelProperties("Sheet1", 9, 3)+javaUtils.getRandomNum();
	String productName=excelUtils.getExcelProperties("Sheet1", 7, 3)+javaUtils.getRandomNum();
	
	String productName1=excelUtils.getExcelProperties("Sheet1", 7, 3);
	
	
//	System.out.println(PRODUCTNAME);
//	System.out.println(SELECTPRODUCT);
//	System.out.println(NEWPRODUCTNAME);
//	System.out.println(PRODUCTNUM);
//	System.out.println(SALESSTARTDATE);
//	System.out.println(PARTNUM);
//	System.out.println(MANUFACTURER);
//	System.out.println(PRODUCTCATAGORY);
//	System.out.println(SALESENDDATE);
//	System.out.println(SUPPORTSTARTDATE);
//	System.out.println(SUPPORTEXPIRYDATE);
//	System.out.println(VENDORNUM);
//	System.out.println(PRODUCTSHEET);
//	System.out.println(MFRPARTNUM);
	System.out.println(PRODUCTNAME1);
	System.out.println(DESCRIPTION);
	System.out.println(NAME);
	System.out.println(productName1);
//	System.out.println();
//	System.out.println();
//	System.out.println(PRODUCTNAME);
}
}
