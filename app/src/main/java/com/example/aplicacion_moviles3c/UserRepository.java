package com.example.aplicacion_moviles3c;

import java.util.HashMap;
import java.util.Map;

/**
 * Maneja un listado sencillo de usuarios permitidos para el login.
 */
public class UserRepository {
    public static final String EXTRA_USER_NAME = "extra_user_name";

    private final Map<String, User> users = new HashMap<>();

    public UserRepository() {
        addUser("admin@tecnoworld.com", "123456", "Administración TecnoWorld");
        addUser("asesor@tecnoworld.com", "abc123", "Asesor Comercial");
        addUser("soporte@tecnoworld.com", "service2024", "Mesa de Soporte");
    }

    private void addUser(String email, String password, String displayName) {
        users.put(email.trim().toLowerCase(), new User(email, password, displayName));
    }

    public boolean isValid(String email, String password) {
        User user = users.get(email.trim().toLowerCase());
        return user != null && user.password.equals(password);
    }

    public String getDisplayName(String email) {
        User user = users.get(email.trim().toLowerCase());
        return user != null ? user.displayName : "";
    }

    private static class User {
        final String email;
        final String password;
        final String displayName;

        private User(String email, String password, String displayName) {
            this.email = email;
            this.password = password;
            this.displayName = displayName;
        }
    }
}
