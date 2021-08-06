package com.qa.opencart.pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.ElementUtils;

public class ProductInfoPage {
	
	ElementUtils elementutils;
	private WebDriver driver;
	private By ProductHeader = By.xpath("//div[@class='col-sm-4']/h1");
	private By ProductImages = By.xpath("//li[@class='image-additional']/a");
	private By productmetadata = By.xpath("//div[@class='col-sm-4']/ul/li");
	private By quantity = By.xpath("//input[@name='quantity']");
	private By addtocart = By.className("btn btn-primary btn-lg btn-block");
	private By successmsg = By.xpath("//div[@class='alert alert-success alert-dismissible']");
	private By productprice = By.xpath("//ul[@class='list-unstyled']/li/h2");
	
	
	
	public ProductInfoPage(WebDriver driver) {
		this.driver = driver;
		elementutils = new ElementUtils(this.driver);
	}
	
	public String getProductHeaderTest() {
		return elementutils.doGetElementText(ProductHeader);
	}
	
	public int getProductImagesCount() {
		return elementutils.getElements(ProductImages).size();
	}
    public Map<String, String> getProductInformation() {
	Map<String, String> productinfomap = new HashMap <String, String>();
	productinfomap.put("name", getProductHeaderTest());
	List<WebElement> productmetadtalist = elementutils.getElements(productmetadata);
	
	for(WebElement e: productmetadtalist) {
		String meta[] = e.getText().split(":");
		String metakey = meta[0];
		String metavalue = meta[1];
		productinfomap.put(metakey, metavalue);
	}
	
	//PRICE
	List<WebElement> pricelist = elementutils.getElements(productprice);
	productinfomap.put("price", pricelist.get(0).getText().trim());
	productinfomap.put("exTaxPrice", pricelist.get(1).getText().split(":")[1].trim());
	
	return productinfomap;
}

public void selectquantity(String qty) {
	elementutils.doSendKeys(quantity, qty);
}
public void addtocart() {
	elementutils.doClick(addtocart);
}
public String getsuccessmessage() {
	return elementutils.doGetElementText(successmsg);
}


}
