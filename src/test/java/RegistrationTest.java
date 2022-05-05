import PageObjects.LoginPage;
import PageObjects.MainPage;
import PageObjects.RegisterPage;
import com.codeborne.selenide.Condition;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.*;

public class RegistrationTest {

    String url = "https://stellarburgers.nomoreparties.site";

    String name = RandomStringUtils.randomAlphabetic(10);
    String email = RandomStringUtils.randomAlphabetic(10) + "@yandex.ru";
    String password = RandomStringUtils.randomAlphabetic(10);
    String shortPassword = RandomStringUtils.randomAlphabetic(5);

    @Test
    public void successfulRegistration(){
        MainPage mainPage = open(url, MainPage.class);
        mainPage.pressLoginButtonOnMainPage();

        LoginPage loginPage = page(LoginPage.class);
        loginPage.pressRegisterButtonOnLoginPage();

        RegisterPage registerPage = page(RegisterPage.class);
        registerPage.fillNameFieldOnRegisterPage(name);
        registerPage.fillEmailFieldOnRegisterPage(email);
        registerPage.fillPasswordFieldOnRegisterPage(password);
        registerPage.pressRegisterButtonOnRegisterPage();

        loginPage.loginButtonOnLoginPage.shouldBe(Condition.visible);
    }

    @Test
    public void anErrorAppearsIfPasswordIsWrong(){
        MainPage mainPage = open(url, MainPage.class);
        mainPage.pressLoginButtonOnMainPage();

        LoginPage loginPage = page(LoginPage.class);
        loginPage.pressRegisterButtonOnLoginPage();

        RegisterPage registerPage = page(RegisterPage.class);
        registerPage.fillNameFieldOnRegisterPage(name);
        registerPage.fillEmailFieldOnRegisterPage(email);
        registerPage.fillPasswordFieldOnRegisterPage(shortPassword);
        registerPage.pressRegisterButtonOnRegisterPage();

        registerPage.errorFieldOnRegistrationPage.shouldHave(Condition.exactText("Некорректный пароль"));
    }
}
