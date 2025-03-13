package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Dropdown {

    WebDriver driver;
    String label;
    private static final String ACCOUNT_DROPDOWN_XPATH = "//*[contains(text(), '%s')]/ancestor::*[contains(@slot, 'inputField')]//button";
    private static final String ACCOUNT_DROPDOWN_OPTION_XPATH = "//*[@class='slds-combobox_container']//lightning-base-combobox-item//*[contains(@title, '%s')]";
    private static final String CONTACT_DROPDOWN_XPATH = "//label[@class='slds-form-element__label' and text()='%s']";

    public Dropdown(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void accountSelectOptions(String options){
        driver.findElement(By.xpath(String.format(ACCOUNT_DROPDOWN_XPATH, label))).click();
        driver.findElement(By.xpath(String.format(ACCOUNT_DROPDOWN_OPTION_XPATH, options))).click();
    }

    public void contactSelectOptions(String options){
        driver.findElement(By.xpath(String.format(CONTACT_DROPDOWN_XPATH, label))).click();
        driver.findElement(By.xpath(String.format(ACCOUNT_DROPDOWN_OPTION_XPATH, options))).click();
    }
}