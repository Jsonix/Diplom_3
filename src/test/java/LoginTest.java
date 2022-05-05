import PageObjects.*;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

import static PageObjects.LoginPage.*;
import static com.codeborne.selenide.Selenide.*;

public class LoginTest {

    @BeforeClass
    public static void setUp(){
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
    public void tearDown(){
        webdriver().driver().close();

        /* Я пробовал сделать вот так. Т.е просто выходить из аккаунта и создавать новый, но при запуске всех тестов
        одновременно, 2-3 теста стабильно падали т.к не могли найти кнопку выхода. */

        /*MainPage mainPage = open(url, MainPage.class);
        mainPage.pressPersonalWebPage();

        PersonalWebPage personalWebPage = page(PersonalWebPage.class);
        personalWebPage.pressExitButtonOnPersonalWebPage();*/

    }

    @Test
    public void loginFromMainPage(){
        LoginPage loginPage = open(urlLogin, LoginPage.class);
        loginPage.fillEmailFieldOnLoginPage(email);
        loginPage.fillPasswordFieldOnLoginPage(password);
        loginPage.pressLoginButtonOnLoginPage();

        MainPage mainPage = page(MainPage.class);
        mainPage.makeAnOrderOnMainPage.shouldBe(Condition.visible);
    }

    @Test
    public void loginFromPersonalWebPage(){
        MainPage mainPage = open(url, MainPage.class);
        mainPage.pressPersonalWebPage();

        LoginPage loginPage = page(LoginPage.class);
        loginPage.fillEmailFieldOnLoginPage(email);
        loginPage.fillPasswordFieldOnLoginPage(password);
        loginPage.pressLoginButtonOnLoginPage();

        mainPage.makeAnOrderOnMainPage.shouldBe(Condition.visible);
    }

    @Test
    public void loginFromRegisterPage(){
        RegisterPage registerPage = open(urlRegistration, RegisterPage.class);
        registerPage.pressLoginButtonOnRegisterPage();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.fillEmailFieldOnLoginPage(email);
        loginPage.fillPasswordFieldOnLoginPage(password);
        loginPage.pressLoginButtonOnLoginPage();

        MainPage mainPage = page(MainPage.class);
        mainPage.makeAnOrderOnMainPage.shouldBe(Condition.visible);
    }

    @Test
    public void loginFromPasswordRecoveryPage(){
        LoginPage loginPage = open(urlLogin, LoginPage.class);
        loginPage.pressRecoveryPasswordOnLoginPage();

        PasswordRecoveryPage passwordRecoveryPage = page(PasswordRecoveryPage.class);
        passwordRecoveryPage.pressLoginButtonOnPasswordRecoveryPage();

        loginPage.fillEmailFieldOnLoginPage(email);
        loginPage.fillPasswordFieldOnLoginPage(password);
        loginPage.pressLoginButtonOnLoginPage();

        MainPage mainPage = page(MainPage.class);
        mainPage.makeAnOrderOnMainPage.shouldBe(Condition.visible);
    }
}
