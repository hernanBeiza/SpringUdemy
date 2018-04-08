package cl.hiperactivo.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MiController {

    @RequestMapping("/saludo")
    @ResponseBody
    public String saludo(){
        return "Hola udemy";
    }

}
