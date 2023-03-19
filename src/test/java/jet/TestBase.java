package jet;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import jet.config.WebDriverConfig;
import jet.config.WebDriverProvider;
import jet.helpers.Attach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public abstract class TestBase {

    MainPageJet mainPageJet = new MainPageJet();
    private static WebDriverConfig config;

    @BeforeAll
    static void beforeAll() {

        WebDriverProvider provider = new WebDriverProvider();

    }

    @BeforeEach
    public void helpersConfig() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        Selenide.clearBrowserCookies();

    }

    @AfterEach
    public void tearDown() {
        Attach.screenShotAs("Test result");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }

}