package homework_5;

import baseTest.BaseTest;
import org.junit.*;

public class Homework5Tests extends BaseTest {

    private final String EMAIL = "k645656dmvfv_dc45sc@gmail.com";
    private final String FIRST_NAME = "Yaroslav";
    private final String LAST_NAME = "Khmelnychenko";
    private final String PASSWORD = "qwerty123";
    private final String ADRESS = "street Kyiv, 77";
    private final String CITY = "Kyiv";
    private final String STATE = "New York";
    private final String COUNTRY = "United States";
    private final String POST_CODE = "98765";
    private final String MOBILE_PHONE = "1234567890";

    public Homework5Tests(String browser) {
        super(browser);
    }

    @Test
    public void registrationTest() {
        mainPage.openUrl("http://automationpractice.com/");
        registrationPage.openSignInPage();
        registrationPage.imputEmailCreate(EMAIL);
        registrationPage.submitButtonCreate();
        registrationPage.inputCustomerFirstName(FIRST_NAME);
        registrationPage.inputCustomerLastName(LAST_NAME);
        registrationPage.inputEmail(EMAIL);
        registrationPage.inputPassword(PASSWORD);
        registrationPage.inputFirstName(FIRST_NAME);
        registrationPage.inputLastName(LAST_NAME);
        registrationPage.inputAddress(ADRESS);
        registrationPage.inputCity(CITY);
        registrationPage.selectState(32);
        registrationPage.inputPostcode(POST_CODE);
        registrationPage.inputPhoneMobile(MOBILE_PHONE);
        registrationPage.inputAlias(EMAIL);
        registrationPage.clickSubmitAccountButton();
        Assert.assertEquals("MY ACCOUNT",
                myAccountPage.checkTitle());
        myAccountPage.checkTitle("Title",
                myAccountPage.checkTitleTextOnPage("My account - My Store"), true);
    }

    @Test
    public void registrationTest2() {
        mainPage.openUrl("http://automationpractice.com/");
        registration2Page
                .openSignInPage()
                .inputEmailCreate(EMAIL)
                .submitButtonCreate()
                .inputCustomerFirstName(FIRST_NAME)
                .inputCustomerLastName(LAST_NAME)
                .inputEmail(EMAIL)
                .inputPassword(PASSWORD)
                .inputFirstName(FIRST_NAME)
                .inputLastName(LAST_NAME)
                .inputAddress(ADRESS)
                .inputCity(CITY)
                .selectState(STATE)
                .selectCountry(COUNTRY)
                .inputPostcode(POST_CODE)
                .inputPhoneMobile(MOBILE_PHONE)
                .inputAlias(EMAIL)
                .clickSubmitAccountButton();
        Assert.assertEquals("MY ACCOUNT",
                myAccountPage.checkTitle());
    }

    @Test
    public void registrationTest3() {
        mainPage.openUrl("http://automationpractice.com/");
        registration2Page
                .openSignInPage()
                .inputEmailCreate(EMAIL)
                .submitButtonCreate()
                .inputCustomerFirstName(FIRST_NAME)
                .inputCustomerLastName(LAST_NAME)
                .inputEmail(EMAIL)
                .inputPassword(PASSWORD)
                .inputFirstName(FIRST_NAME)
                .inputLastName(LAST_NAME)
                .inputAddress(ADRESS)
                .inputCity(CITY)
                .inputPostcode(POST_CODE)
                .inputPhoneMobile(MOBILE_PHONE)
                .inputAlias(EMAIL)
                .clickSubmitAccountButton()
                .checkErrorMsg("This country requires you to choose a State.");
    }
}


