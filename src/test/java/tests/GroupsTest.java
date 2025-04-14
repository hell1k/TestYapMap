package tests;

import common.BasePage;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class GroupsTest extends BasePage {

    @Test(description = "Group lifecycle")
    @Description("Group lifecycle")
    public void groupLifecycle() {
        profile.openProfile();
        groups.createGroup();
    }
}
