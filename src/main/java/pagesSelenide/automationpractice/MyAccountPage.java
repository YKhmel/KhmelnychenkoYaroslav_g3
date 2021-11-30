package pagesSelenide.automationpractice;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class MyAccountPage {

    public final SelenideElement
            titleRegisteredAccount = $x("//div[@id='center_column']/h1"),
            accountButton = $x("//a[@class='account']/span");

    @Step("Check title")
    public String checkTitle(){
        return titleRegisteredAccount.getText();
    }

    @Step("Get account name")
    public String getAccountName() {
        return accountButton.getText();
    }

    @Step("Get Header name")
    public void getHeaderName(String text) {
        titleRegisteredAccount.shouldHave(Condition.exactText(text));
    }
}