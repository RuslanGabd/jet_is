package jet;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$x;

public class MainPageJet {

    private final String TEXT = "Инвенторная система бронирования грузовых авиперевозок";
    private final String TEXT2 = "ООО «АйТи Авиа»";
    private final String TEXT3 = "CARRIER.AERO";
    private final String TEXT4 = "AGENCY.AERO";
    private final String TEXT5 = "PORT.AERO";
    private final String TEXT6 = "EDIFLY - Innovative Software SARL";

    public MainPageJet openPageItAvia() {
        open("https://www.itavia.ru/");
        $("#comp-jmjesc8m").shouldHave(text(TEXT));
        return this;
    }

    public MainPageJet requisites() {
        $("#SITE_FOOTER").$(byText("Реквизиты")).click();
        return this;
    }

    public MainPageJet verifyRequisites() {
        $("#comp-ju2i994o").shouldHave(text(TEXT2));
        return this;
    }

    public MainPageJet careerPage() {
        $("#SITE_HEADER").$("#comp-jmqkhoot").click();
        return this;
    }

    public MainPageJet verifyCareerAero() {
        $("[data-testid=richTextElement]").shouldHave(text(TEXT3));
        return this;
    }

    public MainPageJet agencyPage() {
        $("#SITE_HEADER").$("#comp-jmqkixgz").click();
        return this;
    }

    public MainPageJet verifyAgencyAero() {
        $("#comp-jmsuqhqb").shouldHave(text(TEXT4));
        return this;
    }

    public MainPageJet portPage() {
        $("#SITE_HEADER").$("#comp-jmqkj9sy").click();
        return this;
    }

    public MainPageJet verifyPortAero() {
        $("#comp-jmsv1ae2").shouldHave(text(TEXT5));
        return this;
    }

    public MainPageJet ediflyPage() {
        $("#SITE_HEADER").$("#comp-jmqkjioj").click();
        return this;
    }

    public MainPageJet verifyEdiflyAero() {
        $("#comp-jmsswdte").shouldHave(text(TEXT6));
        return this;
    }

    public MainPageJet logoSite() {
        $("#comp-kfmr2u24").click();
        return this;
    }

    public MainPageJet verifyMainPage() {
        $("#comp-jmjesc8m").shouldHave(text(TEXT));
        return this;
    }
}
