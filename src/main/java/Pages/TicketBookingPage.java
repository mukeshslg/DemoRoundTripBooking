package Pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
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





}
