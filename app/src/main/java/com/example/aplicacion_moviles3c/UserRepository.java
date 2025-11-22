package com.example.aplicacion_moviles3c;

import java.util.HashMap;
import java.util.Map;

public class UserRepository {

    public static final String EXTRA_USER_NAME = "com.example.aplicacion_moviles3c.USER_NAME";

    private final Map<String, String> users = new HashMap<>();
    private final Map<String, String> userDisplayNames = new HashMap<>();

    public UserRepository() {
        // Credenciales Zenit
        users.put("fundadores@zenitdigital.com", "zenit2024!");
        userDisplayNames.put("fundadores@zenitdigital.com", "Dirección Zenit");

        users.put("asesoria@zenitdigital.com", "guiaPro#7");
        userDisplayNames.put("asesoria@zenitdigital.com", "Consultor Senior");

        users.put("operaciones@zenitdigital.com", "deploy360");
        userDisplayNames.put("operaciones@zenitdigital.com", "Líder de Operaciones");
    }

    public boolean isValid(String email, String password) {
        String storedPassword = users.get(email);
        return storedPassword != null && storedPassword.equals(password);
    }

    public String getDisplayName(String email) {
        return userDisplayNames.get(email);
    }
}
