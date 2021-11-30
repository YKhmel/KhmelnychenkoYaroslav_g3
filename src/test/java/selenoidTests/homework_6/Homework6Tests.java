package selenoidTests.homework_6;

import selenoidTests.baseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework6Tests extends BaseTest {

    private final String FIRST_NAME = "Yaroslav";
    private final String LAST_NAME = "Khmelnychenko";
    private final String POST_CODE = "98765";
    private final String CARRENCY = "Dollar";

    @Test
    public void createCustomerTest() {
        XYZBankAddCustomerPage.createNewCustomer(FIRST_NAME, LAST_NAME, POST_CODE);
        Assert.assertEquals("Customer added successfully with customer id :6", XYZBankAddCustomerPage.textFromAlert);
    }

    @Test
    public void loginCustomerWithoutAccountTest() {
        XYZBankAddCustomerPage.createNewCustomer(FIRST_NAME + 1, LAST_NAME, POST_CODE);
        Assert.assertEquals("Customer added successfully with customer id :7", XYZBankAddCustomerPage.textFromAlert);
        XYZBankMainPage.loginAsCustomer();
        XYZBankCustomerPage.loginAsCustomerUser(FIRST_NAME + 1 + " " + LAST_NAME);
        Assert.assertEquals("Please open an account with us.",XYZBankCustomerProfilePage.checkNoAccountMessage());
    }

    @Test
    public void openAccountTest() {
        XYZBankAddCustomerPage.createNewCustomer(FIRST_NAME, LAST_NAME, POST_CODE);
        XYZBankBankManagerPage.openAccount();
        XYZBankOpenAccountPage.openNewAccount(FIRST_NAME + " " + LAST_NAME, CARRENCY);
        Assert.assertEquals("Account created successfully with account Number :1016", XYZBankOpenAccountPage.textFromAlert);
    }

    @Test
    public void withdrawalExceedsBalanceTest() {
        XYZBankMainPage.openMainPage()
                .loginAsCustomer();
        XYZBankCustomerPage.loginAsCustomerUser("Hermoine Granger");
        XYZBankCustomerProfilePage.withdrawFromBalance("6000");
        Assert.assertEquals("Transaction Failed. You can not withdraw amount more than the balance.", XYZBankCustomerProfilePage.checkErrorMessage());
    }
}
