package pageObjectsHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage {
    public WebDriver driver;
    public CartPage(WebDriver driver){
        this.driver = driver;
    }

    private By parbauditVaiProduktsIrGroza = By.cssSelector("div[class='inventory_item_name']");
    private By dotiesUzCheckout = By.id("checkout");

    public WebElement getParbauditVaiProduktsIrGroza(){
        return driver.findElement(parbauditVaiProduktsIrGroza);
    }
    public WebElement getDotiesUzCheckout(){
        return driver.findElement(dotiesUzCheckout);
    }
    public void checkout(){
        getDotiesUzCheckout().click();
    }

}
