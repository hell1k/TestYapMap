package tests;

import common.BasePage;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class MarketTest extends BasePage {

    @Test(description = "Market lifecycle")
    @Description("Создание маркета стаф")
    public void createMarketStaff() throws InterruptedException {
        profile.openProfile();
        market.createMarketStuff();
    }
}
