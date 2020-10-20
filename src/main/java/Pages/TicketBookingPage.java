package Pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.ReadProp;

public class TicketBookingPage {
    WebDriver driver;
    ReadProp rp;
    public static Logger log = Logger.getLogger(TicketBookingPage.class);

    public TicketBookingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        rp=new ReadProp("resource/config.properties");
    }
    @FindBy(id = "itineraryBtn")
    WebElement continueBookingBtn;
    @FindBy(id = "AdultFname1")
    WebElement adultFirstName;
    @FindBy(id = "AdultLname1")
    WebElement adultLastName;
    @FindBy(id = "mobileNumber")
    WebElement mobileNumber;
    @FindBy(id = "AdultTitle1")
    WebElement title;
    @FindBy(id = "username")
    WebElement emailAddress;
    @FindBy(id = "LoginContinueBtn_1")
    WebElement continueBookingEmailBtn;
    @FindBy(id = "AdultDobDay1")
    WebElement dayDob;
    @FindBy(id = "AdultDobMonth1")
    WebElement monthDob;
    @FindBy(id = "AdultDobYear1")
    WebElement yearDob;
    @FindBy(xpath = "//input[@data-idfield=\"adultNationality1\"]")
    WebElement nationality;
    @FindBy(xpath = "//*[@id=\"ui-id-1\"]/li[1]")
    WebElement autoCompleteValueNationality;
    @FindBy(id = "travellerBtn")
    WebElement travellerContinueBtn;
    /**
     * method used to BookTicket
     * @throws InterruptedException
     */
    public void bookTicket() throws InterruptedException {

        new WebDriverWait(driver,20).until(ExpectedConditions.elementToBeClickable(By.id("itineraryBtn")));
        continueBookingBtn.click();
        Thread.sleep(2000);
        emailAddress.sendKeys("abc@gmail.com");
        continueBookingEmailBtn.click();
        new WebDriverWait(driver,20).until(ExpectedConditions.invisibilityOfElementLocated(By.id("LoginContinueBtn_1")));
        Select s=new Select(title);
        s.selectByVisibleText("Mr");
        adultFirstName.sendKeys("John");
        adultLastName.sendKeys("paul");
        mobileNumber.sendKeys("9999999908");
        /*
        Traveller Data entry below
         */
        enterDOB();
        nationality.sendKeys("India");
        new WebDriverWait(driver,20).until(ExpectedConditions.visibilityOf(autoCompleteValueNationality));
        nationality.sendKeys(Keys.ENTER);
        travellerContinueBtn.click();

        new WebDriverWait(driver,20).until(ExpectedConditions.invisibilityOfElementLocated(By.id("travellerBtn")));
    }

    public void enterDOB(){
        Select s=null;
        s=new Select(dayDob);
        s.selectByVisibleText("1");
        s=new Select(monthDob);
        s.selectByVisibleText("Nov");
        s=new Select(yearDob);
        s.selectByVisibleText("1990");
    }


}
