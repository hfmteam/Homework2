package WebTests.tests;

import WebTests.Pages.LoginPage;
import WebTests.Pages.UserMainPage;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Testing a login auth")
public class LoginPageTest extends BaseTest {
    private static final By LOGIN_INPUT = By.xpath(".//*[@name='st.email']");
    private static final By FORM_AUTH = By.xpath(".//*[@class='tab-body']");
    private UserMainPage userMainPage;


    @Test
    @Tag("Check_correct_Login_Password")
    public void LoginTest() {
        LoginPage loginPage = new LoginPage(driver).get();
        String name = null;
        $(FORM_AUTH).$(LOGIN_INPUT).shouldBe(and("", enabled, visible).because("Не найдена форма ввода email"))
                .click();

    }



    @Test
    @Tag("Check_correct_Login_Password")
    public void correctLoginTest() {
        LoginPage loginPage = new LoginPage(driver).get();
        userMainPage = loginPage.login();
        assertAll("Login Test",
                () -> assertTrue(loginPage.getMessageButton().exists(),
                        "Message button should be visible after login"),
                () -> assertTrue(loginPage.getNotificationsButton().exists(),
                        "Notifications button should be visible after login"),
                () -> assertTrue(loginPage.getGuestsButton().exists(),
                        "Guests button should be visible after login")
        );
    }

    @ParameterizedTest
    @Tag("Incorrect_Login_Test")
    @CsvSource({
            "qaa_test, test",
            "technopol32, test"
    })
    public void IncorrectLoginTest(String login, String password) {
        LoginPage loginPage = new LoginPage(driver).get();
        LoginPage.setName(login);
        LoginPage.setPassword(password);
        LoginPage.enterButton();
        Assertions.assertFalse(loginPage.checkIncorrectLogin(), "Авторизация не прошла");
    }

    @AfterEach
    public void setDown() {
        if (userMainPage != null) {
            userMainPage.logout();
        }
    }
}
