package task;


import models.Datum;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import questions.ResponseBody;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ResponseUsers implements Task {


    public static Performable fromPage(){
        return instrumented(ResponseUsers.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        Datum users = new ResponseBody().answeredBy(actor)
                .getData().stream().filter(x -> x.getId().equals(1)).findFirst().orElse(null);

    }
}
