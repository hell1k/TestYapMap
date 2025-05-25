package tests;

import common.BasePage;
import org.testng.annotations.Test;

public class MarketTest extends BasePage {

    @Test(description = "Market Housing lifecycle")
    void housingLifecycle() throws InterruptedException {
        profile.openProfile();
        profile.clickMarket();
        market.addHousing();
    }
}
