package Pages;


import java.security.Key;

import common.CommonMethods;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.ReadProp;

public class SearchPage {
    WebDriver driver;
    ReadProp rp;
    public static Logger log = Logger.getLogger(SearchPage.class);

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        rp=new ReadProp("resource/config.properties");

    }

    @FindBy(id = "RoundTrip")
    WebElement roundTrip;
    @FindBy(id = "FromTag")
    WebElement fromPlace;
    @FindBy(id = "ToTag")
    WebElement ToPlace;
    @FindBy(xpath = "(//*[@id=\"ORtrip\"]//i)[1]")
    WebElement FirstDatePickerIcon;
    @FindBy(xpath = "(//*[@id=\"ORtrip\"]//i)[1]")
    WebElement secondDatePickerIcon;
    @FindBy(xpath = "(//*[@id=\"ui-datepicker-div\"]//a[text()='21'])[1]")
    WebElement fromDate;
    @FindBy(xpath = "(//*[@id=\"ui-datepicker-div\"]//a[text()='22'])[2]")
    WebElement toDate;
    @FindBy(id = "SearchBtn")
    WebElement searchBtn;

    @FindBy(xpath = "//button[text()='Book']")
    WebElement bookTicket;



    /**
     * @author Mukesh
     */
    public void searchFlight(String source,String destination ) throws InterruptedException {
        roundTrip.click();
        Thread.sleep(2000);
        fromPlace.sendKeys(Keys.ESCAPE);
        fromPlace.sendKeys(source);

        new WebDriverWait(driver,20).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"ui-id-1\"]/li[1]")));
        fromPlace.sendKeys(Keys.ENTER);
        ToPlace.sendKeys(destination);
        new WebDriverWait(driver,20).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"ui-id-2\"]/li[1]")));
        ToPlace.sendKeys(Keys.ENTER);
        FirstDatePickerIcon.click();
        Thread.sleep(1000);
        fromDate.click();
        secondDatePickerIcon.click();
        Thread.sleep(1000);
        toDate.click();
        searchBtn.click();
    }


    /**
     *  bookFlightTicketAndSwitchToNewWindow
     * @throws InterruptedException
     */
    public void bookFlightTicketAndSwitchToNewWindow() throws InterruptedException {
        Thread.sleep(15000);
        //WebElement element=new WebDriverWait(driver,30).until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Book']")));
        String currentWindow=driver.getWindowHandle();
        bookTicket.click();
        Thread.sleep(15000);
        CommonMethods.switchToChildWindow(driver,currentWindow);
    }

}
