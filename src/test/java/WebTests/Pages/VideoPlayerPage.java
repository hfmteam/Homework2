package WebTests.Pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class VideoPlayerPage {

    private static final By CLOSE_VIDEO = By.xpath("//*[@id='vpl_close']");
    private static final By CHECK_NAME_VIDEO = By.xpath("//*[contains(@class,'vp-layer-info_h textWrap')]");
    private static final By TOGGLE_LIKE = By.xpath("//*[contains(@class,'widget_w')]");
    private static final By VIDEO_PLAYER = By.xpath("//*[@id='vp_cnt']");
    private static final By SCREEN_VIDEO_PLAYER = By.xpath("//*[@id='VideoAutoplayPlayerE']");


    public VideoPlayerPage() {
        checkVideoPlayerPage();
    }

    public static void checkVideoPlayerPage() {
        $(VIDEO_PLAYER).shouldBe(visible.because("VIDEO PLAYER should be visible on video player page"));
    }

    public static void pauseVideo() {
        $(VIDEO_PLAYER).shouldBe(visible.because("VIDEO PLAYER should be visible on video player page"));
        $(SCREEN_VIDEO_PLAYER).shouldBe(visible.because("SCREEN VIDEO PLAYER should be visible to click on video player page")).click();
    }

    public static void likeVideo() {
        $(VIDEO_PLAYER).shouldBe(visible.because("VIDEO PLAYER should be visible on video player page"));
        $(TOGGLE_LIKE).shouldBe(visible.because("TOGGLE LIKE should be visible to click on video player page")).click();
    }

    public static boolean checkLikeVideo() {
        $(TOGGLE_LIKE).shouldBe(visible.because("TOGGLE LIKE should be visible on video player page"));
        return true;
    }

    public static void closeVideoPlayer() {
        $(VIDEO_PLAYER).shouldBe(visible.because("VIDEO PLAYER should be visible on video player page"));
        $(CLOSE_VIDEO).shouldBe(visible.because("CLOSE_VIDEO button should be visible to click on video player page")).click();
    }


    public static boolean checkOpenVideo() {
        $(CHECK_NAME_VIDEO).shouldBe(visible.because("NAME VIDEO should be visible on video player page"));
        return true;
    }


}
