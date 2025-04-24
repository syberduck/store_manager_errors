package org.example.tests;

import io.restassured.response.Response;
import org.example.backend.models.LoginRequest;
import org.example.backend.models.LoginResponse;
import org.example.backend.models.RegisterRequest;
import org.example.backend.models.RegisterResponse;
import org.example.db.UsersQueries;
import org.example.db.models.User;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.example.backend.AuthServiceRequests.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StoreManagerTests extends BaseTest {

    /*
    "name": "user_1744802557313",
    "email": "1744802557310@email.com",
    "password": "pass_1744802557313"
    "id": "9821b132-f9a1-4349-a4b2-381e9da94141"
     */

    @Test
    void someTest() {
        RegisterRequest request = RegisterRequest.generate();
        RegisterResponse registerResponse = getRegisterResponse(request);

        assertEquals("User successfully created", registerResponse.getMessage());
        assertEquals(request.getEmail(), registerResponse.getUser().getEmail());
        assertEquals(request.getName(), registerResponse.getUser().getName());

        User userFromDb = UsersQueries.getUserByName(registerResponse.getUser().getName());

        String string = UUID.fromString(userFromDb.getId()).toString();
        assertEquals(userFromDb.getId(), string);
        assertEquals(request.getName(), userFromDb.getName());
        assertEquals(request.getEmail(), userFromDb.getEmail());
    }

    @Test
    void loginTest(){
        String email = "1744802557310@email.com";
        String password = "pass_1744802557313";
        LoginResponse loginResponse = postLogin(LoginRequest.builder().email(email).password(password).build());

        Response pendingProducts = getPendingProducts(loginResponse.getAccessToken()); //39 минута

        System.out.println();
    }
}

