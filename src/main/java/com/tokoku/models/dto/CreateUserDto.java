package com.tokoku.models.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

public class CreateUserDto {

    @NotEmpty(message = "name is requiered")
    private String name;
    @NotEmpty(message = "username is required")
    private String username;
    @NotEmpty(message = "email is required")
    @Email(message="email is invalid")
    private String email;
    @NotEmpty(message = "password is required")
    private String password;
    private Integer role;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
