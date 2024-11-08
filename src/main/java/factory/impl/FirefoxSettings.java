package factory.impl;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.AbstractDriverOptions;

public class FirefoxSettings implements IWebDriverSettings {

    @Override
    public AbstractDriverOptions setting() {
        return setting(new FirefoxOptions());
    }


    @Override
    public AbstractDriverOptions setting(AbstractDriverOptions options) {
        if (options instanceof FirefoxOptions) {// Проверяем что передаваемый options экземпляром класса
            FirefoxOptions firefoxOptions = (FirefoxOptions) options;
            firefoxOptions.addArguments("--width=800");
            firefoxOptions.addArguments("--height=600");
        }
        return options;
    }
}
