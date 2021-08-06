package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ElementUtils;

public class AccountsPage {
	private WebDriver driver;
	ElementUtils elementutils;
	
	By logo = By.xpath("//div[@id='logo']/h1/a");
	By AccHeaders = By.xpath("//div[@id='content']/h2");
	By Searchfield = By.xpath("//input[@type='text']");
	By SearchButton = By.xpath("//span[@class='input-group-btn']");
	
	
	public AccountsPage(WebDriver driver) {
		this.driver=driver;
		elementutils = new ElementUtils(driver);
	}
	
	public String getHomePageTitle() {
		return elementutils.waitForTitleContains(5, Constants.HOME_PAGE_TITLE);
	}
	
	public int getAccountPageHeadersCount() {
		return elementutils.getElements(AccHeaders).size();
	}
	
	public List<String> getAccountPageHeadersList() {
		List<WebElement> accList = elementutils.getElements(AccHeaders);
		List<String> accSelectionList = new ArrayList<String>();
		for(WebElement e: accList) {
			accSelectionList.add(e.getText());
		}
		return accSelectionList;
	}
	
	public SearchResultPage doSearch(String ProductName) {
		elementutils.doSendKeys(Searchfield, ProductName);
		elementutils.doClick(SearchButton);
		return new SearchResultPage(driver);
	}
	
	public boolean isLogoExist() {
		return elementutils.doIsDisplayed(logo);
	}
}
