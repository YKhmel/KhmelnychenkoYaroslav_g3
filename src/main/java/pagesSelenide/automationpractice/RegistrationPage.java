package pagesSelenide.automationpractice;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import model.Account;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class RegistrationPage {

    public SelenideElement
            genderMr = $("#id_gender1"),
            genderMrs = $("#id_gender2"),
            customerFistName = $(By.id("customer_firstname")),
            customerLastName = $(By.id("customer_lastname")),
            emailInput = $(By.xpath("//input[@id='email']")),
            passwordInput = $(By.id("passwd")),
            daysDropDown = $(By.id("days")),
            monthsDropDown = $(By.id("months")),
            yearsDropDown = $(By.id("years")),
            firstNameInput = $(By.xpath("//input[@id='firstname']")),
            lastNameInput = $(By.xpath("//input[@id='lastname']")),
            addressInput = $(By.xpath("//div[@class='account_creation']//p[4]//input[@type='text']")),
            cityInput = $(By.xpath("//input[@id='city']")),
            stateSelect = $(By.xpath("//select[@id='id_state']")),
            postcodeInput = $(By.xpath("//input[@id='postcode']")),
            countrySelect = $(By.xpath("//select[@id='id_country']")),
            phoneMobileInput = $(By.xpath("//input[@id='phone_mobile']")),
            aliasInput = $(By.xpath("//input[@id='alias']")),
            submitAccount = $(By.xpath("//button[@id='submitAccount']")),
            titleRegisteredAccount = $(By.xpath("//div[@id='center_column']/h1")),
            errorMsg = $(By.xpath("//div[@class='alert alert-danger']/p"));

    @Step("Select {gender}")
    public RegistrationPage selectGender(String gender) {
        if (gender.equals("1")) {
            genderMr.selectRadio(gender);
        } else {
            genderMrs.selectRadio(gender);
        }
        return this;
    }

    @Step("Input first name: {firstName}")
    public RegistrationPage inputCustomerFirstName(String firstName) {
        customerFistName.setValue(firstName);
        return this;
    }

    @Step("Input last name: {lastName}")
    public RegistrationPage inputCustomerLastName(String lastName) {
        customerLastName.setValue(lastName);
        return this;
    }

    @Step("Input email: {email}")
    public RegistrationPage inputEmail(String email) {
        emailInput.setValue(email);
        return this;
    }

    @Step("Input password: {password}")
    public RegistrationPage inputPassword(String password) {
        passwordInput.setValue(password);
        return this;
    }

    @Step("Input birth day: {day}")
    public RegistrationPage selectBirthDay(String day) {
        daysDropDown.selectOptionByValue(day);
        return this;
    }

    @Step("Input birth month: {month}")
    public RegistrationPage selectBirthMonth(String month) {
        monthsDropDown.selectOptionByValue(month);
        return this;
    }

    @Step("Input birth year: {year}")
    public RegistrationPage selectBirthYear(String year) {
        yearsDropDown.selectOptionByValue(year);
        return this;
    }

    @Step("Input firstName: {firstName}")
    public RegistrationPage inputFirstName(String firstName) {
        firstNameInput.setValue(firstName);
        return this;
    }

    @Step("Input lastName: {lastName}")
    public RegistrationPage inputLastName(String lastName) {
        lastNameInput.setValue(lastName);
        return this;
    }

    @Step("Input street: {street}")
    public RegistrationPage inputAddress(String street) {
        addressInput.setValue(street);
        return this;
    }

    @Step("Input city: {city}")
    public RegistrationPage inputCity(String city) {
        cityInput.setValue(city);
        return this;
    }

    @Step("Select state: {state}")
    public RegistrationPage selectState(String state) {
        stateSelect.selectOptionContainingText(state);
        return this;
    }

    @Step("Select country: {text}")
    public RegistrationPage selectCountry(String text) {
        countrySelect.selectOptionContainingText(text);
        return this;
    }

    @Step("Input postcode: {postCode}")
    public RegistrationPage inputPostcode(String postCode) {
        postcodeInput.setValue(postCode);
        return this;
    }

    @Step("Input mobile phone: {phone}")
    public RegistrationPage inputPhoneMobile(String phone) {
        phoneMobileInput.setValue(phone);
        return this;
    }

    @Step("Input alias: {alias}")
    public RegistrationPage inputAlias(String alias) {
        aliasInput.setValue(alias);
        return this;
    }

    @Step("Submit Account")
    public RegistrationPage clickSubmitAccountButton() {
        submitAccount.click();
        return this;
    }

    @Step("Submit Сheck Title")
    public String checkTitle() {
        return titleRegisteredAccount.getText();
    }

    @Step("Submit Сheck Error Msg")
    public String checkErrorMsg() {
        return errorMsg.getText();
    }

    public RegistrationPage registrationNewUser(Account account) {
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