package com.bank.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.bank.base.Base;
import com.bank.pages.LoginPage;
import com.bank.pages.WelcomePage;

public class WelcomeTest extends Base {
	WelcomePage wp;
	LoginPage lp;
	@BeforeMethod
	public void setup() throws IOException
	{
		initialization();
		wp=new WelcomePage();
	}
	
	@Test
	public void signin()
	{
		//lp=wp.clkSignIn();
		//String actual=lp.getLoginPageTitle();
		wp.clkSignIn();
		log.info("Clicked sign in btn");
		String actual=driver.getTitle();
		String expected="Zero - Log in";
		Assert.assertEquals(actual, expected,"Title does not match");
	}
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
		extent.flush();
	}

}
