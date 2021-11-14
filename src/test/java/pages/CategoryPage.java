package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CategoryPage {

    static By categoryName = By.xpath("/html/body/app-root/div/div/rz-super-portal/div/main/section/div[1]/h1");
    static By subCategory = By.className("tile-cats");
    static By subCategoryProducts = By.xpath("//rz-grid/ul");
    static By productDetailCode = By.xpath("/html/body/app-root/div/div/rz-product/div/rz-product-top/div/div[2]/p");

    public static void checkCategoryName(String category) {
        $(categoryName).shouldHave(Condition.text(category));
    }

    public static void clickSubCategory(String sub) {
        $$(subCategory).findBy(Condition.text(sub)).click();
    }

    public static void clickProductViaSubCategory() {
        $$(subCategoryProducts).first().click();
        $(productDetailCode).should(Condition.visible);
    }
}
