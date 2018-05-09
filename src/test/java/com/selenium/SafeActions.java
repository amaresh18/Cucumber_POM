package com.selenium;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.base.BaseTest;
 
public class SafeActions extends BaseTest
{
	public void safeClick(By locator, String friendlyWebElementName,int... optionWaitTime)
	{
		int waitTime = 0;
		try
		{
			waitTime =  getWaitTime(optionWaitTime);
			if(waitUntilClickable(locator, friendlyWebElementName,waitTime))
			{
				scrollIntoElementView(locator,friendlyWebElementName);
				WebElement element = driver.findElement(locator);
				setHighlight(element);
				element.click();		
			
			}
			else
			{
				Assert.fail( friendlyWebElementName + " is not clickable in time - "+waitTime+" Seconds");
			}
		}
		catch(StaleElementReferenceException e)
		{
			Assert.fail(friendlyWebElementName + " is not attached to the page document - StaleElementReferenceException");
		}
		catch (NoSuchElementException e)
		{
			Assert.fail(friendlyWebElementName + " was not found in DOM in time - "+waitTime+" Seconds"+" - NoSuchElementException");
		}
		catch(Exception e)
		{
			Assert.fail(friendlyWebElementName + " was not found on the web page");
		}
	}
	
	public void safeJavaScriptClick(By locator, String friendlyWebElementName,int... optionWaitTime)
	{
		int waitTime = 0;
		try
		{
			waitTime =  getWaitTime(optionWaitTime);
			if(waitUntilClickable(locator, friendlyWebElementName,waitTime))
			{
				scrollIntoElementView(locator,friendlyWebElementName);
				WebElement element = driver.findElement(locator);
				setHighlight(element);
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);		
			
			}
			else
			{
				Assert.fail( friendlyWebElementName + " is not clickable in time - "+waitTime+" Seconds");
			}
		}
		catch(StaleElementReferenceException e)
		{
			Assert.fail(friendlyWebElementName + " is not attached to the page document - StaleElementReferenceException");
		}
		catch (NoSuchElementException e)
		{
			Assert.fail(friendlyWebElementName + " was not found in DOM in time - "+waitTime+" Seconds"+" - NoSuchElementException");
		}
		catch(Exception e)
		{
			Assert.fail(friendlyWebElementName + " was not found on the web page");
		}
	}

	private void setHighlight(WebElement element) {
		// TODO Auto-generated method stub
			String attributevalue = "border:3px solid red;";
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			String getattrib = element.getAttribute("style");
			executor.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, attributevalue);
			executor.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, getattrib);
		}
	public String safeGetText(By locator,String friendlyWebElementName,int waitTime)
	{
		String sValue =null;
		try
		{
			if(isElementPresent(locator, waitTime))
			{
				sValue = driver.findElement(locator).getText();
			}
			else
			{
				Assert.fail("Unable to find "+ friendlyWebElementName+" in time - "+waitTime);
			}

		}
		catch(StaleElementReferenceException e)
		{			
			Assert.fail(friendlyWebElementName +" is not attached to the page document - StaleElementReferenceException");
		}
		catch (NoSuchElementException e)
		{	    	
			Assert.fail(friendlyWebElementName + " was not found in DOM in time - "+waitTime+" - NoSuchElementException");			
		}
		catch(Exception e)
		{
			Assert.fail("Unable to find "+ friendlyWebElementName);
		}		
		return sValue;		
	}
	
	private boolean isElementPresent(By locator, int waitTime) {
		boolean bFlag = false;
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, waitTime);
			wait.until(ExpectedConditions.elementToBeClickable(locator));
			 
			if(driver.findElement((locator)).isDisplayed())
			{
				bFlag = true;
				
			}
		}
		
		catch (NoSuchElementException e)
		{
			Assert.fail("Unable to find  in DOM in time "+waitTime+" Seconds - NoSuchElementException");
		}
		catch (TimeoutException e)
		{
			Assert.fail(" was not displayed in time - "+waitTime+" Seconds - TimeoutException");
		}
		catch (Exception e)
		{
			Assert.fail(" was not displayed");
		}
		return bFlag;
	}
	

	
	public boolean waitUntilClickable(By locator, String friendlyWebElementName,int waitTime)
	{    	
		
		boolean bFlag = false;
    	try
		{
			WebDriverWait wait = new WebDriverWait(driver, waitTime);
			wait.until(ExpectedConditions.elementToBeClickable(locator));
			 
			if(driver.findElement((locator)).isDisplayed())
			{
				bFlag = true;
				
			}
		}
		
		catch (NoSuchElementException e)
		{
			Assert.fail("Unable to find " + friendlyWebElementName +" in DOM in time "+waitTime+" Seconds - NoSuchElementException");
		}
		catch (TimeoutException e)
		{
			Assert.fail(friendlyWebElementName + " was not displayed in time - "+waitTime+" Seconds - TimeoutException");
		}
		catch (Exception e)
		{
			Assert.fail(friendlyWebElementName + " was not displayed");
		}
		return bFlag;
	}
	public int getWaitTime(int[] optionalWaitArray)
	{
		if(optionalWaitArray.length<=0)
		{
			return 30000;
		}
		else
		{
			return optionalWaitArray[0];
		}
	}
	
	public void scrollIntoElementView(By locator,String friendlyWebElementName)
	{
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",driver.findElement(locator));
		
	}
	
}