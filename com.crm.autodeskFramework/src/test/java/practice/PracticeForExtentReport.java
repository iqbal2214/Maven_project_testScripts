package practice;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import crm.com.autodesk.generic.utility.BaseClass;

public class PracticeForExtentReport extends BaseClass{

	@Test
	public void createOrg() {
		System.out.println("created org");
	}
	@Test
	public void createProduct() {
		Assert.fail();
	}
	@Test
	public void createLead() {
		throw new SkipException(null);		
	}

}
