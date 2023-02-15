package jet;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static io.qameta.allure.Allure.step;

public class WebTests extends TestBase {

    static Stream<Arguments> headerPressCenter() {
        return Stream.of(Arguments.of(List.of("Услуги и решения", "Проекты",
                "Пресс-центр", "О нас", "Карьера", "Контакты")));
   }

    List<String> listForCareer = Arrays.asList("ВАКАНСИИ И СТАЖИРОВКИ", "КАРЬЕРА В КОМПАНИИ", "ПОЧЕМУ МЫ, НАША ЖИЗНЬ", "ОТЗЫВЫ");

    @Tag("jet")
    @DisplayName("Страница Контакты содержит Кнопку 'Оставить заявку'")
    @Owner("RuslanG")
    @Test
    void companyDetails() {

        step("Открытие главной страницы", () -> {
            mainPageJet.openmainPageJet();
        });
        step("Открытие страницы с контактами", () -> {
            mainPageJet.pageContacts();
        });
        step("Проверка, наличие кнопки 'Оставить заявку'", () -> {
            mainPageJet.verifyButtons();
        });
    }

    @Tag("jet")
    @Owner("RuslanG")
    @MethodSource("headerPressCenter")
    @ParameterizedTest(name = "В верхнем меню отображаются кнопки {0}")
    void checkTopMenu(List<String> buttons) {
        step("Перейти на главную страницу", () -> {
            mainPageJet.openmainPageJet();
        });
        step("Проверить, что в верхнем меню есть кнопки {0}", () -> {
            mainPageJet.verifyHeaderMenuItems(buttons);
        });
    }

    @Tag("jet")
    @DisplayName("Страница 'Карьера' содержит ссылки на разделы страницы")
    @Owner("RuslanG")
    @Test
    void carrierJet() {
        step("Открытие главной страницы", () -> {
            mainPageJet.openmainPageJet();
        });
        step("Открытие страницы 'Карьера'", () -> {
            mainPageJet.pageCareer();
        });
        step("Проверка, что страница содержит меню на 5 разделов страницы", () -> {
            mainPageJet.verifyPageCareer(listForCareer);
        });
    }

    @Tag("jet")
    @CsvSource({"Пресс-центр, Новости"})
    @ParameterizedTest(name = "В разделе {0} есть строка {1}")
    public void checkPartNews(String menuItem, String productForm) {
        step("Перейти на главную страницу", () -> {
            mainPageJet.openmainPageJet();
        });
        step("Навести курсор на раздел {0}", () -> {
            mainPageJet.hoverMenuItem(menuItem);
        });
        step("Проверить, что в каталоге есть формат {1}", () -> {
            mainPageJet.verifyProduct(productForm);
        });
    }

    @Tag("jet")
    @DisplayName("Переход на главную страницу при клике на лого сайта")
    @Owner("RuslanG")
    @Test
    void goMainPageByLogo() {
        step("Открытие главной страницу", () -> {
            mainPageJet.openmainPageJet();
        });
        step("Открытие страницы с реквизитами", () -> {
            mainPageJet.pageContacts();
        });
        step("Нажатие на логотип сайта", () -> {
            mainPageJet.logoSite();
        });
        step("Проверка, что переход осуществился на главную страницу", () -> {
            mainPageJet.verifyMainPage();
        });

    }
}
