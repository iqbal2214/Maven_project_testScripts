package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * this class consist of all the webelements of capaign information page
 * @author iqbal
 *
 */
public class CampaignInformationPage {
	public CampaignInformationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);  
	}
@FindBy(xpath="//span[@class='dvHeaderText']")
private WebElement viewText;

@FindBy(xpath="//span[@id='dtlview_Product']/descendant::a")
private WebElement viewProductText;

public WebElement getViewText() {
	return viewText;
}

public WebElement getViewProductText() {
	return viewProductText;
}

/**
 * this is verification method of
 * this method will fetch the text after successfull creation by selecting product and comapre with expected result 
 * 
 * @param ProductName
 */
public void varifySelectionOfProduct(String ProductName) {
	if(viewProductText.getText().contains(ProductName)) {
		System.out.println("product selected succesfully");
	}else {
		System.out.println("failed to select product");
	}
}
	
public void varifyCreationOfCampaign(String campaignName) {
	if(viewText.getText().contains(campaignName)) {
		System.out.println("campaign creation succesfully");
	}else {
		System.out.println("failed to create campaign");
	}
}

public String fetchTextFromViewProductText() {
	String text=viewProductText.getText();
	return text;
}

public String fetchTextFromViewText() {
	String text=viewText.getText();
	return text;
}


}

