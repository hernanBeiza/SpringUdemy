package cl.hiperactivo.javapi.Controllers;


import cl.hiperactivo.javapi.Exceptions.RecursoNoEncontradoException;
import cl.hiperactivo.javapi.Models.Campana;
import cl.hiperactivo.javapi.Repositorys.CampanaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/campana")
public class CampanaController {

    @Autowired
    private CampanaRepository campanaRepository;

    //Obtener todas las campañas
    @RequestMapping(value = {"/",""}, method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Campana> obtener() {
        System.out.println("obtener()");
        return campanaRepository.findAll();
    }

    //Obtener una en específico por el id
    @RequestMapping(value = {"/{id}","/{id}"}, method = RequestMethod.GET)
    public Campana obtenerConID(@PathVariable(value = "id") Long campanaId) {
        System.out.println("obtenerConID() " + String.valueOf(campanaId));
        return campanaRepository.findById(campanaId)
                .orElseThrow(() -> new RecursoNoEncontradoException("Campana", "idcampana", campanaId));
    }

}