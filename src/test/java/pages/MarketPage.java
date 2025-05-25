package pages;

import common.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MarketPage extends BasePage {
    By checkboxPhoto = By.xpath("//XCUIElementTypeImage[@name=\"ic_gray_unselect_checkbox\"]");
    By titleField = By.xpath("//XCUIElementTypeStaticText[@name=\"0/50\"]/preceding-sibling::XCUIElementTypeTextView");
    By selectList = By.xpath("//XCUIElementTypeTable//XCUIElementTypeStaticText");
    By yearOptions = By.xpath("(//XCUIElementTypePickerWheel)[1]");
    By descriptionField = By.xpath("//XCUIElementTypeStaticText[@name=\"0/1000\"]/preceding-sibling::XCUIElementTypeTextView");
    By conditionImage = By.xpath("//XCUIElementTypeImage");
    By navigationBarLivingArea = By.xpath("//XCUIElementTypeNavigationBar[@name=\"Living area\"]");
    By livingAreaField = By.xpath("//XCUIElementTypeNavigationBar[@name=\"Living area\"]/following-sibling::XCUIElementTypeTextField");
    By navigationBarLotSize = By.xpath("//XCUIElementTypeNavigationBar[@name=\"Lot size\"]");
    By lotSizeField = By.xpath("//XCUIElementTypeNavigationBar[@name=\"Lot size\"]/following-sibling::XCUIElementTypeTextField");

    @Step("Add market Housing")
    public void addHousing() throws InterruptedException {
        String marketName = "Test market_" + getRandomNumber(999999);
        clickButton("Add");
        click("Housing", "Housing");
        checkingCheckbox("Housing");
        clickButton("CREATE");
        waitElementName("Housing for sale");
        addPhoto();
        setText(titleField, marketName, "title");
        selectValue("Property Type");
        selectYearBuilt();
        selectLocation();
//        setValue("ZIP", getRandomNumberString(100000, 999999));
        setValue("Price", getRandomNumberString(100000, 999999));
        clickCheckbox("Exchange is possible");
        clickCheckbox("Bargaining is possible");
        setDescription();
        setValue("Bedrooms", getRandomNumberString(1, 10));
        setValue("Bathrooms", getRandomNumberString(1, 10));
        clickCheckbox("Basement");
        clickCheckbox("Pool");
        setValue("Parking spots number", getRandomNumberString(1, 10));
        selectValue("Parking type");
        selectValue("Laundry type");
        selectValue("Air condition type");
        selectValue("Heating type");
        setLivingArea();
        setLotSize();
        setCondition();
        swipeUp();
        swipeUp();
        clickButton("POST");
        waitElementName("Your ad has been accepted");
        waitElementName(marketName);
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

    @Step("Click select {selectName}")
    void clickSelectBtn(String selectName) {
        click(By.xpath("//XCUIElementTypeCell[XCUIElementTypeButton/following-sibling::XCUIElementTypeStaticText[@name='" + selectName + "'] or XCUIElementTypeButton/preceding-sibling::XCUIElementTypeStaticText[@name='" + selectName + "']]"));
    }

    @Step("Select Year Built")
    void selectYearBuilt() {
        clickSelectBtn("Year Built");
        getElements(yearOptions).get(0).sendKeys(String.valueOf(getRandomNumber(2020, 2024)));
        clickButton("Done");
    }

    @Step("Select Location")
    void selectLocation() throws InterruptedException {
        clickSelectBtn("Location");
        waitASecond();
        clickButton("Save");
    }

    @Step("Set description")
    void setDescription() throws InterruptedException {
        setText(descriptionField, "description", "Description");
        waitASecond();
        clickButton("Done");
    }

    @Step("Set {value}")
    void setValue(String fieldName, String value) throws InterruptedException {
        setText(By.xpath("//XCUIElementTypeStaticText[@name=\"" + fieldName + "\"]/following-sibling::XCUIElementTypeTextField"), value, fieldName);
        waitASecond();
        clickButton("Done");
    }

    @Step("Проверка наличия чекбокса {marketName}")
    void checkingCheckbox(String marketName) {
        waitElement(By.xpath("//XCUIElementTypeStaticText[@name=\"" + marketName + "\"]/preceding-sibling::XCUIElementTypeImage[@name=\"checkbox_green\"]"));
    }

    @Step("Add photo")
    void addPhoto() {
        clickButton("Add photo");
        clickRandomElement(checkboxPhoto);
        clickButton("Done");
    }

    @Step("Click checkbox {checkboxName}")
    void clickCheckbox(String checkboxName) {
        click(By.xpath("//XCUIElementTypeStaticText[@name=\"" + checkboxName + "\"]/following-sibling::XCUIElementTypeSwitch"));
    }

    @Step("Set Condition")
    void setCondition() {
        clickSelectBtn("Condition");
        clickRandomElement(conditionImage);
        clickButton("DONE");
    }

    @Step("Set Living area")
    void setLivingArea() {
        clickSelectBtn("Living area");
        waitElement(navigationBarLivingArea);
        setText(livingAreaField, getRandomNumberString(1, 10));
        clickButton("DONE");
    }

    @Step("Set Lot size")
    void setLotSize() {
        clickSelectBtn("Lot size");
        waitElement(navigationBarLotSize);
        setText(lotSizeField, getRandomNumberString(1, 10));
        clickButton("DONE");
    }
}
