package com.qa.opencart.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ExcelUtil;

public class RegistrationPageTest extends BaseTest{

	@BeforeClass
	public void SetUpRegister() {
		registrationpage = loginpage.navigateToRegisterPage();
	}
	
	@DataProvider
	public Object[][] getRegisterData(){
		Object data[][] = ExcelUtil.getTestData(Constants.REGISTER_SHEET_NAME);
		return data;
		
	}
	@Test(dataProvider = "getRegisterData")
	public void userRegisterTest(String firstname, String lastname, String email, String telephone, String password, String subscribe) {
	Assert.assertTrue(registrationpage.accountRegistration(firstname,lastname,email,telephone,password,subscribe));
	}
	
	
	
	
	
}
