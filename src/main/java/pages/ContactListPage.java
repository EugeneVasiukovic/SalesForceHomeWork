package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactListPage extends BasePage{
    public static final String CONTACT_NAME_FIELD_XPATH = "//*[@id='brandBand_1']//table/tbody/tr/th/span/a[contains(text(), '%s')]";
    public static final String PHONE_BY_CONTACT_NAME_XPATH ="//*[@id='brandBand_1']//table/tbody/tr/td[5]";

    public ContactListPage(WebDriver driver){
        super(driver);
    }

    public ContactListPage openPage(String url){
        driver.get(url);
        return this;
    }

    public String getExistContactName(String accountName) {
        return driver.findElement(By.xpath(String.format(CONTACT_NAME_FIELD_XPATH, accountName))).getText();
    }

    public String getExistPhoneNumberByContactName(String accountName) {
        return driver.findElement(By.xpath(String.format(PHONE_BY_CONTACT_NAME_XPATH, accountName))).getText();
    }

    public AccountPage clickOnContactName(String accountName) {
        driver.findElement(By.xpath(String.format(CONTACT_NAME_FIELD_XPATH, accountName))).click();
        return new AccountPage(driver);
    }
}