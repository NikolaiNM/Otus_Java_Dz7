package factory.impl;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.AbstractDriverOptions;

public class EdgeSettings implements IWebDriverSettings {

    @Override
    public AbstractDriverOptions setting() {
        return setting(new EdgeOptions());
    }


    @Override
    public AbstractDriverOptions setting(AbstractDriverOptions options) {
        if (options instanceof EdgeOptions) {// Проверяем что передаваемый options экземпляром класса
            EdgeOptions edgeOptions = (EdgeOptions) options;
            edgeOptions.addArguments("--start-maximized");
        }
        return options;
    }

}
