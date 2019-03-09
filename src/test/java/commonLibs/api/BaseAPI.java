package commonLibs.api;

import com.jayway.restassured.specification.RequestSpecification;
import commonLibs.configReaders.EnvironmentConfigReader;

import java.io.IOException;

import static com.jayway.restassured.RestAssured.given;

public class BaseAPI {
    public RequestSpecification apiRequest() {
        return given().
                header("Content-type", "application/json; charset=UTF-8");
    }

    EnvironmentConfigReader configReader;

    {
        try {
            configReader = new EnvironmentConfigReader();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
