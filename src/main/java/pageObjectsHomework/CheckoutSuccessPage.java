package pageObjectsHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutSuccessPage {
    public WebDriver driver;
    public CheckoutSuccessPage(WebDriver driver){
        this.driver = driver;
    }
    private By lapasTitleNosaukums = By.cssSelector("span[class='title'] ");
    private By paldiesUzraksts = By.cssSelector("h2[class='complete-header'] ");
    private By sakumaLapa = By.xpath("//*[@id=\"back-to-products\"]");

    public WebElement getLapasTitleNosaukums(){
        return driver.findElement(lapasTitleNosaukums);
    }
    public WebElement getPaldiesUzraksts(){
        return driver.findElement(paldiesUzraksts);
    }
    public WebElement getSakumaLapa(){
        return driver.findElement(sakumaLapa);
    }
    public void ietUzSakumLapu(){
        getSakumaLapa().click();
    }
}
