package tests;

import common.BasePage;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.testng.annotations.Test;

public class GroupsTest extends BasePage {

    @Test(description = "Group lifecycle")
    @Description("Создание Не приватной группы")
    public void createPublicGroup() {
        profile.openProfile();
        groups.createGroup();
    }

    @Test(description = "Создание Приватной группы")
    @Description("Создание Приватной группы")
    public void createPrivateGroup() {
        profile.openProfile();
        groups.createPrivateGroup();
    }
}
