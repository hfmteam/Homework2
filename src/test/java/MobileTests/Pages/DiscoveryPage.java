package MobileTests.Pages;

import org.openqa.selenium.By;

import static MobileTests.Pages.LoginPage.TOOLBAR;
import static com.codeborne.selenide.Condition.hidden;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;


public class DiscoveryPage {
    private static final By SIDEBAR = By.xpath("//*[@id='the-sidebar']");
    private static final By SEARCH_FIELD = By.xpath("//*[@class='global-search-form-link']");
    private static final By FEED_ACTIVITY = By.xpath("//*[@aria-label='Лента активности']");
    private static final By GIFT_BUTTON = By.xpath("//*[@class='l-sidebar_i']");
    private static final By SEARCH_GIFT = By.xpath("//*[@id='PresentSearchFormField']");
    private static final By INPUT_GIFT = By.xpath("//*[@id='PresentSearchFormField']");
    private static final By GIFT_30_OK = By.xpath("//*[@aria-label='Описание подарка: [vip, вип, лучший, машина, car, крылья, белый]']");
    private static final By SEND_FRIEND_GIFT = By.xpath("//*[@id='send-present-friend-587302494817']");
    private static final By BACK_BUTTON = By.xpath("//*[@aria-label='Назад']");
    private static final By GIFT_FOR_YOURSELF = By.xpath("//*[@id='send-present-friend-586090035583']");
    private static final By LOGOUT_BUTTON = By.xpath("//*[@id='sidebar-logoff']");


    public DiscoveryPage() {
        checkDiscoveryPage();
    }

    public static boolean checkDiscoveryPage() {
        $(TOOLBAR).shouldBe(visible.because("TOOLBAR should be visible on Discovery Page"));
        $(SIDEBAR).shouldBe(visible.because("SIDEBAR should be visible on Discovery Page"));
        $(SEARCH_FIELD).shouldBe(visible.because("SEARCH_FIELD should be visible on Discovery Page"));
        $(FEED_ACTIVITY).shouldBe(visible.because("FEED_ACTIVITY should be visible on Discovery Page"));
        $(GIFT_BUTTON).shouldBe(visible.because("GIFT_BUTTON Page should be visible on Discovery Page"));
        return true;
    }


    public static void searchFieldGift(String word) {
        $(TOOLBAR).shouldBe(visible.because("TOOLBAR should be visible on Discovery Page"));
        $(SIDEBAR).shouldBe(visible.because("SIDEBAR should be visible on Discovery Page"));
        $(SEARCH_FIELD).shouldBe(visible.because("SEARCH_FIELD should be visible on Discovery Page"));
        $(FEED_ACTIVITY).shouldBe(visible.because("FEED_ACTIVITY should be visible on Discovery Page"));
        $(GIFT_BUTTON).shouldBe(visible.because("GIFT BUTTON Page should be visible on Discovery Page"))
                .click();
        $(SEARCH_GIFT).shouldBe(hidden
                        .because("The search GIFT field should be visible to clicking"))
                .click();
        $(INPUT_GIFT).shouldBe(visible
                        .because("INPUT GIFT field should be visible before setting value"))
                .setValue(word);
    }

    public static void sendGiftFriend() {
        $(GIFT_30_OK).shouldBe(visible.because("GIFT Car should be visible on Discovery Page"))
                .click();
        $(SEND_FRIEND_GIFT).shouldBe(visible.because("SEND FRIEND GIFT BUTTON should be visible on Discovery Page"))
                .click();
        $(BACK_BUTTON).shouldBe(visible.because("BACK BUTTON should be visible on Discovery Page"))
                .click();
    }

    public static void sendGiftForYourself() {
        $(GIFT_30_OK).shouldBe(visible.because("GIFT Car should be visible on Discovery Page"))
                .click();
        $(GIFT_FOR_YOURSELF).shouldBe(visible.because("GIFT FOR YOURSELF button Page should be visible on Discovery Page"))
                .click();
        $(BACK_BUTTON).shouldBe(visible.because("BACK BUTTON Page should be visible on Discovery Page"))
                .click();
    }

    public static void logout() {
        $(LOGOUT_BUTTON).shouldBe(visible.because("LOGOUT BUTTON should be visible on Discovery Page"))
                .click();

    }
}