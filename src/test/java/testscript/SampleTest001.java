package testscript;

import Pages.TestBase;
import org.testng.annotations.Test;

public class SampleTest001 extends TestBase {

    /**
     * This test will login to clearTrip website and perform ticket booking
     *
     * @throws InterruptedException
     */
    @Test
    public void TestFaceBookAndPost() throws InterruptedException {
        //loginPage.loadCT();
        searchPage.searchFlight("bangalore","chennai");


    }
}
