package pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class NavigationMenu {
    public SelenideElement womenMenu = $x("//nav[@id='nav']//li[@class='level0 nav-1 first parent']");
    public SelenideElement viewAllWomenSubmenu = $x("//li[@class='level0 nav-1 first active parent']//a[text()='View All Women']");
    public SelenideElement WomenNewArrivalsSubmenu = $x("//li[@class='level0 nav-1 first active parent']//li[@class='level1 nav-1-1 first']/a[text()='New Arrivals']");
    public SelenideElement womenTopsBlousesSubmenu = $x(".//li[@class='level1 nav-1-2']/a[text()='Tops & Blouses']");
    public SelenideElement WomenPantsDenimSubmenu = $x("//li[@class='level0 nav-1 first active parent']//li[@class='level1 nav-1-3']/a[text()='Pants & Denim']");
    public SelenideElement WomenDressesSkirtsSubmenu = $x("//li[@class='level0 nav-1 first active parent']//li[@class='level1 nav-1-4 last']/a[text()='Dresses & Skirts']");


    public NavigationMenu navigateWomenViewAll() {
        womenMenu.shouldBe(enabled).hover();
        viewAllWomenSubmenu.shouldBe(visible).shouldBe(enabled).click();
        return this;
    }

    public NavigationMenu navigateWomenNewArrivals() {
        womenMenu.shouldBe(enabled).hover();
        WomenNewArrivalsSubmenu.shouldBe(visible).shouldBe(enabled).click();
        return this;
    }

    public NavigationMenu navigateWomenTopsBlouses() {
        womenMenu.shouldBe(enabled).hover();
        womenTopsBlousesSubmenu.shouldBe(visible).shouldBe(enabled).click();
        return this;
    }

    public NavigationMenu navigateWomenPantsDenim() {
        womenMenu.shouldBe(enabled).hover();
        WomenPantsDenimSubmenu.shouldBe(visible).shouldBe(enabled).click();
        return this;
    }

    public NavigationMenu navigateWomenDressesSkirts() {
        womenMenu.shouldBe(enabled).hover();
        WomenDressesSkirtsSubmenu.shouldBe(visible).shouldBe(enabled).click();
        return this;
    }


}
