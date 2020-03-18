package com.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.hubspot.base.BasePage;
import com.hubspot.util.Constants;
import com.hubspot.util.ElementUtil;

public class LoginPage extends BasePage{

//	WebDriver'in icinde a)Locator, b)constructor, c)metodlar(page actions) olusturayoruz.

	//NON-PAGE FACTORY
	//LOCATORS
	WebDriver driver;
	ElementUtil elementUtil;
	
	By emailId = By.id("username");
	By password = By.id("password");
	By loginBtn = By.id("loginBtn");
	
	//CONSTRUCTOR
	public LoginPage(WebDriver driver){
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
				}
	
	// PAGE ACTIONS 
	public String getLoginPageTitle(){
		return elementUtil.waitForGetPageTitle(Constants.LOGIN_PAGE_TITLE);
//		return driver.getTitle();	
		}
	
	public HomePage doLogin(String username, String pwd){
		
		elementUtil.doSendKeys(emailId, username);
		elementUtil.doSendKeys(password, pwd);
		elementUtil.doClick(loginBtn);
		
		
//		driver.findElement(emailId).sendKeys(username);
//		driver.findElement(password).sendKeys(pwd);
//		driver.findElement(loginBtn).click();
		return new HomePage(driver);
	
}	}