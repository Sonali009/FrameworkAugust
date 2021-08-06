package com.qa.opencart.utils;

import java.util.ArrayList;
import java.util.List;

public class Constants {
	
	public static final String LOGIN_PAGE_TITLE = "Account Login";
	public static final String HOME_PAGE_TITLE = "My Account";
	public static final int ACC_PAGE_SECTIONS_COUNT = 4;
	public static final int PRODUCT_IMAGES__COUNT = 3;
	public static final String ACCOUNT_CREATION_SUCCESS_MSG ="Your Account Has Been Created!";
	public static final String REGISTER_SHEET_NAME = "register";
	
	public static List<String>expectedAccSelectionList(){
		List<String> expecList = new ArrayList<String>();
		expecList.add("My Account");
		expecList.add("My Orders");
		expecList.add("My Affiliate Account");
		expecList.add("Newsletter");
		
		return expecList;
	}

}
