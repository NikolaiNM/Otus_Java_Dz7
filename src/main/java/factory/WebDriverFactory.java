package factory;

import enums.WebDriverName;
import exeption.BrowserNotFoundException;
import factory.impl.ChromeSettings;
import factory.impl.EdgeSettings;
import factory.impl.FirefoxSettings;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.AbstractDriverOptions;

public class WebDriverFactory {

    public static WebDriver create(AbstractDriverOptions options) {
        WebDriverName webDriverName = WebDriverName.fromSystemProperty();
        return create(webDriverName, options);
    }

    public static WebDriver create(WebDriverName webDriverName, AbstractDriverOptions options) {
        switch (webDriverName) {
            case CHROME: {
                ChromeSettings settings = new ChromeSettings();
                options = settings.setting(options != null ? options : new ChromeOptions());
                return new ChromeDriver((ChromeOptions) options);
            }

            case FIREFOX: {
                FirefoxSettings settings = new FirefoxSettings();
                options = settings.setting(options != null ? options : new FirefoxOptions());
                return new FirefoxDriver((FirefoxOptions) options);
            }

            case EDGE: {
                EdgeSettings settings = new EdgeSettings();
                options = settings.setting(options != null ? options : new EdgeOptions());
                return new EdgeDriver((EdgeOptions) options);
            }

            default:
                throw new BrowserNotFoundException("Неизвестный браузер: " + webDriverName);
        }
    }

    public static WebDriver create() {
        return create(null);
    }

}
