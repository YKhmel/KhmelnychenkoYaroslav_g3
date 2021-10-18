package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class Registration2Page extends MainPage{

    public Registration2Page(WebDriver webDriver){
        super(webDriver);
    }

    @FindBy(xpath = "//a[@class='login']")
    public WebElement signInLink;

    @FindBy(xpath = "//input[@id='email_create']")
    public WebElement loginInput;

    @FindBy(id = "SubmitCreate")
    public WebElement submitButtonCreate;

    @FindBy(xpath = "//input[@id='customer_firstname']")
    public WebElement customerFirstName;

    @FindBy(xpath = "//input[@id='customer_lastname']")
    public WebElement customerLastName;

    @FindBy(xpath = "//input[@id='email']")
    public WebElement emailInput;

    @FindBy(xpath = "//input[@id='passwd']")
    public WebElement passwordInput;

    @FindBy(xpath = "//input[@id='firstname']")
    public WebElement firstNameInput;

    @FindBy(xpath = "//input[@id='lastname']")
    public WebElement lastNameInput;

    @FindBy(xpath = "//div[@class ='account_creation']//p[4]//input[@type='text']")
    public WebElement addressInput;

    @FindBy(xpath = "//input[@id='city']")
    public WebElement cityInput;

    @FindBy(xpath = "//select[@id='id_state']")
    public WebElement stateSelect;

    @FindBy(xpath = "//input[@id='postcode']")
    public WebElement postcodeInput;

    @FindBy(xpath = "//select[@id='id_country']")
    public WebElement countrySelect;

    @FindBy(xpath = "//input[@id='phone']")
    public WebElement phoneMobileInput;

    @FindBy(xpath = "//input[@id='alias']")
    public WebElement aliasInput;

    @FindBy(xpath = "//button[@id='submitAccount']")
    public WebElement submitAccount;

    @FindBy(xpath = "//div[@id ='center_column']/h1")
    public WebElement titleRegisteredAccount;

    @FindBy(xpath = "(//div[@class='alert alert-danger'])//li")
    public WebElement errorMsg;

    /**
     * Method open SignIn page
     */
    public Registration2Page clickSignIn(){
        signInLink.click();
        return this;
    }
    /**
     * Method click to SignIn page
     */
    public Registration2Page openSignInPage(){
        openUrl("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        return this;
    }

    /**
     * Method input email
     *
     * @param email
     */

    public Registration2Page inputEmailCreate(String email){
        loginInput.clear();
        loginInput.sendKeys(email);
        return this;
    }

    public Registration2Page submitButtonCreate(){
        submitButtonCreate.click();
        return this;
    }

    public Registration2Page inputCustomerFirstName(String firstName){
        customerFirstName.clear();
        customerFirstName.sendKeys(firstName);
        return this;
    }

    public Registration2Page inputCustomerLastName(String lastName){
        customerLastName.clear();
        customerLastName.sendKeys(lastName);
        return this;
    }

    public Registration2Page inputEmail (String email){
        emailInput.clear();
        emailInput.sendKeys(email);
        return this;
    }

    public Registration2Page inputPassword (String email){
        passwordInput.clear();
        passwordInput.sendKeys(email);
        return this;
    }

    public Registration2Page inputFirstName (String firstName){
        firstNameInput.clear();
        firstNameInput.sendKeys(firstName);
        return this;
    }

    public Registration2Page inputLastName (String lastName){
        lastNameInput.clear();
        lastNameInput.sendKeys(lastName);
        return this;
    }

    public Registration2Page inputAddress (String address){
        addressInput.clear();
        addressInput.sendKeys(address);
        return this;
    }

    public Registration2Page inputCity (String city){
        cityInput.clear();
        cityInput.sendKeys(city);
        return this;
    }

    public Registration2Page selectState (int index){
        Select select = new Select(webDriver.findElement(By.xpath("//select[@id='id_state']")));
        select.selectByIndex(index);
        return this;
    }

    public Registration2Page inputPostcode (String postcode){
        postcodeInput.clear();
        postcodeInput.sendKeys(postcode);
        return this;
    }

    public Registration2Page selectCountry (int country){
        Select select = new Select(webDriver.findElement(By.xpath("//select[@id='id_country']")));
        select.selectByIndex(country);
        return this;
    }

    public Registration2Page inputPhoneMobile (String phone){
        phoneMobileInput.clear();
        phoneMobileInput.sendKeys(phone);
        return this;
    }

    public Registration2Page inputAlias (String alias){
        aliasInput.clear();
        aliasInput.sendKeys(alias);
        return this;
    }

    public Registration2Page clickSubmitAccountButton (){
        submitAccount.click();
        return this;
    }
    public String checkTitle (){
        return titleRegisteredAccount.getText();
    }

    public Registration2Page checkErrorMsg(String text) {
        webElements.checkTextInElement(errorMsg, text);
        return this;
    }

}
