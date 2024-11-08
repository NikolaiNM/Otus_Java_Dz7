package enums;

public enum LanguageLevel {

    BEGINNER("beginner"),
    INTERMEDIATE("intermediate"),
    ADVANCED("advanced"),
    NATIVE("native");

    private final String value;

    LanguageLevel(String value) {
        this.value = value;
    }

    public String getLanguageLevelValue() {
        return value;
    }

}
