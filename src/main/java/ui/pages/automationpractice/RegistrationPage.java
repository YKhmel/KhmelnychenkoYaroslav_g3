package ui.pages.automationpractice;

import model.Account;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends MainPage{

    public RegistrationPage(WebDriver webDriver){
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

    @FindBy(xpath = "(//div[@class='alert alert-danger'])//li")
    public WebElement errorMsg;

    /**
     * Method click to SignIn page
     */
    public void openSignInPage(){
        openUrl("http://automationpractice.com/index.php?controller=authentication&back=my-account");
    }

    public void selectGender(String gender) {
        if (gender.equals("Mr.")) {
            webElements.clickRadioButton(genderMr, gender);
        } else {
            webElements.clickRadioButton(genderMrs, gender);
        }
    }

    public void inputCustomerFirstName(String firstName){
        webElements.inputText(customerFirstName, firstName);
    }

    public void inputCustomerLastName(String lastName){
        webElements.inputText(customerLastName, lastName);
    }

    public void inputEmail (String email){
        webElements.inputText(emailInput, email);
    }

    public void inputPassword (String password){
        webElements.inputText(passwordInput, password);
    }

    public void selectBirthDay (String day){
        webElements.selectTextInDropDownByText(daysDropDown, day);
    }

    public void selectBirthMonth (String month){
        webElements.selectTextInDropDownByText(monthsDropDown, month);
    }

    public void selectBirthYear (String year){
        webElements.selectTextInDropDownByText(yearsDropDown, year);
    }

    public void inputFirstName (String firstName){
        webElements.inputText(firstNameInput, firstName);
    }

    public void inputLastName (String lastName){
        webElements.inputText(lastNameInput, lastName);
    }

    public void inputAddress (String address){
        webElements.inputText(addressInput, address);
    }

    public void inputCity (String city){
        webElements.inputText(cityInput, city);
    }

    public void selectState (String text){
        webElements.selectValueInDropDown(stateSelect, text);
    }

    public void inputPostcode (String postcode){
        webElements.inputText(postcodeInput, postcode);
    }

    public void selectCountry (String text){
        webElements.selectTextInDropDownByText(countrySelect, text);
    }

    public void inputPhoneMobile (String phone){
        webElements.inputText(phoneMobileInput, phone);
    }

    public void inputAlias (String alias){
        webElements.inputText(aliasInput, alias);
    }

    public void clickSubmitAccountButton (){
        webElements.clickElement(submitAccount);
    }

    public void registrationNewUser(Account account) {
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
    }
}
