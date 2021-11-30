package selenideTests;

import com.codeborne.selenide.*;
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
public class RegistrationTests extends BaseTest{

    @Epic(value= "Registration")
    @Story(value= "User can registration for this test")
    @Description(value = "Test registration new user account")
    @Issue("GS-213")
    @TmsLink(value = "TL-2134")
    @Link(value = "link", url = "url")
    @Owner(value= "Yaroslav")
    @Severity(value = SeverityLevel.CRITICAL)
    @Test(dataProvider = "registrationNewUser", dataProviderClass = RegistrationPageDataProvider.class)
    public void createNewAccountTest(Account userAccount){
        signInPage
                .clickSignIn()
                .inputEmailCreate(userAccount.getEmail())
                .submitButtonCreate();
        registrationPage.registrationNewUser(userAccount);
        registrationPage.clickSubmitAccountButton();
        myAccountPage.titleRegisteredAccount.shouldHave(Condition.visible);
        Assert.assertEquals(myAccountPage.getAccountName(),
                userAccount.getFirstCustomerName() + " " + userAccount.getLastCustomerName());
    }

    @Test(dependsOnMethods = "selenideTests.RegistrationTests.createNewAccountTest")
    public void correctTotalInCartTest(){
        String totalPrice;

        Selenide.open(Configuration.baseUrl);
        mainPage.clickProduct("Blouse");
        productPage.addProductToCart();
        productPage.clickAddToWishlist()
                .clickCartButton();
        totalPrice = cartPage.getTotalPrice();
        Assert.assertEquals("$29.00",totalPrice);
    }
}