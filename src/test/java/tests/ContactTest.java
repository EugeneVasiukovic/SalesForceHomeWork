package tests;

import objects.Contact;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ContactListPage;

import java.util.Random;

public class ContactTest extends BaseTest{

    Random random = new Random();

    @Test
    public void createContactTest(){
        Contact contact = new Contact();
        contact.setSalutationType("Mr.");
        contact.setContactFirstName("Contact" + random.nextInt(10));
        contact.setContactLastName("Contact" + random.nextInt(10));
        contact.setAccountNameType("account7");
        contact.setPhone("80256565965");
        loginPage
                .openPage(LOGIN_URL)
                .login(USERNAME,PASSWORD);
        newContactModalPage.
                openPage(NEW_CONTACT_MODAL_URL)
                .createNewContact(contact);
        contactListPage.openPage(CONTACT_LIST_URL);

        Assert.assertEquals(contactListPage.getExistContactName(contact.getContactFirstName()),contact.getContactFirstName());
        Assert.assertEquals(contactListPage.getExistPhoneNumberByContactName(contact.getContactFirstName()), contact.getPhone());

    }

    @Test
    public void checkAccountCardTest(){
        loginPage
                .openPage(LOGIN_URL)
                .login(USERNAME, PASSWORD);
        contactListPage
                .openPage(CONTACT_LIST_URL)
                .clickOnContactName("Contact3 Contact1");

        Assert.assertEquals(contactPage.getFieldValueByName("Contact3 Contact1"), "Contact3 Contact1");
    }
}