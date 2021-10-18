package homework_5;

import org.apache.log4j.Logger;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ui.pages.MainPage;
import ui.pages.MyAccountPage;
import ui.pages.Registration2Page;
import ui.pages.RegistrationPage;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class Homework5Tests {
    private WebDriver webDriver;
    public Logger logger =Logger.getLogger(getClass());

    public MainPage mainPage;
    public RegistrationPage registrationPage;
    public Registration2Page registration2Page;
    public MyAccountPage myAccountPage;

    @Before
    public void setUp(){
        logger = Logger.getLogger(getClass());
        File fileChromeDriver = new File("C:\\WORK\\ChromeDriver\\chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", fileChromeDriver.getAbsolutePath());
        webDriver = new ChromeDriver();
        logger.info("Get chromeDriver");
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        logger.info("Browser was opened");
        mainPage = new MainPage(webDriver);
        registrationPage = new RegistrationPage(webDriver);
        registration2Page = new Registration2Page(webDriver);
        myAccountPage = new MyAccountPage(webDriver);
    }

    @After
    public void tyrDown(){
        webDriver.quit();
    }

    private final String EMAIL = "k6nl8nddfv_dc45sc@gmail.com";
    private final String FIRST_NAME = "Yaroslav";
    private final String LAST_NAME = "Khmelnychenko";
    private final String PASSWORD = "qwerty123";
    private final String ADRESS = "street Kyiv, 77";
    private final String CITY = "Kyiv";
    private final int STATE = 32;
    private final String POST_CODE = "98765";
    private final String MOBILE_PHONE = "1234567890";


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
        registrationPage.selectState(STATE);
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


