package csc.groupProject.Bank.LoginManager;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Controller
public class LoginController {
    /*
    *
    *
    * */
    @RequestMapping("/")
    public String home(Map<String, Object> model) {
        model.put("message", "Testing Index Page");
        return "index";
    }

    @RequestMapping("/next")
    public String next(Map<String, Object> model) {
        model.put("message", "Redirect");
        return "redirectTest";
    }
    //redirect to accountCreationController


    //if login is validated redirect to AccountController


    //

}
