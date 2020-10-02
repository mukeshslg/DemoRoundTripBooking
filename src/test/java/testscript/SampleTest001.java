package testscript;

import Pages.TestBase;
import common.CommonMethods;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SampleTest001 extends TestBase {

    /**
     * This test will login to FB and post text
     *
     * @throws InterruptedException
     */
    @Test
    public void TestFaceBookAndPost() throws InterruptedException {
        loginPage.loginToFB();
        CommonMethods.clickLinkByXpath(driver, "//a[text()='Home']");
        Thread.sleep(1500);
        homePage.sendTextById("Helllo World!!!");
        CommonMethods.clickElementByXpath(driver, "//span[text()='Post']");
        Boolean isPostSuccess = driver.findElement(By.xpath("//span[text()='Just now']")).isDisplayed();
        Assert.assertTrue(isPostSuccess, "verifying facebook post is successfull");

        Thread.sleep(10000);//waiting 10 sec to see the post

    }
}
