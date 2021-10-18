package ui.pages;

import libs.WebElements;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    WebDriver webDriver;
    Logger logger;
    WebElements webElements;

    public MainPage(WebDriver webDriver){
        this.webDriver = webDriver;
        logger = Logger.getLogger(getClass());
        webElements = new WebElements(webDriver);
        PageFactory.initElements(webDriver,this);
    }

    /**
     * Metod open url
     *
     * @param url
     * */
    public void openUrl(String url){
        try{
            webDriver.get(url);
            logger.info("Page was open " + url);
        } catch (Exception e){
            e.printStackTrace();
            logger.info("Page can't open " + url);
            Assert.fail("Page can't open " + url);
        }
    }
}
