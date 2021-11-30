package pagesSelenium.XYZBankPages;

import libs.WebElements;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class XYZBankMainPage {

    @FindBy(xpath = "//button[normalize-space()='Customer Login']")
    public WebElement customerLoginButton;

    @FindBy(xpath = "//button[normalize-space()='Bank Manager Login']")
    public WebElement bankManagerLoginButton;

    @FindBy(xpath = "//button[normalize-space()='Home']")
    public WebElement homeButton;

    String mainPageUrl = "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login";

    WebDriver webDriver;
    Logger logger;
    WebElements webElements;

    public XYZBankMainPage(WebDriver webDriver){
        this.webDriver = webDriver;
        logger = Logger.getLogger(getClass());
        webElements = new WebElements(webDriver);
        PageFactory.initElements(webDriver,this);
    }

    /**
     * Metod open url
     * */
    public XYZBankMainPage openMainPage() {

        try{
            webDriver.get(mainPageUrl);
            logger.info("Page was open " + mainPageUrl);
        } catch (Exception e){
            e.printStackTrace();
            logger.info("Page can't open " + mainPageUrl);
            Assert.fail("Page can't open " + mainPageUrl);
        }
        return this;
    }

    public XYZBankMainPage loginAsCustomer() {
        openHomePage();
        customerLoginButton.click();
        return this;
    }

    public XYZBankMainPage loginAsBankManager() {
        openHomePage();
        bankManagerLoginButton.click();
        return this;
    }

    public XYZBankMainPage openHomePage() {
        homeButton.click();
        return this;
    }
}
