package pages;

import common.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.Random;

public class EventsPage extends BasePage {
    ProfilePage profile = new ProfilePage();

    By addButton = By.name("Add");
    By nameEvent = By.xpath("//XCUIElementTypeTextField");
    By description = By.xpath("//XCUIElementTypeTextView");
    By uploadPhoto = By.name("ic ic link");
    By createBtn = By.name("Create");
    By eventTypeBtn = By.xpath("//XCUIElementTypeApplication[@name=\"Relagram\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeCell[1]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeButton");
    By eventTypeOptions = By.xpath("//XCUIElementTypeCollectionView/XCUIElementTypeCell/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]");
    By addPhotoBtn = By.name("Add Photo");
    By photoOptions = By.xpath("//XCUIElementTypeImage[@name and contains(@label, \"Фотография\")]");
    By startDateBtn = By.name("");
    By endDateBtn = By.name("");
    By timeBtn = By.name("");
    By liveEventBtn = By.name("");
    By onlineEventBtn = By.name("");
    By whereBtn = By.name("");
    By mapIconBtn = By.name("mapIcon");
    By saveBtn = By.name("Save");
    By numberOfMembersBtn = By.name("");
    By privateBtn = By.name("");
    By pinChatBtn = By.name("");
    By backgroundBtn = By.name("");
    By backgroundPhoto = By.xpath("//XCUIElementTypeCollectionView/XCUIElementTypeCell[9]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeImage");
    By showItBtn = By.name("");
    By showMeToThisCommunityBtn = By.name("");
    By showMyExactLocationBtn = By.name("");

    public void createEvents() throws InterruptedException {
        profile.clickEvents();
        click(addButton);
        waitElementName("New Event");
        addPhoto(uploadPhoto);
        click(elementName("Done"));

        setText(nameEvent, "New event_" + getRandomNumber(999999));
        setText(description, "description");

        chooseEventType();
        addPhoto(addPhotoBtn);
        click(elementName("Done"));
        wait(2);
    }

    @Step("Выбор типа события")
    public void chooseEventType() throws InterruptedException {
        click(eventTypeBtn, "нажатие на кнопку Event type");
        List<WebElement> eventType = getElements(eventTypeOptions);
        wait(2);
        if (eventType.size() <= 1) {
            throw new IllegalStateException("Нет элементов для выбора");
        }
        int randomIndex = new Random().nextInt(eventType.size());
        WebElement randomGenderElement = eventType.get(randomIndex);
        randomGenderElement.click();
        }

        public void addPhoto(By locator) throws InterruptedException {
            click(locator);
            click(elementName("Photo Library"));
            wait(2);
            List<WebElement> eventType = getElements(photoOptions);
            if (eventType.size() <= 1) {
                throw new IllegalStateException("Нет элементов для выбора");
            }
            int randomIndex = new Random().nextInt(eventType.size());
            WebElement randomGenderElement = eventType.get(randomIndex);
            randomGenderElement.click();
            wait(2);
        }
    }
