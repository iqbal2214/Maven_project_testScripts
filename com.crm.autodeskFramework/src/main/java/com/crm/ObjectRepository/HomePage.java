package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import crm.com.autodesk.generic.utility.WebDriverUtility;

public class HomePage extends WebDriverUtility {
	
	//initialization of web elements
	public HomePage(WebDriver driver) {	
		PageFactory.initElements(driver, this);
	}
	
	//declaration of web elements
	@FindBy(name="Vendors")
	private WebElement vendorsLink;
	
	public WebElement getVendorsLink() {
		return vendorsLink;
	}

	@FindBy(linkText="//img[@src='themes/softed/images/Home.PNG']")
	private WebElement homepageLink;
	
	@FindBy(linkText="Organizations")
	private WebElement organizationLink;
	
	@FindBy(linkText="Contacts")
	private WebElement contactsLink;
	
	@FindBy(linkText="Opportunities")
	private WebElement opportunitiesLink;
	
	@FindBy(linkText="Products")
	private WebElement productsLink;
	
	@FindBy(linkText="More")
	private WebElement moreMouseOver;
	
	@FindBy(linkText="Campaigns")
	private WebElement campaignLink;
	
	@FindBy(xpath="//td[@class='small' and contains(@onmouseover,'ondemand')]")
	private WebElement userMouseOver;
	
	@FindBy(linkText="Sign Out")
	private WebElement signOutLink;
	
	//getters for use in test scripts
	
	public WebElement getHomepageLink() {
		return homepageLink;
	}


	public WebElement getSignOutLink() {
		return signOutLink;
	}

	
	public WebElement getOrganizationLink() {
		return organizationLink;
	}


	public WebElement getContactsLink() {
		return contactsLink;
	}


	public WebElement getOpportunitiesLink() {
		return opportunitiesLink;
	}


	public WebElement getProductsLink() {
		return productsLink;
	}


	public WebElement getMoreMouseOver() {
		return moreMouseOver;
	}


	public WebElement getCampaignLink() {
		return campaignLink;
	}


	public WebElement getUserMouseOver() {
		return userMouseOver;
	}


	//Business logic
	public void clickOnOrganizationsLink(){
		organizationLink.click();
	}
	
	public void clickOnProductLink() {
		productsLink.click();
	}
	
	public void clickOnCampaignLink() {
		campaignLink.click();
	}
	
	public void clickOnContactLink() {
		contactsLink.click();
	}
	
	public void clickOnOpportunitiesLink() {
		opportunitiesLink.click();
	}
	
	public void mouseOverToMore(WebDriver driver) {
		mouseOverToElement(driver, moreMouseOver);
	}
	
	public void mouseOverToUser(WebDriver driver) {
		mouseOverToElement(driver, userMouseOver);
	}
	
	public void logout(WebDriver driver) throws Throwable  {
		waitAndClick(driver, userMouseOver);
		mouseOverToUser(driver);
		signOutLink.click();
	}
	
	public void clickOnHomePageLink() {
		homepageLink.click();
	}
	
	public void clickOnVendorsLink(WebDriver driver) throws Throwable {
		waitAndClick(driver, moreMouseOver);
		mouseOverToMore(driver);
		getVendorsLink().click();
	}
	
}
