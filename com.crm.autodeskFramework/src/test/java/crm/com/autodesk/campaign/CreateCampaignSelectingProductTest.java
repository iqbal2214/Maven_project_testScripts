package crm.com.autodesk.campaign;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.ObjectRepository.Popup;
import com.crm.ObjectRepository.CampaignInformationPage;
import com.crm.ObjectRepository.CampaignPage;
import com.crm.ObjectRepository.CreateCampaignPage;
import com.crm.ObjectRepository.CreateProductPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.ProductPage;

import crm.com.autodesk.generic.utility.BaseClass;

public class CreateCampaignSelectingProductTest extends BaseClass{

	@Test
	public void CreateCampaignSelectingProduct() throws IOException, Throwable  {
		
	 HomePage home=new HomePage(driver);
	 CreateProductPage createProductPage=new CreateProductPage(driver);
	 ProductPage productpage=new ProductPage(driver);
	 Popup popup=new Popup(driver);
	 CampaignInformationPage campaigninfoPage=new CampaignInformationPage(driver);
	 CampaignPage campaignPage=new CampaignPage(driver);
	 CreateCampaignPage createcampgainPage=new CreateCampaignPage(driver);
	 
		String campaignName=excelUtils.getExcelProperties("Sheet1", 9, 3)+javaUtils.getRandomNum();
		String productName=excelUtils.getExcelProperties("Sheet1", 7, 3)+javaUtils.getRandomNum();
			
		home.clickOnProductLink();
		productpage.clickOnCreateProductImg();
		createProductPage.provideProductName(productName);
		createProductPage.getSavebutton().click();
		
		webdriverUtils.waitAndClick(driver, home.getMoreMouseOver());
		home.mouseOverToMore(driver);
		home.clickOnCampaignLink();
		campaignPage.clickOnCreateCampaignImage();
		createcampgainPage.provideCampaignName(campaignName);
		createcampgainPage.clickOnSelectProductImage();
		popup.selectProductFromPopup(driver, productName);
		createcampgainPage.clickOnSaveButton();
//		campaigninfoPage.varifySelectionOfProduct(productName);
//		campaigninfoPage.varifyCreationOfCampaign(campaignName);
		Assert.assertEquals(campaigninfoPage.fetchTextFromViewProductText(), productName);
		Assert.assertEquals(campaigninfoPage.fetchTextFromViewText().contains(campaignName), true);
	}
}
	


