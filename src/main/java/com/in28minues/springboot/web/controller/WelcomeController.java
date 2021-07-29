package com.in28minues.springboot.web.controller;

import com.in28minues.springboot.web.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

// Esta anotacion crea el controller para Spring, para que la levante
@Controller
// Estoy haciendo disponible el valor de name para otros controllers. Depende de cada controller tomar ese valor
//@SessionAttributes("name")
public class WelcomeController {

    @Autowired
    LoginService loginService;

    @RequestMapping(value="/", method = RequestMethod.GET)
    public String showWelcomePage(ModelMap model) {
        model.put("name", getLoggedInUserName());
        return "welcome";
    }

    private String getLoggedInUserName() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            return ((UserDetails) principal).getUsername();
        }
        return principal.toString();
    }

    // Segunda iteracion
    // LoginService es una dependencia de LoginController, porque este ultimo necesita al primero para funcionar.
    // Para eso tiene que ser Inyectado Automaticamente (Dependency Inyection)
    // El Controller necesita tomar el @Component LoginService (la instancia que declare en la clase LoginService)
    /*@Autowired
    LoginService loginService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String showLoginPage(ModelMap model) {
        return "login";
    }

    // Toma datos del form haciendo el mapping de la propiedad 'name' en el input de jsp, contra la variable que lo va a guardar en el model para la proxima pagina a la que redirige.
    // Si no entiendo mal estoy agregando al model de welcome, pero parado en login
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String showWelcomePage(ModelMap model, @RequestParam String name, @RequestParam String password) {

        boolean isValidUser = loginService.validateUserCredentials(name, password);

        if (!isValidUser) {
            model.put("validationMessage", "Invalid Credentials");
            return "login";
        }

        model.put("name", name);
        model.put("password", password);
        return "welcome";
    }*/

    // Primera iteracion, con explicacion
    // Model. La funcionalidad de model es poder pasar funcionalidad/informacion entre el Controller (donde estoy ahora) y la View (login.jsp en este caso)

    // Esta anotacion hace el mapping del endpoint /login con el metodo al que apunta
    // Si no se especifica el metodo en @RequestMapping, lo usa para todos (GET, POST, etc)
//    @RequestMapping("/login")
    // Si no entiendo mal, response body esta haciendo que directamente en vez de buscar una View (De MVC) dibuje de una lo que esta en el metodo, en este caso un string
    // @ResponseBody
    // ModelMap va a hacer el mapping
//    public String loginMessage(@RequestParam String name, ModelMap model) {
//        // No se si sera una buena idea, pero si directamente quiero mostrar mi mensaje usando @ResponseBody, puedo pasarle tags html y los va a dibujar como tal
//        //return "<h1>Hello World</h1>";
//
//        model.put("name", name);
//
//        // Si quiero que haga un redirect a una JSP, pongo el nombre de esa pagina sin el '.jsp'
//        return "login";
//    }
}
