package tests;

import common.BasePage;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class EventsTest extends BasePage {

    @Test(description = "Events lifecycle")
    @Description("Events lifecycle")
    public void eventsLifecycle() {
        profile.openProfile();
        events.createEvents();
    }
}
