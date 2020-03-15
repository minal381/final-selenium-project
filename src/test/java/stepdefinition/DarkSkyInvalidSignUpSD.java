package stepdefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.webPages.BasePage;
import framework.webPages.DarkSkyApiPage;
import framework.webPages.DarkSkyHomePage;
import framework.webPages.DarkSkyRegisterPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DarkSkyInvalidSignUpSD{
    private DarkSkyHomePage  homePage = new DarkSkyHomePage();
    private DarkSkyApiPage darkSkyApiPage = new DarkSkyApiPage();
    private DarkSkyRegisterPage darkSkyRegisterPage = new DarkSkyRegisterPage();

       @Given("^I am on the darksky Register page$")
        public void iAmOnDarkSkyRegisterPage()
       {
            homePage.clickOnDarkSkyApiLink();
            darkSkyApiPage.clickOnSignUpButton();
            Assert.assertTrue(darkSkyRegisterPage.isRegisterDisplayed(),"You are not on the Register page");
       }

        @When("^I click on (Register) button$")
        public void clickOnRegisterButton(String button)
        {
            darkSkyRegisterPage.clickOnRegister();
        }

        @Then("^I verify I am on Register page by asserting Register header$")
        public void verifyIAmOnRegisterPage()
        {
            Assert.assertTrue(darkSkyRegisterPage.isRegisterDisplayed(),"You are not on the Register page");
        }

}

// Assert.assertEquals(SharedSD.getDriver().getTitle(), "Dark Sky API: Register", "Invalid Home page");
// Assert.assertEquals(SharedSD.getDriver().getTitle(), "Dark Sky API: Register", "Invalid Home page");




