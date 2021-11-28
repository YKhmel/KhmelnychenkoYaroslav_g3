package ui.pages.XYZBankPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class XYZBankBankManagerPage extends XYZBankMainPage{

    public XYZBankBankManagerPage(WebDriver webDriver){
        super(webDriver);
    }

    @FindBy(xpath = "//button[normalize-space()='Add Customer']")
    public WebElement addCustomerButton;

    @FindBy(xpath = "//button[normalize-space()='Open Account']")
    public WebElement openAccountButton;

    @FindBy(xpath = "//button[normalize-space()='Customers']")
    public WebElement customersButton;

    public XYZBankBankManagerPage addCustomer() {
        addCustomerButton.click();
        return this;
    }

    public XYZBankBankManagerPage openAccount() {
        openAccountButton.click();
        return this;
    }

    public XYZBankBankManagerPage openCustomersList() {
        customersButton.click();
        return this;
    }
}
