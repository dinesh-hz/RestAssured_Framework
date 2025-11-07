package utilities;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

import static io.restassured.RestAssured.given;

public class Bass_utiles {

    private final Fileread_Manager reader = Fileread_Manager.getInstance();
    public static  RequestSpecification requestSpec;
    TestContext testContext ;
    private String token;

    public Bass_utiles(TestContext context) {
        this.testContext = context;
    }

    public void setBaseUrl() {
        String baseURI = reader.getProperty("bassurlmyhost");
        RestAssured.baseURI = baseURI;
        requestSpec = new RequestSpecBuilder()
                .setBaseUri(baseURI)
                .setContentType(ContentType.JSON)
                .addHeader("Accept", "application/json")
                .build();

        System.out.println("✅ Base URI initialized: " + baseURI);
    }

    // ✅ Generate Token
    public String generateToken(String requestBody, String endpoint) {
        Response response = given()
                .spec(requestSpec)
                .body(requestBody)
                .when()
                .post(endpoint)
                .then()
                .extract()
                .response();

        if (response.getStatusCode() == 200) {
            token = response.jsonPath().getString("token");
            System.out.println("✅ Token generated successfully.");
        } else {
            throw new RuntimeException("❌ Token generation failed. Status: " + response.statusCode());
        }

        return token;
    }

    // ✅ for authenticated requests
    private RequestSpecification withAuth() {
        if (token == null) {
            throw new IllegalStateException("❌ Token not set. Call generateToken() before making authorized requests.");
        }
        return given()
                .spec(requestSpec)
                .header("Authorization", "Bearer " + token);
    }

    public Response getRequest(String endpoint) {
        Response response = given().spec(requestSpec).when().get(endpoint).then().extract().response();
        testContext.setGetResponse(response);
        return response;
    }

    public Response postRequest(String endpoint, Object body) {
        Response response = given().spec(requestSpec).body(body).when().post(endpoint).then().extract().response();
        testContext.setPostResponse(response);
        return response;
    }

    public Response putRequest(String endpoint, Object body) {
        Response response = given().spec(requestSpec).body(body).when().put(endpoint).then().extract().response();
        testContext.setPutResponse(response);
        return response;
    }

    public Response patchRequest(String endpoint, Object body) {
        Response response = given().spec(requestSpec).body(body).when().patch(endpoint).then().extract().response();
        testContext.setPatchResponse(response);
        return response;
    }

    public Response deleteRequest(String endpoint) {
        Response response = given().spec(requestSpec).when().delete(endpoint).then().extract().response();
        testContext.setDeleteResponse(response);
        return response;
    }

    // ======= Utility methods =======
    public String getValueFromJson(String response, String key) {
        return JsonPath.from(response).getString(key);
    }

    public String getPrettyResponse(Response response) {
        return response.asPrettyString();
    }

    public void getStatusCode(requestType Type, int expectedCode) {
        Response response = null;

        switch (Type) {
            case get -> response = testContext.getGetResponse();
            case post -> response = testContext.getPostResponse();
            case patch -> response = testContext.getPatchResponse();
            case put -> response = testContext.getPutResponse();
            case delete -> response = testContext.getDeleteResponse();
        }

        if (response == null) {
            throw new IllegalStateException("❌ Response not found in TestContext for: " + Type);
        }

        int actualCode = response.getStatusCode();

        if (actualCode == expectedCode) {
            System.out.println("✅ " + Type.toString().toUpperCase() + " Status code matched: " + actualCode);
        } else {
            System.err.println("❌ Expected " + expectedCode + " but got " + actualCode + " for " + Type);
        }

        Assert.assertEquals(actualCode, expectedCode, "Status code mismatch for " + Type);
    }

    public enum requestType {
        get,
        post,
        patch,
        delete,
        put
    }
}
