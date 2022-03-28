package com.crm.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import crm.com.autodesk.generic.utility.WebDriverUtility;

public class ProductPage extends WebDriverUtility {
	public ProductPage(WebDriver driver) {	
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//img[@title='Create Product...']")
	private WebElement createProductImg;
	
	@FindBy(xpath="//input[@name='search_text']")
	private WebElement searchTextField;
	
	@FindBy(xpath="//input[@name='submit']/preceding::select[@id='bas_searchfield']")
	private WebElement dropDown;
	
	@FindBy(xpath="//input[@class='crmbutton small create']")
	private WebElement searchButton;
	
	@FindBy(xpath="//table[@class='lvt small']/tbody/tr[contains(.,'edit')][1]/td[9]/a[text()='edit']")
	private WebElement editLink;
	
	
	public WebElement getSearchTextField() {
		return searchTextField;
	}

	public WebElement getDropDown() {
		return dropDown;
	}

	public WebElement getSearchButton() {
		return searchButton;
	}

	public WebElement getEditLink() {
		return editLink;
	}

	public WebElement getCreateProductImg() {
		return createProductImg;
	}
	
	public void clickOnCreateProductImg() {
		createProductImg.click();
	}
	
	public void searchAnyRecordAndClickOnEdit(WebDriver driver,String inputToSearch,String nameToSelect) {
		searchTextField.sendKeys(inputToSearch);
		selectFromList(dropDown, nameToSelect);
		searchButton.click();
		driver.findElement(By.xpath("//a[contains(@href,'"+inputToSearch+"' and text()='edit')]")).click();
	}
}
