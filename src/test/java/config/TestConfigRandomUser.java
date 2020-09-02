package config;

import io.cucumber.java.Before;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class TestConfigRandomUser {
    public static RequestSpecification randoUser_requestSpec;

    @Before
    public static void beforeScenario() {
        System.out.println("before");

        randoUser_requestSpec = new RequestSpecBuilder().
                setBaseUri("https://randomuser.me").
                setPort(8080).
                addHeader("Content-Type", "application/json").
                addHeader("Accept", "application/json").
                build();

    }


}
