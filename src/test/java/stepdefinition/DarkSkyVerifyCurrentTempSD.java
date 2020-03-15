package stepdefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import framework.webPages.DarkSkyHomePage;
import org.testng.Assert;



public class DarkSkyVerifyCurrentTempSD {
    private DarkSkyHomePage homePage = new DarkSkyHomePage();

    @Given("^I am on Darksky HomePage$")
    public void iAmOnDarkSkyHomePage(){
        Assert.assertEquals(SharedSD.getDriver().getTitle(),"Dark Sky - Broadway, New York, NY");
    }

    @Then("^I verify current temp is not greater or less then temps from daily timeline$")
    public void verifyCurrentTemp()
    {
        homePage.getCurrentTemp();
        homePage.dailyTimeLineTemp();

        int currentTemp= homePage.dailyTimeLineTemp().get(0);
        int minimumTempFromTimeLine= homePage.dailyTimeLineTemp().get(1);
        int maximumTempFromTimeLine= homePage.dailyTimeLineTemp().get(2);

        Assert.assertTrue((currentTemp >= minimumTempFromTimeLine && currentTemp <= maximumTempFromTimeLine), "Current temperature is not displayed correctly");
    }

    }



















//        System.out.println(a);
//        System.out.println(b);
//        System.out.println(c);

// Assert.assertTrue(homePage.dailyTimeLineTemp());
//  System.out.println(homePage.dailyTimeLineTemp());
//        int a=10; //minTemp
//        int b=20; //currTemp
//        int c =30; //maxTemp
// Assert.assertTrue((notLessThanMin && notGreaterThanMax), "");
//  Assert.assertTrue((currentTemp >= minimumTempFromTimeLine && currentTemp <= 9), "Current temperature is not displayed correctly");
