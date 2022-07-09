package classRoomEight;

import acodemyShop.MainPage;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class AcodemyShopTest {

    WebDriver driver;
    WebDriverWait wait;
    @BeforeMethod
    public void setupBrowser(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void testSearch() throws InterruptedException {
        driver.get("http://shop.acodemy.lv/");
        MainPage mainPage= new MainPage(driver);
        mainPage.searchProduct("beanie");
        Assert.assertEquals(mainPage.getSearchResultText(),"Showing all 2 results");
        Thread.sleep(5000);
//        mainPage.getSearchInputField().sendKeys("Beanie");
//        Actions actions = new Actions(driver);
//        actions.sendKeys(Keys.ENTER).perform();
//        Thread.sleep(5000);
//        mainPage.getSearchInputField().clear();
//        mainPage.getSearchInputField().sendKeys("tshirt");
//        actions.sendKeys(Keys.ENTER).perform();
        mainPage.searchProduct("T-shirt");
        Assert.assertEquals(mainPage.getSearchResultText(),"Showing all 3 results");
        Thread.sleep(5000);
        mainPage.searchProduct("Hoodie");
        Assert.assertEquals(mainPage.getSearchResults().size(),3);
        Thread.sleep(5000);

        List<WebElement> results =  mainPage.getSearchResults();
        for (int i = 0; i < results.size(); i++) {
            System.out.println("##########################");
            System.out.println(results.get(i).getText());
//      Izvada tikai cenas
//            List<WebElement> results =  mainPage.getSearchResults();
//            for (int i = 0; i < results.size(); i++) {
//                System.out.println("##########################");
//                System.out.println(results.get(i).findElement(By.cssSelector("span.woocommerce-Price-amount")).getText());
//            }

        }

    }
    @Test
    public void testSwitchTabs() throws InterruptedException {
        driver.get("http://shop.acodemy.lv/");
        System.out.println("Tabu skaits:" + driver.getWindowHandles().size());
        driver.findElement(By.cssSelector("div[class='site-info'] a")).click();
        System.out.println(driver.getTitle());
        System.out.println("Tabu skaits:" + driver.getWindowHandles().size());

        ArrayList<String> tabs = new ArrayList<> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        System.out.println(driver.getTitle());
        driver.switchTo().window(tabs.get(0));
        System.out.println(driver.getTitle());
        Thread.sleep(2000);
    }

    @Test
    public void testJavascript() throws InterruptedException {
        driver.get("http://shop.acodemy.lv/");
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,600)");
        Thread.sleep(1000);
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,600)");
        Thread.sleep(1000);
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,600)");
        Thread.sleep(1000);
        //((JavascriptExecutor) driver).executeScript("alert('Marcis!')");
        Thread.sleep(1000);
        //Scroll un atrod elementu
        WebElement element = driver.findElement(By.cssSelector("li.post-18"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(4000);

    }
@Test
public void mouseActionsTest() throws InterruptedException {
        driver.get("https://www.w3schools.com/howto/howto_css_dropdown.asp");
        driver.findElement(By.id("accept-choices")).click();
        Actions actions = new Actions(driver);
    WebElement hoverMeButton = driver.findElement(By.xpath("//button[text()='Hover Me']"));
    actions.moveToElement(hoverMeButton).perform();
    Thread.sleep(1000);
    driver.findElement(By.linkText("Link 1")).click();
    Thread.sleep(1000);
    }

    @Test
    public void keyBoardActionTest() throws InterruptedException {
        driver.get("https://www.selenium.dev/documentation/webdriver/actions_api/keyboard/");
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.CONTROL).sendKeys("k").perform();
        Thread.sleep(5000);


    }

    @AfterMethod
    public void tearDownBrowser(){
        driver.quit();
    }

}
