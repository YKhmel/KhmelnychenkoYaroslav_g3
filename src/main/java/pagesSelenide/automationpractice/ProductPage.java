package pagesSelenide.automationpractice;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class ProductPage {

    public final SelenideElement
            addToCartButton = $x("//span[normalize-space()='Add to cart']"),
            productPrice = $x("//span[@itemprop='price']"),
            continueShoppingButton = $x("//span[@title='Continue shopping']"),
            addToWishlist = $x("//a[@title='Add to my wishlist']"),
            cartButton = $x("//b[normalize-space()='Cart']");

    @Step("Get product price")
    public String getProductPrice(){
        return productPrice.getText();
    }

    @Step("Click on Add to cart button")
    public ProductPage clickAddToCartButton() {
        addToCartButton.click();
        return this;
    }

    @Step("Click on Add to wish list button")
    public ProductPage clickAddToWishlist() {
        addToWishlist.click();
        return this;
    }

    @Step("Click Continue Shopping button")
    public ProductPage clickContinueShoppingButtonButton() {
        continueShoppingButton.click();
        return this;
    }

    @Step("Click Cart button")
    public ProductPage clickCartButton() {
        cartButton.click();
        return this;
    }

    @Step("Click on Add to cart button")
    public ProductPage addProductToCart() {
        addToCartButton.click();
        continueShoppingButton.shouldBe(Condition.visible).click();
        return this;
    }
}