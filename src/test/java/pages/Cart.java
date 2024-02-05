package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

public class Cart {

    public SelenideElement productInCartContainer = Selenide.$(".product-details");
    public SelenideElement pageTitle = Selenide.$("h1");
    public SelenideElement removeItemBtn = Selenide.$(".a-center.product-cart-remove.last a");

    public String getProductInCartUniqueId() {
        return productInCartContainer.find("input.qty").getAttribute("id");
    }
}
