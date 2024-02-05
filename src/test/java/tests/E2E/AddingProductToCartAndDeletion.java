package tests.E2E;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import config.Config;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Pages;
import tests.BaseTest;

import java.util.Objects;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.testng.Assert.assertEquals;

public class AddingProductToCartAndDeletion extends BaseTest {

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
        Pages.homePage.accountBtn.shouldBe(visible).shouldBe(enabled).click();
        Pages.homePage.logInBtn.shouldBe(visible).shouldBe(enabled).click();
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
//      Step 7 Shopping cart page is present (HOW TO DO IT)
//      Verify the id of the product in the cart
        String cartProductUniqueId = Pages.cart.getProductInCartUniqueId();
//      Step 8 Go back to the Product details page
//      Verify whether the selected product has the same id
        getWebDriver().navigate().back();
        String productUniqueIdFromDetailsPage = Pages.productDetails.getProductUniqueId();
        assert Objects.equals(productUniqueIdFromDetailsPage, cartProductUniqueId) : "Product IDs do not match";
//      Step 9 Click on the Cart button in the navigation menu
//      The Cart page is present
        Pages.productDetails.minicartBtn.shouldBe(visible).shouldBe(enabled).click();
        Pages.productDetails.viewCartBtn.shouldBe(visible).shouldBe(enabled).click();
        Pages.cart.pageTitle.shouldBe(visible).shouldHave(exactText("Shopping Cart"));
//      Step 10 Delete the product in the cart
//      The product is deleted
        Pages.cart.removeItemBtn.shouldBe(visible).shouldBe(enabled).click();
        Pages.cart.productInCartContainer
                .find("input.qty[id='S" + productUniqueIdFromDetailsPage + "']")
                .shouldNotBe(visible);
    }
}
