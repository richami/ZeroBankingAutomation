package com.bank.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.bank.base.Base;

public class LoginPage extends Base {
	
	@FindBy(id="user_login")
	WebElement login;
	
	@FindBy(id="user_password")
	WebElement password;
	
	@FindBy(name="submit")
	WebElement loginBtn;
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public AccountSummaryPage doLogin(String u,String p)
	{
		// wait=new WebDriverWait(driver,10);
		//wait.until(ExpectedConditions.elementToBeClickable(login));
		login.sendKeys(u);
		password.sendKeys(p);
		log.info("user and password eneterted");
		//wait.until(ExpectedConditions.elementToBeClickable(loginBtn));
		loginBtn.click();
		return new AccountSummaryPage();
	}
	
	public String getLoginPageTitle()
	{
		return driver.getTitle();
	}

}
