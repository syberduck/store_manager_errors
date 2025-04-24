package org.example.backend;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.example.backend.models.LoginRequest;
import org.example.backend.models.LoginResponse;
import org.example.backend.models.RegisterRequest;
import org.example.backend.models.RegisterResponse;

public class AuthServiceRequests {

    public static final String AUTH_SERVICE_BASE_URL = "http://localhost:8001/";
    public static final String REG_ENDPOINT = "register/";
    public static final String LOGIN_ENDPOINT = "login/";
    public static final String GET_PENDING_PRODUCTS_ENDPOINT = "get-pending-products/";

    public static RegisterResponse getRegisterResponse(RegisterRequest request) {
        return RestAssured.given()
                .baseUri(AUTH_SERVICE_BASE_URL)
                .basePath(REG_ENDPOINT)
                .contentType(ContentType.JSON)
                .body(request).log().all()
                .when().post()
                .then().log().all()
                .extract().response().as(RegisterResponse.class);

    }

    public static LoginResponse postLogin(LoginRequest request) {
        return RestAssured.given()
                .baseUri(AUTH_SERVICE_BASE_URL)
                .basePath(LOGIN_ENDPOINT)
                .contentType(ContentType.JSON)
                .body(request).log().all()
                .when().post()
                .then().log().all()
                .extract().response().as(LoginResponse.class);

    }

    public static Response getPendingProducts(String accessToken) {
        return RestAssured.given()
                .baseUri(AUTH_SERVICE_BASE_URL)
                .basePath(GET_PENDING_PRODUCTS_ENDPOINT)
                .header("Authorization", "Bearer" + accessToken)
                .contentType(ContentType.JSON).log().all()
                .when().get()
                .then().log().all()
                .extract().response();

    }
}