package com.bank.base;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.log4j.Logger;
public class Base {
	
	public static WebDriver driver;
	public static Properties prop;
	public static ExtentReports extent;
	public static ExtentTest test;
	public static Logger log = Logger.getLogger(Base.class.getName());
	
	public static void initialization() throws IOException
	{
		prop=new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\com\\bank\\config\\config.properties");
		prop.load(fis);
		String s=prop.getProperty("browser");
		if(s.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\test\\resources\\drivers\\chromedriver.exe" );
			driver=new ChromeDriver();
		}
		else if(s.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "E://Selenium//work//geckodriver.exe");
			driver=new FirefoxDriver();
		}
		else if(s.equalsIgnoreCase("IE"))
		{
			System.setProperty("webdriver.ie.driver",System.getProperty("user.dir")+"\\src\\test\\resources\\drivers\\IEDriverServer.exe" );
			driver=new InternetExplorerDriver();
		}
		String path=System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter=new ExtentSparkReporter(path);
		reporter.config().setReportName("Zero Banking Automation");
		reporter.config().setDocumentTitle("Test Results");
		extent=new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Richa");
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		test=extent.createTest("verfyLogin");
	}
	
	public static void captureScreen(String name) throws IOException
	{
		TakesScreenshot tc=((TakesScreenshot)driver);
		File src=tc.getScreenshotAs(OutputType.FILE);
		String path=System.getProperty("user.dir")+"\\screenshots\\"+name+".png";
		File dest=new File(path);
		FileUtils.copyFile(src, dest);
		
	}

}
