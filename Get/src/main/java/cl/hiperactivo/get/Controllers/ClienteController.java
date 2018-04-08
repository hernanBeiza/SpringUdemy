package cl.hiperactivo.get.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador web que ofrece funcionalidad para hacer calculos
 *
 * El @RequestMapping a nivel de clase hace que todos los paths especificados
 * en los metodos con @RequestMapping tengan un path con el prefijo "/calc"
 */

@Controller
@RequestMapping("/clientes")
public class ClienteController {
    /**
     * Mapping sencillo a /clientes/info que devuelve un String fijo
     * @ResponseBody hace que Spring MVC devuelva al cliente el valor devuelto
     * por el metodo
     */
    @RequestMapping(path="/info")
    @ResponseBody
    public String info() {
        return "Información de clientes online";
    }

    /**
     * Metodo con parametros. Los parámetros de la URL deben llamarse como los de esta función
     * 0.0.0.0:8080/clientes/suma?a=10&b=10
     */
    @RequestMapping(path="/suma")
    @ResponseBody
    public int suma (int a, int b) {
        return a + b;
    }

    /**
     * Uso de un path variable: parte del path usado es mapeado a una variable del metodo
     * p.e. /clientes/siguiente/5 hace que el valor del parametro original sea 5
     */
    @RequestMapping(path="/siguiente/{original}")
    @ResponseBody
    public int siguiente(@PathVariable int original) {
        return original +  1;
    }

    /**
     * Obtener un cliente por el id
     * /clientes/idcliente
     * /clientes/1
     */

    @RequestMapping(path="/{id}")
    @ResponseBody
    public String obtener(@PathVariable String id) {
        System.out.println("obtener();");
        System.out.println("clientes/"+id);
        return "Cliente con id " + id + " no encontrado";
    }
    /**
     * Cambio de valores de los parámetros HTTP
     * /clientes/buscar/?nombre=asdf
     * /clientes/buscar/
     */
    @RequestMapping(path="/buscar/", method={RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public String buscar(@RequestParam(name="nombre", required=false, defaultValue="hb") String nombreCliente) {
        System.out.println("buscar();");
        System.out.println("clientes/buscar/"+nombreCliente);
        return "Cliente con nombre " + nombreCliente + " no encontrado";
    }


}



