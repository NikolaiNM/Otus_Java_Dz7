package factory.impl;

import org.openqa.selenium.remote.AbstractDriverOptions;

public interface IWebDriverSettings {

    AbstractDriverOptions setting();

    AbstractDriverOptions setting(AbstractDriverOptions options);

}
