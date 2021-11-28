package dataProviders;

import com.github.javafaker.Faker;
import model.AccountBuilder;
import org.testng.annotations.DataProvider;

public class RegistrationPageDataProvider {

    public Faker faker = new Faker();

    @DataProvider
    public Object[][] registrationNewUser() {
        return new Object[][]{
                {
                        new AccountBuilder()
                                .withGender("Mr.")
                                .withFirstCustomerName("Yaroslav")
                                .withLastCustomerName("Khmelnychenko")
                                .withEmail(faker.internet().emailAddress())
                                .withPassword(faker.internet().password(5, 8))
                                .withBirthDay("5")
                                .withBirthMonth("10")
                                .withBirthYear("1989")
                                .withFirstName("Yaroslav")
                                .withLastName("Khmelnychenko")
                                .withCompany("Google")
                                .withAddress1("street New York, 21")
                                .withAddress2("street New York, 22")
                                .withCity("New York")
                                .withState("New York")
                                .withPostalCode("12345")
                                .withPhoneMobile("1234567890")
                                .withAlias("Hello!")
                                .build()
                }
        };
    }
}
