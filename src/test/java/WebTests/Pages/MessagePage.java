package WebTests.Pages;

import WebTests.utils.ElementCollectionWrapper;
import WebTests.utils.MessageToolbar;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MessagePage {
    private static final By CHAT_LIST = By.xpath(".//msg-chats-list-item");
    private static final By RESULTS_LIST = By.xpath(".//msg-search-results-item");
    private static final By MESSAGE_LIST = By.xpath("//msg-message-list");
    private static final By MESSAGE = By.xpath(".//msg-message");
    private static final By MESSAGE_PAGE = By.xpath("//*[@id='hook_Block_MessagesLayer']");
    private static final By CHAT_INPUT = By.xpath(".//*[@data-tsid='chat-theme-input']");
    private static final By PROFILE_FRIEND = By.xpath("//*[contains(@data-tsid-id,'DIALOG')]");
    private static final By OPEN_INPUT_MESSAGE = By.xpath(".//*[@data-tsid='write_msg_input-input']");
    private static final By SEND_MESSAGE = By.xpath("//*[contains(@class,'primary-okmsg')]");
    private static final By CREATE_NEW_CHAT_BUTTON = By.xpath(".//*[@data-tsid='finish_create_chat_button']");
    private static final By CHAT_INFORMATION_BUTTON = By.xpath(".//*[@data-tsid='chat_info_button']");
    private static final By REMOVE_CHAT_BUTTON = By.xpath(".//*[@data-tsid='remove-dialog-btn']");
    private static final By REMOVE_BUTTON = By.xpath(".//*[@data-tsid='confirm-primary']");
    private static final By MESSAGE_CHECKBOX = By.xpath(".//*[@data-l='t,selectMultiple']");
    private static final By REMOVE_MESSAGE_BUTTON = By.xpath(".//*[@data-tsid='control-remove']");
    private final MessageToolbar messageToolbar = new MessageToolbar();

    public MessagePage() {
        checkOpenMessenger();
    }

    private void checkOpenMessenger() {
        messageToolbar.getHomeButton().shouldBe(visible
                .because("The home button should be visible"));
        messageToolbar.getPlusButton().shouldBe(visible
                .because("The plus button should be visible"));
        $(MESSAGE_PAGE).shouldBe(visible.because("MESSAGE PAGE should be visible on MESSAGE PAGE"));
    }

    public MessagePage searchFriends(String friendName) {
        messageToolbar.getSearchChatInput().shouldBe(visible
                        .because("The search chat button should be visible before clicking"))
                .click();
        messageToolbar.getSearchChatInput().shouldBe(visible
                        .because("The search chat button should be visible before setting value"))
                .setValue(friendName);
        return this;
    }

    public MessagePage createChat(String name) {
        messageToolbar.getHomeButton().
                shouldBe(visible.because("The home button should be visible before clicking")).click();
        messageToolbar.getPlusButton().
                shouldBe(visible.because("The plus button should be visible before clicking")).click();
        messageToolbar.getCreateChatButton().shouldBe(visible
                .because("The create chat button should be visible before clicking")).click();
        $(CHAT_INPUT).shouldBe(visible
                .because("The chat input should be visible before setting value")).setValue(name);
        $(CREATE_NEW_CHAT_BUTTON).shouldBe(visible
                .because("The create new chat button should be visible before clicking")).click();
        return this;
    }

    public MessagePage searchChat(String searchLine) {
        messageToolbar.getSearchChatInput().shouldBe(visible
                .because("The search chat button should be visible before clicking")).click();
        messageToolbar.getSearchChatInput().shouldBe(visible
                .because("The search chat button should be visible before setting value")).setValue(searchLine);
        return this;
    }

    public MessagePage sendMessageFriend(String text) {
        $(PROFILE_FRIEND).click();
        $(OPEN_INPUT_MESSAGE).shouldBe(visible.because("OPEN INPUT MESSAGE should be visible to click on message page")).sendKeys(text);
        $(SEND_MESSAGE).shouldBe(visible.because("The send message button should be visible before clicking")).click();
        return this;
    }

    public MessagePage removeChat() {
        $(CHAT_INFORMATION_BUTTON).shouldBe(visible
                .because("The chat information button should be visible before clicking")).click();
        $(REMOVE_CHAT_BUTTON).shouldBe(visible
                .because("The remove chat button should be visible before clicking")).click();
        $(REMOVE_BUTTON).shouldBe(visible
                .because("The remove button should be visible before clicking")).click();
        return this;
    }

    public MessagePage removeMessage() {
        $(MESSAGE_CHECKBOX).shouldBe(visible
                .because("The message checkbox should be visible before clicking")).click();
        $(REMOVE_MESSAGE_BUTTON).shouldBe(visible
                .because("The remove message button should be visible before clicking")).click();
        $(REMOVE_BUTTON).shouldBe(visible
                .because("The remove button should be visible before clicking")).click();
        return this;
    }

    public ElementCollectionWrapper getChatList() {
        return new ElementCollectionWrapper($$(CHAT_LIST));
    }

    public ElementCollectionWrapper getResultsList() {
        return new ElementCollectionWrapper($$(RESULTS_LIST));
    }

    public ElementCollectionWrapper getMessageList() {
        return new ElementCollectionWrapper($$(MESSAGE_LIST));
    }

    public ElementCollectionWrapper getMessage() {
        return new ElementCollectionWrapper($$(MESSAGE));
    }


}



