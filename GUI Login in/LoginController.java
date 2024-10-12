package com.example.loginapp;

import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:5500") // Allow frontend access to the backend
public class LoginController {

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest loginRequest) {
        String username = loginRequest.getUsername();
        String password = loginRequest.getPassword();

        // Here you would validate the username and password from your database
        if ("admin".equals(username) && "password".equals(password)) {
            return new LoginResponse(true, "Login Successful");
        } else {
            return new LoginResponse(false, "Invalid Credentials");
        }
    }

    public static class LoginRequest {
        private String username;
        private String password;

        // Getters and Setters
        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }

    public static class LoginResponse {
        private boolean success;
        private String message;

        // Constructor, Getters and Setters
        public LoginResponse(boolean success, String message) {
            this.success = success;
            this.message = message;
        }

        public boolean isSuccess() {
            return success;
        }

        public String getMessage() {
            return message;
        }
    }
}
