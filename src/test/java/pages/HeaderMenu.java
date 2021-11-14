package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class HeaderMenu {

    static By authButton = By.xpath("//rz-header/header/div/div/ul/li[3]/rz-user/button");
    static By loginField = By.id("auth_email");
    static By passwordField = By.id("auth_pass");
    static By loginModal = By.xpath("//app-root/single-modal-window/div[2]");
    static By loginButton = By.xpath("/html/body/app-root/single-modal-window/div[2]/div[2]/rz-user-identification/rz-auth/div/form/fieldset/div[5]/button[1]");
    static By loginError = By.xpath("//div[@class='form__row validation_type_error']/p");
    static By findField = By.name("search");
    static By findButton = By.xpath("//rz-header/header/div/div/div/form/button");
    static By categoryElement = By.xpath("//rz-category/div/main/div[1]/div/h1");
    static By logo = By.xpath("//img[@alt='Rozetka Logo']");
    static By premiumButton = By.className("premium-button");
    static By premiumLabelText = By.className("premium-button__label");
    static By premiumHeaderText = By.className("premium-hero__heading-text");
    static By languageUA = By.xpath("//*[text()=' UA ']");
    static By languageRU = By.xpath("//*[text()=' RU ']");
    static By cart = By.xpath("//rz-cart/button");
    static By shoppingCart = By.xpath("//rz-shopping-cart/div/div//img");
    static By cartText = By.xpath("//rz-shopping-cart/div/div//h4");

    public static void logIn(String login, String password) {
        $(authButton).click();
        $(loginModal).should(Condition.visible);
        $(loginField).sendKeys(login);
        $(passwordField).sendKeys(password);
    }

    public static void validateLogInAlert() {
        $(loginButton).click();
        $(loginError).shouldBe(Condition.visible);
    }

    public static void findProduct(String productName) {
        $(findField).click();
        $(findField).sendKeys(productName);
        $(findButton).click();
        $(categoryElement).should(Condition.ownText(productName));
    }

    public static void findLogo() {
        $(logo).should(Condition.visible);
    }

    public static void checkPremiumButton() {
        $(premiumButton).should(Condition.visible);
        $(premiumLabelText).should(Condition.ownText("Попробуйте"));
        $(premiumButton).click();
        $(premiumHeaderText).should(Condition.ownText(" Premium "));
    }

    public static void switchLanguageToUA() {
        $(languageUA).click();
        $(By.className("main-slider__pagination-item")).shouldHave(Condition.text(" Всі акції "));
    }

    public static void switchLanguageToRU() {
        $(languageRU).click();
        $(By.className("main-slider__pagination-item")).shouldHave(Condition.text(" Все акции "));
    }

    public static void cartIsEmpty() {
        $(cart).click();
        $(shoppingCart).should(Condition.visible);
        $(cartText).shouldHave(Condition.ownText(" Корзина пуста "));
    }
}
