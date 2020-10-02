package Pages;


import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.ReadProp;

public class LoginPage {
    WebDriver driver;
    ReadProp rp;
    public static Logger log = Logger.getLogger(LoginPage.class);
    private String FB_userName;
    private String FB_password;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        rp=new ReadProp("resource/config.properties");
        FB_userName=rp.getProperty("username");
        FB_password=rp.getProperty("password");
    }
    @FindBy(id = "email")
    WebElement userName;
    @FindBy(id = "pass")
    WebElement password;
    @FindBy(name = "login")
    WebElement loginBtn;

    /**
     * @author Mukesh
     */
    public void loginToFB(){
        userName.sendKeys(FB_userName);
        password.sendKeys(FB_password);
        loginBtn.click();
        new WebDriverWait(driver,20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Mukesh Sah']")));
    }

}
