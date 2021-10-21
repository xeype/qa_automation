package locators;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class MainPage {

    private WebDriver driver;
    public WebDriverWait wait;

    @FindBy(xpath = "//rz-header/header/div/div/ul/li[3]/rz-user/button")
    public WebElement authButton;

    @FindBy(id = "auth_email")
    public WebElement authEmailField;

    @FindBy(id = "auth_pass")
    public WebElement authPassField;

    @FindBy(xpath = "//div[@class='form__row validation_type_error']/p")
    public WebElement authErrorText;

    @FindBy(name = "search")
    public WebElement searchField;

    @FindBy(xpath = "//rz-header/header/div/div/div/form/button")
    public WebElement searchButton;

    @FindBy(xpath = "//rz-category/div/main/div[1]/div/h1")
    public WebElement categoryElement;

    @FindBy(tagName = "img")
    public WebElement image;

    @FindBy(tagName = "img")
    public List<WebElement> images;

    @FindBy(xpath = "//img[@alt='Rozetka Logo']")
    public WebElement logo;

    @FindBy(className = "premium-button")
    public WebElement premiumButton;

    @FindBy(className = "premium-button__label")
    public WebElement premiumButtonLabel;

    @FindBy(partialLinkText = "Ноутбуки")
    public WebElement laptopsCategory;

    @FindBy(partialLinkText = "Ноутбуки и компьютеры")
    public WebElement laptopsAndComputersCategory;

    @FindBy(xpath = "//*[text()=' UA ']")
    public WebElement languageUA;

    @FindBy(xpath = "//*[text()=' RU ']")
    public WebElement languageRU;

    @FindBy(partialLinkText = "продукты")
    public WebElement productsFullTextByPartial;

    @FindBy(xpath = "//aside/main-page-sidebar/div[3]/h3")
    public WebElement mainPageSidebar;

    @FindBy(xpath = "//ul [@class='socials__list']//a/..")
    public List<WebElement> socialNetworksList;

    @FindBy(xpath = "//rz-cart/button")
    public WebElement cart;

    @FindBy(xpath = "//rz-shopping-cart/div/div//img")
    public WebElement shoppingCart;

    @FindBy(xpath = "//rz-shopping-cart/div/div//h4")
    public WebElement cartText;

    public MainPage (WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, 10);
        PageFactory.initElements(driver, this);
    }

    public void openPage() {
        driver.get("https://rozetka.com.ua/");
        var pageTitle = driver.getTitle();
        Assertions.assertEquals("Интернет-магазин ROZETKA™: " +
                "официальный сайт самого популярного онлайн-гипермаркета в Украине", pageTitle);
    }
}
