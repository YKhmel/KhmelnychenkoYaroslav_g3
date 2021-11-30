package selenideTests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.testng.ScreenShooter;
import com.codeborne.selenide.testng.TextReport;
import com.codeborne.selenide.testng.annotations.Report;
import dataProviders.RegistrationPageDataProvider;
import io.qameta.allure.*;
import model.Account;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({ScreenShooter.class, TextReport.class})

@Report
public class ProductTests extends BaseTest{

    @Epic(value= "Products")
    @Story(value= "User can do actions with products")
    @Description(value = "Test purchase of products")
    @Issue("GS-214")
    @TmsLink(value = "TL-2135")
    @Link(value = "link", url = "url")
    @Owner(value= "Yaroslav")
    @Severity(value = SeverityLevel.CRITICAL)
    @Test(priority = 1)
    public void addProductToCartTest(){
        String totalPrice;

        Selenide.open(Configuration.baseUrl);
        mainPage.clickProduct("Blouse");
        productPage.addProductToCart();
        Selenide.open(Configuration.baseUrl);
        mainPage.clickProduct("Printed Chiffon Dress");
        productPage.addProductToCart()
                .clickCartButton();
        totalPrice = cartPage.getTotalPrice();
        Assert.assertEquals(totalPrice,"$45.40");

    }

    @Test(priority = 2, dependsOnMethods = "selenideTests.ProductTests.addProductToCartTest")
    public void removeProductFromCartTest(){
        String totalPrice;

        cartPage.clickDeleteButton();
        productPage.clickCartButton();
        totalPrice = cartPage.getTotalPrice();
        Assert.assertEquals(totalPrice,"$18.40");
        tearDown();
    }

    @Test(priority = 2, dataProvider = "registrationNewUser", dataProviderClass = RegistrationPageDataProvider.class)
    public void proceedToCheckoutShippingErrorTest(Account userAccount){
        Selenide.open(Configuration.baseUrl);
        mainPage.clickProduct("Blouse");
        productPage.addProductToCart();
        productPage.clickCartButton();
        cartPage.clickProceedToCheckoutButton();
        signInPage
                .clickSignIn()
                .inputEmailCreate(userAccount.getEmail())
                .submitButtonCreate();
        registrationPage.registrationNewUser(userAccount)
                .clickSubmitAccountButton();
        cartPage.clickProceedToCheckoutButton();
        cartPage.clickProceedToCheckoutButton();
        cartPage.clickProceedToCheckoutButton();
        Assert.assertEquals(cartPage.getfFancyboxErrorText(), "You must agree to the terms of service before continuing.");
    }
}