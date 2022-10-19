package com.maps.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.hc.core5.util.Timeout;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.maps.qa.util.TestUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	
public static WebDriver driver;
	public static Properties prop;
	
	
	public TestBase(){
		
		try {
			
		prop = new Properties();
		FileInputStream ip = new FileInputStream("C:\\Users\\wcg-QA1\\eclipse-workspace\\selenium\\src\\main\\java\\com\\maps\\qa\\config\\config.properties");
		prop.load(ip);
		
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void initialization() {
		String browsername = prop.getProperty("browser");
		if(browsername.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.get(prop.getProperty("url"));
		
		
	}

}
