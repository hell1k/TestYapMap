package common;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class Menu extends BasePage{
    public By profile = By.name("ic_tb_profile");

    @Step("Click profile")
    public void clickProfile() {
        click(profile);
    }
}
