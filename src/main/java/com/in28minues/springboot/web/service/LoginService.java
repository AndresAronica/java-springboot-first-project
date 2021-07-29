package com.in28minues.springboot.web.service;

import org.springframework.stereotype.Component;

// Spring Bean
// @Component hace que Spring lo maneje y cree una instancia de esta clase por mi
@Component
public class LoginService {
    public boolean validateUserCredentials(String userID, String password) {
        // Como caso super basico suponemos que el usuario disponible es Aandres534 con pass 12345
        // Bastante basico, consulta si los 2 son iguales y devuelve un bool con eso
        return userID.equalsIgnoreCase("Andres") && password.equalsIgnoreCase("1");
    }
}
