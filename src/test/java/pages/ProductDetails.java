package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;

public class ProductDetails {

    public SelenideElement availabilityInfo = Selenide.$(".extra-info .availability");
    public SelenideElement productName = Selenide.$(".product-name .h1");
    public SelenideElement priceInfo = Selenide.$(".price-info .price");
    public SelenideElement shortProductInfo = Selenide.$(".short-description .std");
    public SelenideElement colorLabel = Selenide.$("#color_label");
    public SelenideElement firstColor = Selenide.$("#configurable_swatch_color li:first-child a");
    public SelenideElement secondColor = Selenide.$("#configurable_swatch_color li:nth-child(2) a");
    public SelenideElement thirdColor = Selenide.$("#configurable_swatch_color li:nth-child(3) a");
    public SelenideElement fourthColor = Selenide.$("#configurable_swatch_color li:nth-child(4) a");
    public SelenideElement sizeLabel = Selenide.$("#size_label");
    public SelenideElement sizeOne = Selenide.$("#configurable_swatch_size li:first-child a");
    public SelenideElement sizeTwo = Selenide.$("#configurable_swatch_size li:nth-child(2) a");
    public SelenideElement sizeThree = Selenide.$("#configurable_swatch_size li:nth-child(3) a");
    public SelenideElement sizeFour = Selenide.$("#configurable_swatch_size li:nth-child(4) a");
    public SelenideElement colorOptions = Selenide.$("#configurable_swatch_color");
    public SelenideElement sizeOptions = Selenide.$("#configurable_swatch_size");
    public SelenideElement addToCartBtn = Selenide.$(".add-to-cart-buttons .button.btn-cart");
    public SelenideElement descriptionSection = Selenide.$(".toggle-tabs .current");
    public SelenideElement additionalInfoSection = Selenide.$(".toggle-tabs  li:nth-child(2)");
    public SelenideElement reviewsSection = Selenide.$(".toggle-tabs .last");
    public SelenideElement cartBtn = Selenide.$(".header-minicart .skip-link");

    public ProductDetails selectColor(){

        SelenideElement[] colorElements = {firstColor, secondColor, thirdColor, fourthColor};

        if (availabilityInfo.getText().equalsIgnoreCase("Out of Stock")) {
            System.out.println("Product is out of stock");
            return this;
        }

        for (SelenideElement color : colorElements){
            if (color.is(visible) && color.is(enabled)){
                color.click();

                if (addToCartBtn.is(visible) && "Add to Cart".equals(addToCartBtn.getAttribute("title"))){
                    return this;
                }
            }
        }

        System.out.println("No color is available, and there's no out of stock information.");
        return this;
    }

    public ProductDetails selectSize(){

        SelenideElement[] sizeElements = {sizeOne, sizeTwo, sizeThree, sizeFour};

        for (SelenideElement size : sizeElements){
            if (size.is(visible) && size.is(enabled)){
                size.click();

                if (addToCartBtn.is(visible) && "Add to Cart".equals(addToCartBtn.getAttribute("title"))){
                    return this;
                }
            }
        }

        System.out.println("No size is available.");
        return this;
    }

    public String getProductName(){
        return productName.getText();
    }
















}
