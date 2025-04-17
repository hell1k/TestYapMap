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

    @Step("Ожидание элемента")
    public void waitElement(By locator) {
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    @Step("Ожидание элемента")
    public void waitClickableElement(By locator) {
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    @Step("Клик по элементу")
    public void click(By locator) {
       waitClickableElement(locator);
        getElement(locator).click();
    }

    public int getElementsAmount(By locator) {
        return getElements(locator).size();
    }

    @Step("Заполнение поля текстом {string}")
    public void setText(By locator, String string) {
        getElement(locator).sendKeys(string);
    }

    public String getText(By locator) {
        return getElement(locator).getText();
    }

    public void waitElementName(String name) {
        waitElement(By.name(name));
    }

    public int getRandomNumber(int number) {
        Random random = new Random();
        return random.nextInt(number);
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

    public WebElement getElement(By locator) {
        return driver.findElement(locator);
    }

    public List<WebElement> getElements(By locator) {
        return driver.findElements(locator);
    }
}
