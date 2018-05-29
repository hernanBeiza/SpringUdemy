package cl.hiperactivo.token.controllers;

import cl.hiperactivo.token.config.ConfigurationProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RequestMapping(path = "/api")
@RestController
public class ProductoController {


    @RequestMapping(path="/producto/{idproducto}", method={RequestMethod.GET}, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<Map<String,Object>> obtenerConID(@PathVariable Integer idproducto) {

        System.out.println("obtenerConID();");
        System.out.println(idproducto);
        boolean enviar = true;
        String errores = "Te faltó:\n";
        if(idproducto==null){
            enviar = false;
            errores +="ID del producto";
        }

        Map<String, Object> result = new HashMap<String,Object>();
        if(enviar){
            // TODO: Hacer validación contra DB
            result.put("result",true);
            result.put("mensaje","Producto encontrado");
            result.put("producto",null);
            return new ResponseEntity<Map<String,Object>>(result, HttpStatus.OK);
        } else {
            System.out.println(errores);
            result.put("result",false);
            result.put("errores",errores);
            // Add any additional props that you want to add
            return new ResponseEntity<Map<String,Object>>(result, HttpStatus.BAD_REQUEST);
        }
    }

}

