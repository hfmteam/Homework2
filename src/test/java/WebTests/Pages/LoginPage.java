package WebTests.Pages;

import WebTests.utils.User;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.LoadableComponent;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;


public class LoginPage extends LoadableComponent<LoginPage> {
    // private static final By LOGIN_INPUT = By.xpath("//*[@id='field_email']");
    private static final By LOGIN_INPUT = By.xpath("//*[@name='st.email']");
    private static final By PASSWORD_INPUT = By.xpath("//*[@id='field_password']");
    private static final By LOGIN_BUTTON = By.xpath("//input[@class='button-pro __wide']");
    private static final By NOTIFICATIONS_BUTTON = By.xpath(".//*[@data-l='t,notifications']");
    private static final By LOGIN_ERROR_TEXT = By.xpath("//div[@class='input-e login_error']");
    private static final By GUESTS_BUTTON = By.xpath(".//*[@data-l='t,guests']");
    private static final By BUTTON_AUTH = By.xpath("//*[@data-l='t,login_tab']");
    // private static final By FORM_AUTH = By.xpath("//*[contains(@class,'tab-body')]");
    private static final By FORM_AUTH = By.xpath("//*[@class='tab-body']");
    private static final By OPEN_MESSENGER_BUTTON = By.xpath("//*[@id='msg_toolbar_button']");
    private final WebDriver driver;
    private final User user;


    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.user = new User("technopol32", "technopolisPassword");
    }

    public static void setName(String name) {
        $(FORM_AUTH).shouldBe(visible.because("Authorization form should be on login page"));
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

    public UserMainPage login() {
        $(LOGIN_INPUT).shouldBe(visible.because("Login field should be visible for users to set login"))
                .setValue(user.getLogin());
        $(PASSWORD_INPUT).shouldBe(visible.because("Password field should be visible for users to set password"))
                .setValue(user.getPassword());
        $(LOGIN_BUTTON).shouldBe(visible.because("Login button should be visible to enter"))
                .click();
        return new UserMainPage();
    }

    public SelenideElement getMessageButton() {
        return $(OPEN_MESSENGER_BUTTON);
    }

    public SelenideElement getNotificationsButton() {
        return $(NOTIFICATIONS_BUTTON);
    }

    public SelenideElement getGuestsButton() {
        return $(GUESTS_BUTTON);
    }

    @Override
    protected void load() {
        driver.get("https://ok.ru/");
    }

    @Override
    protected void isLoaded() throws Error {
        checkLoginPage();
    }

    private void checkLoginPage() {
        $(LOGIN_INPUT).shouldBe(visible.because("Login field should be visible on login page"));
        $(PASSWORD_INPUT).shouldBe(visible.because("Password field should be visible on login page"));
        $(LOGIN_BUTTON).shouldBe(visible.because("Login button should be visible to enter"));
        $(BUTTON_AUTH).shouldBe(visible.because("Authorization button should be on login page"));
        $(FORM_AUTH).shouldBe(visible.because("Authorization form should be on login page"));
    }

    public boolean checkIncorrectLogin() {
        $(LOGIN_ERROR_TEXT).shouldBe(visible.because("The TEXT OF THE LOGIN ERROR should be on the incorrect authorization page")).shouldHave(text("Неправильно указан логин и/или пароль"));
        return false;
    }

}