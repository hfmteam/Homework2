package WebTests.tests;

import WebTests.Pages.LoginPage;
import WebTests.Pages.UserMainPage;
import org.junit.jupiter.api.*;

import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;
import static java.time.Duration.ofMillis;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class UserMainPageTest extends BaseTest {
    private UserMainPage userMainPage;

    @BeforeEach
    public void setup() {
        LoginPage loginPage = new LoginPage(driver).get();
        userMainPage = loginPage.login();

    }

    @AfterEach
    public void logoutUser() {
        userMainPage.logout();
    }

    @Test
    @Tag("User")
    @DisplayName("copy User URL in profile & verification")
    public void copyUserURL() throws IOException, UnsupportedFlavorException {
        UserMainPage.openUserPage();
        String userURl;
        userURl = UserMainPage.copyUrl();
        Assertions.assertEquals("https://ok.ru/profile/586090035583?utm_campaign=web_share&utm_content=profile", userURl,
                "Ссылка скопирована неправильно");
        assertThatThrownBy(() ->
                webdriver().shouldHave(url("https://ok.ru/profile/586090035583?utm_campaign=web_share&utm_content=profile"), ofMillis(10)));

    }


}
