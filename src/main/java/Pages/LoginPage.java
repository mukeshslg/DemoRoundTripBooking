package Pages;


import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.ReadProp;

public class LoginPage {
    WebDriver driver;
    ReadProp rp;
    public static Logger log = Logger.getLogger(LoginPage.class);

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
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
        userName.sendKeys(rp.getProperty("username"));
        password.sendKeys(rp.getProperty("password"));
        loginBtn.click();
    }

}
