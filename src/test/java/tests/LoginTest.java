package tests;

import common.BasePage;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class LoginTest extends BasePage {

    @Test(description = "Редактирование имени пользователя")
    @Description("Редактирование имени пользователя")
    public void editProfile() {
        profile.openProfile();
        profile.openProfileEditor();
        profile.editProfileName();
    }

    @Test(description = "Редактирование полей профиля")
    @Description("Редактирование полей профиля")
    public void editProfileData() throws InterruptedException {
        profile.openProfile();
        profile.editProfile();
    }

    @Test(description = "Отмена изменений")
    @Description("Отмена изменений")
    public void undoProfile() {
        profile.openProfile();
        String nameBefore = profile.getFullName();
        String nicknameBefore = profile.getNickname();
        profile.openProfileEditor();
        profile.fillFirstName();
        profile.fillLastName();
        profile.fillNickname();
        profile.undoProfileChanges();
        assert profile.getFullName().equals(nameBefore) : "Старое и новое имена не совпадают";
        assert profile.getNickname().equals(nicknameBefore) : "Старый и новый ники не совпадают";
    }

    @Test(description = "Проверка элеменов профиля")
    @Description("Проверка элементов профиля")
    public void profileCheck() {
        profile.openProfile();
        profile.checkProfileElements();
    }
}
