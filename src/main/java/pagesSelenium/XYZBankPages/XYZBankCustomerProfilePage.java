package pagesSelenium.XYZBankPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class XYZBankCustomerProfilePage extends XYZBankMainPage{

    public XYZBankCustomerProfilePage(WebDriver webDriver){
        super(webDriver);
    }

    @FindBy(xpath = "//span[@ng-show='noAccount']")
    public WebElement noAccountMessageField;

    @FindBy(xpath = "//span[@ng-show='message']")
    public WebElement errorMessage;

    @FindBy(xpath = "//button[normalize-space()='Withdrawl']")
    public WebElement withdrawlButton;

    @FindBy(xpath = "//input[@placeholder='amount']")
    public WebElement withdrawlAmountField;

    @FindBy(xpath = "//button[normalize-space()='Withdraw']")
    public WebElement withdrawButton;

    public String checkNoAccountMessage(){
        return noAccountMessageField.getText();
    }

    public String checkErrorMessage(){
        return errorMessage.getText();
    }

    public XYZBankCustomerProfilePage openWithdrawlSectionButton() {
        withdrawlButton.click();
        return this;
    }

    public XYZBankCustomerProfilePage clickWithdrawButton() {
        withdrawButton.click();
        return this;
    }

    public XYZBankCustomerProfilePage inputAmount (String text){
        withdrawlAmountField.clear();
        withdrawlAmountField.sendKeys(text);
        return this;
    }

    public XYZBankCustomerProfilePage withdrawFromBalance (String amount){
        openWithdrawlSectionButton();
        inputAmount(amount);
        clickWithdrawButton();
        return this;
    }
}
