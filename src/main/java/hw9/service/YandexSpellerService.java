package hw9.service;

import hw9.utils.Properties;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class YandexSpellerService {

    private RequestSpecification REQUEST_SPECIFICATION;

    YandexSpellerService() {
        String SERVICE_URL = Properties.getPropByKey("service.url");

        REQUEST_SPECIFICATION = new RequestSpecBuilder()
                .setBaseUri(SERVICE_URL)
                .addFilter(new RequestLoggingFilter())
                .addFilter(new ResponseLoggingFilter()).build();
    }

    Response getResponse(String uri, Map<String, Object> params, String... lines) {
        RequestSpecification specification = given(REQUEST_SPECIFICATION);

        for (String line : lines) {
            specification.param("text", line);
        }

        if (!params.isEmpty()) {
            for (Map.Entry<String, Object> param : params.entrySet()) {
                specification.param(param.getKey(), param.getValue());
            }
        }
        return specification.get(uri);
    }
}
