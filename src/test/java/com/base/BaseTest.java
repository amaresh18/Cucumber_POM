package com.base;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
public class BaseTest
{
    protected WebDriver driver; 
    @BeforeClass
    public void launchBrowser(){
    driver = new FirefoxDriver();
    driver.get("https://www.google.com/");
    }
    
}