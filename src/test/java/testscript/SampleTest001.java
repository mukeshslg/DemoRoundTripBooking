package testscript;

import Pages.TestBase;
import common.CommonMethods;
import org.testng.annotations.Test;

public class SampleTest001 extends TestBase {

    /**
     * This test will login to clearTrip website and perform ticket booking
     *
     * @throws InterruptedException
     */
    @Test
    public void TestClearTripAndBookTicket() throws InterruptedException {
        searchPage.searchFlight("bangalore","chennai");
        searchPage.bookFlightTicketAndSwitchToNewWindow();
        ticketBookingPage.bookTicket();


        //below wait just to see UI.
        Thread.sleep(5000);
    }

}
