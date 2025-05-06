package pages;

import common.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class GroupsPage extends BasePage {
    ProfilePage profile = new ProfilePage();

    By addButton = By.name("Add");
    By groupName = By.xpath("//XCUIElementTypeStaticText[@name=\"Group name\"]/..");
    By groupDescription = By.xpath("//XCUIElementTypeStaticText[@name=\"Group description\"]/..");
    By privateBtn = By.xpath("//XCUIElementTypeSwitch[@name=\"Private\"]");
    By closeQrCodeBtn = By.name("ic close primary");
    By treeDots = By.name("treeDots");
    By blockedMembersBtn = By.name("Blocked members");
    By deleteGroupBtn = By.name("Delete Group");
    By closeShareBtn = By.name("header.closeButton");
    By groupLogo = By.xpath("//XCUIElementTypeNavigationBar[@name]/XCUIElementTypeButton[2]");
    By groupNameEdit = By.xpath("(//XCUIElementTypeTextView[@value])[1]");
    By groupDescriptionEdit = By.xpath("(//XCUIElementTypeTextView[@value])[2]");

    @Step("Создание новой Не приватной группы")
    public String createGroup() {
        String group = "Group_" + getRandomNumber(999999);
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
        waitElement(elementName("Add"));
        return group;
    }

    @Step("Создание новой Приватной группы")
    public String createPrivateGroup() {
        String group = "Group_" + getRandomNumber(999999);
        profile.clickGroups();
        click(addButton);
        waitElementName("New Group");
        click(elementName("Add photo"));
        click(elementName("ic_gray_unselect_checkbox"));
        click(elementName("Done"));
        setText(groupName, group);
        setText(groupDescription, "description");
        click(privateBtn);
        click(elementName("Create"));
        waitElementName(group);
        return group;
    }
    @Step("Редактирование группы '{groupName}'")
    public void editGroup(String groupName) throws InterruptedException {
        String newGroupName = "Test group_" + getRandomNumber(999999999);

        click(groupLogo);
        click(treeDots);
        wait(1);
        click(elementName("Edit"));
        clearAndSendKeys(groupNameEdit, newGroupName);
        clearAndSendKeys(groupDescriptionEdit, getRandomText(250));
        click(elementName("Save"));
        wait(1);
        clickButton("ic ic back");
        clickButton("Groups");
        waitElement(By.xpath("//XCUIElementTypeStaticText[@name='" + newGroupName + "']"));
    }

    @Step("Переход в группу {groupName}")
    public void openGroup(String groupName) {
        waitElementName(groupName);
        click(elementName(groupName), groupName);
    }

    @Step("Вступление в группу {groupName}")
    public void joinGroup(String groupName) {
        openGroup(groupName);
        clickButton("JOIN");
        waitElementName("Settings");
        waitHiddenElement(elementName("JOIN"), "кнопка Join");
    }

    @Step("Выход из группы {groupName}")
    public void leaveGroup(String groupName) throws InterruptedException {
        openGroup(groupName);
        wait(1);
        click("//XCUIElementTypeNavigationBar[contains(@name,'" + groupName + "')]/XCUIElementTypeButton[2]", "настройки группы");
        swipeUp();
        click(elementName("Leave group"));
        waitElementName("Leave? All data will be lost!");
        clickButton("Leave");
        clickBack();
        click("//XCUIElementTypeNavigationBar[contains(@name,'" + groupName + "')]/XCUIElementTypeButton[1]");
        waitElementName(groupName);
    }

    @Step("Проверка наличия кнопки Join в группе {groupName}")
    public void checkingJoinBtn(String groupName) {
        openGroup(groupName);
        waitElementName("JOIN");
    }

    @Step("Переход в группу {groupName} и открытие описания группы")
    public void clickProfileGroup(String groupName) throws InterruptedException {
        openGroup(groupName);
        wait(1);
        click("//XCUIElementTypeNavigationBar[contains(@name,'" + groupName + "')]/XCUIElementTypeButton[2]", "настройки группы");
    }

    @Step("Переход на экран редактирования")
    public void clickEditGroup() {
        click(elementName("treeDots"));
        click(elementName("Edit"), "Edit");
        waitElementName("Edit Group");
    }

    @Step("Проверка лимита поля Name")
    public void checkingLimitFields(String groupName) {
        clearAndSendKeys(By.xpath("//XCUIElementTypeTextView[@value='" + groupName + "']"), data.name_120);
        waitElementName("125/50");
        clearAndSendKeys(By.xpath("//XCUIElementTypeTextView[@value='description']"), data.text_1000);
        waitElementName("1377/1000");
    }

    @Step("Добавление рандомного админа")
    public void addAdmin() {
        clickButton("ADD ADMINS");
        waitElementName("Add admins");
        waitElementName("checkbox delselected");
        clickRandomElement(elementName("checkbox delselected"));
        waitElement(By.xpath("//XCUIElementTypeButton[@name=\"checkbox delselected\" and @value=\"1\"]"));
        String adminName = getText(By.xpath("//XCUIElementTypeButton[@name=\"checkbox delselected\" and @value=\"1\"]/preceding-sibling::XCUIElementTypeOther/XCUIElementTypeStaticText"));
        clickButton("Choose");
        waitElementName("ADD ADMINS");
        swipeUp();
        waitElementName(adminName);
    }

    @Step("Добавление рандомного участника")
    public void addMembers() {
        clickButton("ADD MEMBERS");
        waitElementName("Add members");
        waitElementName("checkbox delselected");
        clickRandomElement(elementName("checkbox delselected"));
        waitElement(By.xpath("//XCUIElementTypeButton[@name=\"checkbox delselected\" and @value=\"1\"]"));
        String membersName = getText(By.xpath("//XCUIElementTypeButton[@name=\"checkbox delselected\" and @value=\"1\"]/preceding-sibling::XCUIElementTypeOther/XCUIElementTypeStaticText"));
        clickButton("Choose");
        waitElementName("ADD MEMBERS");
        swipeUp();
        waitElementName(membersName);
    }

    @Step("Проверка меню группы (троеточие)")
    public void checkingMenu() throws InterruptedException {
        click(treeDots, "меню группы (троеточие)");
        clickButton("Share");
        waitElementContainsName("See this group on Relagram https://relagram.com/share");
        click(closeShareBtn);
        waitASecond();
        waitASecond();
        click(treeDots, "меню группы (троеточие)");
        clickButton("Share to Relagram");
        waitElementName("Groups");
        waitElement(button("Share"), "кнопка Share");
        clickButton("Back");
        waitASecond();
        click(treeDots, "меню группы (троеточие)");
        clickButton("Generate QR code");
        waitElementName("Share QR code");
        click(closeQrCodeBtn, "кнопка закрытия QR кода");
    }

    @Step("Проверка раздела Blocked Members")
    public void checkingBlockedMembers() {
        click(blockedMembersBtn, "Blocked members");
        waitElementName("You don't have any blocked members");
        clickButton("Back");
    }

    @Step("Удаление группы")
    public void deleteGroup(String groupName) {
        click(deleteGroupBtn, "Delete Group");
        waitElementName("Delete? All data will be lost!");
        clickButton("Delete");
        clickBack();
        click("//XCUIElementTypeNavigationBar[contains(@name,'" + groupName + "')]/XCUIElementTypeButton[1]");
        swipeDown();
        waitHiddenElement(By.name(groupName), groupName);
    }
}
