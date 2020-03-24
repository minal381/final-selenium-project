package stepdefinition;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.en_scouse.An;
import framework.webPages.HotelHomePage;
import org.testng.Assert;

public class HotelVerifyRoomCountDropdownSD {
    private HotelHomePage hotelHomePage = new HotelHomePage();

    @Given("^I am on hotels home page$")
    public void iAmOnHotelHomePage() {
        Assert.assertEquals(SharedSD.getDriver().getCurrentUrl(), "https://www.hotels.com/", "Invalid Home Page");
    }


    @When("^I select (\\d+) from room dropdown$")
    public void iSelectNumOfRooms(int roomNo) throws InterruptedException {
        hotelHomePage.selectRoom(String.valueOf(roomNo));
        Thread.sleep(3000);
    }

    @And("^I verify (\\d+) is displayed$")
    public void verifyNoOfDropDown(int dropdownNo){
        hotelHomePage.noOfDropDowns(dropdownNo);

        Assert.assertTrue(hotelHomePage.noOfDropDowns(dropdownNo), "Number of room dropdown is not displayed correctly");
    }
    }



// System.out.println(hotelHomePage.noOfDropDowns(dropdownNo));
//System.out.println("Number of Dropdowns "+dropdownNo);