package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ElementUtils;

public class RegistrationPage {
	
	private WebDriver driver;
	private ElementUtils elementUtils;
	
	private By firstname = By.id("input-firstname");
	private By lastname = By.id("input-lastname");
	private By email = By.id("input-email");
	private By telephone = By.id("input-telephone");
	private By password = By.id("input-password");
	private By confirmpassword = By.id("input-confirm");
	private By subscribeyes = By.xpath("(//label[@class='radio-inline'])[1]");
	private By subscribeno = By.xpath("(//label[@class='radio-inline'])[2]");	
	private By agreecheckbox = By.xpath("//input[@name='agree']");
	private By continuebtn = By.xpath("//input[@class='btn btn-primary']");
	private By successmsg = By.xpath("//div[@id='content']/h1");
	private By logoutLink = By.linkText("Logout");
	private By registerLink = By.linkText("Register");
	
	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
		elementUtils = new ElementUtils(driver);
	}
	
	public boolean accountRegistration(String firstname, String lastname, String email, String telephone, String password, String subscribe) {
		elementUtils.doSendKeys(this.firstname, firstname);
		elementUtils.doSendKeys(this.lastname, lastname);
		elementUtils.doSendKeys(this.email, email);
		elementUtils.doSendKeys(this.telephone, telephone);
		elementUtils.doSendKeys(this.password, password);
		elementUtils.doSendKeys(this.confirmpassword, password);
		
		if(subscribe.equals("yes")) {
			elementUtils.doClick(this.subscribeyes);}
		else {
			elementUtils.doClick(this.subscribeno);
		}
		elementUtils.doClick(this.agreecheckbox);
		elementUtils.doClick(this.continuebtn);
		elementUtils.waitForPresenceOfElement(this.successmsg, 5);
		
		String msg = elementUtils.doGetElementText(this.successmsg);
		System.out.println("Registration successful");
		
		
		if (msg.contains(Constants.ACCOUNT_CREATION_SUCCESS_MSG)) {
			elementUtils.doClick(logoutLink);
			elementUtils.doClick(registerLink);
			return true;
		}
		else {
			return false;
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
