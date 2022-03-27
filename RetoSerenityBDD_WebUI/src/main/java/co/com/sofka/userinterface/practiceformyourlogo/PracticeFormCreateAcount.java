package co.com.sofka.userinterface.practiceformyourlogo;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.WebElement;

import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.xpath;

public class PracticeFormCreateAcount extends PageObject {


    public static final Target EMAIL_CREATE = Target
            .the("Email create")
            .located(id("email_create"));

    public static final Target SUBMIT_CREATE = Target
            .the("Submit create")
            .located(id("SubmitCreate"));

    public static final Target CREATE_ERROR = Target
            .the("Create error")
            .located(xpath("//li[contains(text(),'An account using this email address has already be')]"));

    public static final Target MRS = Target
            .the("Mrs")
            .located(xpath("//body/div[@id='page']/div[2]/div[1]/div[3]/div[1]/div[1]/form[1]/div[1]/div[1]/div[2]/label[1]"));

    public static final Target CUSTOMER_FIRST_NAME = Target
            .the("Customer firstname")
            .located(id("customer_firstname"));

    public static final Target CUSTOMER_LAST_NAME = Target
            .the("Customer lastname")
            .located(id("customer_lastname"));

    public static final Target PASSWD = Target
            .the("Passwd")
            .located(xpath("//input[@id='passwd']"));


    public static final Target OFFERS = Target
            .the("Offers")
            .located(xpath("//label[contains(text(),'Receive special offers from our partners!')]"));

    public static final Target COMPANY = Target
            .the("Company")
            .located(id("company"));

    public static final Target ADDRESS_UNO = Target
            .the("Address uno")
            .located(id("address1"));

    public static final Target ADDRESS_DOS = Target
            .the("AddresS dos")
            .located(id("address2"));

    public static final Target CITY = Target
            .the("City")
            .located(id("city"));



    public static final Target POST_CODE = Target
            .the("Post code")
            .located(id("postcode"));

    public static final Target COUNTRY = Target
            .the("Country")
            .located(id("id_country"));


    public static final Target ADD_INFORMATION = Target
            .the("Add information")
            .located(xpath("//textarea[@id='other']"));

    public static final Target PHONE = Target
            .the("Phone")
            .located(id("phone"));

    public static final Target PHONE_MOBILE = Target
            .the("Phone_mobile")
            .located(id("phone_mobile"));

    public static final Target ALIAS = Target
            .the("Alias")
            .located(id("alias"));

    public static final Target REGISTER = Target
            .the("Register")
            .located(xpath("//span[contains(text(),'Register')]"));

    public static final Target MY_ACCOUNT = Target
            .the("My account")
            .located(xpath("//h1[contains(text(),'My account')]"));

    public static final Target DAYS = Target
            .the("days")
            .located(id("days"));

    public static final Target MONTHS = Target
            .the("Months")
            .located(id("months"));

    public static final Target YEARS = Target
            .the("years")
            .located(id("years"));

    public static final Target ID_STATE = Target
            .the("Id state")
            .located(id("id_state"));

    public static final Target LOGOUT = Target
            .the("Logout")
            .located(xpath("//a[@class='logout']"));



}


