package com.pages.pageobjects;

import com.cucumber.listener.Reporter;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MyStepdefs {

    @Before
    public void beforeScenario(Scenario scenario) {
        if (scenario.getName().equals("My First Scenario")) {
            Reporter.assignAuthor("Nikhil");
        }
    }

    @Given("I have (\\d+) cukes in my belly")
    public void I_have_cukes_in_my_belly(){
    	Reporter.addStepLog("My test addStepLog message");
        Reporter.addScenarioLog("This is scenario log");
       
    }

    @Then("^I print$") 
    public void iPrint(){
    }
    
    @Given("^Open the Firefox and launch the application$")				
    public void open_the_Firefox_and_launch_the_application() throws Throwable							
    {		
        System.out.println("This Step open the Firefox and launch the application.");					
    }		

    @When("^Enter the Username and Password$")					
    public void enter_the_Username_and_Password() throws Throwable 							
    {		
       System.out.println("This step enter the Username and Password on the login page.");					
    }		

    @Then("^Reset the credential$")					
    public void Reset_the_credential() throws Throwable 							
    {    		
        System.out.println("This step click on the Reset button.");					
    }
    
    

}