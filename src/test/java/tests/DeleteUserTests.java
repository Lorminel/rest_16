package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static specs.TestSpecs.requestSpecification;
import static specs.TestSpecs.statusCodeResponseSpec;

@DisplayName("User deletion tests")
public class DeleteUserTests extends TestBase {
    @Test
    @DisplayName("Successful user deletion check")
    void deleteUserTest() {
        String response = step("Make request", () ->
                given(requestSpecification)
                        .when()
                        .delete("users/{id}", 5)

                        .then()
                        .spec(statusCodeResponseSpec(204))
                        .extract().asString());

        step("Check response", () ->
                assertThat(response).isEmpty());
    }
}
