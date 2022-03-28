package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductInformationPage {
public ProductInformationPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}

@FindBy(xpath="//input[@name='Edit']")
private WebElement editButton;

@FindBy(id="dtlview_Description")
private WebElement detailviewOfDescription;

@FindBy(xpath="//span[@class='lvtHeaderText']")
private WebElement detailViewText;

@FindBy(xpath="//a[@class='hdrLink']")
private WebElement pageTitle;

public WebElement getViewProductName() {
	return detailViewText;
}

public WebElement getEditButton() {
	return editButton;
}

public void varifyCreationOfProduct(String ProductName) {
	if(detailViewText.getText().contains(ProductName)) {
		System.out.println("product creation succesfully");
	}else {
		System.out.println("failed to create product");
	}
}

public void varifyProvidedDescriptionOfProduct(String description) {
	if(detailviewOfDescription.getText().contains(description)) {
		System.out.println("product creation succesfully");
	}else {
		System.out.println("failed to create product");
	}
}
public void validatepage(WebDriver driver) {
	if(pageTitle.getText().equals("Products")) {
		System.out.println("edited information successfully");
	}else {
		System.out.println("failed to edit");
	}
}
}
