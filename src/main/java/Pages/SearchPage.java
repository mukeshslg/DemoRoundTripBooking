package Pages;


import org.apache.log4j.Logger;
import org.openqa.selenium.By;
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
    private String uname;
    private String pass;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        rp=new ReadProp("resource/config.properties");
        uname =rp.getProperty("username");
        pass=rp.getProperty("password");
    }
    @FindBy(id = "email")
    WebElement userName;
    @FindBy(id = "pass")
    WebElement password;
    @FindBy(name = "login")
    WebElement loginBtn;
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
    public void loadCT(){
        userName.sendKeys(uname);
        password.sendKeys(pass);
        loginBtn.click();
        new WebDriverWait(driver,20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Mukesh Sah']")));
    }

    /**
     * @author Mukesh
     */
    public void searchFlight(String source,String destination ) throws InterruptedException {

        roundTrip.click();
        fromPlace.sendKeys(Keys.ESCAPE);
        fromPlace.sendKeys(source);
        Thread.sleep(1500);
        fromPlace.sendKeys(Keys.ENTER);
        ToPlace.sendKeys(destination);
        Thread.sleep(1500);
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
     *
     * @throws InterruptedException
     */
    public void BookFlightTicket() throws InterruptedException {
        new WebDriverWait(driver,20).until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Book']")));
        bookTicket.click();
    }

}
