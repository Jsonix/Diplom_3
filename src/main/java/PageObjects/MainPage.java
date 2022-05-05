package PageObjects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.*;

public class MainPage {

    //Кнопка входа в аккаунт
    @FindBy(how = How.XPATH, using = ".//button[text()='Войти в аккаунт']")
    public SelenideElement loginButtonOnMainPage;

    //Кнопка оформить заказ
    @FindBy(how = How.XPATH, using = "/html/body/div/div/main/section[2]/div/button")
    public SelenideElement makeAnOrderOnMainPage;

    //Кнопка личный кабинет
    @FindBy(how = How.LINK_TEXT,using = "Личный Кабинет")
    public SelenideElement personalWebPage;

    //Кнопка начинки
    @FindBy(xpath = "//*[text()='Начинки']")
    public SelenideElement fillingsButton;

    //Кнопка вкладки начинки
    @FindBy(xpath = ".//*[@class='text text_type_main-medium mb-6 mt-10' and text()='Начинки']")
    public SelenideElement fillingsTab;

    //Кнопка соусы
    @FindBy(xpath = "//*[text()='Соусы']")
    public SelenideElement saucesButton;

    //Кнопка вкладки соусы
    @FindBy(xpath = ".//*[@class='text text_type_main-medium mb-6 mt-10' and text()='Соусы']")
    public SelenideElement saucesTab;

    //Кнопка булки
    @FindBy(xpath = ".//*[//*[@id=\"root\"]/div/main/section[1]/div[1]/div[1]/span]")
    public SelenideElement bunsButton;

    //Кнопка вкладки булки
    @FindBy(xpath = ".//*[@class='text text_type_main-medium mb-6 mt-10' and text()='Булки']")
    public SelenideElement bunsTab;

    //Клик по разделу "Начинки"
    public void clickFilling() {
        fillingsButton.shouldBe(exist).click();
    }

    //Клик по разделу "Соусы"
    public void clickSauces() {
        saucesButton.shouldBe(exist).click();
    }

    //Клик по разделу "Булки"
    public void clickBuns() {
        bunsButton.shouldBe(visible).click();
    }

    //Нажатие кнопки входа
    public void pressLoginButtonOnMainPage(){
        loginButtonOnMainPage.click();
    }

    //Нажатие кнопки личный кабинет
    public void pressPersonalWebPage(){
        personalWebPage.click();
    }

}
