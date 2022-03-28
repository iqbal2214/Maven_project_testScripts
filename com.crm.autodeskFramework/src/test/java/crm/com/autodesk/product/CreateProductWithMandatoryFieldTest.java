package crm.com.autodesk.product;

import java.io.IOException;

import org.testng.annotations.Test;

import com.crm.ObjectRepository.CreateProductPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.ProductInformationPage;
import com.crm.ObjectRepository.ProductPage;

import crm.com.autodesk.generic.utility.BaseClass;

public class CreateProductWithMandatoryFieldTest extends BaseClass {

	@Test(groups="contactModule")
	public void CreateProductWithMandatoryField() throws Throwable, IOException {
		
		String productName=excelUtils.getExcelProperties("Sheet1", 7, 3);
		
		productName=productName+javaUtils.getRandomNum();
		
		System.out.println(productName);
	
		HomePage home=new HomePage(driver);
		CreateProductPage cp=new CreateProductPage(driver);
		ProductInformationPage pip=new ProductInformationPage(driver);
		ProductPage pp=new ProductPage(driver);
		
		home.clickOnProductLink();
		pp.clickOnCreateProductImg();
		cp.provideProductName(productName);
		
		cp.getSavebutton().click();
		
		pip.varifyCreationOfProduct(productName);
		
	}

}
