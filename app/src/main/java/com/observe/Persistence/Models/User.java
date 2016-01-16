package com.observe.Persistence.Models;

public class User {
    private String name, email, password;
    private boolean isProfessional;

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public boolean isProfessional() {
        return isProfessional;
    }
}
