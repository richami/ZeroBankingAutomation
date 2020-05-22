package com.bank.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.bank.base.Base;

public class WelcomePage extends Base {
	
	@FindBy(id="signin_button")
	WebElement signinBtn;
	
	public WelcomePage()
	{
		// initialize the page web elements
		PageFactory.initElements(driver, this);
	}
	
	public LoginPage clkSignIn()
	{
		WebDriverWait wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.elementToBeClickable(signinBtn));
		signinBtn.click();
		return new LoginPage();
	}

}
