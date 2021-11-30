package selenideTests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.testng.ScreenShooter;
import com.codeborne.selenide.testng.TextReport;
import com.codeborne.selenide.testng.annotations.Report;
import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import pagesSelenide.automationpractice.*;

import java.util.HashMap;
import java.util.Map;

@Listeners({ScreenShooter.class, TextReport.class})
@Report
public class BaseTest {

    public Faker faker = new Faker();

    private final String baseUrl_1 = "http://automationpractice.com";

    public SignInPage signInPage = new SignInPage();
    public RegistrationPage registrationPage = new RegistrationPage();
    public MyAccountPage myAccountPage = new MyAccountPage();
    public MainPage mainPage = new MainPage();

    public void setUpBrowser(){
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        // 1 - Allow, 2- Block, 0 - default
        prefs.put("profile.default_content_seetting_values.notification", 1);
        options.setExperimentalOption("prefs", prefs);
        options.addArguments("disable-infobars");
        options.addArguments("--start-maximized");
        WebDriverRunner.setWebDriver(new ChromeDriver(options));
    }

    @BeforeClass
    public void setUp(){
        final String RUN_TYPE = "local";
        switch (RUN_TYPE){
            case ("local"):
                WebDriverManager.chromedriver().browserVersion("96").setup();
                Configuration.browser = "chrome";
                Configuration.timeout = 10000;
                Configuration.baseUrl = baseUrl_1;
                Configuration.screenshots = true;
                Configuration.savePageSource = true;
                Configuration.reopenBrowserOnFail = true;
                setUpBrowser();
                Selenide.open(Configuration.baseUrl);
                break;
            case ("remote"):
                Configuration.remote = baseUrl_1;
                Configuration.browserSize = "1920x1080";
                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setCapability("browserName", "chrome");
                capabilities.setCapability("browserVersion", "91.0");
                capabilities.setCapability("platform", "LINUX");
                capabilities.setCapability("enableVNC", true);
                capabilities.setCapability("enableVideo", true);
                capabilities.setCapability("enableLog", true);
                Configuration.browserCapabilities = capabilities;
                Selenide.open(baseUrl_1);
                break;
        }
    }

    @AfterClass
    public void tearDown(){
        WebDriverRunner.getWebDriver().quit();
    }
}