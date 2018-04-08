package cl.hiperactivo.viewmodel.Controller;

import cl.hiperactivo.viewmodel.Model.Persona;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Arrays;

@Controller
public class ListaController {
	

	/**
	 * El Model es el tipo que nos permite pasar informacion del controller a la vista.
	 * 
	 * Para disponer de un Model podemos declararlo como parametro de nuestro metodo. Spring MVC
	 * nos pasara una referencia a un Model para nuestra peticion si encuentra este parametro en la 
	 * declaracion del metodo.
	 * 
	 * Tipicamente, lo que anadimos al model lo hemos obtenido de la logica de negocio, de una consulta
	 * a base de datos etc etc. Aqui, para simplificar, guardaremos siempre el mismo String. Evidentemente,
	 * en este caso, no tiene sentido usar el model ... pero es un simple ejemplo introductorio.
	 * 
	 * En el model guardamos elementos etiquetados con un String y con valor cualquier tipo no primitivo.
	 * Es decir, la etiqueta ("nombre" en este caso) siempre sera un String, pero el valor ("Lista de nombres",
	 * en nuestro ejemplo) puede ser un array, una Collection, un tipo creado nuestro, etc.
	 */
	private final List<String> valores = Arrays.asList("primero", "segundo", "tercero");

	@RequestMapping(path="/lista")
	public String estado (Model model) {
		
		// el view va ha recibir un atributo "nombre" con valor "Lista de nombres"
		model.addAttribute("nombre","Lista de nombres");
		model.addAttribute("lista", valores);

		return "lista";
	}

	@RequestMapping(path="/lista/{id}")
	public String mostrar(@PathVariable String id, Model model) {
		model.addAttribute("usuario", new Persona("persona " + id, "Selva"));
		return "listaDetalle";
	}

}
