package pages;

import common.BasePage;
import common.Menu;
import common.BaseElementsPage;
import common.TestData;
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
    //By profileFullName = By.xpath("(//XCUIElementTypeCell/XCUIElementTypeButton[contains(@name, 'years')]/preceding-sibling::XCUIElementTypeStaticText[@name]");
    By profileFullName = By.xpath("((//XCUIElementTypeStaticText[@name])[2])");
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
    By yearField = By.xpath("(//XCUIElementTypeTable)[1]//XCUIElementTypeStaticText[@name]");
    By monthField = By.xpath("(//XCUIElementTypeTable)[2]//XCUIElementTypeStaticText[@name]");
    By dayField = By.xpath("(//XCUIElementTypeTable)[3]//XCUIElementTypeStaticText[@name]");
    By yearFieldDoneBtn = By.xpath("(//XCUIElementTypeButton[@name=\"DONE\"])");
    By genderOptions = By.xpath("//XCUIElementTypeCollectionView/XCUIElementTypeCell");
    By religionOptions = By.xpath("//XCUIElementTypeCollectionView/XCUIElementTypeCell");
    By ethnicOptions = By.xpath("//XCUIElementTypeCollectionView/XCUIElementTypeCell");
    By deleteBtn = By.xpath("//XCUIElementTypeKey[@name='Delete']");
    By switchToggle = By.xpath("(//XCUIElementTypeSwitch[@value])[2]");
    By doneButton = By.xpath("//XCUIElementTypeButton[@name=\"DONE\"]");
    By photoLibraryBtn = By.xpath("//XCUIElementTypeButton[@name=\"Photo Library\"]");
    By choosePhoto = By.xpath("//XCUIElementTypeImage[@name=\"PXGGridLayout-Info\" and @label=\"Фотография, 31 марта 2018 г., 02:14\"]");
    By chooseBnt = By.xpath("//XCUIElementTypeButton[@name=\"Done\"]");
    By textInputLocator = By.xpath("//XCUIElementTypeTextView[@value]");
    By codeOptions = By.xpath("//XCUIElementTypeCollectionView/XCUIElementTypeCell");
    By phoneInputLocator = By.xpath("(//XCUIElementTypeTextField[@value])[1]");
    By emailInputLocator = By.xpath("(//XCUIElementTypeTextField[@value])[2]");
    By countryOptions = By.xpath("//XCUIElementTypeCollectionView/XCUIElementTypeCell");
    By keys = By.xpath("//XCUIElementTypeKey[not(contains(@name, 'Delete')) and not(contains(@name, ','))]");
    By noButton = By.name("No");
    //    By fullNameView = By.xpath("(//XCUIElementTypeStaticText)[2]");
    By nicknameView = By.xpath("(//XCUIElementTypeButton)[1]");

    @Step("Open profile")
    public void openProfile() {
        menu.clickProfile();
        waitElement(favorites);
    }

    @Step("Click on Business section")
    public void clickBusiness() {
        click(business);
    }

    @Step("Click on Events section")
    public void clickEvents() {
        click(events);
    }

    @Step("Click on Groups section")
    public void clickGroups() {
        click(groups);
    }

//    public String getFullName() {
//        return profile.getText(profileFullName);
//    }

    public String getFullName() {
        return driver.findElement(profileFullName).getText();
    }

    @Step("Open Profile Editor")
    public void openProfileEditor() {
        click(editProfileBtn);
    }

    @Step("Fill First Name")
    public String fillFirstName() {
        String newFirstName = "John" + new Random().nextInt(10000);
        // Очищаем поле и вводим новые данные
        clearAndSendKeys(firstNameField, newFirstName);
        return newFirstName;
    }

    @Step("Fill Last Name")
    public String fillLastName() {
        String newLastName = "Doe" + new Random().nextInt(10000);
        // Очищаем поле и вводим новые данные
        clearAndSendKeys(lastNameField, newLastName);
        return newLastName;
    }

    @Step("Fill Nickname")
    public String fillNickname() {
        String newNickname = "nickname" + new Random().nextInt(99999);
        // Очищаем поле и вводим новые данные
        clearAndSendKeys(nicknameField, newNickname);
        return newNickname;
    }

    @Step("Edit Profile")
    public void editProfileFields(String newFirstName, String newLastName, String newNickname) {
        String fullNameStr = newFirstName + " " + newLastName;

        // Нажать кнопку Назад
    @Step("Edit user profile name")
    public void editProfileName() {

        String firstName = TestData.getFirstName();
        String lastName = TestData.getLastName();
        String nickname = TestData.getNickname();
        String fullNameStr = firstName + " " + lastName;

        clearAndSendKeys(firstNameField, firstName);
        clearAndSendKeys(lastNameField, lastName);
        clearAndSendKeys(nicknameField, nickname);
        click(backBtn);
        click(yesButton);
        waitElement(By.xpath("//XCUIElementTypeStaticText[@name='" + fullNameStr + "']"));
        waitElement(By.xpath("//XCUIElementTypeButton[contains(@name,@" + nickname + ")]"));
    }

    @Step("Clear field and send keys")
    private void clearAndSendKeys(By element, String text) {
        WebElement el = driver.findElement(element);
        el.click();
        el.clear();
        el.sendKeys(text);
    }

    @Step("Undo Profile")
    public void UndoProfileChanges(String newFirstName, String newLastName, String newNickname) {
        String fullNameStr = newFirstName + " " + newLastName;

        // Нажать кнопку Назад
        click(backBtn);

        // Нажимаем на кнопку "Yes"
        click(noButton);
    }
}

    @Step("Edit full profile information")
    public void editProfile() {
        clickEditProfile();
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
//        changePhone();
        emailEdit();
        countryEdit();
        click(backBtn);
        click(yesButton);
        waitASecond();
    }

    @Step("Click on Edit Profile button")
    public void clickEditProfile() {
        click(editProfileBtn);
    }

    @Step("Edit birth date")
    public void editDate() {
        click(editProfileBtn);
        click(dataField);
        List<WebElement> yearElements = getElements(yearField);

        if (yearElements.isEmpty()) {
            throw new IllegalStateException("Список годов пуст — элементы не найдены по локатору: " + yearField);
        }
        int randomIndex = new Random().nextInt(yearElements.size());
        WebElement randomYearElement = yearElements.get(randomIndex);
        randomYearElement.click();
        List<WebElement> monthElements = getElements(monthField);

        if (monthElements.isEmpty()) {
            throw new IllegalStateException("Список месяцев пуст — элементы не найдены по локатору: " + monthField);
        }
        int randomMonthIndex = new Random().nextInt(monthElements.size());
        WebElement randomMonthElement = monthElements.get(randomMonthIndex);
        randomMonthElement.click();
        List<WebElement> dayElements = getElements(dayField);

        if (dayElements.isEmpty()) {
            throw new IllegalStateException("Список дней пуст — элементы не найдены по локатору: " + dayField);
        }
        int randomDayIndex = new Random().nextInt(dayElements.size());
        WebElement randomDayElement = dayElements.get(randomDayIndex);
        randomDayElement.click();
        click(yearFieldDoneBtn);
    }

    @Step("Edit relationship status")
    public void editStatus() {
        click(statusField);
        By statusOptions = By.xpath("//XCUIElementTypeStaticText[@name]");
        List<WebElement> statusElement = driver.findElements(statusOptions);

        if (statusElement.size() <= 1) {
            throw new IllegalStateException("Нет элементов для выбора");
        }
        // Исключаем первый элемент и выбираем случайный из оставшихся
        List<WebElement> remainingStatusElements = statusElement.subList(1, statusElement.size());
        int randomIndex = new Random().nextInt(remainingStatusElements.size());
        WebElement randomStatusElement = remainingStatusElements.get(randomIndex);
        randomStatusElement.click();
    }

    @Step("Edit gender")
    public void editGender() {
        click(genderField);
        List<WebElement> genderElement = getElements(genderOptions);

        if (genderElement.size() <= 1) {
            throw new IllegalStateException("Нет элементов для выбора");
        }
        int randomIndex = new Random().nextInt(genderElement.size());
        WebElement randomGenderElement = genderElement.get(randomIndex);
        randomGenderElement.click();
    }

    @Step("Edit religion")
    public void editReligion() {
        click(religionField);
        List<WebElement> religionElement = getElements(religionOptions);

        if (religionElement.size() <= 1) {
            throw new IllegalStateException("Нет элементов для выбора");
        }
        int randomIndex = new Random().nextInt(religionElement.size());
        WebElement randomReligionElement = religionElement.get(randomIndex);
        randomReligionElement.click();
    }

    @Step("Edit ethnic")
    public void editEthnic() {
        click(ethnicField);
        List<WebElement> ethnicElement = getElements(ethnicOptions);

        if (ethnicElement.size() <= 1) {
            throw new IllegalStateException("Нет элементов для выбора");
        }
        int randomIndex = new Random().nextInt(ethnicElement.size());
        WebElement randomEthnicElement = ethnicElement.get(randomIndex);
        randomEthnicElement.click();
    }

    @Step("Edit height")
    public void editHeight() {
        swipeUp();
        click(heightField);
        click(deleteBtn);
        click(deleteBtn);
        click(deleteBtn);
        List<WebElement> digitKeys = getElements(keys);
        Collections.shuffle(digitKeys);

        for (int i = 0; i < 3 && i < digitKeys.size(); i++) {
            digitKeys.get(i).click();
        }
        click(switchToggle);
        click(doneButton);
    }

    @Step("Edit weight")
    public void editWeight() {
        click(weightField);
        click(deleteBtn);
        click(deleteBtn);
        click(deleteBtn);
        List<WebElement> digitKeys = getElements(keys);
        Collections.shuffle(digitKeys);

        // Нажать на первые три
        for (int i = 0; i < 2 && i < digitKeys.size(); i++) {
            digitKeys.get(i).click();
        }

        click(switchToggle);
        click(doneButton);
    }

    @Step("Add profile photo")
    public void addPhoto() {

        if (getElementsAmount(deletePhotoBnt) > 0) {
            click(deletePhotoBnt);
        }

        click(addPhotoBnt);
        click(photoLibraryBtn);
        click(choosePhoto);
        click(chooseBnt);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Step("Edit 'About me' section")
    public void aboutMe() {
        WebElement textInput = driver.findElement(textInputLocator);
        textInput.clear();
        String randomString = TestData.getRandomNumber(15);

        setText(aboutMeField, randomString);
        textInput.click();
    }

    public void waitASecond() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

//    @Step("Change phone number")
//    public void changePhone () {
//        click(phoneCodeField);
//        List<WebElement> codeElement = getElements(codeOptions);
//
//        if (codeElement.size() <= 1) {
//            throw new IllegalStateException("Нет элементов для выбора");
//        }
//        int randomIndex = new Random().nextInt(codeElement.size());
//        WebElement randomCodeElement = codeElement.get(randomIndex);
//        randomCodeElement.click();
//        click(phoneField);
//        WebElement phoneInput = driver.findElement(phoneInputLocator);
//        phoneInput.clear();
//        String randomString = TestData.getRandomNumber(7);
//        phoneInput.sendKeys(randomString);
//    }

    @Step("Edit email")
    public void emailEdit () {
        click(emailField);
        WebElement emailInput = driver.findElement(emailInputLocator);
        emailInput.clear();
        String randomEmail = TestData.generateRandomEmail();
        emailInput.sendKeys(randomEmail);
    }

    @Step("Edit country")
    public void countryEdit() {
        click(countryField);
        List<WebElement> countryElement = getElements(countryOptions);

        if (countryElement.size() <= 1) {
            throw new IllegalStateException("Нет элементов для выбора");
        }
        int randomIndex = new Random().nextInt(countryElement.size());
        WebElement randomCountryElement = countryElement.get(randomIndex);
        randomCountryElement.click();
    }
}