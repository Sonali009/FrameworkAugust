package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ElementUtils;

public class LoginPage {
	
	private WebDriver driver;
	ElementUtils elementutils;
	/**
	 * Page objects, by locators, 
	 */
private	By username = By.id("input-email");
private	By password = By.id("input-password");
private	By loginbutton = By.xpath("//input[@value='Login']");
private	By forgotpwd = By.xpath("//div[@class='form-group']/a[text()='Forgotten Password']");
private By registrationlink = By.linkText("Register");
	
	//constructor -
	public LoginPage (WebDriver driver) {
		this.driver = driver;
		elementutils = new ElementUtils(this.driver);
	}
	
	//page actions
	
	public String getLoginPageTitle() {
		//return driver.getTitle();
		return elementutils.waitForTitleIs(5, Constants.LOGIN_PAGE_TITLE);
	}
	
	public boolean isForgotPwdLinkExist() {
		//return driver.findElement(forgotpwd).isDisplayed();
		return elementutils.doIsDisplayed(forgotpwd);
	}
	
	public AccountsPage doLogin(String un, String pwd) {
		//driver.findElement(username).sendKeys(un);
		//driver.findElement(password).sendKeys(pwd);
		//driver.findElement(loginbutton).click();
		
		elementutils.doSendKeys(username, un);
		elementutils.doSendKeys(password, pwd);
		elementutils.doClick(loginbutton);
		return new AccountsPage(driver);
	}
	
	public RegistrationPage navigateToRegisterPage() {
		elementutils.doClick(registrationlink);
		return new RegistrationPage(driver);
	}
	
	
}
