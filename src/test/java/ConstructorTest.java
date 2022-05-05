import PageObjects.*;
import com.codeborne.selenide.Configuration;
import org.junit.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class ConstructorTest {

    String url = "https://stellarburgers.nomoreparties.site/";

    @Test
    public void checkClickFillingTest() {
        Configuration.startMaximized = true;
        MainPage mainPage = open(url, MainPage.class);
        mainPage.clickFilling();
        mainPage.fillingsTab.shouldHave(exactText("Начинки"));
    }

    @Test
    public void checkClickSauceTest() {
        Configuration.startMaximized = true;
        MainPage mainPage = open(url, MainPage.class);
        mainPage.clickSauces();
        mainPage.saucesTab.shouldHave(exactText("Соусы"));
    }

    @Test
    public void checkClickBunTest() {
        Configuration.startMaximized = true;
        MainPage mainPage = open(url, MainPage.class);
        mainPage.clickFilling();
        mainPage.clickBuns();
        mainPage.bunsTab.shouldHave(exactText("Булки"));
    }

}
