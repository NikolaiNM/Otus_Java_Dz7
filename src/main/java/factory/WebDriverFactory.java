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
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class WebDriverFactory {

    public static WebDriver create() {
        return create(WebDriverName.CHROME, null, null);  // Используем Chrome по умолчанию
    }

    public static WebDriver create(AbstractDriverOptions options) {
        WebDriverName webDriverName = WebDriverName.fromSystemProperty();
        return create(webDriverName, options, null);
    }

    public static WebDriver create(WebDriverName webDriverName, AbstractDriverOptions options, String gridUrl) {
        if (gridUrl != null && !gridUrl.isEmpty()) {
            options = getOptionsWithSettings(webDriverName, options);
            try {
                return new RemoteWebDriver(new URL(gridUrl), options);
            } catch (MalformedURLException e) {
                throw new RuntimeException("Некорректный URL для Selenium Grid: " + gridUrl, e);
            }
        } else {
            return createLocalDriver(webDriverName, options);
        }
    }

    private static WebDriver createLocalDriver(WebDriverName webDriverName, AbstractDriverOptions options) {
        switch (webDriverName) {
            case CHROME:
                ChromeSettings chromeSettings = new ChromeSettings();
                options = chromeSettings.setting(options != null ? (ChromeOptions) options : chromeSettings.setting());
                return new ChromeDriver((ChromeOptions) options);
            case FIREFOX:
                FirefoxSettings firefoxSettings = new FirefoxSettings();
                options = firefoxSettings.setting(options != null ? (FirefoxOptions) options : firefoxSettings.setting());
                return new FirefoxDriver((FirefoxOptions) options);
            case EDGE:
                EdgeSettings edgeSettings = new EdgeSettings();
                options = edgeSettings.setting(options != null ? (EdgeOptions) options : edgeSettings.setting());
                return new EdgeDriver((EdgeOptions) options);
            default:
                throw new BrowserNotFoundException("Неизвестный браузер: " + webDriverName);
        }
    }

    private static AbstractDriverOptions getOptionsWithSettings(WebDriverName webDriverName, AbstractDriverOptions options) {
        switch (webDriverName) {
            case CHROME:
                return new ChromeSettings().setting((ChromeOptions) options);
            case FIREFOX:
                return new FirefoxSettings().setting((FirefoxOptions) options);
            case EDGE:
                return new EdgeSettings().setting((EdgeOptions) options);
            default:
                throw new BrowserNotFoundException("Неизвестный браузер: " + webDriverName);
        }
    }
}
