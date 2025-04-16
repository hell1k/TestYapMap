package pages;

import common.BasePage;
import common.Menu;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

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

    public class ProfileEditing {

        public void editProfile() {
            // Редактирование даты
            editDate();
            String gender = editProfileData("Gender");
            checkDataName(gender);
            String status = editProfileData("Status");
            checkDataName(status);
            String orientation = editProfileData("Sexual orientation");
            checkDataName(orientation);
            String religion = editProfileData("Religion");
            checkDataName(religion);

            String ethnos = editProfileData("Ethnos");
            checkDataName(ethnos);


            String height = String.valueOf(150 + new Random().nextInt(50));
            String weight = String.valueOf(50 + new Random().nextInt(50));

            editHeight(height);
            editWeight(weight);

            profile.click(backBtn);

            // Возвращение всех значений
            return new String[]{gender, status, orientation, religion, ethnos, height, weight};
        }

//        private void editDate() {
//            profile.click(dataField);
//            int randomDate = 1 + new Random().nextInt(28);
//            String dateXpath = "//*[@text='" + randomDate + "']";
//            click(By.xpath(dateXpath), "дата " + randomDate);
//            click(dateOk, "кнопка Ок");
//        }
    }
}

