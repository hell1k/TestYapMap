package tests;

import common.BasePage;
import org.testng.annotations.Test;

public class ChatsTest extends BasePage {

    @Test(description = "Chat Business")
    public void TestBusinessChat() throws InterruptedException {
        profile.openProfile();
        profile.clickBusiness();
        String businessName = business.addNewBusiness();
        clickBack();
        profile.logout();
        auth.authorization(data.login2);
        search.selectBusiness();
        search.searchAndOpen(businessName);
        business.clickTreeDots();
        clickButton("Send message");
        String message = business.sendMessage();
        business.sendImage();
        business.sendFiles();
        clickBack();
        clickBack();
        profile.logout();
        auth.authorization(data.login);
        menu.clickChats();
        chats.selectChat("Groups");
        chats.selectChat("Businesses");
        click(elementName(businessName));
        waitText(message);
    }
}
