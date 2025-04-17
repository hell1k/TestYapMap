package tests;

import common.BasePage;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import pages.ProfilePage;

public class LoginTest extends BasePage {

    @Test(description = "Редактирование имени пользователя")
    @Description("Редактирование имени пользователя")
    public void editProfile() {
        profile.openProfile();
        profile.editProfileName();
    }

    @Test(description = "Редактирование полей профиля")
    @Description("Редактирование полей профиля")
    public void editProfileData() {
        profile.openProfile();
        profile.editProfile();
    }
}
