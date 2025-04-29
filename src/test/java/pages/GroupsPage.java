package pages;

import common.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class GroupsPage extends BasePage {
    ProfilePage profile = new ProfilePage();

    By addButton = By.name("Add");
    By groupName = By.xpath("//XCUIElementTypeStaticText[@name=\"Group name\"]/..");
    By groupDescription= By.xpath("//XCUIElementTypeStaticText[@name=\"Group description\"]/..");
    By pribateBtn= By.xpath("//XCUIElementTypeSwitch[@name=\"Private\"]");


    @Step("Создание новой Не приватной группы")
    public void createGroup() {
        String group = "Group_"+getRandomNumber(999999);
        profile.clickGroups();
        click(addButton);
        waitElementName("New Group");
        click(elementName("Add photo"));
        click(elementName("ic_gray_unselect_checkbox"));
        click(elementName("Done"));
        setText(groupName, group);
        setText(groupDescription, "description");
        click(elementName("Create"));
        waitElementName(group);
    }

    @Step("Создание новой Приватной группы")
    public void createPrivateGroup() {
        String group = "Group_"+getRandomNumber(999999);
        profile.clickGroups();
        click(addButton);
        waitElementName("New Group");
        click(elementName("Add photo"));
        click(elementName("ic_gray_unselect_checkbox"));
        click(elementName("Done"));
        setText(groupName, group);
        setText(groupDescription, "description");
        click(pribateBtn);
        click(elementName("Create"));
        waitElementName(group);
    }
//    @Step("Редактирование группы '{groupName}'")
//    public void editGroup() throws InterruptedException {
//        String originalGroupName = "Group_" + getRandomNumber(999999);
//        String newGroupName = "Test group_" + getRandomNumber(999999999);
//
//        click(By.xpath("//XCUIElementTypeStaticText[@name='" + originalGroupName + "']"));
//        wait(1);
//        click(elementName("Edit group"));
//        clearAndSendKeys(By.id(originalGroupName), newGroupName);
//        clearAndSendKeys(groupDescription, getRandomText(250));
//        click(elementName("Save"));
//        wait(1);
//        clickButton("Back");
//        waitElement(By.xpath("//XCUIElementTypeStaticText[@name='" + newGroupName + "']"));
//    }
//
//    @Step("Нажать на кнопку редактирования группы")
//    public void clickEditGroup() {
//        click(elementName("Edit Group"));
//    }
}
