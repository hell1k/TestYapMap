package tests;

import common.BasePage;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class FavoritesTest extends BasePage {
    @Test(description = "Favorites lifecycle")
    @Description("Add to Favorites Group")
    public void addToFavoritesGroup() throws InterruptedException {
        profile.openProfile();
        String groupName = groups.createGroup();
        favorite.addToFavoriteGroup(groupName);
    }

    @Test(description = "Favorites lifecycle")
    @Description("Add to Favorites Event")
    public void addToFavoritesEvent() throws InterruptedException {
        profile.openProfile();
        String eventName = events.createEvents(false);
        favorite.addToFavoriteEvent(eventName);
    }

    @Test(description = "Favorites lifecycle")
    @Description("Add to Favorites Business")
    public void addToFavoritesBusiness() throws InterruptedException {
        profile.openProfile();
        click(elementName("Businesses"));
        String businessName = business.addNewBusiness();
        favorite.addToFavoriteBusiness(businessName);
    }

    @Test(description = "Favorites lifecycle")
    @Description("Add to Favorites Market")
    public void addToFavoritesMarket() throws InterruptedException {
        profile.openProfile();
        click(elementName("Market"));
        String MarketName = market.createMarketStuff();
        favorite.addToFavoritesMarket(MarketName);
    }

    @Test(description = "Favorites lifecycle")
    @Description("Add to Favorites Jobs")
    public void addToFavoritesJobs() throws InterruptedException {
        profile.openProfile();
        click(elementName("Jobs"));
        String jobsName = jobs.addNewJob();
        favorite.addToFavoritesJobs(jobsName);
    }

    @Test(description = "Favorites lifecycle")
    @Description("Add to Favorites Pets")
    public void addToFavoritesPets() throws InterruptedException {
        profile.openProfile();
        click(elementName("Pets"));
        String petsName = pets.addNewPet();
        favorite.addToFavoritesPets(petsName);
    }

    @Test(description = "Favorites lifecycle")
    @Description("Add to Favorites Place")
    public void addToFavoritesPlace() throws InterruptedException {
        profile.openProfile();
        click(elementName("Places"));
        String placeName = place.addNewPlace();
        favorite.addToFavoritesPlace(placeName);
    }

    @Test(description = "Favorites lifecycle")
    @Description("Add to Favorites Channels")
    public void addToFavoritesChannels() throws InterruptedException {
        profile.openProfile();
        click(elementName("Channels"));
        String channelName = channels.addNewChannelPrivate();
        favorite.addToFavoritesPlace(channelName);
    }
}
