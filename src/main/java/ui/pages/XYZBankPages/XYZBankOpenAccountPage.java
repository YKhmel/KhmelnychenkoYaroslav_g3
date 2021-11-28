package ui.pages.XYZBankPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class XYZBankOpenAccountPage extends XYZBankMainPage{

    public XYZBankOpenAccountPage(WebDriver webDriver){
        super(webDriver);
    }

    public String textFromAlert;

    @FindBy(xpath = "//select[@name='userSelect']")
    public WebElement customerSelect;

    @FindBy(xpath = "//select[@name='currency']")
    public WebElement currencySelect;

    @FindBy(xpath = "//button[normalize-space()='Process']")
    public WebElement processButton;


    public XYZBankOpenAccountPage selectCustomerName (String text){
        webElements.selectTextInDropDownByText(customerSelect, text);
        return this;
    }

    public XYZBankOpenAccountPage selectCurrency (String text){
        webElements.selectTextInDropDownByText(currencySelect, text);
        return this;
    }

    public XYZBankOpenAccountPage clickProcessButton() {
        processButton.click();
        return this;
    }

    public XYZBankOpenAccountPage openNewAccount(String customer, String currency) {
        selectCustomerName(customer);
        selectCurrency(currency);
        clickProcessButton();
        textFromAlert = webDriver.switchTo().alert().getText();
        webElements.acceptAlert();
        return this;
    }
}