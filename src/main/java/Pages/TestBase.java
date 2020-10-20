package Pages;

import java.io.File;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import utility.ReadProp;


public class TestBase {
    public WebDriver driver;
    ReadProp rp;
    String baseUrl;
    public SearchPage searchPage;
    public TicketBookingPage ticketBookingPage;
    @BeforeSuite
    public void setup(){
        HashMap<String, Object> chromePrefs = new HashMap();
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + File.separator + "resource" + File.separator + "chromedriver_new");
        chromePrefs.put("profile.default_content_settings.popups", 0);

        chromePrefs.put("profile.default_content_setting_values.notifications", 2);
        chromePrefs.put("safebrowsing.enabled", "true");

        DesiredCapabilities cap = null;
        cap = DesiredCapabilities.chrome();
        cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);
        cap.setCapability(ChromeOptions.CAPABILITY, options);


        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        rp=new ReadProp("resource/config.properties");
    }

    @BeforeMethod
    public void LaunchBrowser(){
        driver.get(rp.getProperty("baseURL"));
        searchPage =new SearchPage(driver);
        ticketBookingPage =new TicketBookingPage(driver);
    }
    @AfterSuite
    public void cleanUp(){
        driver.close();
        rp=null;
    }
}
