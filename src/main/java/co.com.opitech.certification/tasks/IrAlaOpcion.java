package co.com.opitech.certification.tasks;

import co.com.opitech.certification.userinterface.ProfilePageUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actions.ScrollTo;

public class IrAlaOpcion implements Task {


    public static IrAlaOpcion profile() {
        return Tasks.instrumented(IrAlaOpcion.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Scroll.to(ProfilePageUI.OPCION_PROFILE).andAlignToTop());
        actor.attemptsTo(Click.on(ProfilePageUI.OPCION_PROFILE));
    }
}
