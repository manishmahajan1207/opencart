package com.openCart.testBase;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;



public class BaseClass {
	
	public static WebDriver driver;
	//public static Logger logger;
	public static Logger logger;
	public Properties p;
	
	//String path = ".//Configurations//config.properties";
	
	@BeforeClass(groups = {"Sanity","Regression","Master"})
	@Parameters({"os","browser"})
	public void setUp(String os, String br) throws IOException {
	
		try {
		
		FileInputStream file = new FileInputStream(".//Configurations//config.properties");
		p = new Properties();
		p.load(file);
		
		logger = Logger.getLogger("EcommerseShoppingApp");
		PropertyConfigurator.configure("log4j.properties");
		
		//logger = LogManager.getLogger(this.getClass());
		
		//for remote environment
		if(p.getProperty("execution_env").equalsIgnoreCase("remote")) {
			
			DesiredCapabilities dc = new DesiredCapabilities();
			
			//os
			if(os.equalsIgnoreCase("windows")) {
				
				dc.setPlatform(Platform.WIN10);
			}
			
			else if(os.equalsIgnoreCase("mac")){
				
				dc.setPlatform(Platform.MAC);
				
			}
			
			else if(os.equalsIgnoreCase("linux")) {
				
				dc.setPlatform(Platform.LINUX);
			}
			else {
				
				System.out.println("No matching os found");
				return;
			}
			
			//browser
			switch (br.toLowerCase()) {
			case "chrome": dc.setBrowserName("chrome"); break;
			case "edge" : dc.setBrowserName("MicrosoftEdge"); break;
			case "firefox" : dc.setBrowserName("firefox"); break;
			default : System.out.println("No matching browser found"); return;
		
			}
			
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), dc);
			
		}
		
		//for local environment
		if(p.getProperty("execution_env").equalsIgnoreCase("local")) {
			
			switch(br.toLowerCase())
			{
			case "chrome" : driver = new ChromeDriver(); break;
			case "edge" : driver = new EdgeDriver(); break;
			case "firefox" : driver = new FirefoxDriver(); break;
			default : System.out.println("Invalid Browser Name....."); return;
			}
			
			
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		

		driver.get(p.getProperty("url"));
		driver.manage().window().maximize();
		
		logger.info("OpenCart Application is opened");
		
	}catch(Exception e){
		
		System.out.println(e.getMessage());
		
	}
		
		
	}
	
	@AfterClass(groups = {"Sanity","Regression","Master"})
	public void tearDown() {
		driver.quit();
	}

	
	//Random Strings methods for generating automatic random strings for numbers and alphabets
	
	public String randomAlphabeticString() {
		String alphabeticstring = RandomStringUtils.randomAlphabetic(6);
		return alphabeticstring;
		
	}
	
	public String randomNumericString() {
		String numericstring = RandomStringUtils.randomNumeric(10);
		return numericstring;
	}
	
	public String randomAlphabeticAndNumeric() {
		String alphabetipwd = RandomStringUtils.randomAlphabetic(4);
		String numericpwd = RandomStringUtils.randomNumeric(4);
		return alphabetipwd+"@"+numericpwd;
	}

	public String captureScreen(String tName) throws IOException {
		
		String timeStamp = new SimpleDateFormat("yyyymmddhhmmss").format(new Date());
		
		TakesScreenshot  ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath =System.getProperty("user.dir")+ "/ScreenShots/"+tName+"_"+timeStamp+".png";
		File target = new File(targetFilePath);
		
		source.renameTo(target);
		//FileUtils.copyFile(source, target);
		System.out.println("ScreenShot is captured...");
		
		return targetFilePath;
		
		
	}

	
	
	
}
