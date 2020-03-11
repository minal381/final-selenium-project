package stepdefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.webPages.BasePage;
import framework.webPages.DarkSkyHomePage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DarkSkyInvalidSignUpSD{
    private DarkSkyHomePage  homePage = new DarkSkyHomePage();

       @Given("^I am on the darksky Register page$")
        public void iAmOnDarkSkyRegisterPage(){
        homePage.clickOnDarkSkyApiLink();
        homePage.clickOnSignUpButton();
        Assert.assertEquals(SharedSD.getDriver().getTitle(), "Dark Sky API: Register", "Invalid Home page");
       }

        @When("^I click on (Register) button$")
        public void clickOnRegisterButton(String button){
        homePage.clickOnRegister();
        }

        @Then("^I verify I am on Register page by asserting Register header$")
        public void verifyIAmOnRegisterPage(){
            Assert.assertEquals(SharedSD.getDriver().getTitle(), "Dark Sky API: Register", "Invalid Home page");
       }

}




