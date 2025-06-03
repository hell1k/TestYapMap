package pages;

import common.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PlacePage extends BasePage {
    By nameField = By.xpath("//XCUIElementTypeTable/XCUIElementTypeCell[5]/XCUIElementTypeTextView");
    By checkboxPhoto = By.xpath("//XCUIElementTypeImage[@name=\"ic_gray_unselect_checkbox\"]");
    By description = By.xpath("//XCUIElementTypeStaticText[contains(@name,\"/1000\")]/preceding-sibling::XCUIElementTypeTextView");
    By closeShareBtn = By.name("header.closeButton");
    By closeQrCodeBtn = By.xpath("//XCUIElementTypeButton[@name=\"ic close primary\"]");
    By deletePhotoBtn = By.xpath("//XCUIElementTypeButton[@name=\"ic delete\"]");
    By addBtn = By.xpath("//XCUIElementTypeButton[@name=\"Add\"]");
    By selectList = By.xpath("//XCUIElementTypeTable//XCUIElementTypeStaticText");


    public String addNewPlace() throws InterruptedException{
        click(elementName("Places to Visit"));
        click(addBtn);
        addPhoto();
        String placeName = "Test place_" + getRandomNumber(999999);
        setText(nameField, placeName, "Name");
        selectValue("Place type");
        selectLocation();
        setText(description, "description_" + getRandomNumber(999999), "Description");
        clickButton("ADD A PLACE");
        return placeName;
    }

    public void checkOptionsPlace(String placeName) throws InterruptedException{
        click(elementName(placeName));;
        click(elementName("ic not favorited"));
        click(elementName("treeDots"));
        clickButton("Share");
        waitElementContainsName("Hey! Look at the place \"" + placeName + "\"");
        click(closeShareBtn);
        waitASecond();
        click(elementName("treeDots"));
        clickButton("Generate QR code");
        waitElementName("Share QR code");
        click(closeQrCodeBtn, "close QR code button");
    }

    @Step("Select '{selectName}'")
    String selectValue(String selectName) {
        clickSelectBtn(selectName);
        waitElement(By.xpath("//XCUIElementTypeNavigationBar[@name=\"" + selectName + "\"]"));
        WebElement randomValue = getRandomElement(selectList);
        String valueName = randomValue.getText();
        randomValue.click();
        return valueName;
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

    @Step("Select location")
    public void selectLocation() throws InterruptedException {
        clickSelectBtn("Location");
        waitASecond();
        clickButton("Save");
    }

    @Step("Click select {selectName}")
    public void clickSelectBtn(String selectName) {
        click(By.xpath("//XCUIElementTypeStaticText[@name=\"" + selectName + "\"]/following-sibling::XCUIElementTypeButton"));
    }

    @Step("Check like/dislike button")
    public void checkLikeDislikeBtn() {
        clickButton("icLike");
        clickButton("icDislike");
    }

    @Step("Edit Place")
    public void editPlace() throws InterruptedException {
        click(elementName("treeDots"));
        click(elementName("Edit"));
        addPhoto();
        String newPlaceName = "Test place_" + getRandomNumber(999999);
        clearAndSendKeys(nameField, newPlaceName, "Name");
        selectValue("Place type");
        clearAndSendKeys(description, "description_" + getRandomNumber(999999), "Description");
        clickButton("SAVE A PLACE");
    }

    @Step("Delete Place")
    public void deletePlace() {
        click(elementName("treeDots"));
        click(elementName("Delete"));
        click(elementName("Yes"));
        waitElement(elementName("Places to Visit"));
    }
}
