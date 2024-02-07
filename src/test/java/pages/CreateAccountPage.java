package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import utils.TestDataHelper;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;

public class CreateAccountPage {  ///extends Pages ??
    public SelenideElement descriptionTitle = Selenide.$("div.page-title > h1");
    public SelenideElement firstName = Selenide.$("input#firstname.input-text.required-entry");
    public SelenideElement middleName = Selenide.$("input#middlename.input-text");
    public SelenideElement lastName = Selenide.$("input#lastname.input-text.required-entry");
    public SelenideElement emailAddress = Selenide.$("input#email_address.input-text.validate-email");
    public SelenideElement password = Selenide.$("input#password.input-text.required-entry");
    public SelenideElement confirmPassword = Selenide.$("input#confirmation.input-text.required-entry");
    public SelenideElement registerBtn = Selenide.$x("//button[contains(@class, 'button') and @title='Register']//span//span[contains(text(), 'Register')]");
    public SelenideElement mismatchedPasswordErrorMsg = Selenide.$("#advice-validate-cpassword-confirmation");
    public SelenideElement tooShortPasswordErrorMsg = Selenide.$("#advice-validate-password-password");
    public SelenideElement requiredPasswordErrorMsg = Selenide.$("#advice-required-entry-confirmation");
    public SelenideElement requiredEmailErrorMsg = Selenide.$("#advice-required-entry-email_address");


    public CreateAccountPage setFirstName(String firstNameValue) {
        firstName.shouldBe(visible).shouldBe(enabled)
                .setValue(firstNameValue);
        return this;
    }

    public CreateAccountPage setLastName(String lastNameValue) {
        lastName.shouldBe(visible).shouldBe(enabled)
                .setValue(lastNameValue);
        return this;
    }

    public CreateAccountPage setEmailAddress() {
        String emailPrefix = "test";
        String emailSuffix = "@example.com";
        String randomEmail = TestDataHelper.generateRandomEmail(emailPrefix, emailSuffix);
        emailAddress.shouldBe(visible).shouldBe(enabled)
                .setValue(randomEmail);
        return this;
    }

    public CreateAccountPage setEmailAddress(String emailValue){
        emailAddress.shouldBe(visible).shouldBe(enabled)
                .setValue(emailValue);
        return this;
    }

    public CreateAccountPage setPassword(String passwordValue) {
        password.shouldBe(visible).shouldBe(enabled)
                .setValue(passwordValue);
        return this;
    }

    public CreateAccountPage setConfirmPassword(String confirmPasswordValue) {
        confirmPassword.shouldBe(visible).shouldBe(enabled)
                .setValue(confirmPasswordValue);
        return this;
    }


}
