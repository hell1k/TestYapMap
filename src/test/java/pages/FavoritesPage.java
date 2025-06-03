package pages;

import common.BasePage;
import org.openqa.selenium.By;

public class FavoritesPage extends BasePage {
    By groupLogo = By.xpath("//XCUIElementTypeNavigationBar[@name]/XCUIElementTypeButton[2]");
    By addToFavoriteBtn = By.xpath("//XCUIElementTypeButton[@name=\"ic not favorited\"]");
    By favoriteBtn = By.xpath("//XCUIElementTypeTable/XCUIElementTypeCell[3]/XCUIElementTypeOther[1]/XCUIElementTypeOther");

    public void addToFavoriteGroup (String groupName) {
        click(elementName(groupName));
        click(groupLogo);
        click(addToFavoriteBtn);
        click(elementName("ic ic back"));
        click(elementName("Groups"));
        click(elementName("Profile"));
        click(favoriteBtn);
        click(elementName("Groups"));
        waitElement(By.id(groupName));
    }

    public void addToFavoriteEvent(String eventName) {
        click(elementName(eventName));
        click(addToFavoriteBtn);
        click(elementName("ic ic back"));
        click(elementName("Back"));
        click(favoriteBtn);
        click(elementName("Events"));
        waitElement(By.id(eventName));
    }

    public void addToFavoriteBusiness(String businessName) {
        click(elementName(businessName));
        click(addToFavoriteBtn);
        click(elementName("My Businesses"));
        click(elementName("Back"));
        click(favoriteBtn);
        click(elementName("Local Deals"));
        waitElement(elementName(businessName));
    }

    public void addToFavoritesMarket(String marketName) {
        click(elementName(marketName));
        click(addToFavoriteBtn);
        click(elementName("Market"));
        click(elementName("Back"));
        click(favoriteBtn);
        click(elementName("Market"));
        waitElement(elementName(marketName));
    }

    public void addToFavoritesJobs(String jobName) {
        click(elementName(jobName));
        click(addToFavoriteBtn);
        click(elementName("Jobs"));
        click(elementName("Back"));
        click(favoriteBtn);
        click(elementName("Jobs"));
        waitElement(elementName(jobName));
    }

    public void addToFavoritesPets(String petName) {
        click(elementName(petName));
        click(addToFavoriteBtn);
        click(elementName("Pets"));
        click(elementName("Back"));
        click(favoriteBtn);
        click(elementName("Pets"));
        waitElement(elementName(petName));
    }

    public void addToFavoritesPlace(String placeName) {
        click(elementName(placeName));
        click(addToFavoriteBtn);
        click(elementName("Places"));
        click(elementName("Back"));
        click(favoriteBtn);
        click(elementName("Places"));
        waitElement(elementName(placeName));
    }

    public void addToFavoritesChannels(String channelName) {
        click(elementName(channelName));
        click(addToFavoriteBtn);
        click(elementName("Channels"));
        click(elementName("Back"));
        click(favoriteBtn);
        click(elementName("Places"));
        waitElement(elementName(channelName));
    }
}
