package pages;

import common.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PetsPage extends BasePage {
    By checkboxPhoto = By.xpath("//XCUIElementTypeImage[@name=\"ic_gray_unselect_checkbox\"]");
    By nameField = By.xpath("(//XCUIElementTypeStaticText[contains(@name,\"Name\")]/ancestor::XCUIElementTypeCell/following-sibling::XCUIElementTypeCell/XCUIElementTypeTextView)[1]");
    By nickNameField = By.xpath("(//XCUIElementTypeStaticText[contains(@name,\"Nickname\")]/ancestor::XCUIElementTypeCell/following-sibling::XCUIElementTypeCell/XCUIElementTypeTextView)[1]");
    By description = By.xpath("//XCUIElementTypeStaticText[contains(@name,\"/1000\")]/preceding-sibling::XCUIElementTypeTextView");
    By selectList = By.xpath("//XCUIElementTypeTable//XCUIElementTypeStaticText");
    By dayOptions = By.xpath("(//XCUIElementTypePickerWheel)[1]");
    By monthOptions = By.xpath("(//XCUIElementTypePickerWheel)[2]");
    By yearOptions = By.xpath("(//XCUIElementTypePickerWheel)[3]");
    By kennelField = By.xpath("//XCUIElementTypeStaticText[@name=\"Kennel\"]/following-sibling::XCUIElementTypeTextField");
    By treeDots = By.xpath("//XCUIElementTypeButton[@name=\"treeDots\"]");
    By closeShareBtn = By.name("header.closeButton");
    By closeQrCodeBtn = By.xpath("//XCUIElementTypeButton[@name=\"ic close primary\"]");
    By pedigreeAlert = By.xpath("//XCUIElementTypeAlert[@name=\"Pedigree\"]//XCUIElementTypeTextField");

    @Step("Click select {selectName}")
    void clickSelectBtn(String selectName) {
        click(By.xpath("//XCUIElementTypeStaticText[@name=\"" + selectName + "\"]/following-sibling::XCUIElementTypeButton"));
    }

    @Step("Add new pet")
    public String addNewPet() throws InterruptedException {
        String petName = "Test pet_" + getRandomNumber(999999);
        String petNickname = "Nickname" + getRandomNumber(999999);
        clickButton("Add");
        clickButton("Ok");
        addPhoto();
        setText(nameField, petName, "Name");
        setText(nickNameField, petNickname, "Nickname");
        setText(description, "description_" + getRandomNumber(999999), "Description");
        String type = selectValue("Animal type");
        if (type == "Dogs") {
            selectValue("Dog Breed");
        }

        selectValue("Sex");
        selectDate();
        String pedigree = selectValue("Pedigree");
        if (pedigree == "Other") {
            waitElementName("Add your dog's pedigree not registered in our system");
            setText(pedigreeAlert, "pedigree" + getRandomNumber(999999));
            clickButton("Add");
        }

        selectValue("Color");
        setText(kennelField, "Kennel");
        click(elementName("Open for mating"));
        selectLocation();
        addPhoto();
        swipeUp();
        clickButton("POST");
        waitElement(By.xpath("//XCUIElementTypeStaticText[@name='" + petName + "']"));
        return petName;
    }

    @Step("Add photo")
    void addPhoto() {
        clickButton("Add photo");
        clickRandomElement(checkboxPhoto);
        clickButton("Done");
    }

    @Step("Select location")
    void selectLocation() throws InterruptedException {
        clickSelectBtn("Location");
        waitASecond();
        clickButton("Save");
    }

    @Step("Select Date")
    void selectDate() {
        String[] years = {"2018", "2019", "2025", "2021", "2022", "2023", "2024"};
        String[] months = {"January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"};
        clickSelectBtn("Date of Birth");
        getElements(dayOptions).get(0).sendKeys(String.valueOf(getRandomNumber(1, 28)));
        getElements(monthOptions).get(0).sendKeys(months[getRandomNumber(months.length)]);
        getElements(yearOptions).get(0).sendKeys(years[getRandomNumber(years.length)]);
        clickButton("Done");
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

    @Step("Edit pet {petName}")
    public String editPet() {
        String newPetName = "Test pet_" + getRandomNumber(999999);
        String newNickName = "Nickname" + getRandomNumber(999999);
        clickTreeDots();
        clickButton("Edit");
        clearAndSendKeys(nameField, newPetName, "Name");
        clearAndSendKeys(nickNameField, newNickName, "Nickname");
        clearAndSendKeys(description, "description_" + getRandomNumber(999999), "Description");
        String type = selectValue("Animal type");
        if (type == "Dogs") {
            selectValue("Dog Breed");
        }

        selectValue("Sex");
        selectDate();
        String pedigree = selectValue("Pedigree");
        if (pedigree == "Other") {
            waitElementName("Add your dog's pedigree not registered in our system");
            setText(pedigreeAlert, "pedigree" + getRandomNumber(999999));
            clickButton("Add");
        }
        selectValue("Color");
        setText(kennelField, "kennel");
        click(elementName("Open for mating"));
        checking30DaysLocation();
        swipeUp();
        clickButton("SAVE");
        waitElementName(newPetName);
        clickButton("Pets");
        waitElement(By.xpath("//XCUIElementTypeStaticText[@name='" + newPetName + "']"));
        return newPetName;
    }

    @Step("Message: Please come back in 30 days")
    void checking30DaysLocation() {
        clickSelectBtn("Location");
        waitElementName("Please come back in 30 days. Thank you.");
        clickButton("OK");
    }

    @Step("Open pet {petName}")
    public void openPet(String petName) {
        click(By.xpath("//XCUIElementTypeStaticText[@name='" + petName + "']"));
    }

    @Step("Проверка опций Pets")
    public void checkingTreeDots(String petName) throws InterruptedException {
        clickTreeDots();
        clickButton("Share");
        waitElementContainsName("Hey! Look at the pet \"" + petName + "\"");
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
        click(treeDots, "pets menu");
    }

    @Step("Delete pet {petName}")
    public void deletePet(String petName) {
        openPet(petName);
        clickTreeDots();
        clickButton("Delete");
        waitElementName("Are you sure you want to delete?");
        clickButton("Yes");
        waitElementName("Pets");
        waitHiddenElement(elementName(petName));
    }

}
