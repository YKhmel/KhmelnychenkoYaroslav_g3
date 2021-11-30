package pagesSelenium.XYZBankPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class XYZBankAddCustomerPage extends XYZBankMainPage{

    public XYZBankAddCustomerPage(WebDriver webDriver){
        super(webDriver);
    }

    public String textFromAlert;

    @FindBy(xpath = "//button[normalize-space()='Add Customer']")
    public WebElement addCustomerPageButton;

    @FindBy(xpath = "//button[normalize-space()='Open Account']")
    public WebElement openAccountPageButton;

    @FindBy(xpath = "//input[@placeholder='First Name']")
    public WebElement firstNameInput;

    @FindBy(xpath = "//input[@placeholder='Last Name']")
    public WebElement lastNameInput;

    @FindBy(xpath = "//input[@placeholder='Post Code']")
    public WebElement postCodeInput;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement addCustomerButton;

    public XYZBankAddCustomerPage clickSubmitAddCustomerButton() {
        addCustomerButton.click();
        return this;
    }

    public XYZBankAddCustomerPage clickAddCustomerPageButton() {
        addCustomerPageButton.click();
        return this;
    }

    public XYZBankAddCustomerPage clickOpenAccountPageButton() {
        openAccountPageButton.click();
        return this;
    }

    public XYZBankAddCustomerPage inputFirstName (String text){
        firstNameInput.clear();
        firstNameInput.sendKeys(text);
        return this;
    }

    public XYZBankAddCustomerPage inputLastNAme (String text){
        lastNameInput.clear();
        lastNameInput.sendKeys(text);
        return this;
    }

    public XYZBankAddCustomerPage inputPostCode (String text){
        postCodeInput.clear();
        postCodeInput.sendKeys(text);
        return this;
    }

    public XYZBankAddCustomerPage acceptAlert() {
        addCustomerButton.click();
        textFromAlert = webDriver.switchTo().alert().getText();
        webElements.acceptAlert();
        return this;
    }

    public XYZBankAddCustomerPage createNewCustomer(String firstName, String lastName, String postCode) {
        openAddCustomerPage();
        inputFirstName(firstName);
        inputLastNAme(lastName);
        inputPostCode(postCode);
        acceptAlert();
        return this;
    }

    public XYZBankAddCustomerPage openAddCustomerPage(){
        openMainPage().loginAsBankManager();
        clickAddCustomerPageButton();
        return this;
    }
}