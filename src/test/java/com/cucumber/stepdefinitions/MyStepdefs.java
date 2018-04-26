package com.cucumber.stepdefinitions;

import com.cucumber.listener.Reporter;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

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

}
