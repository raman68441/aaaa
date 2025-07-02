package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Utils {

    public static RequestSpecification req;

    public RequestSpecification requestSpecification() throws IOException {
        if (req == null) {
            FileInputStream fis = new FileInputStream("src/test/java/resources/global.properties");
            Properties prop = new Properties();
            prop.load(fis);
            req = new RequestSpecBuilder()
                .setBaseUri(prop.getProperty("baseUrl"))
                .addQueryParam("key", "qaclick123")
                .setContentType("application/json")
                .log(LogDetail.ALL)
                .build();
        }
        return req;
    }

    public static String getJsonPath(Response response, String key) {
        return response.jsonPath().get(key).toString();
    }
}
