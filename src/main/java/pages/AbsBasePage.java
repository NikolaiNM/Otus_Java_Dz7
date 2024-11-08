package pages;

import common.AbsCommon;
import enums.InputField;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AbsBasePage extends AbsCommon {

    private final String BASE_URL;

    public AbsBasePage(WebDriver driver) {
        super(driver);
        this.BASE_URL = System.getProperty("base.url", "https://otus.home.kartushin.su/");
    }

    public void open(String path) {
        driver.get(BASE_URL + path);
    }

    public WebElement findByCssSelector(String cssSelector) {
        return driver.findElement(By.cssSelector(cssSelector));
    }

    public void selectDropdownByValue(WebElement element, String value) {
        Select select = new Select(element);
        select.selectByValue(value);
    }

    public void enterText(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
    }

    public void enterFieldData(InputField field, String value) {
        WebElement element = findByCssSelector(field.getSelector());
        enterText(element, value);
        logger.info("{} введено: {}", field.name(), value);
    }

}
