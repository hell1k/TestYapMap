package tests;

import common.BasePage;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.testng.annotations.Test;

public class GroupsTest extends BasePage {

    @Test(description = "Group lifecycle")
    @Description("Создание и редактирование Не приватной группы")
    public void createPublicGroup() throws InterruptedException {
        profile.openProfile();
        String groupName = groups.createGroup();
        wait(3);
        groups.openGroup(groupName);
        groups.editGroup(groupName);
    }

    @Test(description = "Создание и редактирование Приватной группы")
    @Description("Создание Приватной группы")
    public void createPrivateGroup() throws InterruptedException {
        profile.openProfile();
        String groupName = groups.createPrivateGroup();
        wait(3);
        groups.openGroup(groupName);
        groups.editGroup(groupName);
    }

    @Test(description = "Взаимодействие с группой участником группы")
    public void testGroupParticipant() throws InterruptedException {
        profile.openProfile();
        String groupName = groups.createGroup();
        profile.logout();
        auth.authorization(data.login2);
        profile.openProfile();
        profile.clickGroups();
        groups.joinGroup(groupName);
        clickBack();
        waitElementName("Groups");
        groups.leaveGroup(groupName);
        groups.checkingJoinBtn(groupName);
    }

    @Test(description = "Проверка элементов группы при редактировании")
    public void testCheckingGroupElementsWithEdit() throws InterruptedException {
        profile.openProfile();
        String groupName = groups.createGroup();
        waitASecond();
        groups.clickProfileGroup(groupName);
        groups.clickEditGroup();
        groups.checkingLimitFields(groupName);
        swipeUp();
        groups.addAdmin();
        groups.addMembers();
        clickButton("Save");
        waitElementName("Ooops!");
        waitElementName("Group name should have at least 3 characters, less than or equal 50 characters");
    }

    @Test(description = "Проверка элементов группы")
    public void testCheckingGroupElements() throws InterruptedException {
        profile.openProfile();
        String groupName = groups.createGroup();
        waitASecond();
        groups.clickProfileGroup(groupName);
        groups.checkingMenu();
        swipeUp();
        groups.checkingBlockedMembers();
        groups.deleteGroup(groupName);
    }
}
