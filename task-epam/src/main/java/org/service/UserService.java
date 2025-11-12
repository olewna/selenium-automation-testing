package org.service;

import org.models.User;

public class UserService {
    public static User withCredentialsFromProperty(String username, String password){
        return new User(username, password);
    }

    public static User withWrongCredentials() {
        return new User("anyCredential", "anyCredential");
    }
}
