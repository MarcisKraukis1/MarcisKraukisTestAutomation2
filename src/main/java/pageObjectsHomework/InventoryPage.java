package pageObjectsHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InventoryPage {
   public WebDriver driver;

   public InventoryPage(WebDriver driver){
      this.driver = driver;
   }


   private By pievienotGrozam = By.id("add-to-cart-sauce-labs-bolt-t-shirt");
   private By ietUzGrozu = By.cssSelector("a[class='shopping_cart_link']");

   public WebElement getPievienotGrozam(){
      return driver.findElement(pievienotGrozam);
   }
   public void pievienot(){
      getPievienotGrozam().click();
   }

   public WebElement getIetUzGrozu(){
      return driver.findElement(ietUzGrozu);
   }
   public void atvertGrozu(){
      getIetUzGrozu().click();
   }
}
