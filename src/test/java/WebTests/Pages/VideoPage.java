package WebTests.Pages;


import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.hidden;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;


public class VideoPage {

    private static final By PLAY_VIDEO_PREVIEW = By.xpath("//div[@class='h-mod video-card_preview']");
    private static final By VIDEO_PANEL = By.xpath("//*[@id='listBlockPanelVideoUniversalContentBlock']");

    public VideoPage() {
        checkVideoPage();
    }

    public static void checkVideoPage() {
        $(VIDEO_PANEL).shouldBe(visible);
    }

    public static VideoPlayerPage openVideoPlayer() {
        $(PLAY_VIDEO_PREVIEW).shouldBe(hidden.because("PLAY VIDEO PREVIEW button should be hidden on video page")).click();
        return new VideoPlayerPage();

    }

}
