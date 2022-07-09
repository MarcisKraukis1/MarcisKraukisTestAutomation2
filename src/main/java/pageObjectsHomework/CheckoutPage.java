package pageObjectsHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutPage {
    public WebDriver driver;
    public CheckoutPage(WebDriver driver){
        this.driver = driver;
    }

    private By vards = By.id("first-name");
    private By uzvards = By.id("last-name");
    private By pastaIndekss = By.id("postal-code");
    private By checkoutParskataLapa = By.cssSelector("input[class='submit-button btn btn_primary cart_button btn_action'] ");

    public WebElement getVards(){
        return driver.findElement(vards);
    }
    public WebElement getUzvards(){
        return driver.findElement(uzvards);
    }
    public WebElement getPastaIndekss(){
        return driver.findElement(pastaIndekss);
    }
    public WebElement getCheckoutParskataLapa(){
        return driver.findElement(checkoutParskataLapa);
    }

    public void aizpilditLaukus(String vards, String uzvards, String pastaIndekss){
        getVards().sendKeys(vards);
        getUzvards().sendKeys(uzvards);
        getPastaIndekss().sendKeys(pastaIndekss);
    }
    public void ietUzCheckoutParskatu(){
        getCheckoutParskataLapa().click();
    }

    private By vardaKluda = By.cssSelector("h3[data-test='error']");
    private By uzvardaKluda = By.cssSelector("h3[data-test='error']");
    private By pastaIndeksaKluda = By.cssSelector("h3[data-test='error']");

    public WebElement getVardaKluda(){
        return driver.findElement(vardaKluda);
    }
    public WebElement getUzvardaKluda(){
        return driver.findElement(uzvardaKluda);
    }
    public WebElement getPastaIndeksaKluda(){
        return driver.findElement(pastaIndeksaKluda);
    }
}
