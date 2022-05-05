import PageObjects.*;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class PersonalWebPageTest {

    String urlRegistration = "https://stellarburgers.nomoreparties.site/register";
    String urlLogin = "https://stellarburgers.nomoreparties.site/login";
    String name = RandomStringUtils.randomAlphabetic(10);
    String email = RandomStringUtils.randomAlphabetic(10) + "@yandex.ru";
    String password = RandomStringUtils.randomAlphabetic(10);

    @Before
    public void setUp(){
        Configuration.startMaximized = true;

        MainPage mainPage = open(urlRegistration, MainPage.class);
        mainPage.pressPersonalWebPage();

        LoginPage loginPage = page(LoginPage.class);
        loginPage.pressRegisterButtonOnLoginPage();

        RegisterPage registerPage = page(RegisterPage.class);
        registerPage.fillNameFieldOnRegisterPage(name);
        registerPage.fillEmailFieldOnRegisterPage(email);
        registerPage.fillPasswordFieldOnRegisterPage(password);
        registerPage.pressRegisterButtonOnRegisterPage();
    }

    @After
    public void tearDown() {
        webdriver().driver().close();
    }

    @Test
    public void personalWebPageButtonRedirectToPersonalWebPage(){
        LoginPage loginPage = open(urlLogin, LoginPage.class);
        loginPage.fillEmailFieldOnLoginPage(email);
        loginPage.fillPasswordFieldOnLoginPage(password);
        loginPage.pressLoginButtonOnLoginPage();

        MainPage mainPage = page(MainPage.class);
        mainPage.pressPersonalWebPage();

        PersonalWebPage personalWebPage = page(PersonalWebPage.class);
        personalWebPage.textAboutProfile.shouldHave(Condition.exactText("В этом разделе вы можете изменить свои персональные данные"));
    }

    @Test
    public void userCanExitFromPersonalWebPage(){
        LoginPage loginPage = open(urlLogin, LoginPage.class);
        loginPage.fillEmailFieldOnLoginPage(email);
        loginPage.fillPasswordFieldOnLoginPage(password);
        loginPage.pressLoginButtonOnLoginPage();

        MainPage mainPage = page(MainPage.class);
        mainPage.pressPersonalWebPage();

        PersonalWebPage personalWebPage = page(PersonalWebPage.class);
        personalWebPage.pressExitButtonOnPersonalWebPage();

        loginPage.loginButtonOnLoginPage.shouldBe(visible);
    }

}
