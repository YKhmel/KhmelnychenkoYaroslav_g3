package api.conditions;

import io.restassured.response.ValidatableResponse;
import lombok.AllArgsConstructor;
import org.hamcrest.Matcher;

@AllArgsConstructor
public class ResponceBodyCondition implements Condition {

    private final String path;
    private final Matcher matcher;

    @Override
    public void check(ValidatableResponse response){
        response.assertThat().body(path, matcher);
    }

    @Override
    public String toString(){
        return "Json body field \'" + path + "\' should math the condition: " + matcher;
    }
}
