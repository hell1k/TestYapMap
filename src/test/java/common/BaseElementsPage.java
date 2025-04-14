package common;

import com.google.common.io.Files;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.File;
import java.io.IOException;
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
    public void waitElement(By xpath) {
        wait.until(ExpectedConditions.presenceOfElementLocated(xpath));
    }

    @Step("Клик по элементу")
    public void click(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        driver.findElement(locator).click();
    }

    public int getElementsAmount(By locator) {
        return driver.findElements(locator).size();
    }

    @Step("Заполнение поля текстом {string}")
    public void setText(By xpath, String string) {
        driver.findElement(xpath).sendKeys(string);
    }

    public void waitElementName(String name) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.name(name)));
    }

    public int getRandomNumber(int number) {
        Random random = new Random();
        return random.nextInt(number);
    }

    public By elementName(String name) {
        return By.name(name);
    }
}
