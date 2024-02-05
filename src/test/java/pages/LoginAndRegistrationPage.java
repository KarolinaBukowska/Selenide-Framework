package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import data.UserLoginData;

import static com.codeborne.selenide.Condition.*;

public class LoginAndRegistrationPage {

    public SelenideElement descriptionTitle = Selenide.$("div.page-title > h1");
    public SelenideElement createAccountBtn = Selenide.$x("//a[contains(@class, 'button')]//span[contains(text(), 'Create an Account')]");
    public SelenideElement loginBtn = Selenide.$x("//button[contains(@class, 'button') and @title='Login']//span//span[contains(text(), 'Login')]");
    public SelenideElement emailField = Selenide.$("input#email.input-text.required-entry");
    public  SelenideElement passwordField = Selenide.$("input#pass.input-text.required-entry");

    public LoginAndRegistrationPage login(UserLoginData userData) {
        emailField.setValue(userData.getEmailAddress());
        emailField.shouldBe(visible).shouldNotBe(empty);
        passwordField.setValue(userData.getPassword());
        passwordField.shouldBe(visible).shouldNotBe(empty);
        loginBtn.shouldBe(visible).shouldBe(enabled).click();
        return new LoginAndRegistrationPage();
    }
}
