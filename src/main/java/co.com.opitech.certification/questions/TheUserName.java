package co.com.opitech.certification.questions;

import co.com.opitech.certification.userinterface.LoginPageUI;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.Scroll;
import net.thucydides.core.webdriver.SerenityWebdriverManager;

public class TheUserName implements Question<String> {

    public static Question<String> is() {
        return new TheUserName();
    }

    @Override
    public String answeredBy(Actor actor) {
        actor.attemptsTo(Scroll.to(LoginPageUI.LBL_USERNAME).andAlignToTop());
        return LoginPageUI.LBL_USERNAME.resolveFor(actor).getText();
    }
}
