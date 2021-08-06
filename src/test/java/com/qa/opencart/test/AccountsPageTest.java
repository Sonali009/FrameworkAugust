package com.qa.opencart.test;



import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.pages.SearchResultPage;
import com.qa.opencart.utils.Constants;

public class AccountsPageTest extends BaseTest{
	SoftAssert softassert = new SoftAssert();

	@BeforeClass
	public void AccSetup() {
		
		accPage = loginpage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	@Test(priority = 1)
	public void accPageTitleTest() {
		String title = accPage.getHomePageTitle();
		Assert.assertEquals(title, Constants.HOME_PAGE_TITLE);
	}
	
	@Test(priority =2)
	public void accPageLogoTest() {
		Assert.assertTrue(accPage.isLogoExist());
		
	}
	@Test(priority =3)
		public void accPageSectionsCountTest() {
		Assert.assertEquals(accPage.getAccountPageHeadersCount(), Constants.ACC_PAGE_SECTIONS_COUNT);
		
	}
	@Test(priority = 4)
		
	public void accPageSectionListTest(){
	List<String> actualAccSection = accPage.getAccountPageHeadersList();
	Assert.assertEquals(accPage.getAccountPageHeadersList(), Constants.expectedAccSelectionList());
	}
	
	@Test(priority = 5)
	public void searchTest() {
	searchresultpage= accPage.doSearch("MacBook");
	
	Assert.assertEquals(searchresultpage.getProductResultsCount(),3);
	
	}
	@Test(priority = 6)
	public void SelectProductTest() throws InterruptedException {
		searchresultpage = accPage.doSearch("MacBook");
		Thread.sleep(3000);
		productinfopage=searchresultpage.selectProductFromResults("MacBook Pro");
		String actualHeader = productinfopage.getProductHeaderTest();
		softassert.assertEquals(actualHeader, actualHeader);
		softassert.assertEquals(productinfopage.getProductImagesCount(), Constants.PRODUCT_IMAGES__COUNT);
		softassert.assertAll();
	}
	
}
