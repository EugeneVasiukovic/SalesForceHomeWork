package tests;

import objects.Contact;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;

import java.util.Random;

public class ContactTest extends BaseTest{

    SoftAssertions softAssertions = new SoftAssertions();
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
        newContactModalPage
                .openPage(NEW_CONTACT_MODAL_URL)
                .createNewContact(contact);
        contactListPage.openPage(CONTACT_LIST_URL);

        softAssertions.assertThat(contactListPage.getExistContactName(contact.getContactFirstName())).isEqualTo(contact.getContactFirstName());
        softAssertions.assertThat(contactListPage.getExistPhoneNumberByContactName(contact.getContactFirstName())).isEqualTo(contact.getPhone());
    }

    @Test
    public void checkContactCardTest(){
        loginPage
                .openPage(LOGIN_URL)
                .login(USERNAME, PASSWORD);
        contactListPage
                .openPage(CONTACT_LIST_URL)
                .clickOnContactName("Contact3 Contact1");

        softAssertions.assertThat(contactPage.getFieldValueByName("Name","Mr. Contact3 Contact1")).isEqualTo("Mr. Contact3 Contact1");
        softAssertions.assertThat(contactPage.getFieldValueByName("Account Name","account7")).isEqualTo("account7");
        softAssertions.assertThat(contactPage.getFieldValueByName("Contact Owner", "Evgeniu Vasiukovich")).isEqualTo("Evgeniu Vasiukovich");
    }

    public void resultTest(){
        softAssertions.assertAll();
    }
}