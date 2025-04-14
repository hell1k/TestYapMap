package pages;

import common.BasePage;
import org.openqa.selenium.By;

public class GroupsPage extends BasePage {
    ProfilePage profile = new ProfilePage();

    By addButton = By.name("Add");
    By groupName = By.xpath("//XCUIElementTypeStaticText[@name=\"Group name\"]/..");
    By groupDescription= By.xpath("//XCUIElementTypeStaticText[@name=\"Group description\"]/..");

    public void createGroup() {
        String group = "Group_"+getRandomNumber(999999);
        profile.clickGroups();
        click(addButton);
        waitElementName("New Group");
        click(elementName("Add photo"));
        click(elementName("ic_gray_unselect_checkbox"));
        click(elementName("Done"));
        setText(groupName, group);
        setText(groupDescription, "description");
        click(elementName("Create"));
        waitElementName(group);
    }
}
