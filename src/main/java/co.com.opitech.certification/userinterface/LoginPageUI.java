package co.com.opitech.certification.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginPageUI {
    public static final Target BTN_LOGIN = Target.the("Botón de Login").located(By.id("login"));
    public static final Target BTN_LOG_OUT = Target.the("Botón de log out").locatedBy("//button[@id='submit' and contains(text(),'Log out')]");
    public static final Target INPUT_USERNAME= Target.the("Input Username").located(By.id("userName"));
    public static final Target INPUT_PASSWORD = Target.the("Input Password").located(By.id("password"));
    public static final Target LBL_USERNAME = Target.the("Label Username").locatedBy("//*[@id='userName-label']/following-sibling::label[1]");


}
