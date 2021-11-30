package selenoidTests.baseTest;

import com.github.javafaker.Faker;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import libs.Utils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import pagesSelenium.XYZBankPages.*;
import pagesSelenium.automationpractice.*;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    private WebDriver webDriver;
    public Logger logger =Logger.getLogger(getClass());

    public pagesSelenium.XYZBankPages.XYZBankMainPage XYZBankMainPage;
    public pagesSelenium.XYZBankPages.XYZBankBankManagerPage XYZBankBankManagerPage;
    public XYZBankCustomerPage XYZBankCustomerPage;
    public pagesSelenium.XYZBankPages.XYZBankAddCustomerPage XYZBankAddCustomerPage;
    public pagesSelenium.XYZBankPages.XYZBankOpenAccountPage XYZBankOpenAccountPage;
    public pagesSelenium.XYZBankPages.XYZBankCustomerProfilePage XYZBankCustomerProfilePage;

    public MainPage mainPage;
    public RegistrationPage registrationPage;
    public Registration2Page registration2Page;
    public MyAccountPage myAccountPage;
    public SignInPage signInPage;
    public Utils utils = new Utils();
    public Faker faker = new Faker();
    public String patchToScreenShot;

    public BaseTest(){
    }

    @Parameters("browserName")
    @BeforeClass(alwaysRun = true)
    @Step("Set up browser options {browser}")
    public void setUp(@Optional("chrome") String browser){
        if (browser.toLowerCase().equals("chrome")){
            logger.info(browser + "will be started");
            File fileChromeDriver = new File("C:\\WORK\\ChromeDriver\\chromedriver.exe");
            System.setProperty("webdriver.chrome.driver", fileChromeDriver.getAbsolutePath());
            webDriver = new ChromeDriver();
            logger.info(browser + "is started");
        } else if (browser.toLowerCase().equals("firefox")) {
            logger.info(browser + "will be started");
            File fileChromeDriver = new File("C:\\WORK\\ChromeDriver\\geckodriver.exe");
            System.setProperty("webdriver.gecko.driver", fileChromeDriver.getAbsolutePath());
            webDriver = new FirefoxDriver();
            logger.info(browser + "is started");
        }

        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        File file = new File("");
        patchToScreenShot = file.getAbsolutePath() + "\\resourses\\screenshot" + "-" +
                this.getClass().getPackage().getName() + "\\" +
                this.getClass().getSimpleName() + ".png";

        initPages();
    }

    public void initPages() {
        mainPage = new MainPage(webDriver);
        registrationPage = new RegistrationPage(webDriver);
        registration2Page = new Registration2Page(webDriver);
        myAccountPage = new MyAccountPage(webDriver);
        signInPage = new SignInPage(webDriver);

        XYZBankMainPage = new XYZBankMainPage(webDriver);
        XYZBankBankManagerPage = new XYZBankBankManagerPage(webDriver);
        XYZBankCustomerPage = new XYZBankCustomerPage(webDriver);
        XYZBankAddCustomerPage = new XYZBankAddCustomerPage(webDriver);
        XYZBankOpenAccountPage = new XYZBankOpenAccountPage(webDriver);
        XYZBankCustomerProfilePage = new XYZBankCustomerProfilePage(webDriver);
    }

    @Step("Tear down browser")
    @AfterClass
    public void tyrDown(){
        if(!(webDriver == null)) {
            utils.screenShot(patchToScreenShot, webDriver);
            webDriver.quit();
        }
    }

    @Attachment(value = "scrreenshot", type = "image/png")
    public byte[] screenshot() {
        return ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES);
    }
}
