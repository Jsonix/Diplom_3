package PageObjects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PasswordRecoveryPage {

    //Кнопка логина
    @FindBy(how = How.XPATH, using = "/html/body/div/div/main/div/div/p/a")
    public SelenideElement loginButtonOnPasswordRecoveryPage;

    //Клик на кнопку логина
    public void pressLoginButtonOnPasswordRecoveryPage(){
        loginButtonOnPasswordRecoveryPage.click();
    }
}
