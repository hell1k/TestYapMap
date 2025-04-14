package pages;

import common.BasePage;
import org.openqa.selenium.By;

public class Permission extends BasePage {
    By whenUsingApp = By.xpath("//XCUIElementTypeButton[@name=\"При использовании приложения\"]");
    By allow = By.xpath("//XCUIElementTypeButton[@name=\"Разрешить\"]");

    public void clickWhenUsingApp() {
        click(whenUsingApp);
    }

    public void clickAllow() {
        click(allow);
    }

    By permissionButton (String buttonText) {
        return By.xpath("//XCUIElementTypeButton[@name=\""+buttonText+"\"]");
    }
}
