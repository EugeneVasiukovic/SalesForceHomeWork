package pages;

import elements.Button;
import elements.Dropdown;
import elements.Input;
import objects.Contact;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewContactModalPage extends BasePage{

    @FindBy(xpath = "//*[@name = 'SaveEdit']")
    public WebElement saveButton;

    @FindBy(name = "SaveAndNew")
    public  WebElement saveAndNewButton;

    @FindBy(name = "CancelEdit")
    public  WebElement cancelButton;

    public NewContactModalPage(WebDriver driver) {
        super(driver);
    }

    public NewContactModalPage openPage(String url){
        driver.get(url);
        return this;
    }

    public void createNewContact(Contact contact) {
        new Dropdown(driver, "Salutation").contactSelectOptions(contact.getSalutationType());
        new Input(driver, "First Name").writeTextToInput(contact.getContactFirstName());
        new Input(driver, "Last Name").writeTextToInput(contact.getContactLastName());
        new Dropdown(driver, "Account Name").contactSelectOptions(contact.getAccountNameType());
        new Input(driver, "Phone").writeTextToInput(contact.getPhone());
        new Button(driver).clickButton(saveButton);
    }
}