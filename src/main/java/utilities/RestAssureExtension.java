package utilities;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import io.restassured.specification.RequestSpecification;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class RestAssureExtension {

    private static RequestSpecification Request;

    public RestAssureExtension() {
        //Arrange
        System.out.println("before");

        RequestSpecification videoGame_requestSpec = new RequestSpecBuilder().
                setBaseUri("http://localhost").
                setPort(8080).
                setBasePath("/app/").
                addHeader("Content-Type", "application/json").
                addHeader("Accept", "application/json").
                build();
        Request = given().spec(videoGame_requestSpec);
    }

    public static void GetOpsWithParameters(String url, Map<String, String> pathParams) {
        //Act
        Request.pathParams(pathParams);
        try {
            Request.get(new URI(url));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    public static ResponseOptions<Response> GetOps(String url) {
        // Act
        try {
            return Request.get(new URI(url));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ResponseOptions<Response> postOpsWithBodyAndPathParams(String url, Map<String, String> pathParam, Map<String, String> body) {
        Request.pathParams(pathParam);
        Request.body(body);
        try {
            return Request.post(new URI(url));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }
}
