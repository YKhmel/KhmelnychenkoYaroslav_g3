package homework_3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class Homework3Tests {

    WebDriver webDriver;

    @BeforeClass
    public void setUp(){
        File fileChromeDriver = new File("C:\\WORK\\ChromeDriver\\chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", fileChromeDriver.getAbsolutePath());
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.get("https://ru.wikipedia.org");
    }

    @AfterClass
    public void tyrDown(){
        webDriver.quit();
    }

    @Test
    public void mvnrepositoryTest() throws InterruptedException {
        String exMainPageTile = webDriver.getTitle();
        Assert.assertEquals("Википедия — свободная энциклопедия", exMainPageTile);

        webDriver.findElement(By.xpath("//*[@id='searchInput']")).sendKeys("Selenium Java");
        webDriver.findElement(By.xpath("//*[@id='searchButton']")).click();

        String exHeader = webDriver.findElement(By.xpath("//*[@id='firstHeading']")).getText();
        Assert.assertEquals("Результаты поиска", exHeader);

        webDriver.findElement(By.linkText("Selenium")).click();
        String exSeleniumPageHeader = webDriver.findElement(By.xpath("//*[@id='firstHeading']")).getText();
        Assert.assertEquals("Selenium", exSeleniumPageHeader);

        webDriver.findElement(By.xpath("//*[@id='mw-content-text']/div[1]/table[1]/tbody/tr[8]/td/span/a")).click();
        String exUrl = webDriver.getCurrentUrl();
        Assert.assertEquals("https://www.selenium.dev/", exUrl);
    }
}