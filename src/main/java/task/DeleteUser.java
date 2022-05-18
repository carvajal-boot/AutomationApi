package task;

import interactions.Delete;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class DeleteUser implements Task {

    private final int user;

    public DeleteUser(int user) {
        this.user = user;
    }

    public static Performable fromPage(int user){
        return instrumented(DeleteUser.class, user);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Delete.from("/api/users?page="+user).
                        with(requestSpecification ->
                                requestSpecification.contentType(ContentType.JSON))
        );
    }
}
