package pojos;

import Payload.Address_dataes;
import Payload.Emeleyesdataes;
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

    /**
     * java object covert to json object-----[it this a serialize methode]
     *
     */
    @Test
    public void serlization_to_poja() throws JsonProcessingException {

        RestAssured.baseURI = "http://localhost:3000";

        RequestSpecification given = RestAssured.given();

        given.header("Content-Type", "application/json");

        Emeleyesdataes emeleyesdataes = new Emeleyesdataes();

        emeleyesdataes.setFirstname("abcd");
        emeleyesdataes.setLastename("efgh");
        emeleyesdataes.setEmailid("abcd@gmail.com");

        Address_dataes address = new Address_dataes();

        emeleyesdataes.setAddres(address);
        address.setCity("nagercoil");
        address.setLandmark("thuckaluy");
        address.setDirst("kanykumari");

        List<String> skills = new ArrayList<>();

        skills.add("python");
        skills.add("java");
        skills.add("hhtml");

        emeleyesdataes.setSkiles(skills);

        given.body(emeleyesdataes);

        Response Response = given.request(Method.POST, "/posts");

        String body = Response.getBody().asString();

        System.out.println(body);

        // jsonpath is coming from (io.restassurt packing) to from

        // Extract id using JSONPath
        String id = Response.jsonPath().getString("id");
        System.out.println(id);

        // Assert status

        assertEquals(Response.statusCode(), 201, "status code didnot macth");

        /**
         * prettyPrint is just print value in console that all .
         */

    }
}
