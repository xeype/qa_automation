package pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MainPage {

    static By images = By.tagName("img");
    static By categories = By.className("menu-categories__link");
    static By sidebar = By.xpath("//aside/main-page-sidebar/div[3]/h3");
    static By socialNetworks = By.xpath("//ul [@class='socials__list']//a/..");
    static By burgerMenu = By.className("header__button");


    public static void findImages() {
        $$(images).shouldHave(CollectionCondition.sizeGreaterThan(10));
    }

    public static void findCatalogueElement(String category) {
        SelenideElement selectedCategory = $$(categories).stream().filter(s -> s.getText().contains(category))
                .findFirst().orElseThrow(RuntimeException::new);
        selectedCategory.click();
    }

    public static int findSocialNetworks() {
        $(burgerMenu).click();
        $(sidebar).should(Condition.ownText("Мы в социальных сетях"));
        return $$(socialNetworks).size();
    }
}
