package factory.impl;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.AbstractDriverOptions;

public class ChromeSettings implements IWebDriverSettings {

    @Override
    public AbstractDriverOptions setting() {
        return setting(new ChromeOptions());
    }


    @Override
    public AbstractDriverOptions setting(AbstractDriverOptions options) {
        if (options instanceof ChromeOptions) {// Проверяем что передаваемый options экземпляром класса
            ChromeOptions chromeOptions = (ChromeOptions) options;
            chromeOptions.addArguments("--kiosk");
        }
        return options;
    }

}
