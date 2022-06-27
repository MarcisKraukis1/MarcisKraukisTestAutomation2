package mavenTestNGHomework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class webTitleParbaude {
    WebDriver googleParluks;
    @Test
    public void webTitleParbaudeViens(){
      //  googleParluks = new ChromeDriver();
        googleParluks.navigate().to("https://www.google.com/webhp?hl=en&sa=X&ved=0ahUKEwjF9sLrpcv4AhX6VfEDHWA-DmwQPAgI");
        String gaidamaisNosaukums = "Google";
        String patiesaisNosaukums = googleParluks.getTitle();
        Assert.assertEquals(patiesaisNosaukums,gaidamaisNosaukums);
    }

    @Test
    public void webTitleParbaudeDivi(){
        googleParluks.navigate().to("https://www.istqb.org/");
        String gaidamaisNosaukums = "International Software Testing Qualifications Board";
        String patiesaisNosaukums = googleParluks.getTitle();
        Assert.assertEquals(patiesaisNosaukums,gaidamaisNosaukums);
    }
    @BeforeMethod
        public void driveris(){
        googleParluks = new ChromeDriver();
        }

    @AfterMethod
    public void closeBrowser(){
        googleParluks.quit();
    }

}
