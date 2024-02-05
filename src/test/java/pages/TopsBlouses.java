package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

public class TopsBlouses {
    public SelenideElement descriptionTitle = Selenide.$("div.page-title > h1");
    public SelenideElement firstProduct = Selenide.$(".category-products .products-grid li:first-child a[title=\"View Details\"]");
    public SelenideElement secondProduct = Selenide.$(".category-products .products-grid li:nth-child(2) a[title=\"View Details\"]");
    public SelenideElement thirdProduct = Selenide.$(".category-products .products-grid li:nth-child(3) a[title=\"View Details\"]");
    public SelenideElement fourthProduct = Selenide.$(".category-products .products-grid li:nth-child(4) a[title=\"View Details\"]");

}
