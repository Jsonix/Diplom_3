import PageObjects.*;
import com.codeborne.selenide.Configuration;
import org.junit.Before;
import org.junit.Test;

import static PageObjects.MainPage.url;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class ConstructorTest {

    @Before
    public void setUp(){
        Configuration.startMaximized = true;
        open(url, MainPage.class);
    }

    @Test
    public void checkClickFillingTest() {
        MainPage mainPage = page(MainPage.class);
        mainPage.clickFilling();
        mainPage.fillingsTab.shouldHave(exactText("Начинки"));
    }

    @Test
    public void checkClickSauceTest() {
        MainPage mainPage = page(MainPage.class);
        mainPage.clickSauces();
        mainPage.saucesTab.shouldHave(exactText("Соусы"));
    }

    @Test
    public void checkClickBunTest() {
        MainPage mainPage = page(MainPage.class);
        mainPage.clickFilling();
        mainPage.clickBuns();
        mainPage.bunsTab.shouldHave(exactText("Булки"));
    }

}
