package tests;

import common.BasePage;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class BusinessTest extends BasePage {

    @Test(description = "Business lifecycle")
    @Description("Business lifecycle")
    public void businessLifecycle() {
        profile.openProfile();

    }
}
