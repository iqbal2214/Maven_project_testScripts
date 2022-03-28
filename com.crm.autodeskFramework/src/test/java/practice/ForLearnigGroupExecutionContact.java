package practice;

import org.testng.annotations.Test;

import crm.com.autodesk.generic.utility.BaseClass;

public class ForLearnigGroupExecutionContact extends BaseClass{
	
	@Test(groups={"create","functionalTesting"})
	public void createContactUsingLastName() {
		System.out.println("contact creation successful");
		
	}
	
	@Test(groups={"edit","integrationTesting","smokeTesting"})
	public void editContact() {
		System.out.println("edit contact succesfully");
	}
	
	@Test(groups={"delete","functionalTesting","integrationTesting"})
	public void deleteContact() {
		System.out.println("delete contact successfull");
	}
	
	
}
