package com.example.aplicacion_moviles3c;

import java.util.HashMap;
import java.util.Map;

public class UserRepository {

    public static final String EXTRA_USER_NAME = "com.example.aplicacion_moviles3c.USER_NAME";

    private final Map<String, String> users = new HashMap<>();
    private final Map<String, String> userDisplayNames = new HashMap<>();

    public UserRepository() {
        // Agrega un usuario por defecto para pruebas
        users.put("test@zenit.com", "123456");
        userDisplayNames.put("test@zenit.com", "Usuario Zenit");
    }

    public boolean isValid(String email, String password) {
        String storedPassword = users.get(email);
        return storedPassword != null && storedPassword.equals(password);
    }

    public String getDisplayName(String email) {
        return userDisplayNames.get(email);
    }
}
