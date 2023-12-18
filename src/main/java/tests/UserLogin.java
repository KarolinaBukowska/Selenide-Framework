package tests;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.*;
import static org.testng.Assert.*;

import pages.Pages;
import data.Data;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.File;
import java.nio.file.Paths;


public class UserLogin {

    Data data;

    @BeforeClass
    public void setUp() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String filePath = getPathToResource("testData/UserLogin.json");
            data = objectMapper.readValue(new File(filePath), Data.class);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private String getPathToResource(String relativePath) {

        return Paths.get("src","main","resources", relativePath).toString();
    }

    @Test
    public void openUserLogin() {

//      Preconditions:
//      Home page is present
        Selenide.open("https://ecommerce.tealiumdemo.com/");
        String url = WebDriverRunner.url();
        assertEquals(url, "https://ecommerce.tealiumdemo.com/");

//      Step 1 Click on the "My account" button
//      A page titled "Login or Create an Account" is present
//      There's "Create an account" and "Login" buttons present
        Pages.homePage.accountBtn.shouldBe(enabled).click();
        Pages.homePage.myAccountBtn.shouldBe(enabled).click();
        Pages.loginAndRegistrationPage.descriptionTitle.shouldHave(exactText("Login or Create an Account"));
        Pages.loginAndRegistrationPage.createAccountBtn.shouldBe(visible).shouldBe(enabled);
        Pages.loginAndRegistrationPage.loginBtn.shouldBe(visible).shouldBe(enabled);
//      Step 2 Fill in the fields "Email address" and "Password" with the already registered data
//      All the mandatory fields are filled in
        Pages.loginAndRegistrationPage.setEmailField(data.getLoginData().getEmailAddress());
        Pages.loginAndRegistrationPage.setPasswordField(data.getLoginData().getPassword());
//      Step 3 Click on the Login button
//      A page titled "My dashboard" is present
//      The following list items are present: Account Information, Address Book, My Orders,
//      Billing Agreements, My Product Reviews, My Applications
        Pages.loginAndRegistrationPage.loginBtn.shouldBe(enabled).click();
        Pages.accountDashboard.descriptionTitle.shouldHave(exactText("My Dashboard"));
        Pages.accountDashboard.accountInformation.shouldBe(visible).shouldBe(enabled);
        Pages.accountDashboard.addressBook.shouldBe(visible).shouldBe(enabled);
        Pages.accountDashboard.myOrders.shouldBe(visible).shouldBe(enabled);
        Pages.accountDashboard.billingAgreements.shouldBe(visible).shouldBe(enabled);
        Pages.accountDashboard.myProductReviews.shouldBe(visible).shouldBe(enabled);
        Pages.accountDashboard.myApplications.shouldBe(visible).shouldBe(enabled);

    }

}
