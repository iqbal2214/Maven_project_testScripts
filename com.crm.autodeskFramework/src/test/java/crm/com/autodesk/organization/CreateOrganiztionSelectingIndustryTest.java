package crm.com.autodesk.organization;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.ObjectRepository.CreateOrganizationPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.OrganizationInformationPage;
import com.crm.ObjectRepository.OrganizationPage;

import crm.com.autodesk.generic.utility.BaseClass;

public class CreateOrganiztionSelectingIndustryTest extends BaseClass {
	@Test
	public void createOrganiztionSelectingIndustry() throws Throwable {
		
		String INDUSTRY=excelUtils.getExcelProperties("Sheet1", 2, 3);
		String NAME=excelUtils.getExcelProperties("Sheet1", 1, 3);
		String ORGNAME=NAME+javaUtils.getRandomNum();
		
		HomePage home=new HomePage(driver);
		OrganizationPage orgpage=new OrganizationPage(driver);
		CreateOrganizationPage org=new CreateOrganizationPage(driver);
		OrganizationInformationPage orginfo=new OrganizationInformationPage(driver);
			
		home.clickOnOrganizationsLink();
		
		orgpage.clickOnCreateOrganizationImage();
		
		org.provideOrganizationNameInTextField(ORGNAME);
		org.selectIndustry(INDUSTRY);
		org.clickOnSaveButton();
		
//		orginfo.varifyOrganaztionCreation(ORGNAME);
//		orginfo.varifyIndustySelection(INDUSTRY);
		
		Assert.assertEquals(orginfo.fetchDataFromviewOrganizationText().contains(ORGNAME), true);
		Assert.assertEquals(orginfo.fetchDataFromviewIndustry(), (INDUSTRY));
	}

}
