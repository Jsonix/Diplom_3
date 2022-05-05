package PageObjects;

import com.codeborne.selenide.SelenideElement;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.enabled;

public class PersonalWebPage {

    public static String url = "https://stellarburgers.nomoreparties.site";
    public static String urlRegistration = "https://stellarburgers.nomoreparties.site/register";
    public static String urlLogin = "https://stellarburgers.nomoreparties.site/login";

    public static String name = RandomStringUtils.randomAlphabetic(10);
    public static String email = RandomStringUtils.randomAlphabetic(10) + "@yandex.ru";
    public static String password = RandomStringUtils.randomAlphabetic(10);

    //Кнопка выхода
    @FindBy(how = How.XPATH,using = ".//button[text()='Выход']")
    public SelenideElement exitButtonOnPersonalWebPage;

    //Поле с текстом "В этом разделе вы можете изменить свои персональные данные"
    @FindBy(how = How.XPATH, using = "/html/body/div/div/main/div/nav/p")
    public SelenideElement textAboutProfile;

    //Клик по кнопке выхода
    public void pressExitButtonOnPersonalWebPage(){
        exitButtonOnPersonalWebPage.shouldBe(enabled);
        exitButtonOnPersonalWebPage.click();
    }
}
