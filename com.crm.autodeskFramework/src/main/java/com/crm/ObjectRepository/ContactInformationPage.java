package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInformationPage {
	public ContactInformationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement viewCreatedContact;
	
	@FindBy(xpath="//td[@id='mouseArea_Organization Name']/descendant::a")
	private WebElement viewSelectedOrganization;

	public WebElement getViewCreatedContact() {
		return viewCreatedContact;
	}

	public WebElement getViewSelectedOrganization() {
		return viewSelectedOrganization;
	}
	
	
	public  String fetchTextFromViewCreatedContact() {
		String text=viewCreatedContact.getText();
		return text;
	}
	
	public void varifiactionOfCreateContact(String lastName) {
		if(viewCreatedContact.getText().contains(lastName)) {
			System.out.println("Contact Created Succesfully");
		}else {
			System.out.println("failed to create contact");
		}
	}
	
	public void varifiactionOfSelectedOrganiztion(String organizationName) {
		if(viewSelectedOrganization.getText().equals(organizationName)) {
			System.out.println("organization selected succesfully");
		}else {
			System.out.println("failed to select organization");
		}
	}

}
