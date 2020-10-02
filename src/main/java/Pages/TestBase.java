package Pages;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.aspectj.lang.annotation.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import utility.ReadProp;


public class TestBase {
    public WebDriver driver;
    ReadProp rp;
    String baseUrl;
    public LoginPage loginPage;
    public HomePage homePage;
    @BeforeSuite
    public void setup(){
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + File.separator + "resource" + File.separator + "chromedriver_mac");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        rp=new ReadProp("resource/config.properties");
    }

    @BeforeTest
    public void LaunchBrowser(){
        driver.get(rp.getProperty("baseURL"));
        loginPage=new LoginPage(driver);
        homePage=new HomePage(driver);
    }
    @AfterSuite
    public void cleanUp(){
        driver.close();
        rp=null;
    }
}
