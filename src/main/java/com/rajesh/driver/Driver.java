package com.rajesh.driver;

import java.util.Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.rajesh.constants.FrameworkConstants;
import com.rajesh.enums.ConfigProperties;
import com.rajesh.utils.PropertyUtils;

public final class Driver {

	private Driver() {
		
	}
	public static WebDriver driver;

	public static void initDriver(String browser) {
		if (Objects.isNull(DriverManager.getDriver())) {
			
			if(browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", FrameworkConstants.getChromedriverpath());
				driver = new ChromeDriver();
			}
			else if(browser.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.chrome.driver", FrameworkConstants.getGhecoDriverPath());
				driver = new FirefoxDriver();
			}
			else if(browser.equalsIgnoreCase("ie")) {
				System.setProperty("webdriver.chrome.driver", FrameworkConstants.getIeDriverPath());
				driver = new InternetExplorerDriver();
			}
			
			DriverManager.setDriver(driver);
			DriverManager.getDriver().get(PropertyUtils.getValue(ConfigProperties.URL));
		}
	}

	public static void quitDriver() {
		if (Objects.nonNull(DriverManager.getDriver())) {
			DriverManager.getDriver().quit();
			DriverManager.unload();
		}
	}
}
