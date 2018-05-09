package com.cucumber.stepdefinitions;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import com.selenium.SafeActions;

import cucumber.api.java.en.Given;
 
public class AdenturesByDisney extends SafeActions
{
    @Test
    @Given("^User is on Home Page$")
    public void verifyRatesAndDatesTab()
    
    {
    	safeJavaScriptClick(By.id("destinations-filter-group"), "Destinations drop down");
    	safeJavaScriptClick(By.xpath("//span[@data-filter='NorthAmerica']"), "North America Option");
    	safeJavaScriptClick(By.xpath("//p[@data-default='All Dates']"), "All Dates drop down");
    	safeJavaScriptClick(By.xpath("//span[@data-filter='06']"), "June Option");
    	safeJavaScriptClick(By.xpath("//p[@data-default='All Types']"), "All Types drop down");
    	safeJavaScriptClick(By.xpath("//span[@data-filter='TheGreatOutdoors']"), "The Great Outdoors Option");
    	safeJavaScriptClick(By.xpath("//a[text()='Find Trips']"), "Find Trips button");
    	safeJavaScriptClick(By.xpath("//a[@href='/asia-africa-australia/australia-vacations/']"), "Australia Vacations Resort link");
    	safeJavaScriptClick(By.xpath("//a[@name='rates-dates']"), "Rates and Dates Tab");
    	Assert.assertEquals(safeGetText(By.xpath("//div[@id='rates-container']/div/p"), "Rates and Dates text", 10000), "Please note that itinerary activities and order may vary by vacation departures.");
    	}
    
}