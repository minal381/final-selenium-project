package framework.webPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import stepdefinition.SharedSD;

import java.util.ArrayList;
import java.util.List;

public class HotelHomePage extends BasePage {
    //Locators
    //Scenario 4
    private By roomDropdown = By.id("qf-0q-rooms");
    private By noOfRoomsSelected;
   // private By noOfRoomsSelected = By.xpath("//select[@id='qf-0q-rooms']//option[contains(text(),'9+')]");
    private By noOfDropDowns =By.xpath("//div[contains(@class,'widget-query-group widget-query-rooms widget-query-rooms-multiple')]//span[@class='widget-query-room-options-label']");
    private By age18Text = By.xpath("//span[contains(text(),'Aged 18+')]");
    //Scenario 3
    private By destinationLocator = By.xpath("//input[@id='qf-0q-destination']");
    private By searchButton = By.xpath("//button[@class='cta cta-strong']");
    private By closeButton = By.xpath("//button[@class='cta cta-link']");
    private By autoSuggestionLocator = By.xpath("//div[@class='autosuggest-category-result']");
    private By listOfHotels = By.xpath("//ul[@class='property-landmarks']//li");

    public void selectRoom(String roomToSelect) {
        selectFromDropdown(roomDropdown, roomToSelect);
    }

    public void setEnterDestination(String destination){
        setValue(destinationLocator,destination );
    }

    public void selectFromSuggestions(String selectDestination) throws InterruptedException {
        Thread.sleep(5000);

        System.out.println(selectDestination);

        List<WebElement> suggestions = SharedSD.getDriver().findElements(autoSuggestionLocator);
        for (WebElement suggestion : suggestions) {
           // System.out.println(suggestion.getText());

            if (suggestion.getText().equalsIgnoreCase(selectDestination)) {
                System.out.println(suggestion.getText());
                 //clickOn(suggestion);
                suggestion.click();
            }
        }
    }

    public void clickSearchButton(){
        clickOn(searchButton);
    }

    public void clickCloseButton(){
        clickOn(closeButton);
    }
    public void clickRoomDropDown(){
        clickOn(roomDropdown);
    }

    public boolean isAgeDisplayed(){
        boolean isAge18Displayed = isElementDisplayed(age18Text);
        return isAge18Displayed;
    }

//    public void selectNoOfRooms(int rooms)
//    { String xPathStart ="//select[@id='qf-0q-rooms']//option[contains(text(),'";
//      String xPathEnd = "')]";
//
//      noOfRoomsSelected= By.xpath(xPathStart+rooms+xPathEnd);
//      //clickNoOfRooms();
//        System.out.println(noOfRoomsSelected);
//
//       clickOn(noOfRoomsSelected);
//    }

    public boolean noOfDropDowns(int dropDown) {
        boolean isCorrectNoOfDropDownDisplayed= false;
        List<WebElement> rooms = new ArrayList<>();

        if (dropDown > 1) {
            rooms = SharedSD.getDriver().findElements(noOfDropDowns);
            int dropDownSize = rooms.size();
            if(dropDown == dropDownSize ){ isCorrectNoOfDropDownDisplayed = true;}

        }
        else if( isAgeDisplayed()) {
            isCorrectNoOfDropDownDisplayed = true;}{
        }              //<----// code to look for webElement for dropdown=1

            System.out.println(rooms.size());

        return isCorrectNoOfDropDownDisplayed;
    }





//        //clickOn(selectDate);
//        List<WebElement> rooms = SharedSD.getDriver().findElements(By.xpath("(//div[contains(@class,'datepicker-bd')])[1]//td//a"));
//
//        for (WebElement room : rooms) {
//            //System.out.println(day.getText());
//            if (day.getText().equals(checkInDate)) {
//                System.out.println(day.getText());
//                day.click();
//                break;
//            }
//        }}





















    private By autocompleteTextField = By.xpath("//input[@id='qf-0q-destination']");



    //Methods
    public void setValueInAutoCompleteTextField(){
        setValue(autocompleteTextField, "New York");
    }

}
