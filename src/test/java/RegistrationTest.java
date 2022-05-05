import PageObjects.LoginPage;
import PageObjects.MainPage;
import PageObjects.RegisterPage;
import com.codeborne.selenide.Condition;
import org.junit.Before;
import org.junit.Test;

import static PageObjects.RegisterPage.*;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationTest {

    RegisterPage registerPage = page(RegisterPage.class);
    LoginPage loginPage = page(LoginPage.class);

    @Before
    public void setUp(){
        MainPage mainPage = open(url, MainPage.class);
        mainPage.pressLoginButtonOnMainPage();

        LoginPage loginPage = page(LoginPage.class);
        loginPage.pressRegisterButtonOnLoginPage();

        RegisterPage registerPage = page(RegisterPage.class);
        registerPage.fillNameFieldOnRegisterPage(name);
        registerPage.fillEmailFieldOnRegisterPage(email);
    }

    @Test
    public void successfulRegistration(){
        registerPage.fillPasswordFieldOnRegisterPage(password);
        registerPage.pressRegisterButtonOnRegisterPage();

        loginPage.loginButtonOnLoginPage.shouldBe(Condition.visible);
    }

    @Test
    public void anErrorAppearsIfPasswordIsWrong(){
        registerPage.fillPasswordFieldOnRegisterPage(shortPassword);
        registerPage.pressRegisterButtonOnRegisterPage();

        registerPage.errorFieldOnRegistrationPage.shouldHave(Condition.exactText("Некорректный пароль"));
    }
}
