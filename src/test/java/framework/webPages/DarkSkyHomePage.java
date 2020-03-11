package framework.webPages;

import org.openqa.selenium.By;

public class DarkSkyHomePage  extends BasePage {
    //Locators
    private By darkSkyApiLink = By.xpath("//div[@class='inner']//a[contains(text(),'Dark Sky API')]");
    private By signUpButton   = By.xpath("//a[@class='button filled']");
    private By registerTitle  = By.xpath("//h1[@class='stand-alone title']");
    private By registerButton = By.xpath("//button[contains(text(),'Register')]");

    //Methods

    public void clickOnDarkSkyApiLink(){
        clickOn(darkSkyApiLink);
    }

    public void clickOnSignUpButton(){
        clickOn(signUpButton);
    }

    public void clickOnRegister(){
        clickOn(registerButton);
    }
}
