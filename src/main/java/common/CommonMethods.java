package common;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonMethods {
    /**
     * click element by xpath
     * @param dr
     * @param xpathXpression
     * @author Mukesh
     */
    public static void clickLinkByXpath(WebDriver dr,String xpathXpression){
        WebElement element=new WebDriverWait(dr,20).until(ExpectedConditions.elementToBeClickable(By.xpath(xpathXpression)));
        element.sendKeys(Keys.ESCAPE);
        element.click();
    }

    /**
     * click element by xpath
     * @param dr
     * @param xpathXpression
     */
    public static void clickElementByXpath(WebDriver dr, String xpathXpression){
        WebElement elePostBtn=new WebDriverWait(dr,20)
                .until(ExpectedConditions.elementToBeClickable(By.xpath(xpathXpression)));
        elePostBtn.click();
    }

}
