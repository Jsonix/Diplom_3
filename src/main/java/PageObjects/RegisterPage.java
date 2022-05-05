package PageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RegisterPage {

    public static String url = "https://stellarburgers.nomoreparties.site";

    public static String name = RandomStringUtils.randomAlphabetic(10);
    public static String email = RandomStringUtils.randomAlphabetic(10) + "@yandex.ru";
    public static String password = RandomStringUtils.randomAlphabetic(10);
    public static String shortPassword = RandomStringUtils.randomAlphabetic(5);

    //Поля

    //Поле ввода имени
    @FindBy(how = How.XPATH, using = "/html/body/div/div/main/div/form/fieldset[1]/div/div/input")
    public SelenideElement nameFieldOnRegistrationPage;

    //Поле ввода имейла
    @FindBy(how = How.XPATH, using = "/html/body/div/div/main/div/form/fieldset[2]/div/div/input")
    public SelenideElement emailFieldOnRegistrationPage;

    //Поле ввода пароля
    @FindBy(how = How.XPATH, using = "/html/body/div/div/main/div/form/fieldset[3]/div/div/input")
    public SelenideElement passwordFieldOnRegistrationPage;

    //Поле ошибки
    @FindBy(how = How.XPATH, using = "/html/body/div/div/main/div/form/fieldset[3]/div/p")
    public SelenideElement errorFieldOnRegistrationPage;


    //Кнопка

    //Кнопка зарегистрироваться
    @FindBy(how = How.XPATH, using = ".//button[text()='Зарегистрироваться']")
    public SelenideElement registerButtonOnRegistrationPage;

    //Кнопка логин
    @FindBy(how = How.XPATH, using = "/html/body/div/div/main/div/div/p/a")
    public SelenideElement loginButtonOnRegistrationPage;


    //Действия

    //Заполнение имени
    public void fillNameFieldOnRegisterPage(String text){
        nameFieldOnRegistrationPage.isDisplayed();
        nameFieldOnRegistrationPage.sendKeys(text);
    }

    //Заполнение имейла
    public void fillEmailFieldOnRegisterPage(String text){
        emailFieldOnRegistrationPage.isDisplayed();
        emailFieldOnRegistrationPage.sendKeys(text);
    }

    //Заполнение пароля
    public void fillPasswordFieldOnRegisterPage(String text){
        passwordFieldOnRegistrationPage.shouldBe(Condition.enabled);
        passwordFieldOnRegistrationPage.sendKeys(text);
    }

    //Нажатие кнопки регистрации
    public void pressRegisterButtonOnRegisterPage(){
        registerButtonOnRegistrationPage.shouldBe(Condition.enabled);
        registerButtonOnRegistrationPage.click();
    }

    //Нажатие кнопки логина
    public void pressLoginButtonOnRegisterPage(){
        loginButtonOnRegistrationPage.shouldBe(Condition.enabled);
        loginButtonOnRegistrationPage.click();
    }
}
