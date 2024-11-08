package enums;

public enum InputField {

    USERNAME("#username"),
    EMAIL("#email"),
    PASSWORD("#password"),
    CONFIRM_PASSWORD("#confirm_password"),
    BIRTHDATE("#birthdate"),
    LANGUAGE_LEVEL("#language_level"),
    REGISTER_BUTTON("input[type='submit']"),
    OUTPUT("#output");

    private final String selector;

    InputField(String selector) {
        this.selector = selector;
    }

    public String getSelector() {
        return selector;
    }

}
