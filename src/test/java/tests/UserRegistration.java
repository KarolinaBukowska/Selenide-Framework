package tests;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import config.Config;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Condition.*;
import static org.testng.Assert.*;
import pages.Pages;


public class UserRegistration extends BaseTest {


    @BeforeClass
    public void setUp() {
        setUpTestData(Config.REGISTRATION_DATA);
    }


    @Test
    public void openUserRegistration() {

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
        Pages.loginAndRegistrationPage.loginBtn.shouldBe(visible).shouldBe(enabled);
//      Step 2 Click on the "Create an account" button
//      A page titled "Create an Account" is present
//      The following fields are present: First Name, Middle Name/Initial, Last Name, Email Address, Password,
//      Confirm Password
        Pages.loginAndRegistrationPage.createAccountBtn.shouldBe(enabled).click();
        Pages.createAccountPage.descriptionTitle.shouldHave(exactText("Create an Account"));
        Pages.createAccountPage.firstName.shouldBe(visible).shouldBe(empty);
        Pages.createAccountPage.middleName.shouldBe(visible).shouldBe(empty);
        Pages.createAccountPage.lastName.shouldBe(visible).shouldBe(empty);
        Pages.createAccountPage.emailAddress.shouldBe(visible).shouldBe(empty);
        Pages.createAccountPage.password.shouldBe(visible).shouldBe(empty);
        Pages.createAccountPage.confirmPassword.shouldBe(visible).shouldBe(empty);
//      Step 3 Fill in the mandatory fields: First Name, Last Name, Email Address, Password, Confirm Password
//      All the mandatory fields are filled in
        Pages.createAccountPage
                .setFirstName(data.getRegistrationData().getFirstName())
                .setLastName(data.getRegistrationData().getLastName())
                .setEmailAddress()
                .setPassword(data.getRegistrationData().getPassword())
                .setConfirmPassword(data.getRegistrationData().getConfirmPassword());
//      Step 4 Click on "Register"
//      A page titled "My dashboard" is present
//      The following list items are present: Account Information, Address Book, My Orders,
//      Billing Agreements, My Product Reviews, My Wishlist, My Applications
        Pages.createAccountPage.registerBtn.shouldBe(enabled).click();
        Pages.accountDashboard.descriptionTitle.shouldHave(exactText("My Dashboard"));
        Pages.accountDashboard.accountInformation.shouldBe(visible).shouldBe(enabled);
        Pages.accountDashboard.addressBook.shouldBe(visible).shouldBe(enabled);
        Pages.accountDashboard.myOrders.shouldBe(visible).shouldBe(enabled);
        Pages.accountDashboard.billingAgreements.shouldBe(visible).shouldBe(enabled);
        Pages.accountDashboard.myProductReviews.shouldBe(visible).shouldBe(enabled);
        Pages.accountDashboard.myApplications.shouldBe(visible).shouldBe(enabled);

    }

}
