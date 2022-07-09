package pageObjectsHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutOverviewPage {
    public WebDriver driver;
    public CheckoutOverviewPage(WebDriver driver){
        this.driver = driver;
    }
    private By overviewLapasNosaukums = By.cssSelector("span[class='title']");
    private By produktaNosaukums = By.cssSelector("div[class='inventory_item_name']");
    private By finishPoga = By.id("finish");

    public WebElement getOverviewLapasNosaukums(){
        return driver.findElement(overviewLapasNosaukums);
    }
    public WebElement getProduktaNosaukums(){
        return driver.findElement(produktaNosaukums);
    }
    public WebElement getFinishPoga(){
        return driver.findElement(finishPoga);
    }
    public void ietUzFinishLapu(){
        getFinishPoga().click();
    }
}
