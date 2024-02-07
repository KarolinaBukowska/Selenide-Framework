package tests.registration;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import config.Config;
import org.testng.annotations.Test;
import pages.Pages;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Condition.enabled;
import static org.testng.Assert.assertEquals;

public class RegistrationPasswordValidationTest {
    private final String validFirstName = "First";
    private final String validLastName = "Last";
    private final String shortPassword = "pass";
    private final String validPassword = "Password123!";
    private final String mismatchedConfirmPassword = "unmatching";

    @Test
    public void registrationWithInvalidPassword(){

//      Preconditions:
//      Home page is present
        Selenide.open(Config.BASE_URL);
        String url = WebDriverRunner.url();
        assertEquals(url, Config.BASE_URL);

//      Step 1 Click on the "My account" button
//      A page titled "Login or Create an Account" is present
//      There's "Create an account" and "Login" buttons present
        Pages.homePage.accountBtn.shouldBe(enabled).click();
        Pages.homePage.myAccountBtn.shouldBe(enabled).click();
        Pages.loginAndRegistrationPage.descriptionTitle.shouldHave(exactText("Login or Create an Account"));
        Pages.loginAndRegistrationPage.createAccountBtn.shouldBe(visible).shouldBe(enabled);
//      Step 2 Click on the "Create an account" button
//      A page titled "Create an Account" is present
        Pages.loginAndRegistrationPage.createAccountBtn.shouldBe(enabled).click();
        Pages.createAccountPage.descriptionTitle.shouldHave(exactText("Create an Account"));
//      Step 3 Populate the password and confirm password fields with the password with less than 7 characters
//      Populate the rest of the fields with the valid data
        Pages.createAccountPage
                .setFirstName(validFirstName)
                .setLastName(validLastName)
                .setEmailAddress()
                .setPassword(shortPassword)
                .setConfirmPassword(shortPassword);
//      Step 4 Click on the Register button
//      There is an error message popping up: "Please enter more characters or clean leading or trailing spaces."
        Pages.createAccountPage.registerBtn.shouldBe(visible).shouldBe(enabled).click();
        Pages.createAccountPage.tooShortPasswordErrorMsg.shouldBe(visible).shouldHave(exactText("Please enter more characters or clean leading or trailing spaces."));
//      Step 5 Clear the password and confirm password fields
//      Populate the password field with the valid password and confirm password with the mismatched value
        Pages.createAccountPage.password.clear();
        Pages.createAccountPage.confirmPassword.clear();
        Pages.createAccountPage.password.shouldBe(empty);
        Pages.createAccountPage.confirmPassword.shouldBe(empty);
        Pages.createAccountPage
                .setPassword(validPassword)
                .setConfirmPassword(mismatchedConfirmPassword);
//      Step 6 Click on the Register button
//      There is an error message: "Please make sure your passwords match."
        Pages.createAccountPage.registerBtn.shouldBe(visible).shouldBe(enabled).click();
        Pages.createAccountPage.mismatchedPasswordErrorMsg.shouldBe(visible).shouldHave(exactText("Please make sure your passwords match."));
//      Step 7 Clear the confirm password, while keeping the password field populated and click on the Register button
//      There is an error message: This is a required field.
        Pages.createAccountPage.confirmPassword.clear();
        Pages.createAccountPage.confirmPassword.shouldBe(empty);
        Pages.createAccountPage.registerBtn.shouldBe(visible).shouldBe(enabled).click();
        Pages.createAccountPage.requiredPasswordErrorMsg.shouldBe(visible).shouldHave(exactText("This is a required field."));
//      Step 8 Populate the confirm password field with the valid password and clear the password field
//      Click on the Register button
        Pages.createAccountPage.password.clear();
        Pages.createAccountPage.password.shouldBe(empty);
        Pages.createAccountPage.confirmPassword.clear();
        Pages.createAccountPage.confirmPassword.shouldBe(empty);
        Pages.createAccountPage.setConfirmPassword(validPassword);
        Pages.createAccountPage.registerBtn.shouldBe(visible).shouldBe(enabled).click();
//      There are error messages: : This is a required field. AND "Please make sure your passwords match."
        Pages.createAccountPage.requiredPasswordErrorMsg.shouldBe(visible).shouldHave(exactText("This is a required field."));
        Pages.createAccountPage.mismatchedPasswordErrorMsg.shouldBe(visible).shouldHave(exactText("Please make sure your passwords match."));
    }

}
