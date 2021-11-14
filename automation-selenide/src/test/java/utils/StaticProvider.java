package utils;

import org.testng.annotations.DataProvider;

public class StaticProvider {

    @DataProvider(name = "categoryProvider")
    public static Object[][] categoryProvider() {
        return new Object[][]{
                {"ремонт", "Сантехника и ремонт"},
                {"Спорт", "Спорт и увлечения"},
                {"продукты", "Алкогольные напитки и продукты"},
                {"электроника", "Смартфоны, ТВ и электроника"}
        };
    }

    @DataProvider(name = "credentialsProvider")
    public static Object[][] credentialsProvider() {
        return new Object[][]{
                {"test1%", "test1%"},
                {"test1%", ""},
                {"", "test1%"},
                {"", ""}
        };
    }

    @DataProvider(name = "productsProvider")
    public static Object[][] productsProvider() {
        return new Object[][]{
                {"ремонт", "Ванны"},
                {"Инструменты", "Автомобильные масла"}
        };
    }
}
