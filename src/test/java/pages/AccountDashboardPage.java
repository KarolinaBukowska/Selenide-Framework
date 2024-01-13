package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

public class AccountDashboardPage {

    public SelenideElement descriptionTitle = Selenide.$("div.page-title > h1");
    public SelenideElement accountInformation = Selenide.$x("//li/a[text()='Account Information']");
    public SelenideElement addressBook = Selenide.$x("//li/a[text()='Address Book']");
    public SelenideElement myOrders = Selenide.$x("//li/a[text()='My Orders']");
    public SelenideElement billingAgreements = Selenide.$x("//li/a[text()='Billing Agreements']");
    public SelenideElement myProductReviews = Selenide.$x("//li/a[text()='My Product Reviews']");
    public SelenideElement myApplications = Selenide.$x("//li/a[text()='My Applications']");


}
