package pages;

import common.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AuthorizationPage extends BasePage {
    Permission permission = new Permission();

    By signInButton = By.xpath("//XCUIElementTypeButton[@name=\"SIGN IN\"]");
    By signInButton2 = By.xpath("//XCUIElementTypeButton[@label=\"SIGN IN\"]");
    By loginField = By.xpath("//XCUIElementTypeTextField");
    By passwordField = By.xpath("//XCUIElementTypeSecureTextField");
    By profileIcon = By.xpath("//XCUIElementTypeImage[@name=\"ic_tb_profile\"]");
    By emailField = By.xpath("(//XCUIElementTypeTextField)[1]");
    By regPasswordField = By.xpath("(//XCUIElementTypeSecureTextField)[1]");
    By regConfirmPasswordField = By.xpath("(//XCUIElementTypeSecureTextField)[2]");
    By privacyPolicyCheckbox = By.xpath("//XCUIElementTypeSwitch[@value=\"0\"]");

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

    @Step("Регистрация нового пользователя")
    public void registration() {
        clickButton("SIGN UP");
        //step 1
        waitElementName("New Account");
        String mail = "test" + getRandomNumber(999999) + "@mailforspam.com";
        setText(emailField, mail, "Email");
        setText(regPasswordField, "Qq12345678!", "Password");
        setText(regConfirmPasswordField, "Qq12345678!", "Confirm Password");
        click(privacyPolicyCheckbox, "Privacy policy");
        clickButton("CONTINUE");
        //step 2

    }

    public void  getVerificationCode() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("window-size=1920,1080");
        options.addArguments("headless");

    }
}
