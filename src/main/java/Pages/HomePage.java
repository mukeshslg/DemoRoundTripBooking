package Pages;

import common.CommonMethods;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.ReadProp;

public class HomePage {
    WebDriver driver;
    ReadProp rp;
    public static Logger log = Logger.getLogger(HomePage.class);

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        rp=new ReadProp("resource/config.properties");
    }
    @FindBy(xpath = "//textarea[@name='xhpc_message']")
    WebElement postTextArea;



    /**
     * method is used to enters text by using name locator
     * @param txt
     */
    public void sendTextById(String txt) throws InterruptedException {
        CommonMethods.clickLinkByXpath(driver,"//a[text()='Home']");
        Thread.sleep(2000);
        postTextArea.sendKeys(txt);
        Thread.sleep(3000);
    }

}
