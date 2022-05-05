package PageObjects;

import com.codeborne.selenide.SelenideElement;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.*;

public class LoginPage {

    public static String url = "https://stellarburgers.nomoreparties.site";
    public static String urlRegistration = "https://stellarburgers.nomoreparties.site/register";
    public static String urlLogin = "https://stellarburgers.nomoreparties.site/login";

    public static String name = RandomStringUtils.randomAlphabetic(10);
    public static String email = RandomStringUtils.randomAlphabetic(10) + "@yandex.ru";
    public static String password = RandomStringUtils.randomAlphabetic(10);

    //Поля

    //Поле ввода имейла
    @FindBy(how = How.XPATH,using = "/html/body/div/div/main/div/form/fieldset[1]/div/div/input")
    private SelenideElement emailFieldOnLoginPage;

    //Поле ввода пароля
    @FindBy(how = How.XPATH,using = "/html/body/div/div/main/div/form/fieldset[2]/div/div/input")
    private SelenideElement passwordFieldOnLoginPage;

    //Кнопка

    //Кнопка войти
    @FindBy(how = How.XPATH, using = ".//button[text()='Войти']")
    public SelenideElement loginButtonOnLoginPage;

    //Кнопка зарегистироваться
    @FindBy(how = How.LINK_TEXT,using = "Зарегистрироваться")
    public SelenideElement registerButtonOnLoginPage;

    //Кнопка восставновления пароля
    @FindBy(how = How.XPATH, using = "/html/body/div/div/main/div/div/p[2]/a")
    public SelenideElement recoveryPasswordOnLoginPage;


    //Действия

    //Заполнение имейла
    public void fillEmailFieldOnLoginPage(String text){
        emailFieldOnLoginPage.shouldBe(visible);
        emailFieldOnLoginPage.sendKeys(text);
    }

    //Заполнение пароля
    public void fillPasswordFieldOnLoginPage(String text){
        passwordFieldOnLoginPage.shouldBe(visible);
        passwordFieldOnLoginPage.sendKeys(text);
    }

    //Нажатие кнопки войти
    public void pressLoginButtonOnLoginPage(){
        loginButtonOnLoginPage.shouldBe(enabled);
        loginButtonOnLoginPage.click();
    }

    //Нажатие кнопки зарегистрироваться
    public void pressRegisterButtonOnLoginPage(){
        registerButtonOnLoginPage.shouldBe(enabled);
        registerButtonOnLoginPage.click();
    }

    //Нажатие кнопки восставновить пароль
    public void pressRecoveryPasswordOnLoginPage(){
        recoveryPasswordOnLoginPage.click();
    }
}
