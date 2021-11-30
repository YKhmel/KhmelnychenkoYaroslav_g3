package selenoidTests.homework_4;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pagesSelenium.automationpractice.MainPage;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class Homework4Tests {
    private WebDriver webDriver;
    public Logger logger =Logger.getLogger(getClass());

    public MainPage mainPage;

    @BeforeClass
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
        mainPage.openUrl("https://finance.i.ua/converter/");
    }

    @AfterClass
    public void tyrDown(){
        webDriver.quit();
    }

    @Test
    public void сurrencyConverterTest1() {
        String expectedTitle = webDriver.findElement(By.className("_title")).getText();
        Assert.assertEquals("Курсы валют", expectedTitle);
    }
    @Test
    public void сurrencyConverterTest2() {

        webDriver.findElement(By.xpath("//select[@id='converter_bank']")).click();
        webDriver.findElement(By.xpath("//select[@id='converter_bank']")).click();
        webDriver.findElement(By.xpath("//option[@value='1']")).click();
        Assert.assertTrue(webDriver.findElement(By.xpath("//*[@id='PLN']/span[1]")).isDisplayed());
    }
    @Test
    public void сurrencyConverterTest3() {
        webDriver.findElement(By.xpath("//select[@id='converter_bank']")).click();
        webDriver.findElement(By.xpath("//select[@id='converter_bank']")).click();
        webDriver.findElement(By.xpath("//option[@value='2']")).click();
        Assert.assertFalse(webDriver.findElement(By.xpath("//*[@id='PLN']/span[1]")).isDisplayed());
    }
}