package commonLibs.api;

import com.jayway.restassured.specification.RequestSpecification;

import static com.jayway.restassured.RestAssured.given;

public class BaseAPI {
    public RequestSpecification apiRequest() {
        return given().
                header("Content-type", "application/json; charset=UTF-8");
    }
}
