package baseTest;

import libs.Utils;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ui.pages.*;
import ui.pages.XYZBankPages.*;

import java.io.File;
import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

@RunWith(value = Parameterized.class)

public class BaseTest {
    private WebDriver webDriver;
    public Logger logger =Logger.getLogger(getClass());

    public XYZBankMainPage XYZBankMainPage;
    public XYZBankBankManagerPage XYZBankBankManagerPage;
    public XYZBankCustomerPage XYZBankCustomerPage;
    public XYZBankAddCustomerPage XYZBankAddCustomerPage;
    public XYZBankOpenAccountPage XYZBankOpenAccountPage;
    public XYZBankCustomerProfilePage XYZBankCustomerProfilePage;

    public MainPage mainPage;
    public RegistrationPage registrationPage;
    public Registration2Page registration2Page;
    public MyAccountPage myAccountPage;
    public Utils utils = new Utils();

    public String browser;
    public String patchToScreenShot;

    public BaseTest(String browser){
        this.browser = browser;
    }

    @Parameterized.Parameters
    public static Collection testData() {
        return Arrays.asList(new Object[][]{
                {"chrome"},
//                {"firefox"}
        });
    }

    @Rule
    public TestName testName = new TestName();

    @Before
    public void setUp(){
        if ("chrome".equals(browser)){
            logger.info(browser + "will be started");
            File fileChromeDriver = new File("C:\\WORK\\ChromeDriver\\chromedriver.exe");
            System.setProperty("webdriver.chrome.driver", fileChromeDriver.getAbsolutePath());
            webDriver = new ChromeDriver();
            logger.info(browser + "is started");
        } else if ("firefox".equals(browser)) {
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
                this.getClass().getSimpleName() +
                "\\" + this.testName.getMethodName() + "-" + browser + ".png";

        initPages();
    }

    public void initPages() {
        mainPage = new MainPage(webDriver);
        registrationPage = new RegistrationPage(webDriver);
        registration2Page = new Registration2Page(webDriver);
        myAccountPage = new MyAccountPage(webDriver);

        XYZBankMainPage = new XYZBankMainPage(webDriver);
        XYZBankBankManagerPage = new XYZBankBankManagerPage(webDriver);
        XYZBankCustomerPage = new XYZBankCustomerPage(webDriver);
        XYZBankAddCustomerPage = new XYZBankAddCustomerPage(webDriver);
        XYZBankOpenAccountPage = new XYZBankOpenAccountPage(webDriver);
        XYZBankCustomerProfilePage = new XYZBankCustomerProfilePage(webDriver);
    }

    @After
    public void tyrDown(){
        if(!(webDriver == null)) {
            utils.screenShot(patchToScreenShot, webDriver);
            webDriver.quit();
        }
    }
}
