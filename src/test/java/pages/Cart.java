package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import java.util.Objects;

public class Cart {

    public SelenideElement productNameInCart = Selenide.$("h2.product-name a");

    public String getProductNameInCart(){
        return productNameInCart.getText();
    }

    public boolean areProductNamesMatching(){
        String productNameFromDetailsPage = Pages.productDetails.getProductName();
        String productNameInCart = Pages.cart.getProductNameInCart();

        return Objects.equals(productNameFromDetailsPage, productNameInCart);
    }


}
