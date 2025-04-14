package pages;

import common.BasePage;
import org.openqa.selenium.By;

public class EventsPage extends BasePage {
    ProfilePage profile = new ProfilePage();

    By addButton = By.name("Add");
    By nameEvent = By.xpath("//XCUIElementTypeTextField");
    By description = By.xpath("//XCUIElementTypeTextView");
    By uploadPhoto = By.name("ic ic link");

    public void createEvents() {
        profile.clickEvents();
        click(addButton);
        waitElementName("New Event");
        click(uploadPhoto);
        click(elementName("Photo Library"));
        click(elementName("PXGGridLayout-Info"));
        click(elementName("Choose"));


        setText(nameEvent, "New event_" + getRandomNumber(999999));
        setText(description, "description");
        System.out.println();
    }
}
