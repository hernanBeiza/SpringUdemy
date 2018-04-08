package cl.hiperactivo.errores.Excepciones;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.INTERNAL_SERVER_ERROR, reason = "Operación incorrecta")
public class OperacionException extends RuntimeException {


}
