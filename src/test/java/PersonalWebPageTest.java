import PageObjects.*;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static PageObjects.LoginPage.*;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class PersonalWebPageTest {

    PersonalWebPage personalWebPage = page(PersonalWebPage.class);

    @BeforeClass
    public static void setUpAll(){
        Configuration.startMaximized = true;

        RegisterPage registerPage = open(urlRegistration, RegisterPage.class);
        registerPage.fillNameFieldOnRegisterPage(name);
        registerPage.fillEmailFieldOnRegisterPage(email);
        registerPage.fillPasswordFieldOnRegisterPage(password);
        registerPage.pressRegisterButtonOnRegisterPage();
    }

    @Before
    public void setUp(){
        LoginPage loginPage = open(urlLogin, LoginPage.class);
        loginPage.fillEmailFieldOnLoginPage(email);
        loginPage.fillPasswordFieldOnLoginPage(password);
        loginPage.pressLoginButtonOnLoginPage();

        MainPage mainPage = page(MainPage.class);
        mainPage.pressPersonalWebPage();
    }

    @After
    public void tearDown() {
        webdriver().driver().close();
    }

    @Test
    public void personalWebPageButtonRedirectToPersonalWebPage(){
        personalWebPage.textAboutProfile.shouldHave(Condition.exactText("В этом разделе вы можете изменить свои персональные данные"));
    }

    @Test
    public void userCanExitFromPersonalWebPage(){
        personalWebPage.pressExitButtonOnPersonalWebPage();

        LoginPage loginPage = page(LoginPage.class);
        loginPage.loginButtonOnLoginPage.shouldBe(visible);
    }

}
