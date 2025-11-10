package utilities;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import org.assertj.core.api.Assertions;

public class DynamicVerifier {

    //manually verify expected response body and acutalexpected body
    public static void verifyResponse(Response response, Object expectedObject) {
        try {
            // Convert response JSON to POJO of the same type as expected
            ObjectMapper mapper = new ObjectMapper();
            Object actualObject = mapper.readValue(response.asString(), expectedObject.getClass());

            // AssertJ recursive comparison (checks nested fields and lists automatically)
            Assertions.assertThat(actualObject)
                    .usingRecursiveComparison()
                    .isEqualTo(expectedObject);

        } catch (Exception e) {
            throw new RuntimeException("Failed to verify response dynamically", e);
        }
    }
}
