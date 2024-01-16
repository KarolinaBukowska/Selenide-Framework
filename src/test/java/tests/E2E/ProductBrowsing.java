package tests.E2E;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import config.Config;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Pages;
import tests.BaseTest;

import static com.codeborne.selenide.Condition.*;
import static org.testng.Assert.assertEquals;

public class ProductBrowsing extends BaseTest {

    @BeforeClass
    public void setUp() {
        setUpUsersData(Config.USERS_DATA);
    }

    @Test
    public void productBrowsing(){


//      Preconditions:
//      Home page is present
        Selenide.open(Config.BASE_URL);
        String url = WebDriverRunner.url();
        assertEquals(url, Config.BASE_URL);

//      Step 1 Navigate to the Account and select Log In from the dropdown/submenu
//      A page titled "Login or Create an Account" is present
        Pages.homePage.accountBtn.shouldBe(enabled).click();
        Pages.homePage.logInBtn.shouldBe(enabled).click();
        Pages.loginAndRegistrationPage.descriptionTitle.shouldHave(exactText("Login or Create an Account"));
//      Step 2 Log in with the registered user's credentials
//      A page titled "My dashboard" is present
        Pages.loginAndRegistrationPage.login(users.getUserOne());
        Pages.accountDashboard.descriptionTitle.shouldBe(visible).shouldHave(exactText("My Dashboard"));
//      Step 3 Navigate to the Women category and select Tops & Blouses from the dropdown
        Pages.navigationMenu.navigateWomenTopsBlouses();
//      Verify the user is on the correct page
        Pages.topsBlouses.descriptionTitle.shouldBe(visible).shouldHave(exactText("Tops & Blouses"));
//      Step 4 Click on a product in the listing
//      The product details page is displayed
//      The product name, price, and other relevant information is visible
//      Step 5 Add the product to the cart by clicking on the "Add to Cart" button
//      Step 6 Navigate to the shopping cart
//      Verify the product is in the cart

    }

}
