package com.xeype;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


public class RozetkaTests extends WebDriverSettings {

    @Test
    public void authTest() {
        WebElement authorize = driver.findElement(By.xpath("//rz-header/header/div/div/ul/li[3]/rz-user/button"));
        authorize.click();

        WebElement loginField = driver.findElement(By.id("auth_email"));
        WebElement passField = driver.findElement(By.id("auth_pass"));

        loginField.sendKeys("testLogin");
        passField.sendKeys("testPassword");

        WebDriverWait wait = (new WebDriverWait(driver, 10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='form__row validation_type_error']/p")));
        String authFailText = driver.findElement(By.xpath( "//div[@class='form__row validation_type_error']/p")).getText();
        Assertions.assertEquals("Введен неверный адрес эл.почты или номер телефона", authFailText);
    }

    @Test
    public void findProduct() {
        WebElement findField = driver.findElement(By.name("search"));
        findField.click();
        findField.sendKeys("монитор");

        WebElement findButton = driver.findElement(By.xpath("//rz-header/header/div/div/div/form/button"));
        findButton.click();

        WebDriverWait wait = (new WebDriverWait(driver, 10));
        WebElement categoryElement = driver.findElement(By.xpath("//rz-category/div/main/div[1]/div/h1"));
        wait.until(ExpectedConditions.textToBePresentInElement(categoryElement, "Мониторы"));
        String category = driver.findElement(By.xpath("//rz-category/div/main/div[1]/div/h1")).getText();

        Assertions.assertEquals(category, "Мониторы");
    }

    @Test
    public void findImages() {
        var waitAllImages = new WebDriverWait(driver, 10    );
        waitAllImages.until(ExpectedConditions.presenceOfElementLocated(By.tagName("img")));
        List<WebElement> images = driver.findElements(By.tagName("img"));
        System.out.println("Count of visible images: " + images.size());
    }

    @Test
    public void findLogo() {
        WebDriverWait wait = (new WebDriverWait(driver, 5));
        WebElement logo = driver.findElement(By.xpath("//img[@alt='Rozetka Logo']"));
        wait.until(ExpectedConditions.visibilityOf(logo));
        Assertions.assertTrue(logo.isDisplayed());
    }

    @Test
    public void findPremiumButton() {
        WebDriverWait wait = (new WebDriverWait(driver, 5));
        WebElement premiumButton = driver.findElement(By.className("premium-button"));
        wait.until(ExpectedConditions.attributeToBeNotEmpty(premiumButton, "class"));
        String premiumLabelText = driver.findElement(By.className("premium-button__label")).getText();
        Assertions.assertEquals("Попробуйте", premiumLabelText);
    }

    @Test
    public void findCatalogue() {
        String category = driver.findElement(By.partialLinkText("Ноутбуки")).getText();
        var waitAllImages = new WebDriverWait(driver, 10    );
        waitAllImages.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText("Ноутбуки и компьютеры")));
        Assertions.assertEquals(category, "Ноутбуки и компьютеры");
    }

    @Test
    public void switchLanguage() {
        WebElement languageUA = driver.findElement(By.xpath("//*[text()=' UA ']"));

        languageUA.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement languageRU = driver.findElement(By.xpath("//*[text()=' RU ']"));
        languageRU.click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void findFullText() {
        WebElement findFullText = driver.findElement(By.partialLinkText("продукты"));
        System.out.println(findFullText.getText());
        findFullText.click();
    }

    @Test
    public void findSocialNetworks() {
        WebDriverWait wait = (new WebDriverWait(driver, 5));
        wait.until(ExpectedConditions.textToBe((By.xpath("//aside/main-page-sidebar/div[3]/h3")), "Мы в социальных сетях"));
        List<WebElement> listOfSocialNetworks = driver.findElements(By.xpath("//ul [@class='socials__list']//a/.."));
        System.out.println("Count of social networks: " + listOfSocialNetworks.size());
        Assertions.assertNotNull(listOfSocialNetworks);
    }

    @Test
    public void cartEmpty() {
        WebElement cart = driver.findElement(By.xpath("//rz-cart/button"));
        cart.click();
        WebDriverWait wait = (new WebDriverWait(driver,10));
        WebElement shoppingCart = driver.findElement(By.xpath("//rz-shopping-cart/div/div//img"));
        wait.until(ExpectedConditions.attributeToBeNotEmpty(shoppingCart, "class"));
        String cartText = driver.findElement(By.xpath("//rz-shopping-cart/div/div//h4")).getText();
        Assertions.assertTrue(cartText.contains("Корзина"));
    }
}
