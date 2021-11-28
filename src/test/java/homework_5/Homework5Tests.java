package homework_5;

import baseTest.BaseTest;
import io.qameta.allure.*;
import model.Account;
import org.testng.Assert;
import dataProviders.RegistrationPageDataProvider;
import org.testng.annotations.Test;
import ui.pages.automationpractice.Registration2Page;

public class Homework5Tests extends BaseTest {

    private final String EMAIL = faker.internet().emailAddress();
    private final String GENDER = "Mr.";
    private final String FIRST_NAME = "Yaroslav";
    private final String LAST_NAME = "Khmelnychenko";
    private final String PASSWORD = "qwerty123";
    private final String DAY = "5";
    private final String MONTH = "10";
    private final String YEAR = "1989";
    private final String ADRESS = "street Kyiv, 77";
    private final String CITY = "Kyiv";
    private final String STATE = "Alabama";
    private final String COUNTRY = "United States";
    private final String POST_CODE = "98765";
    private final String MOBILE_PHONE = "1234567890";

//    @Test
//    public void registrationTest() {
//        mainPage.openUrl("http://automationpractice.com/");
//        signInPage.clickSignIn();
//        signInPage.inputEmailCreate(EMAIL);
//        signInPage.submitButtonCreate();
//        registrationPage.selectGender(GENDER);
//        registrationPage.inputCustomerFirstName(FIRST_NAME);
//        registrationPage.inputCustomerLastName(LAST_NAME);
//        registrationPage.inputEmail(EMAIL);
//        registrationPage.inputPassword(PASSWORD);
//        registrationPage.selectBirthDay(DAY);
//        registrationPage.selectBirthMonth(MONTH);
//        registrationPage.selectBirthYear(YEAR);
//        registrationPage.inputFirstName(FIRST_NAME);
//        registrationPage.inputLastName(LAST_NAME);
//        registrationPage.inputAddress(ADRESS);
//        registrationPage.inputCity(CITY);
//        registrationPage.selectState(STATE);
//        registrationPage.selectCountry(COUNTRY);
//        registrationPage.inputPostcode(POST_CODE);
//        registrationPage.inputPhoneMobile(MOBILE_PHONE);
//        registrationPage.inputAlias(EMAIL);
//        registrationPage.clickSubmitAccountButton();
//        Assert.assertEquals("MY ACCOUNT",
//                myAccountPage.checkTitle());
//                myAccountPage.checkTitle(myAccountPage.titleRegisteredAccount.isDisplayed(), true);
//    }
//
//    @Test
//    public void registrationTest2() {
//        mainPage.openUrl("http://automationpractice.com/");
//        signInPage
//                .clickSignIn()
//                .inputEmailCreate(EMAIL)
//                .submitButtonCreate();
//        registration2Page
//                .selectGender(GENDER)
//                .inputCustomerFirstName(FIRST_NAME)
//                .inputCustomerLastName(LAST_NAME)
//                .inputEmail(EMAIL)
//                .inputPassword(PASSWORD)
//                .selectBirthDay(DAY)
//                .selectBirthMonth(MONTH)
//                .selectBirthYear(YEAR)
//                .inputFirstName(FIRST_NAME)
//                .inputLastName(LAST_NAME)
//                .inputAddress(ADRESS)
//                .inputCity(CITY)
//                .selectState(STATE)
//                .selectCountry(COUNTRY)
//                .inputPostcode(POST_CODE)
//                .inputPhoneMobile(MOBILE_PHONE)
//                .inputAlias(EMAIL)
//                .clickSubmitAccountButton();
//        Assert.assertEquals("MY ACCOUNT",
//                myAccountPage.checkTitle());
//    }
//
//    @Test
//    public void registrationTest3() {
//        mainPage.openUrl("http://automationpractice.com/");
//        signInPage
//                .clickSignIn()
//                .inputEmailCreate(EMAIL)
//                .submitButtonCreate();
//        registration2Page
//                .inputCustomerFirstName(FIRST_NAME)
//                .inputCustomerLastName(LAST_NAME)
//                .inputEmail(EMAIL)
//                .inputPassword(PASSWORD)
//                .inputFirstName(FIRST_NAME)
//                .inputLastName(LAST_NAME)
//                .inputAddress(ADRESS)
//                .inputCity(CITY)
//                .inputPostcode(POST_CODE)
//                .inputPhoneMobile(MOBILE_PHONE)
//                .inputAlias(EMAIL)
//                .clickSubmitAccountButton();
//        Assert.assertEquals(Registration2Page.checkErrorMsg(),"This country requires you to choose a State.");
//    }

    @Epic(value= "Registration")
    @Story(value= "User can registration for this test")
    @Description(value = "Test registration new user account")
    @Issue("GS-213")
    @TmsLink(value = "TL-2134")
    @Link(value = "link", url = "url")
    @Owner(value= "Yaroslav")
    @Severity(value = SeverityLevel.CRITICAL)
    @Test(dataProvider = "registrationNewUser", dataProviderClass = RegistrationPageDataProvider.class)
    public void testCreateNewAccount(Account userAccount) {
        mainPage.openUrl("http://automationpractice.com/");
        signInPage
                .clickSignIn()
                .inputEmailCreate(EMAIL)
                .submitButtonCreate();
        registration2Page
                .registrationNewUser(userAccount)
                .clickSubmitAccountButton();
        Assert.assertEquals(myAccountPage.getAccountName(),
                userAccount.getFirstCustomerName() + " " + userAccount.getLastCustomerName());
    }
}