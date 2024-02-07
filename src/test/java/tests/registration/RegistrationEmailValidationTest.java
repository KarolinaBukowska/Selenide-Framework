package tests.registration;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import config.Config;
import org.testng.annotations.Test;
import pages.Pages;

import static com.codeborne.selenide.Condition.*;
import static org.testng.Assert.assertEquals;

public class RegistrationEmailValidationTest {

    private final String validFirstName = "First";
    private final String validLastName = "Last";
    private final String validPassword = "Password123!";

    @Test
    public void registrationWithInvalidEmail(){

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
//      Step 3 Leave the email field empty and populate the other required fields with the valid data
        Pages.createAccountPage
                .setFirstName(validFirstName)
                .setLastName(validLastName)
                .setPassword(validPassword)
                .setConfirmPassword(validPassword);
        Pages.createAccountPage.emailAddress.shouldBe(empty);
//      Step 4 Click the Register button
        Pages.createAccountPage.registerBtn.shouldBe(visible).shouldBe(enabled).click();
        Pages.createAccountPage.requiredEmailErrorMsg.shouldBe(visible).shouldHave(exactText("This is a required field."));
    }
}
