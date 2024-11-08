package registrationpage;

import enums.LanguageLevel;
import factory.WebDriverFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pages.RegistrationForm;

public class RegistrationFormTest {

    private WebDriver driver;
    private RegistrationForm onPage;

    @BeforeEach
    public void init() {
        this.driver = WebDriverFactory.create();
        this.onPage = new RegistrationForm(driver);
        onPage.open("/form.html");
    }

    @AfterEach
    public void close() {
        if (this.driver != null) {
            this.driver.quit();
        }
    }

    @Test
    public void checkingRegistration2() {
        String birthdate = "30.09.1986";
        LanguageLevel languageLevel = LanguageLevel.INTERMEDIATE;

        onPage
                .enterUsername()
                .enterEmail()
                .enterPassword()
                .enterConfirmPassword()
                .checkPasswordsMatch()
                .enterBirthdate(birthdate)
                .selectLanguage(languageLevel.getLanguageLevelValue())
                .clickRegisterButton()
                .verifyOutput(birthdate, languageLevel.getLanguageLevelValue());
    }
}
