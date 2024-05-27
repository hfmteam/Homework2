package MobileTests.Tests;

import MobileTests.Pages.DiscoveryPage;
import MobileTests.Pages.LoginPage;
import MobileTests.Pages.WelcomePage;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

@DisplayName("Testing a Discovery Page")
public class DiscoveryPageTests extends BaseTest {
    private WebDriver driver;
    private DiscoveryPage discoveryPage;

    @BeforeEach
    public void setup() {
        Selenide.open("/");
        WelcomePage welcomePage = new WelcomePage();
        WelcomePage.clickButton();
        LoginPage loginPage = new LoginPage(driver).get();
        loginPage.login();
        Assertions.assertTrue(DiscoveryPage.checkDiscoveryPage(), "Авторизовались");
        DiscoveryPage.checkDiscoveryPage();
        String word = "car";
        DiscoveryPage.searchFieldGift(word);
    }

    @AfterEach
    public void closeBro() {
        closeBrowser();
    }

    @Test
    @Tag("СheckingGivingAGiftToAFriend")
    public void checkGiftFriend() {
        DiscoveryPage.sendGiftFriend();
    }

    @Test
    @Tag("СheckingGivingAGiftToYourself")
    public void checkGiftMe() {
        DiscoveryPage.sendGiftForYourself();
    }

    @AfterClass
    public void closeUp() {
        DiscoveryPage.logout();
        driver.close();
        System.out.println("The close_up process is completed");
    }


}