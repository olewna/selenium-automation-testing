package org.service;

import org.models.User;

public class UserService {
    public static final String USERNAME = "performance_glitch_user";
    public static final String PASSWORD = "secret_sauce";

    public static User withCredentialsFromProperty(){
        return new User(USERNAME, PASSWORD);
    }

    public static User withWrongCredentials() {
        return new User("anyCredential", "anyCredential");
    }
}
