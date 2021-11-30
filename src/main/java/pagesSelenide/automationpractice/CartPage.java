package pagesSelenide.automationpractice;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class CartPage {

    public final SelenideElement
            totalPrice = $(By.id("total_price_container")),
            deleteButton = $x("//a[@title='Delete']//i"),
            proceedToCheckoutButton = $x("//p//span[contains(text(),'Proceed to checkout')]"),
            carrierTitle = $x("//div[@class='delivery_options_address']//p[@class='carrier_title']"),
            fancyboxError = $x("(//p[@class='fancybox-error'])[1]");

    @Step("Get total price")
    public String getTotalPrice(){
        return totalPrice.getText();
    }

    @Step("Get Error Text")
    public String getfFancyboxErrorText(){
        return fancyboxError.getText();
    }

    @Step("Get Carrier title")
    public String getCarrierTitle(){
        return carrierTitle.getText();
    }

    @Step("Click on Delete button")
    public CartPage clickDeleteButton() {
        deleteButton.click();
        return this;
    }

    @Step("Click Proceed to checkout button")
    public CartPage clickProceedToCheckoutButton() {
        proceedToCheckoutButton.click();
        return this;
    }
}