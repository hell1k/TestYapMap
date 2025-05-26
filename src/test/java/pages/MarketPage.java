package pages;

import common.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class MarketPage extends BasePage {
    By deletePhotoBtn = By.xpath("//XCUIElementTypeButton[@name=\"ic delete\"]");
    By titleField = By.xpath("//XCUIElementTypeTable/XCUIElementTypeCell[5]/XCUIElementTypeTextView");
    By photoOptions = By.xpath("(//XCUIElementTypeImage[@name=\"ic_gray_unselect_checkbox\"])[1]");
    By typeBtn = By.xpath("//XCUIElementTypeTable/XCUIElementTypeCell[8]/XCUIElementTypeOther[1]/XCUIElementTypeOther");
    By typeOptions = By.xpath("//XCUIElementTypeTable/XCUIElementTypeCell//XCUIElementTypeOther[1]/XCUIElementTypeOther");
    By detailedDescriptionField = By.xpath("//XCUIElementTypeStaticText[@name=\"0/1000\"]/preceding-sibling::XCUIElementTypeTextView");
    By shippingAvailableSwitch = By.xpath("(//XCUIElementTypeSwitch[@value])[1]");
    By exchangeIsPossibleSwitch = By.xpath("(//XCUIElementTypeSwitch[@value])[2]");
    By bargainingIsPossibleSwitch = By.xpath("(//XCUIElementTypeSwitch[@value])[3]");
    By selectList = By.xpath("//XCUIElementTypeTable//XCUIElementTypeStaticText");
    By doneBtn = By.xpath("//XCUIElementTypeButton[@name=\"Done\"]");
    By postBtn = By.xpath("//XCUIElementTypeButton[@name=\"POST\"]");

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
        click(postBtn);
        waitElement(elementName("Market"));
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

    @Step("add Photo")
    public void addPhoto() throws InterruptedException {
        click(elementName("Add photo"));
        if (getElementsAmount(deletePhotoBtn) > 0) {
            click(deletePhotoBtn, "нажатие на кнопку Удалить фото");
        }
        waitElement(photoOptions);
        List<WebElement> eventType = getElements(photoOptions);
        int randomIndex = new Random().nextInt(eventType.size());
        WebElement randomGenderElement = eventType.get(randomIndex);
        randomGenderElement.click();
        click(elementName("Done"));
        wait(2);
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

    @Step("Select Location")
    void selectLocation() throws InterruptedException {
        clickSelectBtn("Location");
        waitASecond();
        clickButton("Save");
    }

    @Step("Set {value}")
    void setValue(String fieldName, String value) throws InterruptedException {
        setText(By.xpath("//XCUIElementTypeStaticText[@name=\"" + fieldName + "\"]/following-sibling::XCUIElementTypeTextField"), value, fieldName);
        waitASecond();
        clickButton("Done");
    }
}
