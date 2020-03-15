package framework.webPages;

import org.openqa.selenium.By;

public class DarkSkyRegisterPage extends BasePage {

    //Scenario 4

    private By registerTitle = By.xpath("//h1[text()='Register']");
    private By registerButton = By.xpath("//button[contains(text(),'Register')]");


    public void clickOnRegister()
    {
        clickOn(registerButton);
    }

    public String getTitle()
    {
        return getTextFromElement(registerTitle);
    }

    public boolean isRegisterDisplayed()
    {
       return isElementDisplayed(registerTitle);
    }

}

//private By registerTitle = By.xpath("//h1[@class='stand-alone title']");