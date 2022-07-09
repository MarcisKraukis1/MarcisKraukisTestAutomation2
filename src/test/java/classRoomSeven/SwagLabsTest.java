package classRoomSeven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObject.Footer;
import pageObject.LoginPage;
import pageObject.ProductsPage;

import java.time.Duration;
import java.util.List;

public class SwagLabsTest {

    WebDriver driver;
    private final String SWAGLABS_URL = "https://www.saucedemo.com/";
    private final String LOCAL_URL = "file://C:\\Users\\User\\Desktop\\Javamajasdarbs\\MarcisKraukisTestAutomation\\elements.html";

    @BeforeMethod(alwaysRun = true)
    public void openBrowser(){
        //atveram browseri
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage()
                .timeouts()
                .implicitlyWait(Duration.ofSeconds(10));

        System.out.println("Atveram browseri");

    }

    @Test
    public void testErrorMessage() throws InterruptedException {
        //veiksim visas darbibas, lai notestetu error message
        driver.get(SWAGLABS_URL);

        WebElement userNameInputField = driver.findElement(By.id("user-name")); // userNameInputField var rakstīt jebkādu nosaukumu
        userNameInputField.sendKeys("standard_user");

       WebElement passwordInputField =  driver.findElement(By.name("password"));
       passwordInputField.sendKeys("");

       WebElement loginButon = driver.findElement(By.cssSelector("input#login-button"));
       loginButon.click();
       WebElement errorMessage = driver.findElement(By.cssSelector("h3[data-test = 'error']"));
       String actualErrorMessage = errorMessage.getText();
       String expectedErrorMessage = "Epic sadface: Password is required";

        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);




        Thread.sleep(5000);
        System.out.println("Izpildam testu");
    }

//   // @Test
//    //public void tetsSuccesfullLogin() throws InterruptedException {
//        driver.get(SWAGLABS_URL);
//        WebElement userNameInputField =  driver.findElement(By.id("user-name"));
////        WebElement userNameInputField =  driver.findElement(By.cssSelector("input[id='user-name']"));
//        userNameInputField.sendKeys("standard_user");
//
//        //tagad uzrakstam paroles lauku un ievadam tur vertibu
//        WebElement passwordInputField = driver.findElement(By.name("password"));
//        passwordInputField.sendKeys("secret_sauce");
//
//        //atradisim Login pogu
//
//        WebElement loginButton = driver.findElement(By.cssSelector("input#login-button"));
//        loginButton.click();
//
//        WebElement titleText = driver.findElement(By.cssSelector("span[class='title']"));
//        Assert.assertEquals(titleText.getText(),"PRODUCTS");
//
//        WebElement linkedInLink = driver.findElement(By.linkText("LinkedIn"));
//        // WebElement linkedInLink = driver.findElement(By.cssSelector("li[class='social_linkedin'] > a"));
//        //linkedInLink.click();
//
//        Select sortDropDown = new Select(driver.findElement(By.className("product_sort_container")));
//        sortDropDown.selectByValue("hilo");
//
//        WebElement addFleeceJacketToCartButton = driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-fleece-jacket']"));
//        addFleeceJacketToCartButton.click();
//
//
//        Thread.sleep(3000);
//    }

    @Test
    public void testSamplePage() throws InterruptedException {
    driver.get(LOCAL_URL);

    WebElement vards = driver.findElement(By.id("fNameID"));
    vards.sendKeys("Mārcis");

    WebElement uzvards = driver.findElement(By.id("lNameID"));
    vards.sendKeys("Krauķis");

    WebElement informacija = driver.findElement(By.name("description"));
    informacija.clear();
    informacija.sendKeys("Šī ir info par mani");

    WebElement studentCheckBox = driver.findElement(By.id("studentID"));
    studentCheckBox.click();

        WebElement radioButtonJava = driver.findElement(By.id("javaID"));
        System.out.println(radioButtonJava.isSelected());
        radioButtonJava.click();
        System.out.println(radioButtonJava.isSelected());

        Select milakaKrasaDropdown = new Select(driver.findElement(By.id("colorsID")));
        milakaKrasaDropdown.selectByIndex(0);
        milakaKrasaDropdown.selectByIndex(1);

        List<WebElement> saraksts = milakaKrasaDropdown.getOptions();

        for (int i = 0; i < saraksts.size(); i++) {
            System.out.println(saraksts.get(i).getText());
        }





        Thread.sleep(3000);
    }

    @Test
    public void testErrorMessageWithPOM(){
        driver.get(SWAGLABS_URL);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.getUsernameField().sendKeys("standard_user");
        loginPage.getPasswordField().sendKeys("");
        loginPage.getLoginButton().click();
        String expectedErrorMessage = "Epic sadface: Password is required";
        String actualText = loginPage.getErrorMessageTextField().getText();
        Assert.assertEquals(actualText,expectedErrorMessage);


    }

    @Test
    public void testErrorMessageWithoutPasswordPOM(){
        driver.get(SWAGLABS_URL);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Marcis","");
        loginPage.getLoginButton().click();
        String actualText = loginPage.getErrorMessageTextField().getText();
        String expectedErrorMessage = "Epic sadface: Password is required";
        Assert.assertEquals(actualText,expectedErrorMessage);
    }
    @Test
    public void testErrorMessageWithoutUsernameWPOM(){
        driver.get(SWAGLABS_URL);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("","parole");
        loginPage.getLoginButton().click();
        String actualText = loginPage.getErrorMessageTextField().getText();
        String expectedErrorMessage = "Epic sadface: Password is required";
        Assert.assertEquals(actualText,expectedErrorMessage);
    }
    @Test
    public void testSuccessLogin(){
        driver.get(SWAGLABS_URL);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user","secret_sauce");

  }
//   // @Test
//  //  public void testSuccessLogin(){
//        driver.get(SWAGLABS_URL);
//        LoginPage loginPage = new LoginPage(driver);
//        loginPage.login("standard_user","secret_sauce");
//        ProductsPage productsPage = new ProductsPage(driver);
//        Assert.assertEquals(productsPage.getPageTitle().getText(),"PRODUCTS");
//    }
//
@Test
public void testFooterCopyRightText() {
    driver.get(SWAGLABS_URL);
    LoginPage loginPage = new LoginPage(driver);
    loginPage.login("standard_user", "secret_sauce");
    Footer footer = new Footer(driver);
    String actualString = footer.getCopyRightTextField().getText();
    String expectedString = "© 2022 Sauce Labs. All Rights Reserved. Terms of Service | Privacy Policy";
    Assert.assertEquals(actualString, expectedString);
}


    @AfterMethod(alwaysRun = true)
    public void closeBrowser(){
        //aizveram browseri
        driver.quit();
        System.out.println("Aizveram browseri");
    }

}
