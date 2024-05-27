package MobileTests.Tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Browsers.CHROME;
import static com.codeborne.selenide.WebDriverRunner.clearBrowserCache;

public abstract class BaseTest {
    protected static WebDriver driver;

    @BeforeAll
    public static void start() {
        System.setProperty("selenide.browser", "Chrome");
        Configuration.browser = CHROME;
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://m.ok.ru/discovery";
        Selenide.open("/");
    }

    @AfterAll
    public static void closeBrowser() {
        clearBrowserCache();
        Selenide.closeWebDriver();
    }
}

