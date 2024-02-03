package tests.E2E;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import config.Config;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Pages;
import pages.ProductDetails;
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
        Pages.topsBlouses.firstProduct.shouldBe(visible).click();
//      The product details page is displayed
//      The product name, price, and other key elements are visible
        Pages.productDetails.productName.shouldBe(visible);
        Pages.productDetails.priceInfo.shouldBe(visible);
        Pages.productDetails.availabilityInfo.shouldBe(visible);
        Pages.productDetails.shortProductInfo.shouldBe(visible);
        Pages.productDetails.colorLabel.shouldBe(visible);
        Pages.productDetails.colorOptions.shouldBe(visible);
        Pages.productDetails.sizeLabel.shouldBe(visible);
        Pages.productDetails.sizeOptions.shouldBe(visible);
        Pages.productDetails.addToCartBtn.shouldBe(visible).shouldBe(enabled);
        Pages.productDetails.descriptionSection.shouldBe(visible);
        Pages.productDetails.additionalInfoSection.shouldBe(visible);
        Pages.productDetails.reviewsSection.shouldBe(visible);
//      Step 5 Select color and size
        Pages.productDetails.selectColor();
        Pages.productDetails.selectSize();
//      Step 6 Add the product to the cart by clicking on the "Add to Cart" button
        Pages.productDetails.addToCartBtn.click();
        Pages.productDetails.cartBtn.shouldBe(visible).shouldBe(enabled).click();
//      Step 7 Shopping cart page is present
//      Verify the product with correct name is in the cart
        assert Pages.cart.areProductNamesMatching() : "Product names do not match";


    }

}
