package pages;

import common.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class MarketPage extends BasePage {
    By checkboxPhoto = By.xpath("//XCUIElementTypeImage[@name=\"ic_gray_unselect_checkbox\"]");
    By titleField = By.xpath("//XCUIElementTypeStaticText[contains(@name,\"/50\")]/preceding-sibling::XCUIElementTypeTextView");
    By selectList = By.xpath("//XCUIElementTypeTable//XCUIElementTypeStaticText");
    By yearOptions = By.xpath("(//XCUIElementTypePickerWheel)[1]");
    By descriptionField = By.xpath("//XCUIElementTypeStaticText[contains(@name,\"0/1000\")]/preceding-sibling::XCUIElementTypeTextView");
    By conditionImage = By.xpath("//XCUIElementTypeImage");
    By navigationBarLivingArea = By.xpath("//XCUIElementTypeNavigationBar[@name=\"Living area\"]");
    By livingAreaField = By.xpath("//XCUIElementTypeNavigationBar[@name=\"Living area\"]/following-sibling::XCUIElementTypeTextField");
    By navigationBarLotSize = By.xpath("//XCUIElementTypeNavigationBar[@name=\"Lot size\"]");
    By lotSizeField = By.xpath("//XCUIElementTypeNavigationBar[@name=\"Lot size\"]/following-sibling::XCUIElementTypeTextField");
    By typeBtn = By.xpath("//XCUIElementTypeTable/XCUIElementTypeCell[8]/XCUIElementTypeOther[1]/XCUIElementTypeOther");
    By typeOptions = By.xpath("//XCUIElementTypeTable/XCUIElementTypeCell//XCUIElementTypeOther[1]/XCUIElementTypeOther");
    By detailedDescriptionField = By.xpath("//XCUIElementTypeStaticText[@name=\"0/1000\"]/preceding-sibling::XCUIElementTypeTextView");
    By shippingAvailableSwitch = By.xpath("(//XCUIElementTypeSwitch[@value])[1]");
    By exchangeIsPossibleSwitch = By.xpath("(//XCUIElementTypeSwitch[@value])[2]");
    By bargainingIsPossibleSwitch = By.xpath("(//XCUIElementTypeSwitch[@value])[3]");
    By doneBtn = By.xpath("//XCUIElementTypeButton[@name=\"Done\"]");
    By treeDots = By.xpath("//XCUIElementTypeButton[@name=\"treeDots\"]");
    By closeShareBtn = By.name("header.closeButton");
    By closeQrCodeBtn = By.xpath("//XCUIElementTypeButton[@name=\"ic close primary\"]");

    @Step("Add market Housing")
    public String addHousing() throws InterruptedException {
        String marketName = "Test market_" + getRandomNumber(999999);
        clickButton("Add");
        click("Housing", "Housing");
        checkingCheckbox("Housing");
        clickButton("CREATE");
        waitElementName("Housing for sale");
        addPhoto();
        setText(titleField, marketName, "Title");
        selectValue("Property Type");
        selectYearBuilt();
        selectLocation();
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
        waitASecond();
        clickButton("POST");
        waitElementName("Your ad has been accepted");
        waitElementName(marketName);
        return marketName;
    }

    @Step("Проверка опций Housing")
    public void checkingHousingElements(String marketName) throws InterruptedException {
        clickTreeDots();
        clickButton("Share");
        waitElementContainsName("Hey! Look at the house advertisement \"" + marketName + "\"");
        click(closeShareBtn);
        waitASecond();
        waitASecond();
        clickTreeDots();
        clickButton("Generate QR code");
        waitElementName("Share QR code");
        click(closeQrCodeBtn, "close QR code button");
    }

    @Step("Click treeDots")
    public void clickTreeDots() {
        click(treeDots, "market menu");
    }

    @Step("Edit Housing")
    public String editHousing() throws InterruptedException {
        click(elementName("treeDots"));
        click(elementName("Edit"));
        String newMarketName = "Test market_" + getRandomNumber(999999);
        addPhoto();
        clearAndSendKeys(titleField, newMarketName, "Title");
        selectValue("Property Type");
        selectYearBuilt();
        selectLocation();
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
        clickButton("SAVE");
        waitElement(elementName("treeDots"));
        clickButton("Market");
        waitElement(By.xpath("//XCUIElementTypeStaticText[@name='" + newMarketName + "']"));
        return newMarketName;
    }

    @Step("Open {marketName}")
    public void openMarket(String marketName) {
        click(By.xpath("//XCUIElementTypeStaticText[@name=\"" + marketName + "\"]/following-sibling::XCUIElementTypeButton"));
    }

    @Step("Delete pet {marketName}")
    public void deleteMarket(String marketName) {
        openMarket(marketName);
        clickTreeDots();
        clickButton("Delete");
        waitElementName("Are you sure you want to delete?");
        clickButton("Yes");
        waitElementName("Market");
        waitHiddenElement(elementName(marketName));
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
        clearAndSendKeys(descriptionField, "description", "Description");
        waitASecond();
        clickButton("Done");
    }

    @Step("Set {value}")
    void setValue(String fieldName, String value) throws InterruptedException {
        clearAndSendKeys(By.xpath("//XCUIElementTypeStaticText[@name=\"" + fieldName + "\"]/following-sibling::XCUIElementTypeTextField"), value, fieldName);
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

    @Step("create new Market Stuff")
    public void createMarketStuff() throws InterruptedException {
        click(elementName("Market"));
        click(elementName("Add"));
        click(elementName("CREATE"));
        addNewStaff();
    }

    @Step("add new Stuff")
    public void addNewStaff() throws InterruptedException {
        addPhoto();
        clearAndSendKeys(titleField, getRandomText(10));
        click(elementName("Done"));
        String value = selectValue("Category");
        if ("Clothing".equals(value) ||
                "Jewelry".equals(value) ||
                "Shoes".equals(value) ||
                "Fashion accessories".equals(value) ||
                "Transportation".equals(value)) {
            addType();
        }
        selectLocation();
        setValue("Price", "123");
        click(shippingAvailableSwitch);
        click(exchangeIsPossibleSwitch);
        click(bargainingIsPossibleSwitch);
        clearAndSendKeys(detailedDescriptionField, getRandomText(10));
        click(doneBtn);
        swipeUp();
        swipeUp();
        clickButton("POST");
        waitElement(elementName("Market"));
    }

    @Step("add Type")
    public void addType() throws InterruptedException {
        click(typeBtn);
        wait(2);
        List<WebElement> typeElement = getElements(typeOptions);

        if (typeElement.isEmpty()) {
            throw new IllegalStateException("Список пуст — элементы не найдены по локатору: " + typeBtn);
        }
        int randomIndex = new Random().nextInt(typeElement.size());
        WebElement randomTypeElement = typeElement.get(randomIndex);
        randomTypeElement.click();
    }
}
