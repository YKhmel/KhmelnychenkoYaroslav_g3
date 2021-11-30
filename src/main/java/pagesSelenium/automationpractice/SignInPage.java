package pagesSelenium.automationpractice;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends MainPage {

    public SignInPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "//a[@class='login']")
    public WebElement signInLink;

    @FindBy(xpath = "//input[@id='email_create']")
    public WebElement loginInput;

    @FindBy(id="SubmitCreate")
    public WebElement submitButtonCreate;

    public SignInPage clickSignIn() {
        webElements.clickElement(signInLink);
        return this;
    }

    @Step("click on SignIn page")
    public SignInPage inputEmailCreate(String email) {
        webElements.inputText(loginInput, email);
        return this;
    }

    @Step("Input email")
    public SignInPage submitButtonCreate() {
        webElements.clickElement(submitButtonCreate);
        return this;
    }
}