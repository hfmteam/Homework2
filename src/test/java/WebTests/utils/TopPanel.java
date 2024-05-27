package WebTests.utils;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class TopPanel {
    private static final By MESSAGE_BUTTON = By.xpath(".//*[@data-l='t,messages']");
    private static final By USER_PROFILE_SETTINGS = By.xpath(".//*[@aria-controls='user-dropdown-menu']");

    public TopPanel() {
        checkTopPanel();
    }

    private void checkTopPanel() {
        $(MESSAGE_BUTTON).shouldBe(visible.because("The message button should be visible"));
        $(USER_PROFILE_SETTINGS).shouldBe(visible.because("The profile settings button should be visible"));
    }

    public SelenideElement getMessageButton() {
        return $(MESSAGE_BUTTON);
    }

    public SelenideElement getProfileSettingsButton() {
        return $(USER_PROFILE_SETTINGS);
    }
}
