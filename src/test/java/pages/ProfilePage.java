package pages;

import common.BasePage;
import common.Menu;
import common.BaseElementsPage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Collections;
import java.util.List;
import java.util.Random;

public class ProfilePage extends BasePage {
    Menu menu = new Menu();

    By favorites = By.name("Favorites");
    By business = By.name("Business");
    By events = By.name("Events");
    By groups = By.name("Groups");
    By editProfileBtn = By.name("Edit profile");
    By firstNameField = By.xpath("(//XCUIElementTypeTextField)[1]");
    By lastNameField = By.xpath("(//XCUIElementTypeTextField)[2]");
    By nicknameField = By.xpath("(//XCUIElementTypeTextField)[3]");
    By backBtn = By.name("ic ic back");
    By yesButton = By.name("Yes");
    By dataField = By.xpath("(//XCUIElementTypeTextField[@value])[4]");
    By religionField = By.xpath("//XCUIElementTypeWindow/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeCell[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[10]");
    By genderField = By.xpath("//XCUIElementTypeWindow/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeCell[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[9]");
    By statusField = By.xpath("//XCUIElementTypeWindow/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeCell[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[8]/XCUIElementTypeTextField");
    By ethnicField = By.xpath("//XCUIElementTypeWindow/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeCell[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[11]");
    By heightField = By.xpath("//XCUIElementTypeWindow/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeCell[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[12]");
    By weightField = By.xpath("//XCUIElementTypeWindow/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeCell[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[13]");
    By aboutMeField = By.xpath("//XCUIElementTypeTextView");
    By addPhotoBnt = By.xpath("//XCUIElementTypeButton[@name=\"Add Photo\"]");
    By deletePhotoBnt = By.xpath("//XCUIElementTypeButton[@name=\"icDeleteWhite\"]");
    By phoneCodeField = By.xpath("//XCUIElementTypeStaticText[contains(@name, '+')]");
    By phoneField = By.xpath("(//XCUIElementTypeTextField[@value])[1]");
    By emailField = By.xpath("(//XCUIElementTypeTextField[@value])[2]");
    By countryField = By.xpath("(//XCUIElementTypeTextField[@value])[3]");


    @Step("Open profile")
    public void openProfile() {
        menu.clickProfile();
        waitElement(favorites);
    }

    public void clickBusiness() {
        click(business);
    }

    public void clickEvents() {
        click(events);
    }

    public void clickGroups() {
        click(groups);
    }

    @Step("Редактирование имени пользователя")
    public void editProfileName() {
        click(editProfileBtn);

        String newFirstName = "John" + new Random().nextInt(10000);
        String newLastName = "Doe" + new Random().nextInt(10000);
        String newNickname = "nickname" + new Random().nextInt(99999);

        String fullNameStr = newFirstName + " " + newLastName;

        // Очищаем поля и вводим новые данные
        clearAndSendKeys(firstNameField, newFirstName);
        clearAndSendKeys(lastNameField, newLastName);
        clearAndSendKeys(nicknameField, newNickname);

        // Нажать кнопку Назад
        click(backBtn);

        // Нажимаем на кнопку "Yes"
        click(yesButton);
        waitElement(By.xpath("//XCUIElementTypeStaticText[@name='" + fullNameStr + "']"));
        waitElement(By.xpath("//XCUIElementTypeButton[@name='@" + newNickname + " / 19 years']"));
    }

    private void clearAndSendKeys(By element, String text) {
        WebElement el = driver.findElement(element);
        el.click();
        el.clear();
        el.sendKeys(text);
    }

    public void editProfile() {
        clickElitProfile();
        editProfileName();
        editDate();
        editStatus();
        editGender();
        editReligion();
        editEthnic();
        editHeight();
        editWeight();
        addPhoto();
        aboutMe();
        changePhone();
        emailEdit();
        countryEdit();
        click(backBtn);
        click(yesButton);
        waitASecond();
    }

    public void clickElitProfile() {
        click(editProfileBtn);
    }

    public void editDate() {
        click(dataField);

        // Локатор для всех годов в таблице
        By yearField = By.xpath("(//XCUIElementTypeTable)[1]//XCUIElementTypeStaticText[@name]");
        List<WebElement> yearElements = driver.findElements(yearField);

        if (yearElements.isEmpty()) {
            throw new IllegalStateException("Список годов пуст — элементы не найдены по локатору: " + yearField);
        }
        int randomIndex = new Random().nextInt(yearElements.size());
        WebElement randomYearElement = yearElements.get(randomIndex);
        String yearText = randomYearElement.getText();

        // Кликаем по выбранному году
        randomYearElement.click();
        System.out.println("Выбран год: " + yearText);

        // Локатор для всех месяцев в таблице
        By monthField = By.xpath("(//XCUIElementTypeTable)[2]//XCUIElementTypeStaticText[@name]");
        List<WebElement> monthElements = driver.findElements(monthField);

        if (monthElements.isEmpty()) {
            throw new IllegalStateException("Список месяцев пуст — элементы не найдены по локатору: " + monthField);
        }
        int randomMonthIndex = new Random().nextInt(monthElements.size());
        WebElement randomMonthElement = monthElements.get(randomMonthIndex);
        String monthText = randomMonthElement.getText();

        // Кликаем по выбранному месяцу
        randomMonthElement.click();
        System.out.println("Выбран месяц: " + monthText);

        // Локатор для всех дней в таблице
        By dayField = By.xpath("(//XCUIElementTypeTable)[3]//XCUIElementTypeStaticText[@name]");
        List<WebElement> dayElements = driver.findElements(dayField);

        if (dayElements.isEmpty()) {
            throw new IllegalStateException("Список дней пуст — элементы не найдены по локатору: " + dayField);
        }
        int randomDayIndex = new Random().nextInt(dayElements.size());
        WebElement randomDayElement = dayElements.get(randomDayIndex);
        String dayText = randomDayElement.getText();

        // Кликаем по выбранному дню
        randomDayElement.click();
        System.out.println("Выбран день: " + dayText);

        // Кликаем по кнопке DONE
        By yearFieldDoneBtn = By.xpath("(//XCUIElementTypeButton[@name=\"DONE\"])");
        click(yearFieldDoneBtn);
    }

    public void editStatus() {
        click(statusField);
        By statusOptions = By.xpath("//XCUIElementTypeStaticText[@name]");
        List<WebElement> statusElement = driver.findElements(statusOptions);

        if (statusElement.size() <= 1) {
            throw new IllegalStateException("Нет элементов для выбора");
        }
        // Исключаем первый элемент и выбираем случайный из оставшихся
        List<WebElement> remainingStatusElements = statusElement.subList(1, statusElement.size());

        // Генерируем случайный индекс для оставшихся элементов
        int randomIndex = new Random().nextInt(remainingStatusElements.size());
        WebElement randomStatusElement = remainingStatusElements.get(randomIndex);
        String statusText = randomStatusElement.getText();

        // Клик по выбранному статусу
        randomStatusElement.click();
        System.out.println("Выбран статус: " + statusText);
    }

    public void editGender() {
        click(genderField);
        By genderOptions = By.xpath("//XCUIElementTypeCollectionView/XCUIElementTypeCell");
        List<WebElement> genderElement = driver.findElements(genderOptions);

        if (genderElement.size() <= 1) {
            throw new IllegalStateException("Нет элементов для выбора");
        }
        int randomIndex = new Random().nextInt(genderElement.size());
        WebElement randomGenderElement = genderElement.get(randomIndex);
        String genderText = randomGenderElement.getText();

        randomGenderElement.click();
        System.out.println("Выбран пол: " + genderText);
    }

    public void editReligion() {
        click(religionField);
        By religionOptions = By.xpath("//XCUIElementTypeCollectionView/XCUIElementTypeCell");
        List<WebElement> religionElement = driver.findElements(religionOptions);

        if (religionElement.size() <= 1) {
            throw new IllegalStateException("Нет элементов для выбора");
        }
        int randomIndex = new Random().nextInt(religionElement.size());
        WebElement randomReligionElement = religionElement.get(randomIndex);
        String religionText = randomReligionElement.getText();

        randomReligionElement.click();
        System.out.println("Выбран пол: " + religionText);
    }

    public void editEthnic() {
        click(ethnicField);
        By ethnicOptions = By.xpath("//XCUIElementTypeCollectionView/XCUIElementTypeCell");
        List<WebElement> ethnicElement = driver.findElements(ethnicOptions);

        if (ethnicElement.size() <= 1) {
            throw new IllegalStateException("Нет элементов для выбора");
        }
        int randomIndex = new Random().nextInt(ethnicElement.size());
        WebElement randomEthnicElement = ethnicElement.get(randomIndex);
        String ethnicText = randomEthnicElement.getText();

        randomEthnicElement.click();
        System.out.println("Выбран пол: " + ethnicText);
    }

    public void editHeight() {
        swipeUp();

        click(heightField);

        By heightInputLocator = By.xpath("//XCUIElementTypeTextField[@value]");
        WebElement heightInput = driver.findElement(heightInputLocator);


        click(By.xpath("//XCUIElementTypeKey[@name='Delete']"));
        click(By.xpath("//XCUIElementTypeKey[@name='Delete']"));
        click(By.xpath("//XCUIElementTypeKey[@name='Delete']"));


        List<WebElement> digitKeys = driver.findElements(By.xpath("//XCUIElementTypeKey[not(contains(@name, 'Delete')) and not(contains(@name, ','))]"));

        // Перемешать список
        Collections.shuffle(digitKeys);

        // Нажать на первые три
        for (int i = 0; i < 3 && i < digitKeys.size(); i++) {
            digitKeys.get(i).click();
        }

        // Нажимаем на переключатель
        By switchToggle = By.xpath("(//XCUIElementTypeSwitch[@value])[2]");
        click(switchToggle);

        // Закрываем окно
        By doneButton = By.xpath("//XCUIElementTypeButton[@name=\"DONE\"]");
        click(doneButton);
    }

    public void editWeight () {
        click(weightField);

        By weightInputLocator = By.xpath("//XCUIElementTypeTextField[@value]");
        WebElement weightInput = driver.findElement(weightInputLocator);


        click(By.xpath("//XCUIElementTypeKey[@name='Delete']"));
        click(By.xpath("//XCUIElementTypeKey[@name='Delete']"));
        click(By.xpath("//XCUIElementTypeKey[@name='Delete']"));

        List<WebElement> digitKeys = driver.findElements(By.xpath("//XCUIElementTypeKey[not(contains(@name, 'Delete')) and not(contains(@name, ','))]"));

        // Перемешать список
        Collections.shuffle(digitKeys);

        // Нажать на первые три
        for (int i = 0; i < 2 && i < digitKeys.size(); i++) {
            digitKeys.get(i).click();
        }

        // Нажимаем на переключатель
        By switchToggle = By.xpath("(//XCUIElementTypeSwitch[@value])[2]");
        click(switchToggle);

        // Закрываем окно
        By doneButton = By.xpath("//XCUIElementTypeButton[@name=\"DONE\"]");
        click(doneButton);
    }

    public void addPhoto() {

        if (getElementsAmount(deletePhotoBnt) > 0) {
            click(deletePhotoBnt);
            waitElement(By.xpath("//XCUIElementTypeImage[@name=\"imagePlaceholder\"]"));
        }

        click(addPhotoBnt);
        By photoLibraryBtn = By.xpath("//XCUIElementTypeButton[@name=\"Photo Library\"]");
        click(photoLibraryBtn);
        By choosePhoto = By.xpath("//XCUIElementTypeImage[@name=\"PXGGridLayout-Info\" and @label=\"Фотография, 31 марта 2018 г., 02:14\"]");
        click(choosePhoto);
        By chooseBnt = By.xpath("//XCUIElementTypeButton[@name=\"Done\"]");
        click(chooseBnt);
        try {
            Thread.sleep(3000); // Пауза на 3 секунды
        } catch (InterruptedException e) {
            e.printStackTrace(); // Обработка исключения, если поток был прерван
        }
    }

    // Генерация случайной строки
    public String generateRandomString(int length) {
        String chars = "0123456789";
//      ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz
        Random random = new Random();
        StringBuilder randomString = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(chars.length());
            randomString.append(chars.charAt(randomIndex));
        }

        return randomString.toString();
    }

    public void aboutMe() {

        By textInputLocator = By.xpath("//XCUIElementTypeTextView[@value]");
        WebElement textInput = driver.findElement(textInputLocator);

        textInput.clear();

        String randomString = generateRandomString(15);

        setText(aboutMeField, randomString);
        textInput.click();
    }

    public void waitASecond() {
        try {
            Thread.sleep(3000); // Пауза на 3 секунды
        } catch (InterruptedException e) {
            e.printStackTrace(); // Обработка исключения, если поток был прерван
        }
    }

    public void changePhone () {
        click(phoneCodeField);

        By codeOptions = By.xpath("//XCUIElementTypeCollectionView/XCUIElementTypeCell");
        List<WebElement> codeElement = driver.findElements(codeOptions);

        if (codeElement.size() <= 1) {
            throw new IllegalStateException("Нет элементов для выбора");
        }
        int randomIndex = new Random().nextInt(codeElement.size());
        WebElement randomCodeElement = codeElement.get(randomIndex);
        String codeText = randomCodeElement.getText();

        randomCodeElement.click();
        System.out.println("Выбран пол: " + codeText);

        click(phoneField);

        By phoneInputLocator = By.xpath("(//XCUIElementTypeTextField[@value])[1]");
        WebElement phoneInput = driver.findElement(phoneInputLocator);

        phoneInput.clear();

        String randomString = generateRandomString(10);

        phoneInput.sendKeys(randomString);

    }

    public static String generateRandomEmail() {
        String characters = "abcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();

        // Генерация случайной строки для имени пользователя
        for (int i = 0; i < 10; i++) {
            sb.append(characters.charAt(random.nextInt(characters.length())));
        }

        String userName = sb.toString(); // имя пользователя

        // Генерация случайного домена
        String[] domains = {"gmail.com", "yahoo.com", "outlook.com", "mail.com"};
        String domain = domains[random.nextInt(domains.length)];

        return userName + "@" + domain;
    }

    public void emailEdit () {
        click(emailField);

        By emailInputLocator = By.xpath("(//XCUIElementTypeTextField[@value])[2]");
        WebElement emailInput = driver.findElement(emailInputLocator);

        emailInput.clear();

        String randomEmail = generateRandomEmail();
        System.out.println("Сгенерированный email: " + randomEmail);

        emailInput.sendKeys(randomEmail);

    }

    public void countryEdit() {
        click(countryField);
        By countryOptions = By.xpath("//XCUIElementTypeCollectionView/XCUIElementTypeCell");
        List<WebElement> countryElement = driver.findElements(countryOptions);

        if (countryElement.size() <= 1) {
            throw new IllegalStateException("Нет элементов для выбора");
        }
        int randomIndex = new Random().nextInt(countryElement.size());
        WebElement randomCountryElement = countryElement.get(randomIndex);
        String countryText = randomCountryElement.getText();

        randomCountryElement.click();
        System.out.println("Выбрана страна: " + countryText);
    }
}

