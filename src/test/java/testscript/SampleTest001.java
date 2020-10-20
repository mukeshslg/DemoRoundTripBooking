package testscript;

import Pages.TestBase;
import common.CommonMethods;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SampleTest001 extends TestBase {

    /**
     * This test will login to clearTrip website and perform ticket booking
     *
     * @throws InterruptedException
     */
    @Test
    public void TestFaceBookAndPost() throws InterruptedException {
        loginPage.loginToCT();


    }
}
