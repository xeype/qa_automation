package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ProductPage {

    static By addToCartViaProductPage = By.xpath("//*[@id=\"#scrollArea\"]/div[1]/div[2]/rz-product-main-info/div[2]/div/ul/li[1]/app-product-buy-btn/app-buy-button/button");
    static By cartReceiptSum = By.className("cart-receipt__sum-price");
    static By increaseAmountOfProductsButton = By.xpath("/html/body/app-root/single-modal-window/div[2]/div[2]/rz-shopping-cart/div/ul/li/rz-cart-product/div/div[2]/rz-cart-counter/div/button[2]");
    static By amountOfProducts = By.xpath("/html/body/app-root/single-modal-window/div[2]/div[2]/rz-shopping-cart/div/ul/li/rz-cart-product/div/div[2]/rz-cart-counter/div/input");
    static By continueShop = By.xpath("/html/body/app-root/single-modal-window/div[2]/div[2]/rz-shopping-cart/div/div[1]/a");
    static By logo = By.xpath("/html/body/app-root/div/div/rz-header/header/div/div/a/picture/img");

    public static void addProductToCartViaProductPage() {
        $(addToCartViaProductPage).click();
        $(cartReceiptSum).should(Condition.visible);
    }

    public static void increaseAmountOfProductsInCart() {
        $(increaseAmountOfProductsButton).click();
        $(amountOfProducts).shouldHave(Condition.value("2"));
    }

    public static void backToShop() {
        $(continueShop).click();
    }

    public static void backToMainPage() {
        $(logo).click();
    }
}
