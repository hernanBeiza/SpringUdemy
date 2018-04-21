package cl.hiperactivo.internacionalizacion.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SaludoController {

    @RequestMapping(path="/saludo")
    public String saludo (Model model) {

        /*
         el view va ha recibir un atributo "nombre" con valor "Lista de nombres"
         Revisar archivo ConfigResources y la carpeta "resources"
        */

        model.addAttribute("titulo","Probando desde el controlador");
        return "saludo";
    }

}
