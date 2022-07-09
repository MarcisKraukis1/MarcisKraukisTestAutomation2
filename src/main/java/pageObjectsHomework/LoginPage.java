package pageObjectsHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    public WebDriver driver;

    public LoginPage(WebDriver driver){this.driver = driver;}

    private  By lietotajvardaIevadesLauks = By.id("user-name");
    private By parolesIevadesLauks = By.id("password");
    private By loginPoga = By.id("login-button");

    public void login(String username, String password){
        getLietotajvardaIevadesLauks().sendKeys(username);
        getParolesIevadesLauks().sendKeys(password);
        getLoginPoga().click();
    }
    public WebElement getLietotajvardaIevadesLauks(){
        return driver.findElement(lietotajvardaIevadesLauks);
    }
    public WebElement getParolesIevadesLauks(){
        return driver.findElement(parolesIevadesLauks);
    }
    public WebElement getLoginPoga(){
        return driver.findElement(loginPoga);
    }

}
