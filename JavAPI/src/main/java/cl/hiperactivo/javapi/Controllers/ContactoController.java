package cl.hiperactivo.javapi.Controllers;

import cl.hiperactivo.javapi.Exceptions.RecursoNoEncontradoException;
import cl.hiperactivo.javapi.Models.ContactoModel;
import cl.hiperactivo.javapi.Repositorys.ContactoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contacto")
public class ContactoController {

    @Autowired
    private ContactoRepository contactoRepository;

    //Obtener todas los contactos
    @RequestMapping(value = {"/",""}, method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<ContactoModel> obtener() {
        System.out.println("obtener()");
        return contactoRepository.findAll();
    }

    //Obtener una en específico por el id
    @RequestMapping(value = {"/{id}","/{id}"}, method = RequestMethod.GET)
    public ContactoModel obtenerConID(@PathVariable(value = "id") Long idcontacto) {
        System.out.println("obtenerConID() " + String.valueOf(idcontacto));

        return contactoRepository.findById(idcontacto)
                .orElseThrow(() -> new RecursoNoEncontradoException("Contacto", "idcontacto", idcontacto));
    }


}
