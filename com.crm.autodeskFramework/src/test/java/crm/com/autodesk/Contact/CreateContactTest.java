package crm.com.autodesk.Contact;



import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.ObjectRepository.ContactInformationPage;
import com.crm.ObjectRepository.ContactPage;
import com.crm.ObjectRepository.CreateContactPage;
import com.crm.ObjectRepository.HomePage;


import crm.com.autodesk.generic.utility.BaseClass;


public class CreateContactTest extends BaseClass{
	@Test
	public void createContact() throws Throwable {
		
		String FIRSTNAME=excelUtils.getExcelProperties("Sheet1", 4, 3);
		String LASTNAME=excelUtils.getExcelProperties("Sheet1", 5, 3);
		
		LASTNAME=LASTNAME+javaUtils.getRandomNum();
		
		//create contacts
		HomePage home=new HomePage(driver);
		ContactPage contpage=new ContactPage(driver);
		CreateContactPage createcontact=new CreateContactPage(driver);
		ContactInformationPage infopage=new ContactInformationPage(driver);
		
		home.clickOnContactLink();
		contpage.clickOnCreateContactImg();
		createcontact.provideFirstName(FIRSTNAME);
		createcontact.provideLastName(LASTNAME);
		createcontact.clickOnSaveButton();
		
		//Verification of create contacts
	//	infopage.varifiactionOfCreateContact(LASTNAME);
		Assert.assertEquals(infopage.fetchTextFromViewCreatedContact().contains(LASTNAME), true);
}
}
