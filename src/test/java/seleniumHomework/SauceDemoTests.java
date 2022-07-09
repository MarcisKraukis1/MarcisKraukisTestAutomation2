package seleniumHomework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObject.LoginPage;
import pageObjectsHomework.*;

import java.time.Duration;

public class SauceDemoTests {

    private final String SWAGPAGE_URL = "https://www.saucedemo.com/";
    WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void atvertParluku() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage()
                .timeouts()
                .implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void pirmaisScenarijs() throws InterruptedException {
        driver.get(SWAGPAGE_URL);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");
        Thread.sleep(3000);

        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.pievienot();
        inventoryPage.atvertGrozu();
        Thread.sleep(3000);

        CartPage cartPage = new CartPage(driver);
        Assert.assertEquals(cartPage.getParbauditVaiProduktsIrGroza().getText(),"Sauce Labs Bolt T-Shirt");
        cartPage.checkout();
        Thread.sleep(3000);

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.aizpilditLaukus("Marcis", "Krauķis", "LV-3301");
        checkoutPage.ietUzCheckoutParskatu();
        Thread.sleep(3000);

        CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(driver);
        Assert.assertEquals(checkoutOverviewPage.getOverviewLapasNosaukums().getText(),"CHECKOUT: OVERVIEW");
        Assert.assertEquals(checkoutOverviewPage.getProduktaNosaukums().getText(),"Sauce Labs Bolt T-Shirt");
        checkoutOverviewPage.ietUzFinishLapu();
        Thread.sleep(3000);

        CheckoutSuccessPage checkoutSuccessPage = new CheckoutSuccessPage(driver);
        Assert.assertEquals(checkoutSuccessPage.getLapasTitleNosaukums().getText(),"CHECKOUT: COMPLETE!");
        Assert.assertEquals(checkoutSuccessPage.getPaldiesUzraksts().getText(), "THANK YOU FOR YOUR ORDER");
        checkoutSuccessPage.ietUzSakumLapu();
        Thread.sleep(3000);
        }

        @Test
        public void otraisScenarijs() throws InterruptedException {
            driver.get(SWAGPAGE_URL);
            LoginPage loginPage = new LoginPage(driver);
            loginPage.login("standard_user", "secret_sauce");

            InventoryPage inventoryPage = new InventoryPage(driver);
            inventoryPage.atvertGrozu();

            CartPage cartPage = new CartPage(driver);
            cartPage.checkout();

            CheckoutPage checkoutPage = new CheckoutPage(driver);
            checkoutPage.ietUzCheckoutParskatu();
            Thread.sleep(3000);
            Assert.assertEquals(checkoutPage.getVardaKluda().getText(),"Error: First Name is required");
            checkoutPage.aizpilditLaukus("Mārcis","","");
            checkoutPage.ietUzCheckoutParskatu();
            Thread.sleep(3000);
            Assert.assertEquals(checkoutPage.getUzvardaKluda().getText(),"Error: Last Name is required");
            checkoutPage.aizpilditLaukus("","Krauķis","");
            Thread.sleep(3000);
            checkoutPage.ietUzCheckoutParskatu();
            Assert.assertEquals(checkoutPage.getPastaIndeksaKluda().getText(),"Error: Postal Code is required");
            Thread.sleep(3000);
        }

    @AfterMethod(alwaysRun = true)
    public void aizvertParluku(){
        driver.quit();
    }
}
