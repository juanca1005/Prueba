package co.com.opitech.certification.tasks;

import co.com.opitech.certification.models.User;
import co.com.opitech.certification.userinterface.LoginPageUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actions.ScrollTo;

public class Loguearse implements Task {

    private User usuario;

    public Loguearse(User usuario) {
        this.usuario = usuario;
    }

    public static Loguearse con(User usuario) {
        return Tasks.instrumented(Loguearse.class, usuario);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(LoginPageUI.BTN_LOGIN));
        actor.attemptsTo(Enter.keyValues(usuario.getNameUser()).into(LoginPageUI.INPUT_USERNAME));
        actor.attemptsTo(Scroll.to(LoginPageUI.INPUT_USERNAME).andAlignToTop());
    actor.attemptsTo(Enter.keyValues(usuario.getPassword()).into(LoginPageUI.INPUT_PASSWORD));

        actor.attemptsTo(Click.on(LoginPageUI.BTN_LOGIN));

    }
}
