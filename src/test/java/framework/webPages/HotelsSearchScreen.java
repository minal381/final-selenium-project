package framework.webPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import stepdefinition.SharedSD;
import java.util.ArrayList;
import java.util.List;


public class HotelsSearchScreen extends BasePage {
    private By bestDealTitle = By.xpath("//h2[@class='header-text widget-tooltip widget-tooltip-br widget-tooltip-multiline']");
    private By dealValue = By.xpath("//li[@class='hotel deal-of-the-day']//ins");
    private By distanceLable = By.xpath("//a[contains(text(),'Distance')]");
    private By airPortLocator = By.xpath("//a[contains(text(),'LaGuardia Airport (LGA)')]");
    private By listOfHotels = By.xpath("//ul[@class='property-landmarks']//li[1]");
    private By footerBlock = By.xpath("//div[@id='result-info-container']//h3[1]");
    private By listHotelName = By.xpath("//h3[@class='p-name']//child::a");
    private By selectStars =By.id("filter-star-rating-contents");
            //.xpath("//input[@id='f-star-rating-5']");
         //   private By starBadge = By.xpath("//div[@class='additional-details resp-module']//span[@class='star-rating-text']");//1 2 3 star
            private By starBadge = By.xpath("//span[contains(@class,'star-rating-text')]");

    public boolean starHotelList(float star) {
        List<WebElement> hotels = SharedSD.getDriver().findElements(starBadge);
        boolean verifyStars = false;

        for (WebElement hotel : hotels) {
            System.out.println(hotel.getText());
            {
                Float starFromText = Float.valueOf(getTextFromElement(starBadge).toString().substring(0, getTextFromElement(starBadge).indexOf("-")));
              //  Float starFromText = Float.valueOf(hotel.getText().toString().substring(0,hotel.getText().indexOf("-"))) ;
                if (starFromText >= star && starFromText<star+1) {//if we consider 4.5 =4stars, 3.5=3stars 2.5=2stars
                    verifyStars = true;
                } else{verifyStars = false;

                break;
                }
            }
        }
        return verifyStars;
    }

    public void selectStarProperty(int stars){
        String xPathStart ="//input[@id='f-star-rating-";
        String xPathEnd ="']";
        selectStars = By.xpath(xPathStart + stars + xPathEnd);
        clickOn(selectStars);
    }

//    public void selectStarsRating(String stars) {
//        selectFromDropdown(selectStars, stars);
//    }


    public boolean getBestDealTitle() {
        //getTextFromElement(bestDealTitle);
        return isElementDisplayed(bestDealTitle);
    }

    public String getDealValue() {
        return getTextFromElement(dealValue);
    }

    // Method to get is deal value less than $200    *** Scenario 3 ***
    public boolean dealValue(int value) {
        boolean lessThan200 = true;
        int dealValue_int = Integer.parseInt(getDealValue().toString().substring(1, getDealValue().length()));
        System.out.println(dealValue_int);
        if (dealValue_int < value) {
            lessThan200 = true;
        } else {
            lessThan200 = false;
        }

        return lessThan200;
    }


// Method to click on Distance     *** Scenario 2 ***

    public void cliclOnDistance(int distance) {
        clickOn(distanceLable);
    }

    public void clickOnAirport() {
        clickOn(airPortLocator);
    }

    public boolean listOfHotels() {
        // HotelName = hotelNames.get(i).getText()


        List<WebElement> hotelMiles = SharedSD.getDriver().findElements(listOfHotels);
        List<WebElement> hotelNames = SharedSD.getDriver().findElements(listHotelName);
        boolean hotelsWithin10Miles = false;
        int sizeOfhotelMiles = hotelMiles.size();
        System.out.println(sizeOfhotelMiles);
        int sizeOfhotelNames = hotelNames.size();

        List<String> hotelWithinRadius = new ArrayList<>();
        //[22, 23, 20, 16, 7]
        for (int i = 0; i < sizeOfhotelMiles; i++) {
            if (Float.valueOf(hotelMiles.get(i).getText().substring(0, hotelMiles.get(i).getText().indexOf(" "))) <= 10) {
              //  System.out.println("Hello " + hotelMiles.get(i).getText() + "--" + hotelNames.get(i).getText());
                System.out.println(Float.valueOf(hotelMiles.get(i).getText().substring(0, hotelMiles.get(i).getText().indexOf(" "))) + " less than 10 ");

                hotelWithinRadius.add(hotelNames.get(i).getText());

                System.out.println(hotelWithinRadius);

                hotelsWithin10Miles = true;
            }

        }
        return hotelsWithin10Miles;
    }

        // To find Hiltton is in list

    boolean isHiltoninList = false;

    public boolean isHiltonWithinRadius() {
        List<WebElement> hotelMiles = SharedSD.getDriver().findElements(listOfHotels);
        List<WebElement> hotelNames = SharedSD.getDriver().findElements(listHotelName);
        int sizeOfhotelMiles = hotelMiles.size();

        for (int i = 0; i < sizeOfhotelMiles; i++)
            if (hotelNames.get(i).getText().contains("Hilton")) {
                isHiltoninList = true;
                System.out.println("Hilton is within radius");
            }
        return  isHiltoninList = true;
    }
}





// Float abc= Float.valueOf(hotel.getText().toString().substring(0,hotel.getText().indexOf("-"))) ;
// System.out.println(abc + "-- "+getTextFromElement(starBadge)+ "--"+ hotel.getText());
//System.out.println( hotel.getText());
//h3[@class='p-name']//child::a
//li[@class='hotel']//a
// private By starBadgeHotelNames = By.xpath("//span[@class='hotel-badge']");
//  private By starBadge = By.xpath("//span[@class='star-rating-text star-rating-text-strong']");// 5 star and 4 star
// Hotel Distance full String e.g 8.6 miles to LaGuardia Airport (LGA) = hotels.get(i).getText()
// Hotel Distance Only e.g. 8.3 =hotels.get(i).getText().substring(0, hotels.get(i).getText().indexOf(" "))
// Hotel Distance Only in Float =  Float.valueOf(hotels.get(i).getText().substring(0, hotels.get(i).getText().indexOf(" ")))
