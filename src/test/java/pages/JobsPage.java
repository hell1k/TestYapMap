package pages;

import common.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.List;
import java.util.Random;

public class JobsPage extends BasePage {
    By professionTypeBtn = By.xpath("(//XCUIElementTypeButton[@name=\"chevron\"])[1]");
    By professionOptions = By.xpath("//XCUIElementTypeTable/XCUIElementTypeCell/XCUIElementTypeOther[1]/XCUIElementTypeOther");
    By dutiesDescription = By.xpath("//XCUIElementTypeTable/XCUIElementTypeCell[5]/XCUIElementTypeTextView");
    By requiredEducation = By.xpath("//XCUIElementTypeTable/XCUIElementTypeCell[7]/XCUIElementTypeTextView");
    By deletePhotoBtn = By.xpath("//XCUIElementTypeButton[@name=\"ic delete\"]");
    By photoOptions = By.xpath("(//XCUIElementTypeImage[@name=\"ic_gray_unselect_checkbox\"])[1]");
    By selectExistingBusiness = By.xpath("(//XCUIElementTypeWindow/XCUIElementTypeOther[3]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell/XCUIElementTypeOther[1]/XCUIElementTypeOther)");
    By JobTypeOptionsBtn = By.xpath("//XCUIElementTypeTable/XCUIElementTypeCell[12]/XCUIElementTypeOther[1]/XCUIElementTypeOther");
    By JobTypeOptions = By.xpath("//XCUIElementTypeTable/XCUIElementTypeCell/XCUIElementTypeOther/XCUIElementTypeOther");
    By hourPerWeekBtn = By.xpath("//XCUIElementTypeTable/XCUIElementTypeCell[13]/XCUIElementTypeOther[1]/XCUIElementTypeOther");
    By hourPerWeekOptions = By.xpath("//XCUIElementTypeTable/XCUIElementTypeCell/XCUIElementTypeOther/XCUIElementTypeOther");
    By salaryPerBtn = By.xpath("//XCUIElementTypeTable/XCUIElementTypeCell[14]/XCUIElementTypeOther[1]/XCUIElementTypeOther");
    By salaryPerOptions = By.xpath("//XCUIElementTypeTable/XCUIElementTypeCell/XCUIElementTypeOther[1]/XCUIElementTypeOther");
    By salaryAmount = By.xpath("//XCUIElementTypeTable/XCUIElementTypeCell[15]/XCUIElementTypeOther[1]/XCUIElementTypeOther");
    By currencyBtn = By.xpath("//XCUIElementTypeTable/XCUIElementTypeCell[16]/XCUIElementTypeOther[1]/XCUIElementTypeOther");
    By arrowBtn = By.xpath("//XCUIElementTypeTable/XCUIElementTypeCell[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther");
    By positionName = By.xpath("(//XCUIElementTypeTextView[@value])[1]");
    By commissionsTipsBtn = By.xpath("//XCUIElementTypeSwitch[@name='Commissions / tips']");
    By canWorkRemotelyBtn = By.xpath("//XCUIElementTypeSwitch[@name='Can work remotely']");
    By saveBtn = By.xpath("//XCUIElementTypeButton[@name=\"SAVE\"]");
    By closeBtn = By.xpath("//XCUIElementTypeImage[@name=\"UICloseButtonBackground\"]");

    @Step("Добавление новой записи Job")
    public String addNewJob () throws InterruptedException {
        click(elementName("Jobs"));
        click(elementName("Add"));
        click(selectExistingBusiness);
        String jobName = clearAndSendKeys(elementName("Position name"), getRandomText(10));
        addProfessionType();
        clearAndSendKeys(dutiesDescription, getRandomText(20));
        clearAndSendKeys(requiredEducation, getRandomText(20));
        addPhoto();
        chooseJobType();
        chooseHourPerWeek();
        chooseSalaryPer();
        chooseSalaryAmount();
        click(commissionsTipsBtn);
        click(canWorkRemotelyBtn);
        clickButton("POST");
        clickButton("POST");
        waitElement(elementName("Your ad has been accepted"));
        return jobName;
    }

    @Step("редактироание Бизнеса")
    public void editJob() throws InterruptedException {
        click(elementName("Jobs"));
        waitElement(arrowBtn);
        click(arrowBtn);
        click(elementName("treeDots"));
        click(elementName("Edit"));
        clearAndSendKeys(positionName, getRandomText(10));
        addProfessionType();
        clearAndSendKeys(dutiesDescription, getRandomText(20));
        clearAndSendKeys(requiredEducation, getRandomText(20));
        addPhoto();
        chooseJobType();
        chooseHourPerWeek();
        chooseSalaryPer();
        chooseSalaryAmount();
        click(commissionsTipsBtn);
        click(canWorkRemotelyBtn);
        click(saveBtn);
        click(saveBtn);
    }

    @Step("Проверка меню Job (троеточие)")
    public void checkingJob() throws InterruptedException {
        click(elementName("Jobs"));
        waitElement(arrowBtn);
        click(arrowBtn);
        click(elementName("treeDots"), "меню группы (троеточие)");
        clickButton("Share");
        waitElementContainsName("Hey!");
        click(elementName("treeDots"), "меню группы (троеточие)");
        clickButton("Generate QR code");
        waitElementName("Share QR code");
        click(elementName("ic close primary"), "кнопка закрытия QR кода");
        click(elementName("Jobs"));
    }

    @Step("Удаление Job")
    public void deleteJob() {
        click(elementName("Jobs"));
        waitElement(arrowBtn);
        click(arrowBtn);
        click(elementName("treeDots"), "меню группы (троеточие)");
        click(elementName("Delete"), "Delete Group");
        waitElementName("Are you sure you want to delete?");
        clickButton("Yes");
        clickBack();
    }

    @Step("Выбор валюты")
    public void chooseCurrency() {
        click(currencyBtn);
        List<WebElement> typeElement = getElements(salaryPerOptions);

        if (typeElement.isEmpty()) {
            throw new IllegalStateException("Список пуст — элементы не найдены по локатору: " + currencyBtn);
        }
        int randomIndex = new Random().nextInt(typeElement.size());
        WebElement randomTypeElement = typeElement.get(randomIndex);
        randomTypeElement.click();
    }

    @Step("Выбор размера оплаты")
    public void chooseSalaryAmount() {
        clearAndSendKeys(salaryAmount, "293123");
        click(elementName("Done"));
    }

    @Step("выбор периода оплаты")
    public void chooseSalaryPer() {
        click(salaryPerBtn);
        List<WebElement> typeElement = getElements(salaryPerOptions);

        if (typeElement.isEmpty()) {
            throw new IllegalStateException("Список пуст — элементы не найдены по локатору: " + salaryPerBtn);
        }
        int randomIndex = new Random().nextInt(typeElement.size());
        WebElement randomTypeElement = typeElement.get(randomIndex);
        randomTypeElement.click();
    }

    @Step("Выбор размера оплаты в неделю")
    public void chooseHourPerWeek() {
        click(hourPerWeekBtn);
        List<WebElement> typeElement = getElements(hourPerWeekOptions);

        if (typeElement.isEmpty()) {
            throw new IllegalStateException("Список пуст — элементы не найдены по локатору: " + hourPerWeekBtn);
        }
        int randomIndex = new Random().nextInt(typeElement.size());
        WebElement randomTypeElement = typeElement.get(randomIndex);
        randomTypeElement.click();
    }

    @Step("Выбор типа работы")
    public void chooseJobType() {
        click(JobTypeOptionsBtn);
        List<WebElement> typeElement = getElements(JobTypeOptions);

        if (typeElement.isEmpty()) {
            throw new IllegalStateException("Список пуст — элементы не найдены по локатору: " + JobTypeOptionsBtn);
        }
        int randomIndex = new Random().nextInt(typeElement.size());
        WebElement randomTypeElement = typeElement.get(randomIndex);
        randomTypeElement.click();
        click(elementName("Apply"));
    }

    @Step("добавление типа Job")
    public void addProfessionType() throws InterruptedException {
        click(professionTypeBtn);
        wait(2);
        List<WebElement> typeElement = getElements(professionOptions);

        if (typeElement.isEmpty()) {
            throw new IllegalStateException("Список пуст — элементы не найдены по локатору: " + professionTypeBtn);
        }
        int randomIndex = new Random().nextInt(typeElement.size());
        WebElement randomTypeElement = typeElement.get(randomIndex);
        randomTypeElement.click();
    }

    @Step("добавление Фото")
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
}
