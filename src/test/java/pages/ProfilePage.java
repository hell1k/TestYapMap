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

    @Step("Edit Profile")
    public void editProfileFields() {
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
}
