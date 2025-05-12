package tests;

import common.BasePage;
import io.qameta.allure.Description;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Collections;

public class EventsTest extends BasePage {

    @Test(description = "Events lifecycle")
    @Description("Events lifecycle")
    public void eventsLifecycle() throws InterruptedException {
        profile.openProfile();
        events.createEvents();

    }
}
