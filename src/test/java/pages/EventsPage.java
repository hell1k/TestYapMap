package pages;

import common.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.LocalDate;
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
    By dayOptions = By.xpath("(//XCUIElementTypePickerWheel)[1]");
    By monthOptions = By.xpath("(//XCUIElementTypePickerWheel)[2]");
    By yearOptions = By.xpath("(//XCUIElementTypePickerWheel)[3]");
    By startDateBtn = By.xpath("((//XCUIElementTypeCollectionView)[1]/XCUIElementTypeCell[2]//XCUIElementTypeTextField)[1]");
    By dateToolbar = By.xpath("//XCUIElementTypeToolbar[@name=\"Toolbar\"]");
    By endDateBtn = By.xpath("((//XCUIElementTypeCollectionView)[1]/XCUIElementTypeCell[2]//XCUIElementTypeTextField)[3]");
    By mapIconBtn = By.name("mapIcon");
    By locationBtn = By.xpath("//XCUIElementTypeApplication[@name=\"Relagram\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeCell[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[4]/XCUIElementTypeTextField");
    By favoriteBtn = By.name("ic not favorited");
    By treeDotsBtn = By.name("treeDots");
    By saveBtn = By.name("Save");
    By numberOfMembersBtn = By.xpath("//XCUIElementTypeWindow/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeCell[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeTextField");
    By privateBtn = By.xpath("(//XCUIElementTypeSwitch[@value])[1]");
    By pinChatBtn = By.xpath("(//XCUIElementTypeSwitch[@value])[2]");
    By showMeToThisCommunityBtn = By.xpath("(//XCUIElementTypeSwitch[@value])[4]");
    By showMyExactLocationBtn = By.xpath("(//XCUIElementTypeSwitch[@value])[5]");
    By deleteAndLeaveBtn = By.xpath("//XCUIElementTypeButton[@name=\"Delete and Leave\"]");
    By deletePhotoBtn = By.xpath("//XCUIElementTypeButton[@name=\"icDeleteWhite\"]");
    By addToFavoriteBtn = By.xpath("//XCUIElementTypeButton[@name=\"ic not favorited\"]");
    By treeDots = By.xpath("//XCUIElementTypeButton[@name=\"treeDots\"]");
    By closeShareBtn = By.name("header.closeButton");
    By closeQrCodeBtn = By.xpath("//XCUIElementTypeButton[@name=\"ic close primary\"]");
    By leaveBtn = By.xpath("(//XCUIElementTypeButton[@name=\"Leave\"])[2]");

    @Step("Создание ноого События")
    public String createEvents(boolean isPrivate) throws InterruptedException {
        profile.clickEvents();
        click(addButton);
        waitElementName("New Event");
        addPhoto(uploadPhoto);
        click(elementName("Done"));
        String eventName = "New event_" + getRandomNumber(999999);
        setText(nameEvent, eventName);
        setText(description, "description");
        chooseEventType();
        addPhoto(addPhotoBtn);
        click(elementName("Done"));
        waitElement(deletePhotoBtn);
        waitASecond();
        swipeUp();
        click(startDateBtn);
        waitElement(dateToolbar);
        LocalDate startDate = chooseStartDate();
        click(elementName("Done"));
        click(endDateBtn);
        waitElement(dateToolbar);
        chooseEndDate(startDate);
        click(elementName("Done"));
        chooseLocation();
        chooseNumberMembers();
        if (isPrivate) {
            click(privateBtn);
        }
        click(pinChatBtn);
        click(showMeToThisCommunityBtn);
        click(showMyExactLocationBtn);
        click(createBtn);
        click(elementName("Yes"));
        waitElementName(eventName);
        waitElementName("There are no messages in this chat.");
        return eventName;
    }

    @Step("Проверка меню Event (троеточие)")
    public void eventCheckingElement() throws InterruptedException {
        String eventName = createEvents(true);
        click(elementName(eventName));
        clearAndSendKeys(nameEvent, "New event_" + getRandomNumber(999999));
        click(favoriteBtn);
        checkingMenu();
    }

    @Step("Проверка меню группы (троеточие)")
    public void checkingMenu() throws InterruptedException {
        click(treeDotsBtn, "меню группы (троеточие)");
        clickButton("Share");
        click(elementName("header.closeButton"));
        click(treeDotsBtn, "меню группы (троеточие)");
        click(elementName("Generate QR code"));
        waitElementName("Share QR code");
        click(elementName("ic close primary"));
        click(treeDotsBtn, "меню группы (троеточие)");
        clickButton("Share to Relagram");
        waitElementName("Groups");
        waitElement(button("Share"), "кнопка Share");
        clickButton("Event");
        waitASecond();
        click(treeDotsBtn, "меню группы (троеточие)");
        inviteNewMembers();
        click(treeDotsBtn, "меню группы (троеточие)");
        inviteNewAdmin();
        swipeUp();
        swipeUp();
        swipeUp();
        swipeUp();
        click(deleteAndLeaveBtn);
        click(elementName("Delete"));
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
        waitElement(photoOptions);
        List<WebElement> eventType = getElements(photoOptions);
        if (eventType.size() <= 1) {
            throw new IllegalStateException("Нет элементов для выбора");
        }
        int randomIndex = new Random().nextInt(eventType.size());
        WebElement randomGenderElement = eventType.get(randomIndex);
        randomGenderElement.click();
        wait(2);
    }

    @Step("Выбор времени Начала события")
    public LocalDate chooseStartDate() {
        LocalDate today = LocalDate.now();
        Random rand = new Random();

        String[] years = {"2025"};
        String[] months = {"January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"};

        int selectedYear;
        int selectedMonth;
        int selectedDay;

        while (true) {
            selectedYear = Integer.parseInt(years[rand.nextInt(years.length)]);
            selectedMonth = getRandomNumber(1, 12);
            selectedDay =  getRandomNumber(1, 28);

            LocalDate candidate = LocalDate.of(selectedYear, selectedMonth, selectedDay);
            if (!candidate.isBefore(today)) {
                // Выбираем дату в пикере
                getElements(yearOptions).get(0).sendKeys(String.valueOf(selectedYear));
                getElements(monthOptions).get(0).sendKeys(months[selectedMonth - 1]);
                getElements(dayOptions).get(0).sendKeys(String.valueOf(selectedDay));
                return candidate;
            }
        }
    }

    @Step("Выбор времени Окончания события")
    public void chooseEndDate(LocalDate startDate) {
        LocalDate maxEndDate = startDate.plusYears(1);
        Random rand = new Random();

        String[] months = {"January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"};

        while (true) {
            int year = rand.nextInt(maxEndDate.getYear() - startDate.getYear() + 1) + startDate.getYear();
            int month = getRandomNumber(1, 12);
            int daysInMonth = LocalDate.of(year, month, 1).lengthOfMonth();
            int day = rand.nextInt(daysInMonth) + 1;
            LocalDate candidate = LocalDate.of(year, month, day);

            if (!candidate.isBefore(startDate) && !candidate.isAfter(maxEndDate)) {
                getElements(yearOptions).get(0).sendKeys(String.valueOf(year));
                getElements(monthOptions).get(0).sendKeys(months[month - 1]);
                getElements(dayOptions).get(0).sendKeys(String.valueOf(day));
                break;
            }
        }
    }

    @Step("Выбор локации")
    public void chooseLocation() {
        clearAndSendKeys(locationBtn, "Novosibirsk");
        setText(locationBtn, " ");
        click(mapIconBtn);
        click(saveBtn);
    }

    @Step("Выбор колличества участников")
    public void chooseNumberMembers() {
        clearAndSendKeys(numberOfMembersBtn, String.valueOf(getRandomNumber(1, 10)));
    }

    @Step("Добавление в избранное Event")
    public void addToFavorite() {
        click(addToFavoriteBtn);
    }

    @Step("Проверка опций Event")
    public void checkingTreeDots() throws InterruptedException {
        clickTreeDots();
        clickButton("Share");
        waitElementContainsName("See this event on Relagram https://relagram.com/share");
        click(closeShareBtn);
        waitASecond();
        waitASecond();
        clickTreeDots();
        clickButton("Share to Relagram");
        waitElementName("Groups");
        waitElement(button("Share"), "кнопка Share");
        clickButton("Event");
        waitASecond();
        clickTreeDots();
        clickButton("Generate QR code");
        waitElementName("Share QR code");
        click(closeQrCodeBtn, "кнопка закрытия QR кода");
        waitASecond();
        clickTreeDots();
        clickButton("Send message");
        waitElementName("Type a message");
        waitElementName("icSendOn");
        clickButton("Event");
        waitElementName("Event");
    }

    @Step("Добавление рандомного участника")
    public void inviteNewMembers() {
        clickButton("Invite new members");
        waitElementName("Select contacts");
        waitElementName("checkbox delselected");
        clickRandomElement(elementName("checkbox delselected"));
        waitElement(By.xpath("//XCUIElementTypeButton[@name=\"checkbox delselected\" and @value=\"1\"]"));
        clickButton("Send");
        waitElementName("Invitation sent");
        clickButton("OK");
        waitElementName("Event");
    }

    @Step("Добавление рандомного админа")
    public void inviteNewAdmin() {
        clickButton("Invite new admins");
        waitElementName("Select contacts");
        waitElementName("checkbox delselected");
        clickRandomElement(elementName("checkbox delselected"));
        waitElement(By.xpath("//XCUIElementTypeButton[@name=\"checkbox delselected\" and @value=\"1\"]"));
        clickButton("Send");
        waitElementName("Invitation sent");
        clickButton("OK");
        waitElementName("Event");
    }

    @Step("Join the event")
    public void joinEvent() throws InterruptedException {
        waitASecond();
        clickTreeDots();
        clickButton("Join");
        waitElementName("Congrats! You’re the member of event now!");
        clickButton("Ok");
    }

    @Step("Leave the event")
    public void leaveEvent() {
        clickButton("Leave");
        waitElementName("Leave? All data will be lost!");
        click(leaveBtn);
    }

    @Step("Report for review")
    public void reportForReview() throws InterruptedException {
        swipeUp();
        swipeUp();
        swipeUp();
        clickButton("Report for review");
        waitElementName("Choose the reason");
        clickButton("Cancel");
        waitASecond();
    }

    @Step("Клик по кнопке")
    public void clickTreeDots() {
        click(treeDots, "меню мероприятия (троеточие)");
    }

}


