package com.qa.opencart.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.ElementUtils;

public class SearchResultPage {
	private WebDriver driver;
	
	ElementUtils elementutils;
	By searchResult = By.xpath("//div[@class='product-layout product-grid col-lg-3 col-md-3 col-sm-6 col-xs-12']");
	By resultsitem = By.xpath("//div[@class='caption']/h4/a");
			

	public SearchResultPage(WebDriver driver) {
		this.driver = driver;
		elementutils = new ElementUtils(this.driver);
	}
	
	public int getProductResultsCount() {
		return elementutils.getElements(resultsitem).size();
	}
	public ProductInfoPage selectProductFromResults(String ProductName) {
		List<WebElement>  seleProduct = elementutils.getElements(resultsitem);
		for (WebElement e : seleProduct) {
			if(e.getText().equals(ProductName)) {
				e.click();
				break;
			}
		}
		return new ProductInfoPage(driver);
	}
	
}
