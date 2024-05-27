package WebTests.tests;

import WebTests.Pages.LoginPage;
import WebTests.Pages.MessagePage;
import WebTests.Pages.UserMainPage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.visible;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Message Page Test")
public class MessengerTest extends BaseTest {
    private final static int NUMBER_CHATS = 2;
    private final String CHAT_NAME = UUID.randomUUID().toString();
    private final String FRIEND_NAME = "technopol42";
    private final List<String> chatNames = new ArrayList<>();
    private MessagePage messagePage;
    private UserMainPage userMainPage;

    @BeforeEach
    public void setup() {
        LoginPage loginPage = new LoginPage(driver).get();
        userMainPage = loginPage.login();
        messagePage = userMainPage.goToMessage();
    }

    @AfterEach
    public void setDown() {
        if (messagePage.getChatList().searchElement(CHAT_NAME).exists()) {
            removeChat();
        }

        removeMultipleChats();

        if (userMainPage != null) {
            userMainPage.logout();
        }
    }

    @Test
    @Tag("Chat")
    @DisplayName("Create Chat Test")
    public void createChatTest() {
        messagePage.createChat(CHAT_NAME);
        assertTrue(messagePage.getChatList().searchElement(CHAT_NAME).shouldBe(Condition.exist).exists(),
                "Chat must exist after creation");
    }

    @TestFactory
    @Tag("Chat")
    @DisplayName("Create Multiple Chats Test")
    Stream<DynamicTest> createMultipleChatsTest() {
        messagePage.createChat(CHAT_NAME);
        generateRandomChatNames(NUMBER_CHATS);
        return chatNames.stream().map(chatName ->
                DynamicTest.dynamicTest("Chat must exist after creation: " + chatName, () -> {
                    messagePage.createChat(chatName);
                    assertTrue(messagePage.getChatList().searchElement(chatName).shouldBe(Condition.exist).exists());
                })
        );
    }

    @Test
    @Tag("Search")
    @DisplayName("Search Friend In Messenger")
    public void searchFriends() {
        messagePage.searchFriends(FRIEND_NAME);
        assertTrue(messagePage.getResultsList().searchElement(FRIEND_NAME).exists(),
                "Chat should be found after searching");
    }

    @ParameterizedTest(name = "Sending a message with the text: {0}.")
    @ValueSource(strings = {"Привет", "Как дела?", "Автотест работает"})
    @Tag("Message")
    @DisplayName("Send Message friend")
    public void sendMessageFriend(String messageText) {
        messagePage.searchFriends(FRIEND_NAME).sendMessageFriend(messageText);
        assertTrue(messagePage.getMessageList().searchElement(messageText).exists(),
                "Message must exist after sending");
    }

    @Test
    @Tag("Message")
    @DisplayName("Remove Message Test")
    public void removeMessageTest() {
        String messageText = UUID.randomUUID().toString();
        messagePage.searchFriends(FRIEND_NAME).sendMessageFriend(messageText);
        messagePage.getMessage().searchElement(messageText).shouldBe(visible).hover();
        messagePage.removeMessage();
        Selenide.refresh();
        assertFalse(messagePage.getMessageList().searchElement(messageText).exists(),
                "Message should not exist after deletion");
    }

    @DisplayName("Functions")
    private void removeChat() {
        messagePage.searchChat(CHAT_NAME);
        messagePage.getResultsList().searchElement(CHAT_NAME)
                .shouldBe(visible.because("The chat should be visible before clicking")).click();
        messagePage.removeChat();
    }

    private void removeMultipleChats() {
        for (String chatName : chatNames) {
            if (messagePage.getChatList().searchElement(chatName).exists()) {
                messagePage.searchChat(chatName);
                messagePage.getResultsList().searchElement(chatName)
                        .shouldBe(visible.because("The chat should be visible before clicking")).click();
                messagePage.removeChat();
            }
        }
    }

    private void generateRandomChatNames(int count) {
        for (int i = 0; i < count; i++) {
            chatNames.add(UUID.randomUUID().toString());
        }
    }

}
