package libs;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class WebElements {

    WebDriver webDriver;
    Logger logger;

    public WebElements(WebDriver webDriver){
        this.webDriver = webDriver;
        logger = Logger.getLogger(getClass());
    }

    /**
     * Method input text
     * @param element
     * @param text
     * */
    public void inputText(WebElement element,String text){
        try {
            element.clear();
            element.sendKeys(text);
        }catch (Exception e){
            logger.error("Can't work with element " + element);
            Assert.fail("Can't work with element " + element);
        }
    }

    /**
     * Method click element button
     * @param element
     * */
    public void clickElement(WebElement element){
        try {
            element.click();
            logger.info("Element was clicked " + element);
        } catch (Exception e){
            logger.error("Can't work with element " + element);
            Assert.fail("Can't work with element " + element);
        }
    }

    public void clickRadioButton(WebElement element, String text) {
        try {
            boolean status = element.isSelected();
            if (status) {
                logger.info("Checkbox is initially checked");
            } else {
                element.click();
                logger.info("Element was clicked " + element);
            }
        } catch (Exception e) {
            logger.error("Can't work with element " + element);
        }
    }

    public boolean isElementPresent(String text){
        try {
            return webDriver.findElement(By.xpath(text)).isDisplayed();
        }catch (Exception e){
            return false;
        }
    }

    public void selectTextInDropDownByText(WebElement element, String text){
        try {
            Select optionsFromDropDownByText = new Select(element);
            optionsFromDropDownByText.selectByValue(text);
            logger.info("Was selected is DropDown y text: " + text);
        } catch (Exception e){
            logger.error("Cant work with element: " + element);
        }
    }

    public void selectValueInDropDown(WebElement element, String value) {
        try {
            Select optionsFromDropDown = new Select(element);
            optionsFromDropDown.selectByVisibleText(value);
            logger.info("was selected by values " + value);
        } catch (Exception e) {
            logger.error("Can't work with DropDown " + element);
        }
    }

    public boolean isElementPresent(WebElement element){
        try {
            return element.isDisplayed();
        }catch (Exception e){
            return false;
        }
    }

    public void acceptAlert() {
        webDriver.switchTo().alert().accept();
    }

    public void checkAC(boolean actualRes, boolean expectedRes){
        Assert.assertEquals(actualRes, expectedRes);
    }
}
