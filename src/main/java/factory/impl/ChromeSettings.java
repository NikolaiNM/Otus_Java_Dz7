package factory.impl;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.AbstractDriverOptions;

import java.util.HashMap;

public class ChromeSettings implements IWebDriverSettings {

    @Override
    public ChromeOptions setting() {
        return setting(new ChromeOptions());
    }

    @Override
    public ChromeOptions setting(AbstractDriverOptions options) {
        if (options instanceof ChromeOptions) {
            ChromeOptions chromeOptions = (ChromeOptions) options;
            chromeOptions.addArguments("--kiosk");

            // Пример дополнительных настроек для Selenoid
            String browserVersion = System.getProperty("browser.version");
            if (browserVersion != null) {
                chromeOptions.setCapability("browserVersion", browserVersion);
                chromeOptions.setCapability("selenoid:options", new HashMap<String, Object>() {{
                    put("name", "Test badge...");
                }});
            }
        }
        return (ChromeOptions) options;
    }
}
