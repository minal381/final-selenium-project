package stepdefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.webPages.DarkSkyHomePage;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;

public class DarkSkyVerifyIndividualDayTempSD {

    private DarkSkyHomePage homePage = new DarkSkyHomePage();


    @Given("^I am on Darksky Home Page$")
    public void iAmOnhomePage(){
        Assert.assertEquals(SharedSD.getDriver().getTitle(),"Dark Sky - Broadway, New York, NY");
    }

    @When("^I expand todays timeline$")
    public void iExpandTodaysTimeline() throws InterruptedException {
        JavascriptExecutor jsScrollBy =(JavascriptExecutor)SharedSD.getDriver();
        jsScrollBy.executeScript("scrollBy(0,500);");
        Thread.sleep(4000);
        homePage.clickToggleButton();
    }

    @Then("^I verify lowest and highest temp is displayed correctly$")
    public void verifyTempDisplayedCorrectly()
    {
         homePage.getTimeLineMinTemp();
         homePage.getTimeLineMaxTemp();
         homePage.getMinTemp();
         homePage.getMaxTemp();

         Assert.assertEquals(homePage.getMinTemp(),homePage.getTimeLineMinTemp(),"Temperature is not displayed correctly");

         Assert.assertEquals(homePage.getMaxTemp(),homePage.getTimeLineMaxTemp(),"Temperature is not displayed correctly");
    }
}









//SharedSD.getDriver().manage().window().maximize();
//System.out.println(homePage.getMinTemp()+"  "+homePage.getMaxTemp());
//boolean correctMinTempDisplayed = homePage.getMinTemp().equals(homePage.getTimeLineMinTemp());
// boolean correctMaxTempDisplayed = homePage.getMaxTemp().equals(homePage.getTimeLineMaxTemp());
