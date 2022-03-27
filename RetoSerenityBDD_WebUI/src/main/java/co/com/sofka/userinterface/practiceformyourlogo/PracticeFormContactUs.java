package co.com.sofka.userinterface.practiceformyourlogo;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.xpath;

public class PracticeFormContactUs extends PageObject  {

    public static final Target SUBJECT_HEADING = Target
            .the("Subject heading")
            .located(id("id_contact"));

    public static final Target EMAIL_ADDRESS = Target
            .the("Email address")
            .located(xpath("//input[@id='email']"));

    public static final Target ORDER_REFERENCE = Target
            .the("Order reference")
            .located(id("id_order"));

    public static final Target MESSAGE = Target
            .the("Message")
            .located(id("message"));

    public static final Target SEND = Target
            .the("Send")
            .located(xpath("//body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/form[1]/fieldset[1]/div[2]/button[1]/span[1]"));

    public static final Target CONTACT_EXITOSO = Target
            .the("Contact exitoso")
            .located(xpath("//p[contains(text(),'Your message has been successfully sent to our tea')]"));

    public static final Target INVALID_EMAIL = Target
            .the("Invalid email")
            .located(xpath("//li[contains(text(),'Invalid email address.')]"));


}
