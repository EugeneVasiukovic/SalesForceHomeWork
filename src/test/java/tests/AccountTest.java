package tests;

import objects.Account;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class AccountTest extends BaseTest {

    Random random = new Random();

    @Test
    public void createAccountTest(){
        Account account = new Account();
        account.setAccountName("account" + random.nextInt(10));
        account.setWebSite("Website");
        account.setType("Investor");
        account.setPhone("80256565965");
        account.setDescription("sdsasfasd");
        loginPage
                .openPage(LOGIN_URL)
                .login(USERNAME,PASSWORD);
        newAccountModalPage
                .openPage(NEW_ACCOUNT_MODAL_URL)
                .createNewAccount(account);
        accountListPage.openPage(ACCOUNT_LIST_URL);

        Assert.assertEquals(accountListPage.getExistAccountName(account.getAccountName()),account.getAccountName());
        Assert.assertEquals(accountListPage.getExistPhoneNumberByAccountName(account.getAccountName()), account.getPhone());

    }

    @Test
    public void checkAccountCardTest(){
        loginPage
                .openPage(LOGIN_URL)
                .login(USERNAME, PASSWORD);
        accountListPage
                .openPage(ACCOUNT_LIST_URL)
                .clickOnAccountName("account7");

        Assert.assertEquals(accountPage.getFieldValueByName("account7"), "account7");

    }
}