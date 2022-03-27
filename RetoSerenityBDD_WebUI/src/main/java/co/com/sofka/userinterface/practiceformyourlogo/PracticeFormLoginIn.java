package co.com.sofka.userinterface.practiceformyourlogo;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.xpath;

public class PracticeFormLoginIn  extends PageObject  {
    public static final Target EMAIL_LOGIN = Target
            .the("Email login")
            .located(xpath("//input[@id='email']"));

    public static final Target PASSWORD_LOGIN = Target
            .the("Password login")
            .located(xpath("//input[@id='passwd']"));

    public static final Target SIGN_IN_LOGIN = Target
            .the("Sign inLogin")
            .located(xpath("//h1[contains(text(),'My account')]"));

    public static final Target LOGIN = Target
            .the("Login in")
            .located(id("SubmitLogin"));

    public static final Target ERROR = Target
            .the("Error")
            .located(xpath("//li[contains(text(),'Authentication failed.')]"));


}


