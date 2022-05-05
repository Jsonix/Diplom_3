package PageObjects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.enabled;

public class PersonalWebPage {

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
