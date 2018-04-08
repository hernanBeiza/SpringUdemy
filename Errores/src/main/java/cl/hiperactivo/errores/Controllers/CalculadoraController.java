package cl.hiperactivo.errores.Controllers;

import cl.hiperactivo.errores.Excepciones.OperacionException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CalculadoraController {

    @RequestMapping(path="/div")
    public int division (int a, int b){
        //Se puede usar una clase propia para manejar la excepción,
        if(b==0){
            throw new OperacionException();
        }
        return a/b;
    }

    /**
     * Demostración del uso de ResponseEntity,
     * Permite manipular código, cabeceras y cuerpo
     */

    @RequestMapping(path="/dividir")
    public ResponseEntity<Integer> dividir (int a,int b){
        if(b==0){
            return new ResponseEntity<>(0, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(a/b,HttpStatus.OK);
    }

    @ExceptionHandler(ArithmeticException.class)
    @ResponseBody
    public String error(ArithmeticException e){
        return "Se ha producido un error en la operación: " + e.getLocalizedMessage();
    }

}