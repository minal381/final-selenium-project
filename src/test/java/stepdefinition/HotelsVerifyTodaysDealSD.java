package stepdefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import framework.webPages.HotelHomePage;
import framework.webPages.HotelsSearchScreen;
import org.testng.Assert;

public class HotelsVerifyTodaysDealSD {

    private HotelHomePage hotelHomePage = new HotelHomePage();
    private HotelsSearchScreen hotelsSearchScreen = new HotelsSearchScreen();

    @Given("^I'm on default locations search result screen$")
    public void iAmOnSearchResultScreen() throws InterruptedException
    {
         hotelHomePage.setEnterDestination("New York");
          Thread.sleep(3000);
         hotelHomePage.selectFromSuggestions("New York, New York, United States of America");
          Thread.sleep(2000);
         hotelHomePage.clickSearchButton();
        // Assert.assertTrue(hotelsSearchScreen.getBestDealTitle(),"I am not on locations search result screen or Today's deal is not displayed ");
    }

   @Then("^I verify todays deal is less than \\$(\\d+)$")
   public void iVerifyTodaysDealIsLessThan$(int value)
   {
       Assert.assertTrue(hotelsSearchScreen.dealValue(200),"Today's deal is greater than $200");
   }
}


//  hotelHomePage.clickCloseButton();

//Assert.assertEquals(hotelsSearchScreen.getBestDealTitle(), "Today's Best Deal);

//System.out.println("Hi  " + hotelsSearchScreen.getDealValue());
// Thread.sleep(2000);
// hotelsSearchScreen.getDealValue();
// System.out.println(hotelsSearchScreen.getDealValue());