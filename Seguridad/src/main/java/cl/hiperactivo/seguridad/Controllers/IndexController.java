package cl.hiperactivo.seguridad.Controllers;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collections;
import java.util.Map;

@Controller
public class IndexController {

    @RequestMapping(path="",method={RequestMethod.POST,RequestMethod.GET},produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public Map saludar(){
        Map result = Collections.singletonMap("result", "Hola...");
        return result;
    }

}
