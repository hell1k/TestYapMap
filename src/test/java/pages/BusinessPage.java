package pages;

import common.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.List;
import java.util.Random;

import static java.awt.SystemColor.menu;

public class BusinessPage extends BasePage {

    By profile = By.name("ic_tb_profile");
    By addBusinessBtn = By.xpath("//XCUIElementTypeButton[@name=\"Add\"]");
    By businessBtn = By.xpath("(//XCUIElementTypeButton[@name=\"chevron\"])[4]");
    By addPhotoBnt = By.xpath("//XCUIElementTypeButton[@name='Add photo']");
    By chooseBusiness = By.xpath("//XCUIElementTypeCell/XCUIElementTypeOther[1]/XCUIElementTypeOther");
    By deletePhotoBnt = By.xpath("//XCUIElementTypeButton[@name=\"icDeleteWhite\"]");
    By choosePhoto = By.xpath("//XCUIElementTypeWindow/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeCell[2]/XCUIElementTypeOther/XCUIElementTypeImage[1]");
    By doneBnt = By.xpath("//XCUIElementTypeButton[@name=\"Done\"]");
    By businessName = By.xpath("//XCUIElementTypeTable/XCUIElementTypeCell[5]/XCUIElementTypeTextView");
    By businessDescription = By.xpath("//XCUIElementTypeTable/XCUIElementTypeCell[7]/XCUIElementTypeTextView");
    By businessType = By.xpath("//XCUIElementTypeTable/XCUIElementTypeCell[9]/XCUIElementTypeOther[1]/XCUIElementTypeOther");
    By typesOfBusiness = By.xpath("//XCUIElementTypeTable/XCUIElementTypeCell/XCUIElementTypeOther[1]/XCUIElementTypeOther");
    By siteField = By.xpath("//XCUIElementTypeTable/XCUIElementTypeCell[10]/XCUIElementTypeOther[1]/XCUIElementTypeOther");
    By phoneField = By.xpath("//XCUIElementTypeTable/XCUIElementTypeCell[11]/XCUIElementTypeTextField");
    By locationBtn = By.xpath("//XCUIElementTypeButton[@name=\"chevron\"]");
    By saveBtn = By.xpath("//XCUIElementTypeButton[@name=\"Save\"]");
    By saveChangesBtn = By.xpath("//XCUIElementTypeButton[@name=\"SAVE\"]");
    By showToToggle = By.xpath("//XCUIElementTypeSwitch[@value]");
    By postBtn = By.xpath("//XCUIElementTypeButton[@name=\"POST\"]");
//    By saveBtn = By.xpath("//XCUIElementTypeButton[@name=\"SAVE\"]");
    By businessToDelete = By.xpath("//XCUIElementTypeCell/XCUIElementTypeOther[1]/XCUIElementTypeOther");
    By deleteBtn = By.xpath("//XCUIElementTypeButton[@name='Delete']");
    By yesBtn = By.xpath("//XCUIElementTypeButton[@name=\"Yes\"]");
    By favoriteBtn = By.xpath("//XCUIElementTypeButton[@name=\"ic not favorited\"]");
    By extraBtn = By.xpath("//XCUIElementTypeButton[@name=\"treeDots\"]");
    By editBtn = By.xpath("//XCUIElementTypeButton[@name=\"Edit\"]");
    By photoEdit = By.xpath("//XCUIElementTypeWindow/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeCell/XCUIElementTypeOther/XCUIElementTypeImage");
    By photoEditDeleteBtn = By.xpath("//XCUIElementTypeButton[@name=\"ic delete\"]");
    By shareBtn = By.xpath("//XCUIElementTypeButton[@name=\"Share\"]");
    By closeShareBtn = By.xpath("//XCUIElementTypeButton[@name=\"header.closeButton\"]");
    By generateQrCodeBtn = By.xpath("//XCUIElementTypeButton[@name=\"Generate QR code\"]");
    By closeQrCodeBtn = By.xpath("//XCUIElementTypeButton[@name=\"ic close primary\"]");
    By deleteBtnExtra = By.xpath("//XCUIElementTypeButton[@name=\"Delete\"]");
    By deleteTextBtn = By.xpath("//XCUIElementTypeKey[@name=\"delete\"]");
    By siteName = By.xpath("//XCUIElementTypeTable/XCUIElementTypeCell[10]/XCUIElementTypeOther[1]/XCUIElementTypeOther");
    By confirmDeleteBtn = By.xpath("//XCUIElementTypeButton[@name=\"Yes\"]");


    @Step("Добавление новой записи Business")
    public void addNewBusiness () throws InterruptedException {
        deleteBusiness();
        click(addBusinessBtn);
        addPhoto();
        addBusinessName();
        addBusinessDescription();
        addBusinessType();
        addSite();
        addPhone();
        addLocation();
        showToOthers();
        swipeUp();
        post();
        wait(2);
    }

    @Step("Добавление новой записи Business Все Поле")
    public void addNewBusinessWithFullFields () throws InterruptedException {
        deleteBusiness();
        click(addBusinessBtn);
        addPhoto();
        addBusinessNameFull();
        addBusinessDescriptionFull();
        addBusinessType();
        addSite();
        addPhone();
        addLocation();
        showToOthers();
        swipeUp();
        post();
        wait(2);
    }

    @Step("редактироание Бизнеса")
    public void editBusiness() throws InterruptedException {
        clickOnBusiness();
        click(extraBtn);
        click(editBtn);
        addPhotoInEdit();
        addBusinessName();
        addBusinessDescription();
        addBusinessType();
        addSite();
        addPhone();
        addLocation();
        showToOthers();
        swipeUp();
        saveChange();
        wait(2);
    }

    @Step("Open profile")
    public void clickProfile() {
        click(profile);
    }

    @Step("открытие вкладки Бизнес")
    public void openBusiness() {
        click(businessBtn);
    }

    public void clickOnBusiness() {
        clickProfile();
        openBusiness();
        click(chooseBusiness);
    }

    public void addToFavorite() {
        clickOnBusiness();
        click(extraBtn);
        click(favoriteBtn);
    }

    public void share() {
        clickOnBusiness();
        click(extraBtn);
        click(shareBtn);
        click(closeShareBtn);
    }
    public void generateQrCode() {
        clickOnBusiness();
        click(extraBtn);
        click(generateQrCodeBtn);
        click(closeQrCodeBtn);
    }
    public void deleteBusinessExtra() {
        clickOnBusiness();
        click(extraBtn);
        click(deleteBtnExtra);
        click(confirmDeleteBtn);
    }

    @Step("удаление Бизнеса")
    public void deleteBusiness() throws InterruptedException {
        List<WebElement>  elements = driver.findElements(businessToDelete);

        if (!elements.isEmpty()) {
            WebElement element = elements.get(0);
            swipeToDeleteElement(element);
            wait.until(ExpectedConditions.elementToBeClickable(deleteBtn));
            driver.findElement(deleteBtn).click();
            click(yesBtn);
            wait(2);
        }
    }

    @Step("добавление Фото профиля")
    public void addPhoto() throws InterruptedException {
        if (getElementsAmount(deletePhotoBnt) > 0) {
            click(deletePhotoBnt, "нажатие на кнопку Удалить фото");
        }
        click(addPhotoBnt, "нажатие на кнопку Добавить фото");
        click(choosePhoto, "нажатие на кнопку Выбрать фото");
        click(doneBnt, "нажатие на кнопку Подтвердить выбор");
        wait(3);
    }

    @Step("добавление Фото при Редактировании")
    public void addPhotoInEdit() throws InterruptedException {
        click(addPhotoBnt, "нажатие на кнопку Добавить фото");
        if (getElementsAmount(photoEditDeleteBtn) > 0) {
            click(photoEditDeleteBtn, "нажатие на кнопку Удалить фото");
        }
        click(choosePhoto, "нажатие на кнопку Выбрать фото");
        click(doneBnt, "нажатие на кнопку Подтвердить выбор");
        wait(3);
    }

    @Step("добавление Названия Бизнеса")
    public void addBusinessName () {
        clearAndSendKeys(businessName, getRandomText(10));
    }

    @Step("добавление Названия Бизнеса")
    public void addBusinessNameFull () {
        clearAndSendKeys(businessName, getRandomText(50));
    }

    @Step("добавление Описания Бизнеса Все Поле")
    public void addBusinessDescription () {
        clearAndSendKeys(businessDescription, getRandomText(10));
    }

    @Step("добавление Описания Бизнеса Все Поле")
    public void addBusinessDescriptionFull () {
        clearAndSendKeys(businessDescription, getRandomText(1000));
    }

    @Step("добавление типа бизнеса")
    public void addBusinessType() {
        click(businessType);
        List<WebElement> typeElement = getElements(typesOfBusiness);

        if (typeElement.isEmpty()) {
            throw new IllegalStateException("Список годов пуст — элементы не найдены по локатору: " + businessType);
        }
        int randomIndex = new Random().nextInt(typeElement.size());
        WebElement randomTypeElement = typeElement.get(randomIndex);
        randomTypeElement.click();
    }

    @Step("добавление Сайта")
    public void addSite () {
        click(siteField);
//        if (getElementsAmount(siteName) > 0) {
//            click(deleteTextBtn, "нажатие на кнопку Стереть");
//        }
        String randomSite = getRandomSite(10);
        clearAndSendKeys(siteField, randomSite);
    }

    @Step("добавление Телефона")
    public void addPhone () {
        click(phoneField);
        String randomPhone = getRandomPhone(9);
        clearField(phoneField);
        clearAndSendKeys(phoneField, randomPhone);
    }

    @Step("добавление рандомного Номера")
    public static String getRandomPhone(int length) {
        String characters = "0123456789";
        StringBuilder result = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            result.append(characters.charAt(index));
        }

        return "9" + result.toString();
    }

    @Step("добавление Локации")
    public void addLocation () throws InterruptedException {
        click(locationBtn);
        wait(2);
        click(saveBtn);
    }

    @Step("переключатель Показывать всем")
    public void showToOthers () {
        click(showToToggle);
    }

    @Step("Нажатие кнопки POST")
    public void post () {
        click(postBtn);
    }

    @Step("Нажатие кнопки SAVE")
    public void saveChange () {
        click(saveChangesBtn);
    }
}
