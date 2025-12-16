package transformations;

import enums.LoginStatus;
import io.cucumber.java.ParameterType;

public class CustomTypes {

    @ParameterType("successful|unsuccessful")
    public static LoginStatus status(String status) {
        if (status.contains("un")) {
            return LoginStatus.FAILURE;
        } else {
            return LoginStatus.SUCCESS;
        }
    }
}