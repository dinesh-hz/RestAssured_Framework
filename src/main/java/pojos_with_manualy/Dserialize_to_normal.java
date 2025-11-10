/*
package pojos;

import Payload.UserData;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.Assert.assertEquals;

public class Dserialize_to_normal {

    @Test
    public void deserialization() throws JsonMappingException, JsonProcessingException {

        RestAssured.baseURI = "http://localhost:3000";

        RequestSpecification given = RestAssured.given();

        Response response = given.request(Method.GET, "/posts/00aa");

        // Ensure that the response status code is 200
        assertEquals(200, response.getStatusCode(), "status code did not match 200");

        // this objectmapper come from com.fasterxml.jackson.core(jackson-databind)
        // Jackson's ObjectMapper
        ObjectMapper objectMapper = new ObjectMapper();

        UserData value = objectMapper.readValue(response.getBody().asString(), UserData.class);

        // Validate the values from the deserialized object

        assertEquals(value.getFirstname(), "abcd", "Firstname mismatch");

        assertEquals(value.getSkiles(), Arrays.asList("python", "java", "hhtml"), "Skills mismatch");

         * assertEquals(value.getFirstname(), "muru", "Firstname mismatch");
         * assertEquals(value.getLastename(), "dien", "Lastname mismatch");
         * assertEquals(value.getEmailid(), "bsjdbjdjj@gmail.com", "Email mismatch");
         *
         * assertEquals(value.getAddres().getCity(), "nahe", "City mismatch");
         * assertEquals(value.getAddres().getLandmark(), "nahe", "Landmark mismatch");
         * assertEquals(value.getAddres().getDirst(), "nahe", "District mismatch");
         *
         * assertEquals(value.getSkiles().toString(), "[java, java]",
         * "Skills mismatch");


        response.prettyPrint();
    }
}
*/
