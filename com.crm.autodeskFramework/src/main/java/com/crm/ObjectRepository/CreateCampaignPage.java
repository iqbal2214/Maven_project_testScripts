package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCampaignPage {
	public CreateCampaignPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(name="campaignname")
	private WebElement campaignTextField;
	
	@FindBy(xpath="//img[@title='Select']")
	private WebElement selectProductImage;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveButton;

	public WebElement getCampaignTextField() {
		return campaignTextField;
	}

	public WebElement getSelectImage() {
		return selectProductImage;
	}
	public void provideCampaignName(String campaignName) {
	campaignTextField.sendKeys(campaignName);
}	
	public void clickOnSelectProductImage() {
		selectProductImage.click();
	}
	public void clickOnSaveButton() {
		saveButton.click();
	}
}