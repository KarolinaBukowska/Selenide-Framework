package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

public class HomePage {

    public SelenideElement accountBtn = Selenide.$x("//a[contains(@class, 'skip-account')]//span[contains(@class, 'label') and text()='Account']");
    public SelenideElement myAccountBtn = Selenide.$x("//*[@id='header-account']//li[@class='first']/a[@title='My Account']");


}


