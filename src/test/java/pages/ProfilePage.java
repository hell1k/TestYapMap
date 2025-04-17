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
    //By profileFullName = By.xpath("(//XCUIElementTypeCell/XCUIElementTypeButton[contains(@name, 'years')]/preceding-sibling::XCUIElementTypeStaticText[@name]");
    By profileFullName = By.xpath("((//XCUIElementTypeStaticText[@name])[2])");
    By backBtn = By.name("ic ic back");
    By yesButton = By.name("Yes");
    By noButton = By.name("No");
    //    By fullNameView = By.xpath("(//XCUIElementTypeStaticText)[2]");
    By nicknameView = By.xpath("(//XCUIElementTypeButton)[1]");

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
        click(backBtn);

        // Нажимаем на кнопку "Yes"
        click(yesButton);
        waitElement(By.xpath("//XCUIElementTypeStaticText[@name='" + fullNameStr + "']"));
        waitElement(By.xpath("(//XCUIElementTypeButton)[1]"));

        //Проверяем, что данные были обновлены
//        assert getText(fullNameView).equals(fullNameStr) : "Full Name не совпадает";
//        assert getText(lastNameView).equals(newLastName) : "Last name не совпадает";
//        assert getText(nicknameView).equals(newNickname) : "Nickname не совпадает";
    }

    private void clearAndSendKeys(By element, String text) {
        WebElement el = driver.findElement(element);
        el.click();
        el.clear(); // полностью очищает поле
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
