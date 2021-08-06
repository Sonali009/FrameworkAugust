package com.qa.opencart.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.utils.Constants;

public class LoginPageTest extends BaseTest {
	
	
	@Test(priority = 1)
	public void loginPageTitleTest() {
		String title = loginpage.getLoginPageTitle();
		Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE);
	}
	
	@Test(priority = 2)
	public void forgotpwLinkTest() {
		Assert.assertTrue(loginpage.isForgotPwdLinkExist());
	}

	@Test(priority=3)
	public void loginTest() {
		accPage = loginpage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
		accPage.getHomePageTitle();
		Assert.assertEquals(accPage.getHomePageTitle(), Constants.HOME_PAGE_TITLE);
	}
	
	
	
}
