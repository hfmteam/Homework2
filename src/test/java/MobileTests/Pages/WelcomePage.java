package MobileTests.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.LoadableComponent;

import static WebTests.tests.BaseTest.driver;
import static com.codeborne.selenide.Condition.clickable;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class WelcomePage extends LoadableComponent<WelcomePage> {
    private static final By PROMO_TITLE = By.xpath("//*[@class='login-landing-promo_title']");
    private static final By LOGIN_BUTTON = By.xpath("//*[@name='loginButton']");


    public WelcomePage() {
        checkWelcomePage();
    }

    private void checkWelcomePage() {
        $(PROMO_TITLE).shouldBe(visible.because("PROMO TITLE should be visible on Welcome Page"));
        $(LOGIN_BUTTON).shouldBe(clickable.because("LOGIN BUTTON should be clickable on Welcome Page"));
    }

    public static WelcomePage clickButton() {
        $(LOGIN_BUTTON).shouldBe(clickable
                        .because("LOGIN BUTTON should be clickable on Welcome Page"))
                .click();
        return null;
    }

    public void load() {
        driver.get("https://m.ok.ru/discovery");
    }

    @Override
    protected void isLoaded() throws Error {

    }
}