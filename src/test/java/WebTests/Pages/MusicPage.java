package WebTests.Pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.hidden;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class MusicPage {
    private static final By PLAY_MUSIC = By.xpath("//*[contains(@class,'play __active')]");
    private static final By OFF_VOLUME = By.xpath("//*[contains(@class,'wm-player_action-volume')]");
    private static final By ON_VOLUME = By.xpath("//*[@data-l='t,unmute']");
    private static final By ADD_MUSIC = By.xpath("//*[contains(@class,'action __add')]");
    private static final By MUSIC_PAGE = By.xpath("//*[@id='music_layer_holder']");

    public MusicPage() {
        checkMusicPage();
    }

    public static void checkMusicPage() {
        $(MUSIC_PAGE).shouldBe(visible.because("MUSIC PAGE should be visible on music page"));
    }

    public static void setPlayMusic() {
        $(PLAY_MUSIC).shouldBe(hidden.because("The play music button should be hidden on music page")).click();
    }

    public static void offVolumeMusic() {
        $(OFF_VOLUME).shouldBe(visible.because("Music mute button should be visible on music page")).click();
    }

    public static boolean checkoffVolumeMusic() {
        $(ON_VOLUME).shouldBe(visible.because("Music unmute button should be visible on music page"));
        return true;
    }

    public static void addFavouriteMusic() {
        $(ADD_MUSIC).shouldBe(visible.because("Add music favourite button should be visible on music page")).click();
    }

    public static String checkAddFavouriteMusic() {
        return $(byText("Песня добавлена. Вам также может понравиться")).text();
    }


}



