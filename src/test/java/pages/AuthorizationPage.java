package pages;

import common.BasePage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class AuthorizationPage extends BasePage {
    Permission permission = new Permission();

    By signInButton = By.xpath("//XCUIElementTypeButton[@name=\"SIGN IN\"]");
    By signInButton2 = By.xpath("//XCUIElementTypeButton[@label=\"SIGN IN\"]");
    By loginField = By.xpath("//XCUIElementTypeTextField");
    By passwordField = By.xpath("//XCUIElementTypeSecureTextField");
    By profileIcon = By.xpath("//XCUIElementTypeImage[@name=\"ic_tb_profile\"]");

    @Step("Авторизация")
    public void authorization() throws InterruptedException {
        if (getElementsAmount(signInButton) > 0) {
            click(signInButton);
            setText(loginField, data.login);
            setText(passwordField, data.password);
            click(signInButton2);
        }
//        waitElement(By.name("Cancel"));
//        click(By.name("Не сейчас"));
//        click(By.name("Cancel"));
        waitElement(profileIcon);
    }
}
