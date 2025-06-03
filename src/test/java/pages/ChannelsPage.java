package pages;

import common.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class ChannelsPage extends BasePage {
    By addBtn = By.xpath("//XCUIElementTypeButton[@name=\"Add\"]");
    By deletePhotoBtn = By.xpath("//XCUIElementTypeButton[@name=\"ic delete\"]");
    By checkboxPhoto = By.xpath("//XCUIElementTypeImage[@name=\"ic_gray_unselect_checkbox\"]");
    By nameField = By.xpath("//XCUIElementTypeTable/XCUIElementTypeCell[2]/XCUIElementTypeTextView");
    By description = By.xpath("//XCUIElementTypeTable/XCUIElementTypeCell[3]/XCUIElementTypeTextView");
    By privateBtn = By.xpath("//XCUIElementTypeSwitch[@name=\"Private\"]");
    By showMyExactLocationBtn = By.xpath("//XCUIElementTypeSwitch[@name=\"Show my exact location\"]");
    By channelLogo = By.xpath("//XCUIElementTypeButton[@name=\"channelMainPlaceholder\"]");
    By treeDots = By.xpath("//XCUIElementTypeButton[@name=\"treeDots\"]");
    By favoriteBtn = By.xpath("//XCUIElementTypeButton[@name=\"ic not favorited\"]");
    By closeShareBtn = By.name("header.closeButton");
    By closeQrCodeBtn = By.xpath("//XCUIElementTypeButton[@name=\"ic close primary\"]");
    By messageField = By.xpath("//XCUIElementTypeApplication[@name=\"Relagram\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]");
    By deleteAndLeaveBtn = By.xpath("//XCUIElementTypeTable/XCUIElementTypeCell[14]/XCUIElementTypeOther[1]/XCUIElementTypeOther");
    By logoutBtn = By.xpath("//XCUIElementTypeStaticText[@name=\"Log Out\"]");
    By signInButton = By.xpath("//XCUIElementTypeButton[@name=\"SIGN IN\"]");
    By signInButton2 = By.xpath("//XCUIElementTypeButton[@label=\"SIGN IN\"]");
    By loginField = By.xpath("//XCUIElementTypeTextField");
    By passwordField = By.xpath("//XCUIElementTypeSecureTextField");
    By profileIcon = By.xpath("//XCUIElementTypeImage[@name=\"ic_tb_profile\"]");
    By leaveChannelBtn = By.xpath("//XCUIElementTypeTable/XCUIElementTypeCell[13]/XCUIElementTypeOther[1]/XCUIElementTypeOther");

    public String addNewChannelPrivate() throws InterruptedException {
        String channelName = "Test channel_" + getRandomNumber(999999);
        click(elementName("Channels"));
        click(addBtn);
        addPhoto();
        setText(nameField, channelName, "Name");
        setText(description, "description_" + getRandomNumber(999999), "Description");
        click(privateBtn);
        click(showMyExactLocationBtn);
        addAdmin();
        addMembers();
        click(elementName("Create"));
        waitElement(By.id(channelName));
        return channelName;
    }

    public String addNewChannelNotPrivate() throws InterruptedException {
        String channelName = "Test channel_" + getRandomNumber(999999);
        click(elementName("Channels"));
        click(addBtn);
        addPhoto();
        setText(nameField, channelName, "Name");
        setText(description, "description_" + getRandomNumber(999999), "Description");
        click(showMyExactLocationBtn);
        addAdmin();
        addMembers();
        click(elementName("Create"));
        waitElement(By.id(channelName));
        return channelName;
    }

    @Step("Add photo")
    void addPhoto() throws InterruptedException {
        clickButton("Add photo");
        wait(2);
        if (getElementsAmount(deletePhotoBtn) > 0) {
            click(deletePhotoBtn, "нажатие на кнопку Удалить фото");
        }
        clickRandomElement(checkboxPhoto);
        clickButton("Done");
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

    public void checkChannel(String channelName) {
        click(channelName);
        click(channelLogo);
        click(treeDots);
        clickButton("Edit");
        clearAndSendKeys(nameField, "Test channel_" + getRandomNumberByLength(37));
        clearAndSendKeys(description, "Test channel_" + getRandomNumberByLength(937));
        clickButton("Save");
        click(favoriteBtn);
        click(treeDots);
        clickButton("Share");
        waitElementContainsName("See this channel on Relagram");
        click(closeShareBtn);
        clickButton("Share to Relagram");
        clickButton("Back");
        click(elementName("treeDots"));
        clickButton("Generate QR code");
        waitElementName("Share QR code");
        click(closeQrCodeBtn, "close QR code button");
        clickButton("ic ic back");
        waitElement(By.id(channelName));
    }

    public void checkingUserItemsAndDelete(String channelName) {
        click(channelName);
        click(channelLogo);
        click(treeDots);
        clickButton("Edit");
        addAdmin();
        addMembers();
        clickButton("ic ic back");
        clickButton("ic ic back");
        clearAndSendKeys(messageField, getRandomText(20));
        clickButton("icSendOn");
        click(channelLogo);
        swipeUp();
        click(deleteAndLeaveBtn);
        clickButton("Delete");
    }

    public void channelsParticipant(String channelName) throws InterruptedException {
        logout();
        authorization(data.login2);
        click(elementName("Channels"));
        click(channelName);
        joinChannel(channelName);
        checkingReportChannelBtn();
        clickButton("Cancel");
        leaveChannel(channelName);
    }

    public void leaveChannel(String channelName) {
        click(leaveChannelBtn);
        clickButton("Leave");
        click(channelName);
        waitElement(elementName("JOIN"));
    }

    public void checkingReportChannelBtn() {
        clickButton("Report for review");
        waitElement(elementName("Choose the reason"));
    }

    public void joinChannel(String channelName) {
        click(elementName("Channels"));
        click(channelName);
        clickButton("JOIN");
        waitElement(elementName("Leave channel"));
    }

    @Step("Log Out")
    public void logout() {
        swipeUp();
        swipeUp();
        swipeUp();
        click(logoutBtn, "Log Out");
        waitElement(button("SIGN IN"));
    }

    @Step("Авторизация")
    public void authorization(String login) throws InterruptedException {
        if (getElementsAmount(signInButton) > 0) {
            click(signInButton);
            setText(loginField, login);
            setText(passwordField, data.password);
            click(signInButton2);
        }

        waitElement(profileIcon);
    }

//    @Step("Test channel comment")
//    public void checkChannelComment(String channelName) throws InterruptedException {
//        click(channelName);
//        String channelMessage = clearAndSendKeys(messageField, getRandomText(20));
//        clickButton("icSendOn");
//        clickButton("Channels");
//        clickButton("Back");
//        logout();
//        authorization(data.login2);
//        joinChannel(channelName);
//        clickButton("Channels");
//        click(channelName);
//        checkingChannelCommentMember(channelMessage);
//    }
//
//    public void checkingChannelCommentMember(String channelMessage) {
//        clickButton("Comment");
//        waitElement(By.id(channelMessage));
//
//    }
}
