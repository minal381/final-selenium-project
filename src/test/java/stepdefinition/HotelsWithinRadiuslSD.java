package stepdefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import framework.webPages.HotelHomePage;
import framework.webPages.HotelsSearchScreen;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;

public class HotelsWithinRadiuslSD {

    private HotelHomePage hotelHomePage = new HotelHomePage();
    private HotelsSearchScreen hotelsSearchScreen = new HotelsSearchScreen();

    @Given("^I am on default locations search result screen$")
    public void iAmOnSearchResultScreen() throws InterruptedException {
        hotelHomePage.setEnterDestination("Jersey City");
        Thread.sleep(2000);
        hotelHomePage.selectFromSuggestions("Jersey City, New Jersey, United States of America");
        //Thread.sleep(2000);
        hotelHomePage.clickSearchButton();
        // Assert.assertTrue(hotelsSearchScreen.getBestDealTitle(),"I am not on locations search result screen ");
    }

    @Then("^I verify system displays all hotels within (\\d+) miles radius of airport$")
    public void verifyHotelsWithInRadius(int distance) throws InterruptedException {
        SharedSD.getDriver().manage().window().fullscreen();

        hotelsSearchScreen.cliclOnDistance(distance);

        hotelsSearchScreen.clickOnAirport();

        Thread.sleep(3000);


        try {
            long lastHeight = (long) ((JavascriptExecutor) SharedSD.getDriver()).executeScript("return document.body.scrollHeight");

            while (true) {

                ((JavascriptExecutor) SharedSD.getDriver()).executeScript("window.scrollTo(0, document.body.scrollHeight);");
                Thread.sleep(5000);

                long newHeight = (long) ((JavascriptExecutor) SharedSD.getDriver()).executeScript("return document.body.scrollHeight");
                if (newHeight == lastHeight) {
                    break;
                }
                lastHeight = newHeight;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(hotelsSearchScreen.listOfHotels(), "All hotels are not within 10 miles radius of airport");

        // hotelsSearchScreen.listOfHotels();
    }


    @Then("^I verify Hilton Hotel is within radius$")
    public void verifyHiltonHotelIsWithinRadius() {
        Assert.assertTrue(hotelsSearchScreen.isHiltonWithinRadius(), "Hilton Hotel is not within radius");
    }
    }
   // JavascriptExecutor js = (JavascriptExecutor)SharedSD.getDriver();
//
//        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
