package common;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BasePage extends BaseElementsPage {

    public static AppiumDriver driver;
    public static WebDriverWait wait;
    public TestData data = new TestData();
    public AuthorizationPage auth;
    public ProfilePage profile;
    public EventsPage events;
    public GroupsPage groups;

    @BeforeMethod
    public void setUp() throws MalformedURLException, InterruptedException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("appium:platformName", "iOS");
        capabilities.setCapability("appium:platformVersion", "18.4");
        capabilities.setCapability("appium:automationName", "XCUITest");
//        capabilities.setCapability("appium:id", "BD9D4A92-2713-45AE-89EB-E01673F6E5CF");
        capabilities.setCapability("appium:deviceName", "iPhone 16 Pro");
        capabilities.setCapability("appium:app", "/Users/anton/Downloads/Relagram.app");
        capabilities.setCapability("appium:showXcodeLog", true);
        capabilities.setCapability("appium:usePrebuiltWDA", true);
        capabilities.setCapability("appium:derivedDataPath", "/tmp/wda");
        capabilities.setCapability("appium:noReset", true);
//        capabilities.setCapability("appium:fullReset", true);
//        capabilities.setCapability("appium:autoAcceptAlerts", true);
//        capabilities.setCapability("appium:autoDismissAlerts", true);

//        capabilities.setCapability("appium:autoGrantPermissions", true);
//        capabilities.setCapability("appium:skipDeviceInitialization", true);
        driver = new IOSDriver(new URL("http://localhost:4723"), capabilities);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        auth = new AuthorizationPage();
        profile = new ProfilePage();
        events = new EventsPage();
        groups = new GroupsPage();
        auth.authorization();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            getScreenshot(driver);
            ((IOSDriver) driver).terminateApp("com.open4u.Open4U");
            driver.quit();
        }
    }
}
