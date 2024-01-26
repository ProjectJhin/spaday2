package org.launchcode.models;

import jakarta.validation.constraints.*;

public class User {
    @NotBlank(message = "username cannot be blank")
    @Size(min=5, max = 20, message = "username has incorrect length")
    private String username;
    @Email
    private String email;
    @NotBlank(message = "password cannot be blank")
    private String password;

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public User() {

    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
