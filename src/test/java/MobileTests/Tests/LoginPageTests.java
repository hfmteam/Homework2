package MobileTests.Tests;

import MobileTests.Pages.DiscoveryPage;
import MobileTests.Pages.LoginPage;
import MobileTests.Pages.WelcomePage;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeSuite;

@DisplayName("Testing a login auth")
public class LoginPageTests extends BaseTest {
    private WebDriver driver;

    @BeforeSuite
    public void checkLoginPage() {
        LoginPage.checkLoginPage();
        WelcomePage.clickButton();
    }

    @Test
    @Tag("CheckСorrectLoginPassword")
    public void correctLoginTest() {
        WelcomePage.clickButton();
        LoginPage loginPage = new LoginPage(driver).get();
        loginPage.login();
        Assertions.assertTrue(DiscoveryPage.checkDiscoveryPage(), "Авторизовались");
        DiscoveryPage.logout();
    }

    @ParameterizedTest
    @Tag("IncorrectLoginTest")
    @CsvSource({
            "qaa_test, test",
            "technopol32, test"
    })
    public void IncorrectLoginTest(String login, String password) {
        WelcomePage.clickButton();
        LoginPage loginPage = new LoginPage(driver).get();
        LoginPage.setName(login);
        LoginPage.setPassword(password);
        LoginPage.enterButton();
        Assertions.assertFalse(loginPage.checkIncorrectLogin(), "Авторизация не прошла");
        Selenide.open("/");
    }

    @AfterClass
    public void closeUp() {
        driver.close();
        System.out.println("The close_up process is completed");
    }


}