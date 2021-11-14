package tests;

import org.testng.annotations.Test;
import utils.StaticProvider;

import static pages.CategoryPage.*;
import static pages.HeaderMenu.*;
import static pages.MainPage.*;
import static pages.ProductPage.*;

public class MainTests extends BaseTest {

    @Test(dataProvider = "credentialsProvider", dataProviderClass = StaticProvider.class)
    public void authTest(String login, String pass) {
        logIn(login, pass);
        validateLogInAlert();
    }

    @Test
    public void findProductTest() {
        findProduct("Мониторы");
    }

    @Test
    public void findImagesTest() {
        findImages();
    }

    @Test
    public void findLogoTest() {
        findLogo();
    }

    @Test
    public void checkPremiumTest() {
        checkPremiumButton();
    }

    @Test(dataProvider = "categoryProvider", dataProviderClass = StaticProvider.class)
    public void findCategoryPageTest(String partialCategory, String category) {
        findCatalogueElement(partialCategory);
        checkCategoryName(category);
    }

    @Test
    public void switchLanguageTest() {
        switchLanguageToUA();
        switchLanguageToRU();
    }

    @Test
    public void findSocialNetworksTest() {
        System.out.println("Count of social networks: " + findSocialNetworks());
    }

    @Test
    public void checkCartIsEmpty() {
        cartIsEmpty();
    }

    @Test(dataProvider = "productsProvider", dataProviderClass = StaticProvider.class)
    public void navigateToProductAndAddToCart(String category, String subCategory) {
        findCatalogueElement(category);
        clickSubCategory(subCategory);
        clickProductViaSubCategory();
        addProductToCartViaProductPage();
    }

    @Test(dataProvider = "productsProvider", dataProviderClass = StaticProvider.class)
    public void navigateToProductAndAddToCartAndIncreaseAmountOfProducts(String category, String subCategory) {
        findCatalogueElement(category);
        clickSubCategory(subCategory);
        clickProductViaSubCategory();
        addProductToCartViaProductPage();
        increaseAmountOfProductsInCart();
    }

    @Test(dataProvider = "productsProvider", dataProviderClass = StaticProvider.class)
    public void addTwoProductsToCart(String category, String subCategory) {
        findCatalogueElement(category);
        clickSubCategory(subCategory);
        clickProductViaSubCategory();
        addProductToCartViaProductPage();
        backToShop();
        backToMainPage();
        findCatalogueElement("Зоотовары");
        clickSubCategory("Спальные места и переноски");
        clickProductViaSubCategory();
        addProductToCartViaProductPage();
    }
}
