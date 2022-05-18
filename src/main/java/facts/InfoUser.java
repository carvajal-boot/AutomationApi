package facts;


import interactions.Get;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.facts.Fact;

import java.util.HashMap;

public class InfoUser implements Fact {

    private String dataFinal;

    public static InfoUser toViewInfo(){
        return new InfoUser();
    }

    @Override
    public void setup(Actor actor) {

    actor.attemptsTo(
        Get.resource("/api/users/2"
        )
    );

    HashMap data = SerenityRest.lastResponse().path("data");


        actor.remember("data", data);

        dataFinal = data.toString();
    }

    public String toString(){
        return "The data of user is: "+dataFinal;
    }




}
