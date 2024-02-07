package tests.login;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import config.Config;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Pages;
import tests.BaseTest;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Condition.enabled;
import static org.testng.Assert.assertEquals;

public class LoginPasswordValidationTest extends BaseTest {

    @BeforeClass
    public void setUp() {
        setUpUsersData(Config.USERS_DATA);
    }

    @Test
    public void loginWithUnregisteredPassword(){

//      Preconditions:
//      Home page is present
        Selenide.open(Config.BASE_URL);
        String url = WebDriverRunner.url();
        assertEquals(url, Config.BASE_URL);
//      Step 1 Click on the "My account" button
//      A page titled "Login or Create an Account" is present
//      There's "Create an account" and "Login" buttons present
        Pages.homePage.accountBtn.shouldBe(enabled).click();
        Pages.homePage.logInBtn.shouldBe(enabled).click();
        Pages.loginAndRegistrationPage.descriptionTitle.shouldHave(exactText("Login or Create an Account"));
        Pages.loginAndRegistrationPage.createAccountBtn.shouldBe(visible).shouldBe(enabled);
        Pages.loginAndRegistrationPage.loginBtn.shouldBe(visible).shouldBe(enabled);
//      Step 2 Enter the user's credentials that contain registered email and unregistered password
//      The error message pops up
        Pages.loginAndRegistrationPage.login(users.getUserWithInvalidPassword());
        Pages.loginAndRegistrationPage.invalidLoginMessage.shouldBe(visible).shouldHave(exactText("Invalid login or password."));
//      Step 3 Clear the PASSWORD field, leaving the email field populated with the registered email
        Pages.loginAndRegistrationPage.passwordField.clear();
        Pages.loginAndRegistrationPage.passwordField.shouldBe(empty);
//      Step 4 Click on the Login button
//      Both Email Address and Password fields get cleared out
//      The error message pops up: "Invalid login or password."
//      The message pops up under Password field:"This is a required field."
        Pages.loginAndRegistrationPage.loginBtn.shouldBe(visible).shouldBe(enabled).click();
        Pages.loginAndRegistrationPage.passwordField.shouldBe(empty);
        Pages.loginAndRegistrationPage.invalidLoginMessage.shouldBe(visible).shouldHave(exactText("Invalid login or password."));
        Pages.loginAndRegistrationPage.missingLoginPassword.shouldBe(visible).shouldHave(exactText("This is a required field."));
    }
}
