package stepdefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import framework.webPages.DarkSkyHomePage;
import org.testng.Assert;

public class DarkSkyCorrectTimelineDisplaySD {
    private DarkSkyHomePage homePage = new DarkSkyHomePage();

    @Given("^I am on Darksky home page$")
    public void iAmOnDarkSkyHome(){
    Assert.assertEquals(SharedSD.getDriver().getTitle(),"Dark Sky - Broadway, New York, NY");
    }

    @Then("^I verify timeline is displayed with two hours incremented$")
    public void verifyTimeLineDisplay(){
        boolean result = homePage.timeLineDisplay();
        Assert.assertTrue(result,"Timeline is not displayed with two hours incremented.");
}
}
