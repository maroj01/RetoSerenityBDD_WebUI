package co.com.sofka.userinterface.practiceformyourlogo;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.xpath;

public class PracticeFormHome extends PageObject {

    public static final Target CONTACT_US = Target
            .the("contact us")
            .located(xpath("//header/div[2]/div[1]/div[1]/nav[1]/div[2]/a[1]"));

    public static final Target SIGN_IN = Target
            .the("sign in")
            .located(xpath("//a[contains(text(),'Sign in')]"));


}




