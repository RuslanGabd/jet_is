package jet;

import java.util.List;
import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class MainPageJet {


    public MainPageJet openMainPageJet() {
        open("https://jet.su/");
        return this;
    }

    public MainPageJet openPage(String page) {
        $(".main-nav__wrapper").$(byText(page)).click();
        return this;
    }

    public MainPageJet verifyButtons(String btn) {
        $("button.btn").shouldHave(text(btn));
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

    public MainPageJet verifyPage(String text) {
        $(".intro__title-wrap").shouldHave(text(text));
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
