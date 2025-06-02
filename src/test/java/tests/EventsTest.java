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
        events.createEvents(true);
        events.eventCheckingElement();
    }

    @Test(description = "Взаимодействие с эвентом другого пользователя")
    public void testEventWithOtherUser() throws InterruptedException {
        profile.openProfile();
        String eventName = events.createEvents(false);
        clickBack();
        profile.logout();
        auth.authorization(data.login2);
        search.selectEvents();
        search.searchValue(eventName);
        swipeUp();
        click(elementName(eventName));
        events.addToFavorite();
        events.joinEvent();
        events.checkingTreeDots();
        events.reportForReview();
        events.leaveEvent();
        waitElementName(eventName);
        click(elementName(eventName));
        events.clickTreeDots();
        waitElementName("Join");
    }
}
