package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignPage {
public CampaignPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}

@FindBy(xpath="//img[@title='Create Campaign...']")
private WebElement createCampainImage;

public WebElement getCreateCampainImage() {
	return createCampainImage;
}
public void clickOnCreateCampaignImage() {
	createCampainImage.click();
}
}
