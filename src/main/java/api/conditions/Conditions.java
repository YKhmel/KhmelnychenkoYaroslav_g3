package api.conditions;

import org.hamcrest.Matcher;

public class Conditions {

    public static StatusCodeConditions statusCode(int code){
        return new StatusCodeConditions(code);
    }

    public static ResponceBodyCondition body(String path, Matcher matcher){
        return new ResponceBodyCondition(path, matcher);
    }
}
