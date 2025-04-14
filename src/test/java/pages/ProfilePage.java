package pages;

import common.BasePage;
import common.Menu;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.util.Random;

public class ProfilePage extends BasePage {
    Menu menu = new Menu();

    By favorites = By.name("Favorites");
    By business = By.name("Business");
    By events = By.name("Events");
    By groups = By.name("Groups");
    By editProfileBtn = By.name("Edit profile");
    By firstNameField = By.xpath("//XCUIElementTypeCell/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]");
    By lastNameField = By.xpath("//XCUIElementTypeCell/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[3]");
    By nicknameField = By.xpath("//XCUIElementTypeCell/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[4]");
    By backBtn = By.name("ic ic back");
    By yesButton = By.name("Yes");
    By firstNameView = By.name("hatr");
    By lastNameView = By.name("awou");
    By nicknameView = By.name("@hatrawou ");

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

    @Step("Редактирование профиля")
    public void editProfileFields() {
        // Перед редактированием профиля проверяем, что пользователь авторизован
        openProfile();

        String newFirstName = "John" + new Random().nextInt(10000);
        String newLastName = "Doe" + new Random().nextInt(10000);
        String newNickname = "nickname" + new Random().nextInt(99999);

        // Ожидаем, что иконка редактирования будет доступна и кликаем на неё
        click(backBtn);

        // Очищаем поля и вводим новые данные
        clearAndSendKeys(firstNameField, newFirstName);
        clearAndSendKeys(lastNameField, newLastName);
        clearAndSendKeys(nicknameField, newNickname);

        // Нажимаем на кнопку "Сохранить"
        click(yesButton);

//Проверяем, что данные были обновлены
        assert getText(firstNameView).equals(newFirstName) : "First name не совпадает";
        assert getText(lastNameView).equals(newLastName) : "Last name не совпадает";
        assert getText(nicknameView).equals("@" + newNickname) : "Nickname не совпадает";
    }

    // Вспомогательный метод для очистки и ввода текста в поле
    private void clearAndSendKeys(By element, String text) {
        driver.findElement(element).clear();
        driver.findElement(element).sendKeys(text);
    }
}
