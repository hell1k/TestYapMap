package tests;

import common.BasePage;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class ChannelsTest extends BasePage {

    @Test(description = "Channels lifecycle")
    @Description("Add new Channel Private")
    public void addNewChannelPrivate() throws InterruptedException {
        profile.openProfile();
        channels.addNewChannelPrivate();
    }

    @Test(description = "Channels lifecycle")
    @Description("Add new Channel Not Private")
    public void addNewChannelNotPrivate() throws InterruptedException {
        profile.openProfile();
        channels.addNewChannelNotPrivate();
    }

    @Test(description = "Channels lifecycle")
    @Description("Check Channel")
    public void checkChannel() throws InterruptedException {
        profile.openProfile();
        String channelName = channels.addNewChannelPrivate();
        channels.checkChannel(channelName);
    }

    @Test(description = "Channels lifecycle")
    @Description("Check Users Items and Delete")
    public void checkingUserItemsAndDelete() throws InterruptedException {
        profile.openProfile();
        String channelName = channels.addNewChannelPrivate();
        channels.checkingUserItemsAndDelete(channelName);
    }

    @Test(description = "Channels lifecycle")
    @Description("Check Users Items and Delete")
    public void channelsParticipant() throws InterruptedException {
        profile.openProfile();
        String channelName = channels.addNewChannelPrivate();
        channels.channelsParticipant(channelName);
    }

    @Test(description = "Channels lifecycle")
    @Description("Test channel comment")
    public void checkChannelComment() throws InterruptedException {
        profile.openProfile();
        String channelName = channels.addNewChannelNotPrivate();
        channels.checkChannelComment(channelName);
    }

}
