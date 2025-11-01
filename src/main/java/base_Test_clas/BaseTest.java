package base_Test_clas;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utilities.contText;

public class BaseTest {
    // this is  non bdd style
    protected static RequestSpecification request;
    protected static Response response;

    public void setup() {

        RestAssured.baseURI = contText.starturl;
        request = RestAssured.given().header("Content-Type", "application/json");
    }

    public String getRequestBody() {
        return response.getBody().asString();
    }

    public void setRequestBody(String jsonBody) {
        request.body(jsonBody);
    }

    public int getstatuscode() {

        return response.getStatusCode();
    }

    public Response getResponse() {
        return response;
    }

    public String getprettyprint() {
        return response.prettyPrint();
    }

    public Response sendRequest(String method, String endpoint) {
        return sendRequest(method, endpoint, null);
    }

    public Response sendRequest(String method, String endpoint, String body) {
        switch (method.toUpperCase()) {
            case "GET":
                response = request.when().get(endpoint);
                break;
            case "POST":
                response = request.body(body).when().post(endpoint);
                break;
            case "PUT":
                response = request.body(body).when().put(endpoint);
                break;
            case "PATCH":
                response = request.body(body).when().patch(endpoint);
                break;
            case "DELETE":
                response = request.when().delete(endpoint);
                break;
            default:
                throw new IllegalArgumentException("Invalid HTTP method: " + method);
        }
        return response;
    }
}
