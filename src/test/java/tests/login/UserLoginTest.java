package tests.login;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import config.Config;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Pages;
import tests.BaseTest;

import static com.codeborne.selenide.Condition.*;
import static org.testng.Assert.assertEquals;


public class UserLoginTest extends BaseTest {

    @BeforeClass
    public void setUp() {
        setUpUsersData(Config.USERS_DATA);
    }

    @Test
    public void openUserLogin() {

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
//      Step 2 Log in with the registered user's credentials
//      All the login mandatory fields are filled in
        Pages.loginAndRegistrationPage.login(users.getUserOne());
//      A page titled "My dashboard" is present
//      The following list items are present: Account Information, Address Book, My Orders,
//      Billing Agreements, My Product Reviews, My Applications
        Pages.accountDashboard.descriptionTitle.shouldHave(exactText("My Dashboard"));
        Pages.accountDashboard.accountInformation.shouldBe(visible).shouldBe(enabled);
        Pages.accountDashboard.addressBook.shouldBe(visible).shouldBe(enabled);
        Pages.accountDashboard.myOrders.shouldBe(visible).shouldBe(enabled);
        Pages.accountDashboard.billingAgreements.shouldBe(visible).shouldBe(enabled);
        Pages.accountDashboard.myProductReviews.shouldBe(visible).shouldBe(enabled);
        Pages.accountDashboard.myApplications.shouldBe(visible).shouldBe(enabled);
    }
}
