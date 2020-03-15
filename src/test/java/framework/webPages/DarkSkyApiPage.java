package framework.webPages;

import org.openqa.selenium.By;

public class DarkSkyApiPage extends BasePage {

    //Scenario 4

    // Locators
   //private By signUpButton = By.xpath("//header[@class='header']//li[5]");
    private By signUpButton = By.xpath("//a[@class='button filled']");

    //Methods
    public void clickOnSignUpButton() {
        clickOn(signUpButton);
    }

}
