package com.qa.opencart.test;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.pages.ProductInfoPage;
import com.qa.opencart.pages.SearchResultPage;

public class ProductPageTest extends BaseTest {
SoftAssert softassert = new SoftAssert();

@BeforeClass
public void AccSetup() {
	
	accPage = loginpage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
}

@Test
public void ProductInfoTest() {
	SearchResultPage s1 = accPage.doSearch("MacBook");
	ProductInfoPage p1 = searchresultpage.selectProductFromResults("MacBook Pro");
	Map<String, String> accPageInfoMap = productinfopage.getProductInformation();
	
}


}
