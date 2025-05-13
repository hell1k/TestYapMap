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
    By startDateBtn = By.xpath("//XCUIElementTypeApplication[@name=\"Relagram\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeCell[4]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeTextField");
    By endDateBtn = By.xpath("//XCUIElementTypeApplication[@name=\"Relagram\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeCell[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[1]/XCUIElementTypeTextField");
    By liveEventBtn = By.name("Live event");
    By onlineEventBtn = By.name("Online event");
    By mapIconBtn = By.name("mapIcon");
    By saveBtn = By.name("Save");
    By numberOfMembersBtn = By.xpath("//XCUIElementTypeWindow/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeCell[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeTextField");
    By privateBtn = By.xpath("(//XCUIElementTypeSwitch[@value])[1]");
    By pinChatBtn = By.xpath("(//XCUIElementTypeSwitch[@value])[2]");
    By showItBtn = By.xpath("(//XCUIElementTypeSwitch[@value])[3]");
    By showMeToThisCommunityBtn = By.xpath("(//XCUIElementTypeSwitch[@value])[4]");
    By showMyExactLocationBtn = By.xpath("(//XCUIElementTypeSwitch[@value])[5]");

    public void createPrivateEvents() throws InterruptedException {
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
        click(startDateBtn);
        LocalDate startDate = chooseStartDate();
        click(elementName("Done"));
        click(endDateBtn);
        chooseEndDate(startDate);
        click(elementName("Done"));
        chooseLocation();
        chooseNumberMembers();
        click(privateBtn);
        click(pinChatBtn);
        click(showMeToThisCommunityBtn);
        click(showMyExactLocationBtn);
        click(createBtn);
        click(elementName("Yes"));
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

//    public void chooseDate() {
//
//        LocalDate today = LocalDate.now();
//        Random rand = new Random();
//
//        // Подходящие годы из массива
//        String[] years = {"2029", "2028", "2027", "2026", "2025", "2030"};
//        String[] values = {"January", "February", "March", "April", "May", "June",
//                "July", "August", "September", "October", "November", "December"};
//
//
//        // Получаем текущий год, месяц и день
//        int currentYear = today.getYear();
//        int currentMonth = today.getMonthValue();
//        int currentDay = today.getDayOfMonth();
//
//        String selectedYear;
//        do {
//            selectedYear = years[rand.nextInt(years.length)];
//        } while (Integer.parseInt(selectedYear) < currentYear);
//
//        String selectedMonth;
//        int monthIndex;
//        do {
//            monthIndex = rand.nextInt(values.length); // 0–11
//            selectedMonth = values[monthIndex];
//        } while (Integer.parseInt(selectedYear) == currentYear && monthIndex + 1 < currentMonth);
//
//        int selectedDay;
//        do {
//            selectedDay = rand.nextInt(28) + 1;
//        } while (Integer.parseInt(selectedYear) == currentYear &&
//                monthIndex + 1 == currentMonth &&
//                selectedDay < currentDay);
//
//        // Подставляем в элементы
//        List<WebElement> yearType = getElements(yearOptions);
//        yearType.get(0).sendKeys(selectedYear);
//
//        List<WebElement> monthType = getElements(monthOptions);
//        monthType.get(0).sendKeys(selectedMonth);
//
//        List<WebElement> dayType = getElements(dayOptions);
//        dayType.get(0).sendKeys(String.valueOf(selectedDay));
//    }

    public LocalDate chooseStartDate() {
        LocalDate today = LocalDate.now();
        Random rand = new Random();

        String[] years = {"2025", "2026", "2027", "2028", "2029", "2030"};
        String[] months = {"January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"};

        int selectedYear;
        int selectedMonth;
        int selectedDay;

        while (true) {
            selectedYear = Integer.parseInt(years[rand.nextInt(years.length)]);
            selectedMonth = rand.nextInt(12) + 1;
            selectedDay = rand.nextInt(28) + 1;

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

    public void chooseEndDate(LocalDate startDate) {
        LocalDate maxEndDate = startDate.plusYears(1);
        Random rand = new Random();

        String[] months = {"January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"};

        while (true) {
            // Генерируем случайный год и месяц
            int year = rand.nextInt(maxEndDate.getYear() - startDate.getYear() + 1) + startDate.getYear();
            int month = rand.nextInt(12) + 1;

            // Определяем количество дней в выбранном месяце
            int daysInMonth = LocalDate.of(year, month, 1).lengthOfMonth();

            // Генерируем случайный день в пределах допустимых дней
            int day = rand.nextInt(daysInMonth) + 1;

            // Создаем кандидата на дату окончания
            LocalDate candidate = LocalDate.of(year, month, day);

            // Проверка: дата не раньше даты начала и не позже максимальной даты
            if (!candidate.isBefore(startDate) && !candidate.isAfter(maxEndDate)) {
                getElements(yearOptions).get(0).sendKeys(String.valueOf(year));
                getElements(monthOptions).get(0).sendKeys(months[month - 1]);
                getElements(dayOptions).get(0).sendKeys(String.valueOf(day));
                break;
            }
        }
    }

    public void chooseLocation() {
        click(mapIconBtn);
        click(saveBtn);
    }

    public void chooseNumberMembers() {
        clearAndSendKeys(numberOfMembersBtn, "5");
    }
}


