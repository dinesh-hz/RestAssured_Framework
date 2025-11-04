package utilities;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class Bass_utiles {

    private static Bass_utiles instance;
    public RequestSpecification requestSpec;
    Fileread_Manager reader = Fileread_Manager.getInstance();
    protected static Response response;
    protected static String token;

    private Bass_utiles() {}

    public static Bass_utiles getInstance() {
        if (instance == null) {
            instance = new Bass_utiles();
        }
        return instance;
    }

    public void initAPISetup() {
        String baseURI = reader.getProperty("bassurlmyhost");
        RestAssured.baseURI = baseURI;

        requestSpec = new RequestSpecBuilder()
                .setBaseUri(baseURI)
                .setContentType(ContentType.JSON)
                .addHeader("Accept", "application/json")
                .addHeader("Authorization", "Bearer myToken" + token)
                .build();

        System.out.println("✅ Base URI initialized: " + baseURI);
    }

    public String getAuthToken(String Requstbody, String EndUrl) {
        if (token == null) {
            response = given()
                    .spec(requestSpec)
                    .body(Requstbody)
                    .when()
                    .post(EndUrl);

            if (response.getStatusCode() == 200) {
                token = response.jsonPath().getString("token");
            } else {
                throw new RuntimeException("❌ Failed to generate token. Status code: " + response.getStatusCode());
            }
        }
        return token;
    }

    public Response getRequest(String endpoint) {
        response = given().spec(requestSpec).when().get(endpoint);
        return response;
    }

    public Response postRequest(String endpoint, String body) {
        response = given().spec(requestSpec).body(body).when().post(endpoint);
        return response;
    }

    public Response putRequest(String endpoint, String body) {
        response = given().spec(requestSpec).body(body).when().put(endpoint);
        return response;
    }

    public Response deleteRequest(String endpoint) {
        response = given().spec(requestSpec).when().delete(endpoint);
        return response;
    }

    public Response patchRequest(String endpoint, String body) {
        response = given().spec(requestSpec).body(body).when().patch(endpoint);
        return response;
    }

    public int getStatusCode() {
        return response.getStatusCode();
    }

    public String getResponseBody() {
        return response.getBody().asPrettyString();
    }

    public String getPrettyResponse() {
        return response.prettyPrint();
    }

    public String jsonpathfrom(String responsbody, String Keyvalue) {
        return JsonPath.from(responsbody).getString(Keyvalue);
    }
}
