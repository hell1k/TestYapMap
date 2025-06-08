package pages;

import common.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class ChatsPage extends BasePage {

    @Step("Select chatName")
    public void selectChat(String chatName) throws InterruptedException {
        click(By.xpath("//XCUIElementTypeStaticText[@name=\"" + chatName + "\"]"));
        waitASecond();
    }


}
