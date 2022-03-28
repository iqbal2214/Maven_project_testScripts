package crm.com.autodesk.Contact;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.ObjectRepository.Popup;

import crm.com.autodesk.generic.utility.BaseClass;

import com.crm.ObjectRepository.ContactInformationPage;
import com.crm.ObjectRepository.ContactPage;
import com.crm.ObjectRepository.CreateContactPage;
import com.crm.ObjectRepository.CreateOrganizationPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.OrganizationPage;


public class CreateContactSelectingOrganizationTest extends BaseClass  {
	
		@Test
		public void createContactSelectingOrg() throws Throwable {
		
		String FIRSTNAME=excelUtils.getExcelProperties("Sheet1", 4, 3);
		String LASTNAME=excelUtils.getExcelProperties("Sheet1", 5, 3);
		String NAME=excelUtils.getExcelProperties("Sheet1", 1, 3);
		String INDUSTRY=excelUtils.getExcelProperties("Sheet1", 2, 3);
		String ORGNAME=NAME+javaUtils.getRandomNum();
		
		LASTNAME=LASTNAME+javaUtils.getRandomNum();
		
		HomePage home=new HomePage(driver);
		OrganizationPage orgpage=new OrganizationPage(driver);
		CreateOrganizationPage org=new CreateOrganizationPage(driver);
		ContactPage contpage=new ContactPage(driver);
		CreateContactPage createcontact=new CreateContactPage(driver);
		ContactInformationPage infopage=new ContactInformationPage(driver);
		Popup popup=new Popup(driver);

		home.clickOnOrganizationsLink();
		
		orgpage.clickOnCreateOrganizationImage();
		
		org.provideOrganizationNameInTextField(ORGNAME);
		org.selectIndustry(INDUSTRY);
		org.clickOnSaveButton();
			
		webdriverUtils.waitAndClick(driver, home.getContactsLink());
		
		home.clickOnContactLink();
		contpage.clickOnCreateContactImg();
		createcontact.provideFirstName(FIRSTNAME);
		createcontact.provideLastName(LASTNAME);
		createcontact.clickonSelectOrganizationImage();
		popup.selectOrganizationFromPoupup(driver, ORGNAME, "Accounts", "Contacts");
		createcontact.clickOnSaveButton();
		
//		infopage.varifiactionOfCreateContact(LASTNAME);
//		infopage.varifiactionOfSelectedOrganiztion(ORGNAME);
		
		Assert.assertEquals(infopage.fetchTextFromViewCreatedContact().contains(LASTNAME), true);
		Assert.assertEquals(infopage.getViewSelectedOrganization().getText(),(ORGNAME));
}
}
