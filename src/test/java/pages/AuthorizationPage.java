package pages;

import common.BasePage;
import common.Menu;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.Test;

import java.util.List;


public class AuthorizationPage extends BasePage {
    Permission permission = new Permission();
    Menu menu = new Menu();
    ProfilePage profile = new ProfilePage();

    By signInButton = By.xpath("//XCUIElementTypeButton[@name=\"SIGN IN\"]");
    By signInButton2 = By.xpath("//XCUIElementTypeButton[@label=\"SIGN IN\"]");
    By loginField = By.xpath("//XCUIElementTypeTextField");
    By passwordField = By.xpath("//XCUIElementTypeSecureTextField");
    By profileIcon = By.xpath("//XCUIElementTypeImage[@name=\"ic_tb_profile\"]");
    By emailField = By.xpath("(//XCUIElementTypeTextField)[1]");
    By regPasswordField = By.xpath("(//XCUIElementTypeSecureTextField)[1]");
    By regConfirmPasswordField = By.xpath("(//XCUIElementTypeSecureTextField)[2]");
    By privacyPolicyCheckbox = By.xpath("//XCUIElementTypeSwitch[@value=\"0\"]");
    By firstName = By.xpath("(//XCUIElementTypeTextField)[1]");
    By lastName = By.xpath("(//XCUIElementTypeTextField)[2]");
    By dateOfBirth = By.xpath("(//XCUIElementTypeTextField)[3]");
    By staticYear = By.xpath("//XCUIElementTypeStaticText[@name=\"1993\"]");
    By staticMonth = By.xpath("//XCUIElementTypeStaticText[@name=\"APRIL\"]");
    By staticDay = By.xpath("//XCUIElementTypeStaticText[@name=\"4\"]");
    By maleBtn = By.xpath("//XCUIElementTypeButton[@name=\"icMaleOff\"]");
    By femaleBtn = By.xpath("//XCUIElementTypeButton[@name=\"icFemaleOff\"]");
    By uploadPicture = By.xpath("//XCUIElementTypeButton[@name=\"ic ic link\"]");
    By status = By.xpath("//XCUIElementTypeTextField[@value=\"Status\"]");
    By sexualOrientation = By.xpath("//XCUIElementTypeTextField[@value=\"Sexual orientation\"]");
    By religionGroup = By.xpath("//XCUIElementTypeTextField[@value=\"Religion group\"]");
    By race = By.xpath("//XCUIElementTypeTextField[@value=\"Ethnic/Race Information\"]");
    By height = By.xpath("//XCUIElementTypeTextField[@value=\"Height\"]");
    By heightWeightField = By.xpath("//XCUIElementTypeTextField[@value=\"Enter\"]");
    By weight = By.xpath("//XCUIElementTypeTextField[@value=\"Weight\"]");
    By phone = By.xpath("(//XCUIElementTypeTextField)[2]");
    By profileDataValues = By.xpath("//XCUIElementTypeCell//XCUIElementTypeStaticText[@value]");

    @Step("Авторизация")
//    public void authorization() throws InterruptedException {
//        if (getElementsAmount(signInButton) > 0) {
//            click(signInButton);
//            setText(loginField, data.login);
//            setText(passwordField, data.password);
//            click(signInButton2);
//        }
//
//        waitElement(profileIcon);
//    }

    public void authorization() throws InterruptedException {
        if (getElementsAmount(menu.profile) > 0) {
            profile.logout();
        }
        click(signInButton);
        setText(loginField, data.login);
        setText(passwordField, data.password);
        click(signInButton2);
        waitElement(profileIcon);
    }


    @Step("Авторизация")
    public void authorization(String login) throws InterruptedException {
        if (getElementsAmount(signInButton) > 0) {
            click(signInButton);
            setText(loginField, login);
            setText(passwordField, data.password);
            click(signInButton2);
        }

        waitElement(profileIcon);
    }

    @Step("Регистрация нового пользователя")
    public void registration() throws InterruptedException {
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
        String verificationCode = getVerificationCode(mail);
        for (int i = 0; i < verificationCode.length(); i++) {
            setText(By.xpath("(//XCUIElementTypeTextField)[" + (i + 1) + "]"), String.valueOf(verificationCode.charAt(i)));
        }

        click(uploadPicture, "upload picture");
        clickButton("Photo Library");
        click(elementName("PXGGridLayout-Info"));
        wait(1);
        click(elementName("Choose"));
        setText(firstName, "test" + getRandomNumber(999999), "First Name");
        setText(lastName, "testov" + getRandomNumber(999999), "Last Name");
        click(dateOfBirth, "D.O.B.");
        click(staticYear, "Year");
        click(staticMonth, "Month");
        click(staticDay, "Day");
        click(elementName("DONE"), "кнопка Done");
        click(maleBtn, "Male");
        clickButton("CONTINUE");
        //step3
//        clickButton("Skip");
        click(status, "Status");
        clickRandomElement(profileDataValues);
        click(sexualOrientation, "Sexual orientation");
        clickRandomElement(profileDataValues);
        click(religionGroup, "Re");
        clickRandomElement(profileDataValues);
        click(race, "Ethnic/Race");
        clickRandomElement(profileDataValues);
        click(height, "Height");
        setText(heightWeightField, String.valueOf(getRandomNumber(120, 200)));
        click(elementName("DONE"), "кнопка Done");
        click(weight, "Weight");
        setText(heightWeightField, String.valueOf(getRandomNumber(50, 100)));
        click(elementName("DONE"), "кнопка Done");
        clickButton("CONTINUE");
        //step4
        setText(phone, "9" + getRandomNumber(900000000, 999999999), "Phone");
        clickButton("SIGN UP");
        waitElement(profileIcon);
    }

    @Test
    public String getVerificationCode(String mail) throws InterruptedException {
        FirefoxOptions options2 = new FirefoxOptions();
        options2.setPageLoadStrategy(PageLoadStrategy.EAGER);
        options2.addArguments("-headless");
        WebDriver driver2 = new FirefoxDriver(options2);
        wait(5);
        driver2.get("https://www.mailforspam.com/mail/" + mail.split("@")[0] + "/1");
        String code_value = driver2.findElement(By.xpath("//span[contains(text(), 'Your Relagram verification code is:')]")).getText().replaceAll("\\D+", "");
        driver2.close();
        return code_value;
    }
}
