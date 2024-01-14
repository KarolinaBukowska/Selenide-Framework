package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import data.UserLoginData;
import data.Users;

import static com.codeborne.selenide.Condition.enabled;

public class LoginAndRegistrationPage {

    public SelenideElement descriptionTitle = Selenide.$("div.page-title > h1");
    public SelenideElement createAccountBtn = Selenide.$x("//a[contains(@class, 'button')]//span[contains(text(), 'Create an Account')]");
    public SelenideElement loginBtn = Selenide.$x("//button[contains(@class, 'button') and @title='Login']//span//span[contains(text(), 'Login')]");

    public SelenideElement emailField = Selenide.$("input#email.input-text.required-entry");
    public  SelenideElement passwordField = Selenide.$("input#pass.input-text.required-entry");

//    public LoginAndRegistrationPage setEmailField(String emailFieldValue) {
//        emailField.shouldBe(enabled).setValue(emailFieldValue);
//        return this;
//    }
//
//    public LoginAndRegistrationPage setPasswordField(String passwordFieldValue) {
//        passwordField.shouldBe(enabled).setValue(passwordFieldValue);
//        return this;
//    }

    public LoginAndRegistrationPage login(UserLoginData userData) {
        emailField.setValue(userData.getEmailAddress());
        passwordField.setValue(userData.getPassword());
        loginBtn.shouldBe(enabled).click();
        return new LoginAndRegistrationPage();
    }


}
