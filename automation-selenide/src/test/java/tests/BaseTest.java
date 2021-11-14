package tests;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.*;

import static com.codeborne.selenide.Selenide.*;

public class BaseTest {

    @BeforeSuite
    public void suiteSetUp() {
        System.out.println("Before Suite setUp");
        Configuration.startMaximized = true;
    }

    @BeforeTest
    public void testSetUp() {
        System.out.println("Before Test setUp");
        Configuration.timeout = 10000;
    }

    @BeforeClass
    public void classSetUp() {
        System.out.println("Before Class setUp");
        Configuration.browser = "chrome";
    }

    @BeforeGroups
    public void groupSetUp() {
        System.out.println("Before Group SetUp");
    }

    @BeforeMethod
    public void setUp() {
        open("https://rozetka.com.ua/");
    }

    @AfterMethod
    public void tearDown() {
        clearBrowserCookies();
        clearBrowserLocalStorage();
    }

    @AfterGroups
    public void groupTearDown() {
        System.out.println("After Groups tearDown");
    }

    @AfterClass
    public void classTearDown() {
        System.out.println("After Class tearDown");
    }

    @AfterTest
    public void testTearDown() {
        System.out.println("After Test tearDown");
    }

    @AfterSuite
    public void suiteTearDown() {
        System.out.println("After Suite tearDown");
    }

}
