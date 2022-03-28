package com.crm.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import crm.com.autodesk.generic.utility.WebDriverUtility;

public class Popup extends WebDriverUtility{
public Popup(WebDriver driver) {
	PageFactory.initElements(driver, this);
}
@FindBy(name="search_text")
private WebElement searchTextField;

@FindBy(name="search")
private WebElement searchButton;

public WebElement getSearchTextField() {
	return searchTextField;
}

public WebElement getSearchButton() {
	return searchButton;
}


public void selectOrganizationFromPoupup(WebDriver driver,String organizationName, String popUppartialText,String mainIdpartialText) {
	waitForPageToLoad(driver, 20);
	switchToWindow(driver, popUppartialText);
	searchTextField.sendKeys(organizationName);
	searchButton.click();
	driver.findElement(By.xpath("//a[text()='"+organizationName+"']")).click();
	switchToWindow(driver, mainIdpartialText);
}
public void selectProductFromPopup(WebDriver driver,String productName) {
	waitForPageToLoad(driver, 20);
	switchToWindow(driver, "Accounts");
	searchTextField.sendKeys(productName);
	searchButton.click();
	driver.findElement(By.xpath("//a[text()='"+productName+"']")).click();
	switchToWindow(driver, "Contacts");

}

public void selectVendorNameFromPopup(WebDriver driver,String vendorName)
{
	waitForPageToLoad(driver, 20);
	switchToWindow(driver, "Vendors");
	searchTextField.sendKeys(vendorName);
	searchButton.click();
	driver.findElement(By.xpath("//a[text()='"+vendorName+"']")).click();
	switchToWindow(driver, "Products");
}
}
