package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactPage extends BasePage{

    public static final String DATA_BY_FIELD_NAME_XPATH = "//*[@class='slds-assistive-text' and contains(text(), '%s')]";

    public ContactPage(WebDriver driver){
        super(driver);
    }

    public String getFieldValueByName(String name) {
        String contactName = driver.findElement(By.xpath(String.format(DATA_BY_FIELD_NAME_XPATH, name))).getText();
        String value = contactName.replaceAll("Locked Name: Item", "").trim();
        return value;
    }
}