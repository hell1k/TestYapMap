package common;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class Menu extends BasePage{
    public By profile = By.name("ic_tb_profile");
    public By chats = By.name("ic_tb_chat");

    @Step("Click profile")
    public void clickProfile() {
        click(profile);
    }

    @Step("Click Chats")
    public void clickChats() {
        click(chats);
    }
}
