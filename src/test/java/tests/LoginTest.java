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
        profile.openProfileEditor();
        String firstname = profile.fillFirstName();
        String lastname = profile.fillLastName();
        String nickname = profile.fillNickname();
        profile.editProfileFields(firstname, lastname, nickname);
    }

    @Test(description = "Редактирование полей профиля")
    @Description("Редактирование полей профиля")
    public void editProfileData() {
        profile.openProfile();
        profile.editProfile();
    }

    @Test(description = "Отмена изменений")
    @Description("Отмена изменений")
    public void undoProfile() {
        profile.openProfile();
        String nameBefore = profile.getFullName();
        profile.openProfileEditor();
        String firstname = profile.fillFirstName();
        String lastname = profile.fillLastName();
        String nickname = profile.fillNickname();
        profile.UndoProfileChanges(firstname, lastname, nickname);
        assert profile.getFullName().equals(nameBefore) : "Старое и новое имена не совпадают";
    }
}
