package enums;

import exeption.BrowserNotFoundException;

public enum WebDriverName {

    CHROME,
    FIREFOX,
    EDGE;

    public static WebDriverName fromSystemProperty() {
        String browserName = System.getProperty("browser", "chrome").toUpperCase();
        try {
            return WebDriverName.valueOf(browserName);
        } catch (IllegalArgumentException e) {
            throw new BrowserNotFoundException("Неизвестный броузер: " + browserName);
        }
    }
}
