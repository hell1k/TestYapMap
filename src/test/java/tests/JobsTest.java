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

    @Test(description = "Создание Jobs")
    @Description("Создание Jobs")
    public void createJob() throws InterruptedException {
        profile.openProfile();
        jobs.addNewJob();
    }

    @Test(description = "Редактирование Jobs")
    @Description("Редактирование Jobs")
    public void editJob() throws InterruptedException {
        profile.openProfile();
        jobs.editJob();
    }

    @Test(description = "Jobs check tree dots")
    @Description("Jobs check tree dots")
    public void checkJob() throws InterruptedException {
        profile.openProfile();
        jobs.checkingJob();
    }

    @Test(description = "Удаление Job")
    @Description("Удаление Job")
    public void deleteJob() throws InterruptedException {
        profile.openProfile();
        jobs.deleteJob();
    }
}
