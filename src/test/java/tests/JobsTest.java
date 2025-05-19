package tests;

import common.BasePage;
import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;

public class JobsTest extends BasePage {

    @Test(description = "Jobs lifecycle")
    @Description("Создание и редактирование Jobs")
    public void createJob() throws InterruptedException {
        profile.openProfile();
        jobs.addNewJob();
    }
}
