import locators.MainPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.concurrent.TimeUnit;

public class RozetkaTests {

    MainPage mainPage;
    WebDriver driver;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        mainPage = new MainPage(driver);
        PageFactory.initElements(driver, mainPage);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void authTest() {
        mainPage.openPage();
        mainPage.authButton.click();
        mainPage.authEmailField.sendKeys("1234");
        mainPage.authPassField.sendKeys("1234");
        mainPage.wait.until(ExpectedConditions.visibilityOf(mainPage.authErrorText));
        String authFailText = mainPage.authErrorText.getText();
        Assertions.assertEquals("Введен неверный адрес эл.почты или номер телефона", authFailText);
    }

    @Test
    public void findProduct() {
        mainPage.openPage();
        mainPage.searchField.click();
        mainPage.searchField.sendKeys("монитор");
        mainPage.searchButton.click();
        mainPage.wait.until(ExpectedConditions.textToBePresentInElement(mainPage.categoryElement, "Мониторы"));
        String category = mainPage.categoryElement.getText();
        Assertions.assertEquals(category, "Мониторы");
    }

    @Test
    public void findImages() {
        mainPage.openPage();
        mainPage.wait.until(ExpectedConditions.visibilityOf(mainPage.image));
        System.out.println("Count of visible images: " + mainPage.images.size());
    }

    @Test
    public void findLogo() {
        mainPage.openPage();
        mainPage.wait.until(ExpectedConditions.visibilityOf(mainPage.logo));
        Assertions.assertTrue(mainPage.logo.isDisplayed());
    }

    @Test
    public void findPremiumButton() {
        mainPage.openPage();
        mainPage.wait.until(ExpectedConditions.attributeToBeNotEmpty(mainPage.premiumButton, "class"));
        String premiumLabelText = mainPage.premiumButtonLabel.getText();
        Assertions.assertEquals("Попробуйте", premiumLabelText);
    }

    @Test
    public void findCatalogue() {
        mainPage.openPage();
        String category = mainPage.laptopsCategory.getText();
        mainPage.wait.until(ExpectedConditions.elementToBeClickable(mainPage.laptopsAndComputersCategory));
        Assertions.assertEquals(category, "Ноутбуки и компьютеры");
    }

    @Test
    public void switchLanguage() {
        mainPage.openPage();

        mainPage.wait.until(ExpectedConditions.elementToBeClickable(mainPage.languageUA));
        mainPage.languageUA.click();

        Assertions.assertEquals(driver.getTitle(),
                "Інтернет-магазин ROZETKA™: офіційний сайт найпопулярнішого онлайн-гіпермаркету в Україні");

        mainPage.wait.until(ExpectedConditions.elementToBeClickable(mainPage.languageRU));
        mainPage.languageRU.click();

        Assertions.assertEquals(driver.getTitle(),"Интернет-магазин ROZETKA™: " +
                "официальный сайт самого популярного онлайн-гипермаркета в Украине");
    }

    @Test
    public void findFullTextByPartial() {
        mainPage.openPage();
        mainPage.wait.until(ExpectedConditions.elementToBeClickable(mainPage.productsFullTextByPartial));
        Assertions.assertEquals(mainPage.productsFullTextByPartial.getText(), "Алкогольные напитки и продукты");
    }

    @Test
    public void findSocialNetworks() {
        mainPage.openPage();
        mainPage.wait.until(ExpectedConditions.textToBePresentInElement(mainPage.mainPageSidebar, "Мы в социальных сетях"));
        Assertions.assertNotNull(mainPage.socialNetworksList);
        System.out.println("Count of social networks: " + mainPage.socialNetworksList.size());
    }

    @Test
    public void cartEmpty() {
        mainPage.openPage();
        mainPage.cart.click();
        mainPage.wait.until(ExpectedConditions.attributeToBeNotEmpty(mainPage.shoppingCart, "class"));
        String cartText = mainPage.cartText.getText();
        Assertions.assertTrue(cartText.contains("Корзина"));
    }
}
