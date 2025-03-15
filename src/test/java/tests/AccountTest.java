package tests;

import objects.Account;
import org.assertj.core.api.SoftAssertions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class AccountTest extends BaseTest {

    Random random = new Random();
    SoftAssertions softAssertions =new SoftAssertions();

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

        softAssertions.assertThat(accountListPage.getExistAccountName(account.getAccountName())).isEqualTo(account.getAccountName());
        softAssertions.assertThat(accountListPage.getExistPhoneNumberByAccountName(account.getAccountName())).isEqualTo(account.getPhone());
    }

    @Test
    public void checkAccountCardTest(){
        loginPage
                .openPage(LOGIN_URL)
                .login(USERNAME, PASSWORD);
        accountListPage
                .openPage(ACCOUNT_LIST_URL)
                .clickOnAccountName("account7");

        softAssertions.assertThat(accountPage.getFieldValueByName("Account Name","account7")).isEqualTo( "account7");
        softAssertions.assertThat(accountPage.getFieldValueByName("Website","Website")).isEqualTo("Website");
        softAssertions.assertThat(accountPage.getFieldValueByName("Type", "Investor")).isEqualTo("Investor");
        softAssertions.assertThat(accountPage.getFieldValueByName("Description","sdsasfasd")).isEqualTo("sdsasfasd");
        softAssertions.assertThat(accountPage.getFieldValueByName("Account Owner","Evgeniu Vasiukovich")).isEqualTo("Evgeniu Vasiukovich");
    }


    public void resultTest(){
        softAssertions.assertAll();
    }
}