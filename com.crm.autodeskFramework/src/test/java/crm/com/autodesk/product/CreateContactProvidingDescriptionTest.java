package crm.com.autodesk.product;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.ObjectRepository.CreateProductPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.ProductInformationPage;
import com.crm.ObjectRepository.ProductPage;

import crm.com.autodesk.generic.utility.BaseClass;

public class CreateContactProvidingDescriptionTest extends BaseClass{
	@Test (groups="contactModule")
	public void createContactProvidingDescription() throws Throwable, IOException {
		
		String PRODUCTNAME=excelUtils.getExcelProperties("Sheet2", 5, 3);
		String DESCRIPTION=excelUtils.getExcelProperties("Sheet2", 6, 3);
		
		PRODUCTNAME=PRODUCTNAME+javaUtils.getRandomNum();
		
		HomePage home=new HomePage(driver);
		CreateProductPage cp=new CreateProductPage(driver);
		ProductInformationPage pip=new ProductInformationPage(driver);
		ProductPage pp=new ProductPage(driver);
		
		home.clickOnProductLink();
		pp.clickOnCreateProductImg();
		cp.provideProductName(PRODUCTNAME);

		cp.getDescriptionTextField().sendKeys(DESCRIPTION);
		cp.getSavebutton().click();
		
//		pip.varifyProvidedDescriptionOfProduct(DESCRIPTION);
//		pip.varifyCreationOfProduct(PRODUCTNAME);		
		
		Assert.assertEquals(pip.getViewProductName().getText(), PRODUCTNAME);
	}


}
