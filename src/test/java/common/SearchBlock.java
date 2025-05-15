package common;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class SearchBlock extends BasePage{
    By events = By.name("Events");
    By searchField = By.xpath("//XCUIElementTypeTextField[@value=\"Search\"]");

    @Step("Выбор раздела Events")
    public void selectEvents() {
        click(events);
    }

    @Step("Поиск {value}")
    public void searchValue(String value) {
        setText(searchField, value);
        waitElementName(value);
    }

}
