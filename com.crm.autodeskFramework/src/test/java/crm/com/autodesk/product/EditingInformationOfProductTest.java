package crm.com.autodesk.product;

import java.io.IOException;


import org.testng.annotations.Test;

import com.crm.ObjectRepository.CreateProductPage;
import com.crm.ObjectRepository.CreateVendersPage;
import com.crm.ObjectRepository.EditingProductInformationPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.Popup;
import com.crm.ObjectRepository.ProductInformationPage;
import com.crm.ObjectRepository.ProductPage;
import com.crm.ObjectRepository.VendorsPage;

import crm.com.autodesk.generic.utility.BaseClass;

public class EditingInformationOfProductTest extends BaseClass{
	@Test(groups="contactModule")
	public void editingInformationOfProduct() throws Throwable, IOException {		
		
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
		
		
		System.out.println(PRODUCTCATAGORY);
		System.out.println(MANUFACTURER);
		
		HomePage home=new HomePage(driver);
		CreateProductPage cp=new CreateProductPage(driver);
		ProductPage pp=new ProductPage(driver);
		VendorsPage vpage=new VendorsPage(driver);
		CreateVendersPage cvpage=new CreateVendersPage(driver);
		EditingProductInformationPage editinfo=new EditingProductInformationPage(driver);
		ProductInformationPage pif=new ProductInformationPage(driver);
		Popup popup=new Popup(driver);
		
		home.clickOnProductLink();
		pp.clickOnCreateProductImg();
		cp.createProductWithMandatoryField(PRODUCTNAME);
		
		home.clickOnVendorsLink(driver);
		vpage.getCreateVendorsImg().click();
		cvpage.createVendorwithMandatoryFields(VENDORNAME);
		
		webdriverUtils.waitAndClick(driver, home.getProductsLink());
		
		home.clickOnProductLink();
		pp.searchAnyRecordAndClickOnEdit(driver,PRODUCTNAME, SELECTPRODUCT);
		
		editinfo.enterAllInputFieldsOfProductInformation(NEWPRODUCTNAME, PRODUCTNUM, PARTNUM, VENDORNUM, MFRPARTNUM, PRODUCTSHEET, SERIALNUM);
		editinfo.enterAllDates(SALESSTARTDATE, SALESENDDATE, SUPPORTSTARTDATE, SUPPORTEXPIRYDATE);
		editinfo.selectAllDropdownOfProductInformation(PRODUCTCATAGORY, MANUFACTURER);
		
		editinfo.clickOnSelectVendorImg();
		popup.selectVendorNameFromPopup(driver, VENDORNAME);
		editinfo.clickOnSaveButton();
		pif.validatepage(driver);
}
}
