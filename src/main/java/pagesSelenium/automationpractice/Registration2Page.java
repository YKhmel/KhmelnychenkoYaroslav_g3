package pagesSelenium.automationpractice;

import io.qameta.allure.Step;
import model.Account;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Registration2Page extends MainPage{

    public Registration2Page(WebDriver webDriver){
        super(webDriver);
    }

    @FindBy(xpath = "//div[@class='radio-inline'][1]")
    public WebElement genderMr;

    @FindBy(xpath = "//div[@class='radio-inline'][2]")
    public WebElement genderMrs;

    @FindBy(xpath = "//input[@id='customer_firstname']")
    public WebElement customerFirstName;

    @FindBy(xpath = "//input[@id='customer_lastname']")
    public WebElement customerLastName;

    @FindBy(xpath = "//input[@id='email']")
    public WebElement emailInput;

    @FindBy(xpath = "//input[@id='passwd']")
    public WebElement passwordInput;

    @FindBy(id = "days")
    public WebElement daysDropDown;

    @FindBy(id = "months")
    public WebElement monthsDropDown;

    @FindBy(id = "years")
    public WebElement yearsDropDown;

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
    public static WebElement errorMsg;

    @Step("Select gender {gender}")
    public Registration2Page selectGender(String gender) {
        if (gender.equals("Mr.")) {
            webElements.clickRadioButton(genderMr, gender);
        } else {
            webElements.clickRadioButton(genderMrs, gender);
        }
        return this;
    }

    @Step("Input customer first name {firstName}")
    public Registration2Page inputCustomerFirstName(String firstName){
        customerFirstName.clear();
        customerFirstName.sendKeys(firstName);
        return this;
    }

    @Step("Input customer last name {lastName}")
    public Registration2Page inputCustomerLastName(String lastName){
        customerLastName.clear();
        customerLastName.sendKeys(lastName);
        return this;
    }

    @Step("Input email {email}")
    public Registration2Page inputEmail (String email){
        emailInput.clear();
        emailInput.sendKeys(email);
        return this;
    }

    @Step("Input password {password}")
    public Registration2Page inputPassword (String email){
        passwordInput.clear();
        passwordInput.sendKeys(email);
        return this;
    }

    @Step("Select birthday {day}")
    public Registration2Page selectBirthDay(String day){
        webElements.selectTextInDropDownByText(daysDropDown, day);
        return this;
    }

    @Step("Select birthday month {month}")
    public Registration2Page selectBirthMonth(String month){
        webElements.selectTextInDropDownByText(monthsDropDown, month);
        return this;
    }

    @Step("Select birthday year {year}")
    public Registration2Page selectBirthYear(String year){
        webElements.selectTextInDropDownByText(yearsDropDown, year);
        return this;
    }

    @Step("Input first name {firstName}")
    public Registration2Page inputFirstName (String firstName){
        firstNameInput.clear();
        firstNameInput.sendKeys(firstName);
        return this;
    }

    @Step("Input last name {lastName}")
    public Registration2Page inputLastName (String lastName){
        lastNameInput.clear();
        lastNameInput.sendKeys(lastName);
        return this;
    }

    @Step("Input address {address}")
    public Registration2Page inputAddress (String address){
        addressInput.clear();
        addressInput.sendKeys(address);
        return this;
    }

    @Step("Input city {city}")
    public Registration2Page inputCity (String city){
        cityInput.clear();
        cityInput.sendKeys(city);
        return this;
    }

    @Step("Select state {text}")
    public Registration2Page selectState (String text){
        webElements.selectValueInDropDown(stateSelect, text);
        return this;
    }

    @Step("Input post code {postCode}")
    public Registration2Page inputPostcode (String postcode){
        postcodeInput.clear();
        postcodeInput.sendKeys(postcode);
        return this;
    }

    @Step("Select country {text}")
    public Registration2Page selectCountry (String text){
        webElements.selectTextInDropDownByText(countrySelect, text);
        return this;
    }

    @Step("Input mobile {phone}")
    public Registration2Page inputPhoneMobile (String phone){
        phoneMobileInput.clear();
        phoneMobileInput.sendKeys(phone);
        return this;
    }

    @Step("Input alias {alias}")
    public Registration2Page inputAlias (String alias){
        aliasInput.clear();
        aliasInput.sendKeys(alias);
        return this;
    }

    @Step("Submit account")
    public Registration2Page clickSubmitAccountButton (){
        submitAccount.click();
        return this;
    }

    public String checkTitle (){
        return titleRegisteredAccount.getText();
    }

    public static String checkErrorMsg() {
        return errorMsg.getText();
    }

    public Registration2Page registrationNewUser(Account account) {
        selectGender(account.getGender());
        inputCustomerFirstName(account.getFirstCustomerName());
        inputCustomerLastName(account.getLastCustomerName());
        inputEmail(account.getEmail());
        inputPassword(account.getPassword());
        selectBirthDay(account.getDay());
        selectBirthMonth(account.getMonth());
        selectBirthYear(account.getYear());
        inputFirstName(account.getFirstName());
        inputLastName(account.getLastName());
        inputAddress(account.getAddress1());
        inputCity(account.getCity());
        selectState(account.getState());
        inputPostcode(account.getPostCode());
        selectCountry(account.getCountry());
        inputPhoneMobile(account.getPhoneMobile());
        inputAlias(account.getAlias());
        return this;
    }
}
