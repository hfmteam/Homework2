package WebTests.tests;

import WebTests.Pages.LoginPage;
import WebTests.Pages.MusicPage;
import WebTests.Pages.UserMainPage;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Music Test")

public class MusicPageTest extends BaseTest {

    String s = "Песня добавлена. Вам также может понравиться";
    private UserMainPage userMainPage;

    @BeforeEach
    public void setup() {
        LoginPage loginPage = new LoginPage(driver).get();
        userMainPage = loginPage.login();
    }
    @AfterEach
    public void logoutUser() {
        userMainPage.logout();
    }

    @Test
    @Tag("Music")
    @DisplayName("Play Music Test")
    public void playMusic() {
        UserMainPage.openMusic();
        MusicPage.setPlayMusic();
        Assertions.assertTrue(UserMainPage.openMusic(), "Музыка играет");
    }

    @Test
    @Tag("Music")
    @DisplayName("Add music to favourite")
    public void addMusic() {
        UserMainPage.openMusic();
        MusicPage.addFavouriteMusic();
        String textFavourite = MusicPage.checkAddFavouriteMusic();
        Assertions.assertEquals("Песня добавлена. Вам также может понравиться", textFavourite);
    }

    @Test
    @Tag("Music")
    @DisplayName("Off Volume Music")
    public void offVolume() {
        UserMainPage.openMusic();
        MusicPage.setPlayMusic();
        MusicPage.offVolumeMusic();
        assertTrue(MusicPage.checkoffVolumeMusic());
    }

}