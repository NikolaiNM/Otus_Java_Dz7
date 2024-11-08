package exeption;

public class BrowserNotFoundException extends RuntimeException {

    public BrowserNotFoundException(String webDriverName) {
        super(String.format("Браузер %s не поддерживается", webDriverName));
    }

}
