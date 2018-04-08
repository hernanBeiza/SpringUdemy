package cl.hiperactivo.contenttype.Controllers;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import cl.hiperactivo.contenttype.Models.Persona;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PersonaController {

	
	/**
	 * Arrancad la aplicacion y acceded a:
	 *
	 * http://localhost:8080/persona
	 * http://localhost:8080/persona.xml
	 * http://localhost:8080/persona.json
	 * 
	 * Despues provad las mismas peticiones cambiando el RequestMapping a:
	 * 	@RequestMapping(path="/persona", produces=MediaType.APPLICATION_JSON_VALUE) i
	 *  @RequestMapping(path="/persona", produces=MediaType.APPLICATION_XML_VALUE)
	 *
	 *  Recordar: El cliente debe enviar en la cabececera "Accept: application/xml"
	 */
	@RequestMapping(path="/persona", produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	@ResponseBody
	public Persona obtenerPersona() throws ParseException {
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		return new Persona("Pere","Selva", df.parse("22-12-1980"),"supersecreto");
	}
}
