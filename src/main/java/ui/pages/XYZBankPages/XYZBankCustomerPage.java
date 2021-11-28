package ui.pages.XYZBankPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class XYZBankCustomerPage extends XYZBankMainPage{

    public XYZBankCustomerPage(WebDriver webDriver){
        super(webDriver);
    }

    @FindBy(xpath = "//select[@name='userSelect']")
    public WebElement yourNameSelect;

    @FindBy(xpath = "//button[normalize-space()='Login']")
    public WebElement loginButton;

    public XYZBankCustomerPage selectCustomerName (String text){
        webElements.selectTextInDropDownByText(yourNameSelect, text);
        return this;
    }

    public XYZBankCustomerPage clickLoginButton() {
        loginButton.click();
        return this;
    }

    public XYZBankCustomerPage loginAsCustomerUser(String user) {
        selectCustomerName(user);
        clickLoginButton();
        return this;
    }
}
