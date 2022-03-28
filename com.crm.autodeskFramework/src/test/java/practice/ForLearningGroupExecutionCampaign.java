package practice;

import org.testng.annotations.Test;

import crm.com.autodesk.generic.utility.BaseClass;

public class ForLearningGroupExecutionCampaign extends BaseClass{

	
	@Test(groups={"create","functionalTesting","smokeTesting"}) 
	public void createcampaignUsingcampaignName() {
		System.out.println("campaign creation successful");
	}
	
	@Test(groups={"edit","integrationTesting"})
	public void editcampaign() {
		System.out.println("edit campaign succesfully");
	}
	
	@Test(groups={"delete","integrationTesting"})
	public void deletecampaign() {
		System.out.println("delete campaign successfull");
	}
	
	@Test(groups={"search","functionalTesting","integrationTesting"})
	public void searchcampaign() {
		System.out.println("search campaign successfull");
	}

}
