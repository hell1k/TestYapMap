package tests;

import common.BasePage;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import pages.BusinessPage;

public class BusinessTest extends BasePage {

    @Test(description = "Business lifecycle")
    @Description("Business lifecycle")
    public void businessLifecycle() throws InterruptedException {
        profile.openProfile();
//        profile.swipeUp();
        business.openBusiness();
        business.addNewBusiness();
        business.addNewBusinessWithFullFields();
        business.editBusiness();
        business.share(); 
        business.generateQrCode();
    }
}