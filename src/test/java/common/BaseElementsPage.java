package common;

import com.google.common.io.Files;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static common.BasePage.driver;
import static common.BasePage.wait;

public class BaseElementsPage {
    public TestData data = new TestData();
    By backBtn = By.xpath("//XCUIElementTypeButton[@name='ic ic back' or @name='Back']");

    @Attachment(type = "image/png")
    public static byte[] getScreenshot(WebDriver driver) {
        try {
            File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            return Files.toByteArray(screen);
        } catch (IOException e) {
            return null;
        }
    }

    public void wait(int second) throws InterruptedException {
        int time = second * 1000;
        Thread.sleep((int) time);
    }

    public WebElement getRandomElement(By locator) {
        return getElements(locator).get(getRandomNumber(getElementsAmount(locator)));
    }

    public void waitASecond() throws InterruptedException {
        wait(1);
    }

    @Step("Clear field and send keys")
    public String clearAndSendKeys(By element, String text) {
        WebElement el = getElement(element);
        el.click();
        el.clear();
        el.sendKeys(text);
        return text;
    }

    @Step("Clear field '{fieldName}' and send keys")
    public void clearAndSendKeys(By element, String text, String fieldName) {
        WebElement el = getElement(element);
        el.click();
        el.clear();
        el.sendKeys(text);
    }

    public void clearField(By element) {
        WebElement el = getElement(element);
        el.click();
        el.clear();
        el.clear();
    }

    public static String getRandomText(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder result = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            result.append(characters.charAt(index));
        }

        return result.toString();
    }

    public static String getRandomSite(int length) {
        String characters = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder result = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            result.append(characters.charAt(index));
        }

        return result.toString() + ".com";
    }

    public void waitElement(By locator) {
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    @Step("Ожидание элемента '{string}'")
    public void waitElement(By locator, String string) {
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public void waitClickableElement(By locator) {
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public void click(By locator) {
        waitClickableElement(locator);
        getElement(locator).click();
    }

    public void click(String xpath) {
        waitClickableElement(By.xpath(xpath));
        getElement(By.xpath(xpath)).click();
    }

    @Step("Клик по элементу {string}")
    public void click(String xpathOrName, String string) {
        if (String.valueOf(xpathOrName.charAt(0)).equals("/")) {
            waitClickableElement(By.xpath(xpathOrName));
            getElement(By.xpath(xpathOrName)).click();
        } else {
            waitClickableElement(By.name(xpathOrName));
            getElement(By.name(xpathOrName)).click();
        }
    }

    public void click(WebElement element) {
        element.click();
    }

    @Step("Клик по элементу {string}")
    public void click(WebElement element, String string) {
        element.click();
    }

    @Step("Клик по элементу {string}")
    public void click(By locator, String string) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        getElement(locator).click();
    }

    public int getElementsAmount(By locator) {
        return getElements(locator).size();
    }

    @Step("Заполнение поля текстом {string}")
    public void setText(By locator, String string) {
        getElement(locator).sendKeys(string);
    }

    @Step("Заполнение поля {fieldName} текстом {string}")
    public void setText(By xpath, String string, String fieldName) {
        getElement(xpath).sendKeys(string);
    }

    public String getText(By locator) {
        return getElement(locator).getText();
    }

    @Step("Ожидание элемента '{name}'")
    public void waitElementName(String name) {
        waitElement(By.name(name));
    }

    @Step("Ожидание элемента содержащего '{name}'")
    public void waitElementContainsName(String name) {
        waitElement(By.xpath("//*[contains(@name, '" + name + "')]"));
    }

    public int getRandomNumber(int number) {
        Random random = new Random();
        return random.nextInt(number);
    }

    public int getRandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

    public int getRandomNumberByLength(int length) {
        Random random = new Random();
        int min = (int) Math.pow(10, length - 1);
        int max = (int) Math.pow(10, length) - 1;
        return random.nextInt(max - min + 1) + min;
    }

    public String getRandomNumberString(int min, int max) {
        Random random = new Random();
        return String.valueOf(random.nextInt(max - min + 1) + min);
    }

    public By elementName(String name) {
        return By.name(name);
    }

    public void swipeUp() {
        Dimension size = driver.manage().window().getSize();
        int startX = size.getWidth() / 2;
        int startY = size.getHeight() / 2;
        int endX = startX;
        int endY = (int) (size.getHeight() * 0.25);
        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        Sequence sequence = new Sequence(finger1, 1)
                .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY))
                .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger1, Duration.ofMillis(200)))
                .addAction(finger1.createPointerMove(Duration.ofMillis(100), PointerInput.Origin.viewport(), endX, endY))
                .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Collections.singleton(sequence));
    }

    public void swipeDown() {
        Dimension size = driver.manage().window().getSize();
        int startX = size.getWidth() / 2;
        int startY = size.getHeight() / 2;
        int endX = startX;
        int endY = (int) (size.getHeight() * 0.75);
        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        Sequence sequence = new Sequence(finger1, 1)
                .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY))
                .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger1, Duration.ofMillis(200)))
                .addAction(finger1.createPointerMove(Duration.ofMillis(100), PointerInput.Origin.viewport(), endX, endY))
                .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Collections.singleton(sequence));
    }

    public void swipeToElement(By locator) {
        if (getElementsAmount(locator) < 0) {
            swipeUp();
        }
    }

    public void swipeRight() {
        Dimension size = driver.manage().window().getSize();
        int startX = 0;
        int startY = size.getHeight() / 2;
        int endX = 300;
        int endY = startY;
        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        Sequence sequence = new Sequence(finger1, 1)
                .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY))
                .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger1, Duration.ofMillis(200)))
                .addAction(finger1.createPointerMove(Duration.ofMillis(100), PointerInput.Origin.viewport(), endX, endY))
                .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Collections.singleton(sequence));
    }

    public void swipeToDeleteElement(WebElement element) {
        // Получаем координаты и размеры элемента
        Point location = element.getLocation();
        Dimension size = element.getSize();

        int startY = location.getY() + size.getHeight() / 2;

        // Начинаем свайп с правого края элемента и ведем влево
        int startX = location.getX() + (int) (size.getWidth() * 0.9);
        int endX = location.getX() + (int) (size.getWidth() * 0.1);
        int endY = startY;

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 1)
                .addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY))
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger, Duration.ofMillis(200)))
                .addAction(finger.createPointerMove(Duration.ofMillis(300), PointerInput.Origin.viewport(), endX, endY))
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singletonList(swipe));
    }

    public WebElement getElement(By locator) {
        return driver.findElement(locator);
    }

    public List<WebElement> getElements(By locator) {
        return driver.findElements(locator);
    }

    public By button(String name) {
        return By.xpath("//XCUIElementTypeButton[@name='" + name + "']");
    }

    @Step("Клик по кнопке '{name}'")
    public void clickButton(String name) {
        click(button(name));
    }

    public String getNumberFromSting(String string) {
        return string.replaceAll("\\D+", "");
    }

    public String getNumberFromElement(By locator) {
        return getText(locator).replaceAll("\\D+", "");
    }

    @Step("Select random value")
    public void clickRandomElement(By locator) {
        getElements(locator).get(getRandomNumber(getElementsAmount(locator))).click();
    }

    public static String generateRandomEmail() {
        String characters = "abcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            sb.append(characters.charAt(random.nextInt(characters.length())));
        }

        String userName = sb.toString();

        // Генерация случайного домена
        String[] domains = {"gmail.com", "yahoo.com", "outlook.com", "mail.com"};
        String domain = domains[random.nextInt(domains.length)];

        return userName + "@" + domain;
    }

    public void closeNotification(By element) {
        try {
            WebElement alertOkButton = driver.findElement(element);
            if (alertOkButton.isDisplayed()) {
                alertOkButton.click();
            }
        } catch (NoSuchElementException e) {
        }
    }

    public void clickBack() {
        if (getElements(backBtn).size() > 0) {
            click(backBtn);
        }
    }

    @Step("Проверка отсутствия элемента")
    public void waitHiddenElement(By locator) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    @Step("Проверка отсутствия элемента {string}")
    public void waitHiddenElement(By locator, String string) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }
}

