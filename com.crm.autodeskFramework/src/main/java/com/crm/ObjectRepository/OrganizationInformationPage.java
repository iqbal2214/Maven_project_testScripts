	package com.crm.ObjectRepository;

	import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

	public class OrganizationInformationPage {
		public OrganizationInformationPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}

		@FindBy(xpath="//span[@class='dvHeaderText']")
		private WebElement viewOrganizationText;

		@FindBy(id="dtlview_Industry")
		private WebElement viewIndustry;

		//getters for access in test Scripts
		public WebElement getAccountNameTextField() {
			return viewOrganizationText;
		}

		public WebElement getIndustryName() {
			return viewIndustry;
		}

		public String fetchDataFromviewIndustry() {
			String text=viewIndustry.getText();
			return text;
		}
		
		public String fetchDataFromviewOrganizationText() {
			String text=viewOrganizationText.getText();
			return text;
		}
		
		
		public void varifyOrganaztionCreation(String organizationName) {
	if(viewOrganizationText.getText().contains(organizationName)) {
		System.out.println("organization creation successfull");
	}else {
		System.out.println("organization creation failed");
	}
		}

		public void varifyIndustySelection(String SelectedIndustry) {
	if(viewIndustry.getText().equals(SelectedIndustry)) {
		System.out.println("industry selected successfully");
	}else {
		System.out.println("industry selection failed");
	}
}

}
