package tests;

import common.BasePage;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class LoginTest extends BasePage {

    @Test(description = "Редактирование имени пользователя")
    @Description("Редактирование имени пользователя")
    public void editProfile() {
        profile.openProfile();
        profile.editProfileFields();
    }
}