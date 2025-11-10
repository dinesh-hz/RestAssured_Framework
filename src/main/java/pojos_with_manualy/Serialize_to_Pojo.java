/*
package pojos;

import Payload.AddressData;
import Payload.UserData;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class Serialize_to_Pojo {


    @Test
    public void serlization_to_poja() throws JsonProcessingException {

        RestAssured.baseURI = "http://localhost:3000";

        RequestSpecification given = RestAssured.given();

        given.header("Content-Type", "application/json");

        UserData userData = new UserData();

        userData.setFirstname("abcd");
        userData.setLastename("efgh");
        userData.setEmailid("abcd@gmail.com");

        AddressData address = new AddressData();

        userData.setAddres(address);
        address.setCity("nagercoil");
        address.setLandmark("thuckaluy");
        address.setDirst("kanykumari");

        List<String> skills = new ArrayList<>();

        skills.add("python");
        skills.add("java");
        skills.add("hhtml");

        userData.setSkiles(skills);

        given.body(userData);

        Response Response = given.request(Method.POST, "/posts");

        String body = Response.getBody().asString();

        System.out.println(body);

        // jsonpath is coming from (io.restassurt packing) to from

        // Extract id using JSONPath
        String id = Response.jsonPath().getString("id");
        System.out.println(id);

        // Assert status

        assertEquals(Response.statusCode(), 201, "status code didnot macth");

*
         * prettyPrint is just print value in console that all .



    }
}
*/
