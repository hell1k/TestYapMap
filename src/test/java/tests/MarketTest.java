package tests;

import common.BasePage;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.testng.annotations.Test;

public class MarketTest extends BasePage {
    public static String title;

    @Test(description = "Market lifecycle")
    @Description("Создание маркета стаф")
    public void createMarketStaff() throws InterruptedException {
        profile.openProfile();
        title = market.createMarketStuff();
    }

    @Test(description = "Market lifecycle")
    @Description("Редактирование маркета стаф")
    public void editStuff() throws InterruptedException {
        profile.openProfile();
        title = market.createMarketStuff();
        market.editStuff(title);
    }

    @Test(description = "Market lifecycle")
    @Description("Проверка меню Троеточие стафа")
    public void checkingStuff() throws InterruptedException {
        profile.openProfile();
        title = market.createMarketStuff();
        market.checkingStuff(title);
    }

    @Test(description = "Market Housing lifecycle")
    void housingLifecycle() throws InterruptedException {
        profile.openProfile();
        profile.clickMarket();
        market.addHousing();
    }

    @Test(description = "Market Housing lifecycle")
    @Description("Создание маркета транспорт")
    void addTransportation() throws InterruptedException {
        profile.openProfile();
        profile.clickMarket();
        wait(2);
        String title = market.addTransportation();
    }

    @Test(description = "Market Housing lifecycle")
    @Description("Редактирование маркета транспорт")
    void editTransportation() throws InterruptedException {
        profile.openProfile();
        profile.clickMarket();
        wait(3);
        String title = market.addTransportation();
        market.editTransportation(title);
        market.checkingTransportation(title);
    }

    @Test(description = "Market Housing lifecycle")
    @Description("Проверка троеточие транспорт")
    void checkingTransportation() throws InterruptedException {
        profile.openProfile();
        profile.clickMarket();
        wait(3);
        market.checkingTransportation(title);
    }
}