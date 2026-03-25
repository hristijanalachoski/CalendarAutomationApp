package tests;

import data.CalendarTestData;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import util.DriverSetup;

@Epic("Calendar app")
@Feature("New event")
public class CalendarTest extends DriverSetup {

    @Severity(SeverityLevel.CRITICAL)
    @Description("Create new event test functionality")
    @Test(testName = "Calendar test", dataProviderClass = CalendarTestData.class, dataProvider = "calendarData")
    public void calendarTest(String timeSlot, String title) {

        Assert.assertTrue(calendarHomeScreen.calendarHomeScreenLoaded(), "Calendar home screen is not loaded");

        calendarHomeScreen.createEventOnTimeslot(timeSlot);
        Assert.assertTrue(newEventScreen.newEventScreenLoaded(), "New event screen is not loaded");

        newEventScreen.enterEventTitle(title);
    }
}
