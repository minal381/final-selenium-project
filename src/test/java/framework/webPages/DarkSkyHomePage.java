package framework.webPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import stepdefinition.SharedSD;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DarkSkyHomePage  extends BasePage {

    //Locators
    private By darkSkyApiLink = By.xpath("//div[@class='inner']//a[contains(text(),'Dark Sky API')]");
    private By toggleButton = By.xpath("//body[@class='forecast']/div[@id='week']/a[1]/span[3]//span[@class='open']");
    private By currentTemperature = By.xpath("//div[@id='title']//span[@class='summary swap']");
    private By timeLineMinTemp = By.xpath("//a[1]//span[2]//span[1]");
    private By timeLineMaxTemp = By.xpath("//a[1]//span[2]//span[3]");
    private By minTemp = By.xpath("//div[@class='dayDetails revealed']//div[@class='highLowTemp swip']//span[@class='highTemp swip']//span[@class='temp']");
    private By maxTemp = By.xpath("//div[@class='dayDetails revealed']//div[@class='highLowTemp swip']//span[@class='lowTemp swap']//span[@class='temp']");
    private By dailyTimeLineTemp;
    private By timeLineDisplay = By.xpath("//div[@id='timeline']//div[@class='hours']/child::span");
    private By timeLineDisplay1;

    //Methods
    // Scenario 4
    public void clickOnDarkSkyApiLink() {
        clickOn(darkSkyApiLink);
    }

    // Scenario 3
    public void clickToggleButton() {
        SharedSD.getDriver().manage().window();
        clickOn(toggleButton);
    }
    // Scenario 3
    public String getTimeLineMinTemp() {
        return getTextFromElement(timeLineMinTemp);
    }
    // Scenario 3
    public String getTimeLineMaxTemp() {
        return getTextFromElement(timeLineMaxTemp);
    }
    // Scenario 3
    public String getMinTemp() {
        return getTextFromElement(minTemp);
    }
    // Scenario 3
    public String getMaxTemp() {
        return getTextFromElement(maxTemp);
    }

    //Scenario 1
    public int getCurrentTemp() {
        String currentTemp_string = getTextFromElement(currentTemperature);
       // System.out.println(currentTemp_string);
        String currenttempArray[] = currentTemp_string.split(" ");
        currentTemp_string = currenttempArray[0];

        // 1. Remove degree symbol from temperature using substring method
        currentTemp_string= currentTemp_string.toString().substring(0,currentTemp_string.toString().length()-1);

        //2. Convert string to integer
        int currentTemp_int= Integer.parseInt(currentTemp_string);
     //   System.out.println(currentTemp_int);

       return currentTemp_int;

    }

    // Scenario 1
    public List<Integer> dailyTimeLineTemp() {

        //Below logic to create 12 different xpaths for each row by incrementing number

        String xPathStart = "//div[@class='temps']//span[";
        String xPathEnd = "]//span[1]";
        List<Integer> temps = new ArrayList<>();

        for (int i = 1; i <= 12; i++) {
            dailyTimeLineTemp = By.xpath(xPathStart + i + xPathEnd);
            String temp_string = getTextFromElement(dailyTimeLineTemp);
            //System.out.println( getTextFromElement(dailyTimeLineTemp).length());

            // 1. Remove degree symbol from temperature using substring method
            temp_string = temp_string.toString().substring(0, temp_string.toString().length() - 1);
            //2. Convert string to integer
            int dailyTimeLineTemp_int = Integer.parseInt(temp_string);

            //3. Add temperature to list
            temps.add(dailyTimeLineTemp_int);

        } //////End of for loop

        // sort list
             // System.out.println(temps);
             Collections.sort(temps);
              //System.out.println(temps);


        // Find first Number of list
            int minimumTempFromTimeLine = temps.get(0);
             //System.out.println(temps.get(0));

        //Find last number of list
             int maximumTempFromTimeLine = temps.get(temps.size() - 1);
            //System.out.println(maximumTempFromTimeLine);

        // get current temperature
        int currentTemp = getCurrentTemp();

        List<Integer> tempArray = new ArrayList<>();
        tempArray.add(currentTemp);
        tempArray.add(minimumTempFromTimeLine);
        tempArray.add(maximumTempFromTimeLine);
        return tempArray;
    }

    // Scenario 2

    public boolean timeLineDisplay(){
       // getTextFromElement(timeLineDisplay);

        // List Web Elements
        List<WebElement> timeLineHrs = SharedSD.getDriver().findElements(timeLineDisplay);
        int timeLineHrSize = timeLineHrs.size();
        System.out.println(timeLineHrSize);

        // Using for loop, get text for each web element
        String xPathStart1 = "//div[@id='timeline']//div[@class='hours']/child::span[";
        String xPathEnd1 ="]";
        boolean isTimeLinedisplayedWithTwoHrsIncremented = true;


        List<String>  listHrsString = new ArrayList<>();


        for(int i=3; i<=timeLineHrSize; i=i+2)
        {
            timeLineDisplay1 = By.xpath(xPathStart1 + i + xPathEnd1);
            String timeLine_string = getTextFromElement(timeLineDisplay1);
            timeLine_string=timeLine_string.toUpperCase();
            System.out.println("Time line Hrs"+": "+timeLine_string);

        //    timeLine_string = timeLine_string.toString().substring(0,timeLine_string.length()-2);
         //System.out.println(timeLine_string);

            LocalTime localTime = LocalTime.now();
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("ha");
            String timeAfterEvery2Hrs =localTime.plusHours(i-1).format(dateTimeFormatter);
           System.out.println("System time"+ ":" + timeAfterEvery2Hrs); //+localTime.plusHours(i-1).format(dateTimeFormatter));
           if (timeLine_string.equals(timeAfterEvery2Hrs) )
           {
               System.out.println("Matched");
               isTimeLinedisplayedWithTwoHrsIncremented = true;
           }
           else {
               System.out.println("Not Matching");
               isTimeLinedisplayedWithTwoHrsIncremented = false;
               break;
           }
        }
         return isTimeLinedisplayedWithTwoHrsIncremented;

    }


}






//    private By registerTitle = By.xpath("//h1[@class='stand-alone title']");
//private By registerButton = By.xpath("//button[contains(text(),'Register')]");

//    public void clickOnRegister() {
//        clickOn(registerButton);
//    }

//    public String getTitle() {
//        return getTextFromElement(registerTitle);
//    }




//    public void getDailyTimeLineTemps() {
//        List<WebElement> temps = SharedSD.getDriver().findElements(tempDailyTimeLine);
//        for (WebElement temp : temps) {
//            System.out.println(temp);
//        }



// System.out.println(getTextFromElement(dailyTimeLineTemp));
//-----
// System.out.println("Helo"+ Integer.valueOf(temp_string.toString().substring(0,temp_string.toString().length()-1)));
//----


//            int lastIndex = temp_string.length()-1;
//            temp_string.substring(0,lastIndex);
//            temperature = Integer.valueOf(temp_string);
//            System.out.println(temperature);

    //int minTempFromTimeLine =9999;
//        int maxTempFromTimeLine =-99;


// Assert.assertTrue((notLessThanMin && notGreaterThanMax), "");

//        boolean isGreaterThanMinimumTemp = getCurrentTemp() > minimumTempFromTimeLine;
//        boolean isLessThanMaximumTemp = getCurrentTemp() < maximumTempFromTimeLine;

// System.out.println(timeLineHrs);


// private By signUpButton = By.xpath("//a[@class='button filled']");

//    public void clickOnSignUpButton() {
//        clickOn(signUpButton);
//    }
//dateTimeFormatter=localTime.plusHours(i-1).format(dateTimeFormatter);
// System.out.println("System time"+": "+localTime.format(dateTimeFormatter));

//       // for(WebElement timeLineHr : timeLineHrs){
//         //   String timeLineHrString = timeLineHr.getText();
//            System.out.println(timeLineHrString);
//
//            List<String>  listHrsString = new ArrayList<>();
//
//            listHrsString.add(timeLineHrString);

//System.out.println("hi"+ listHrsString.get(0));
//
//        boolean notLessThanMin = currentTemp >= minimumTempFromTimeLine;
//        boolean notGreaterThanMax = currentTemp <= maximumTempFromTimeLine;
           //  *******//IMPORTS//********* //
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.interactions.SourceType;
//import org.openqa.selenium.interactions.touch.ScrollAction;
//import org.testng.Assert;

// private By tempDailyTimeLine = By.xpath("//div[@class='temps']//span//span[1]");
// private By  dailyTimeLineTempSize= By.xpath("//div[@class='temps']//span[4]//span[1]");