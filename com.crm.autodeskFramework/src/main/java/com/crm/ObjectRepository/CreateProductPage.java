package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateProductPage {
public CreateProductPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}

@FindBy(xpath="//textarea[@class='detailedViewTextBox']")
private WebElement descriptionTextField;

public WebElement getDescriptionTextField() {
	return descriptionTextField;
}

@FindBy(name="productname")
private WebElement productNameTextField;

@FindBy(xpath="//b[text()='Product Information']/preceding::input[@title='Save [Alt+S]']")
private WebElement savebutton;

public WebElement getSavebutton() {
	return savebutton;
}

public WebElement getProductNameTextField() {
	return productNameTextField;
}

public void provideProductName(String productName) {
	productNameTextField.sendKeys(productName);
}

public void createProductWithMandatoryField(String productName) {
	provideProductName(productName);	
	savebutton.click();
}
}
