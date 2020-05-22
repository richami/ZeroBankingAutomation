package com.bank.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.bank.base.Base;
import com.bank.pages.AccountSummaryPage;
import com.bank.pages.LoginPage;
import com.bank.pages.WelcomePage;
import com.bank.utilities.DataDriven;

public class LoginTest extends Base {
	
	WelcomePage wp;
	LoginPage lp;
	AccountSummaryPage ap;
	
	@BeforeMethod
	public void setup() throws IOException
	{
		initialization();
		wp=new WelcomePage();
		lp=wp.clkSignIn();
		
	}
	
	@Test(dataProvider="sendData")
	public void verfyLogin(String u,String p)
	{
		
		ap=lp.doLogin(u,p);
		log.info("login completed");
		String actual=driver.getTitle();
		String expected="Zero - Account Summary";
		Assert.assertEquals(actual, expected,"Tittle does not match");
		
		
	}
	
	@DataProvider
	public Object [][] sendData() throws IOException
	{
		Object data[][]=new Object[2][2];
		for(int i=0;i<2;i++)
		{
			for(int j=0;j<2;j++)
			{
				data[i][j]=DataDriven.getData("Sheet1", i+1, j+1);
			}
		}
		return data;
	}
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
		extent.flush();
	}

}
