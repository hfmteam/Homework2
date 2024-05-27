package MobileTests.Pages;

import MobileTests.Utils.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.LoadableComponent;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends LoadableComponent<LoginPage> {
    static final By TOOLBAR = By.xpath("//*[@id='head']");
    private static final By LOGIN_WINDOW = By.xpath("//*[@class='login-page-fullscreen']");
    private static final By LOGIN_INPUT = By.xpath("//*[@id='field_login']");
    private static final By PASSWORD_INPUT = By.xpath("//*[@id='field_password']");
    private static final By LOGIN_BUTTON = By.xpath("//*[@name='button_login']");
    private static final By LOGIN_ERROR_TEXT = By.xpath("//*[@id='ferr']");
    private static WebDriver driver;
    private final User user;

    public LoginPage(WebDriver driver) {
        checkLoginPage();
        LoginPage.driver = driver;
        this.user = new User("technopol32", "technopolisPassword");
    }

    @Override
    protected void load() {
    }

    @Override
    protected void isLoaded() throws Error {

    }

    public static void checkLoginPage() {
        $(TOOLBAR).shouldBe(visible.because("TOOLBAR should be visible on Login Page"));
        $(LOGIN_WINDOW).shouldBe(visible.because("LOGIN WINDOW should be visible on Login Page"));
        $(LOGIN_INPUT).shouldBe(visible.because("LOGIN INPUT should be visible on Login Page"));
        $(PASSWORD_INPUT).shouldBe(visible.because("PASSWORD INPUT Page should be visible on Login Page"));
    }

    public void login() {
        $(LOGIN_INPUT).shouldBe(visible.because("Login field should be visible for users to set login"))
                .setValue(user.getLogin());
        $(PASSWORD_INPUT).shouldBe(visible.because("Password field should be visible for users to set password"))
                .setValue(user.getPassword());
        $(LOGIN_BUTTON).shouldBe(visible.because("Login button should be visible to enter"))
                .click();
    }

    public static void setName(String name) {
        $(LOGIN_INPUT).shouldBe(visible.because("Login field should be visible for users to set login")).setValue(name);
        $(LOGIN_INPUT).shouldHave(value(name));
    }

    public static void setPassword(String password) {
        $(PASSWORD_INPUT).shouldBe(visible.because("Password field should be visible for users to set password")).setValue(password);
        $(PASSWORD_INPUT).shouldHave(value(password));
    }

    public static void enterButton() {
        $(LOGIN_BUTTON).shouldBe(visible.because("Login button should be visible to enter")).click();
    }

    public boolean checkIncorrectLogin() {
        $(LOGIN_ERROR_TEXT).shouldBe(visible.because("The TEXT OF THE LOGIN ERROR should be on the incorrect authorization page")).shouldHave(text("Неверный логин или пароль"));
        return false;
    }

}
