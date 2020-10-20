package common;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;


public class CommonMethods {


    /**
     * switch to child window
     * @param driver
     */
    public static void switchToChildWindow(WebDriver driver){
        String currentWindow=driver.getWindowHandle();
        Set<String> s=driver.getWindowHandles();
        Iterator<String> it=s.iterator();
        while (it.hasNext()){
            String strNewWindow=it.next();
            if (strNewWindow!=currentWindow)
                driver.switchTo().window(strNewWindow);
        }
    }

}
