package tests;

import common.BasePage;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class PlaceTest extends BasePage {
    @Test(description = "Places lifecycle")
    @Description("Add new Place")
    public void addNewPlace() throws InterruptedException {
        profile.openProfile();
        swipeUp();
        String placeName = place.addNewPlace();
        place.checkOptionsPlace(placeName);
        place.checkLikeDislikeBtn();
        place.editPlace();
        place.deletePlace();
    }
}
