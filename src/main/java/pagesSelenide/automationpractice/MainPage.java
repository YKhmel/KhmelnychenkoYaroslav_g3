package pagesSelenide.automationpractice;

import com.codeborne.selenide.*;
import io.qameta.allure.Step;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.$x;

public class MainPage {
    public final SelenideElement column = $x("//div[@id='center_column']");
    public final ElementsCollection products = $$("#homefeatured li div div h5 a");

    @Step("Open URL {url}")
    public MainPage openUrl(String url){
        try {
            Selenide.open(url);
        } catch (Exception e){
            e.printStackTrace();
            Assert.fail("Page can't opened: " + url);
        }
        return this;
    }

    @Step("Get product {text}")
    public MainPage getProduct(String text){
        if(column.exists()){
            // strict verification
            products.shouldHave(CollectionCondition.itemWithText(text));
            // not strict verification
            products.filter(Condition.text(text)).shouldHave(CollectionCondition.sizeGreaterThan(0));
        } else {
            products.shouldHave(CollectionCondition.size(0));
        }
        return this;
    }

    @Step("Click on product: {product}")
    public MainPage clickProduct(String product){
        products.findBy(Condition.exactText(product)).click();
        return this;
    }
}