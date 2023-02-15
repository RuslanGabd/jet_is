package jet;

import org.junit.jupiter.params.provider.Arguments;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class MainPageJet {
    private final String TEXT = "Комплексное предложение по импортозамещению";
    private final String TEXT2 = "Оставить заявку";

    public MainPageJet openmainPageJet() {
        open("https://jet.su/");
        $(".intro__title-wrap").shouldHave(text(TEXT));
        return this;
    }

    public MainPageJet pageContacts() {
        $(".main-nav__wrapper").$(byText("Контакты")).click();
        return this;
    }

    public MainPageJet verifyButtons() {
        $("button.btn").shouldHave(text(TEXT2));
        return this;
    }


    public MainPageJet pageCareer() {
        $(".main-nav__wrapper").$(byText("Карьера")).click();
        return this;
    }

    public MainPageJet verifyPageCareer(List<String> list) {
        $("ul.second-nav__list").$$("li.second-nav__item").contains(list);
        return this;
    }

    public MainPageJet logoSite() {
        $("a.header__logo").click();
        return this;
    }

    public MainPageJet verifyMainPage() {
        $(".intro__title-wrap").shouldHave(text(TEXT));
        return this;
    }



    public MainPageJet verifyHeaderMenuItems(List<String> buttons) {
        $(".main-nav__post-wrapper").$$("li.main-nav__item").shouldHave(texts(buttons));
        return this;
    }

    public MainPageJet  hoverMenuItem(String menuItem) {
        $("div.help-accordion__head").$(byText(menuItem)).hover();
        return this;
    }

    public MainPageJet verifyProduct(String productForm) {
        $x("(//div[@class='help-accordion__content-wrapper'])").shouldHave(text(productForm));
        return this;
    }
}
