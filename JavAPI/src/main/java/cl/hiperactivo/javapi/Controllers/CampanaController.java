package cl.hiperactivo.javapi.Controllers;


import cl.hiperactivo.javapi.CampanaRepository;
import cl.hiperactivo.javapi.Campana;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/campana")
public class CampanaController {

    @Autowired
    private CampanaRepository campanaRepository;

    /*
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Campana>getCampanaById(@PathVariable("id") Integer id) {
        System.out.println("id: " + id);
        Campana model = new Campana();
        model.setId(id);
        Campana encontrad;
        encontrad = campanaRepository.findOne(id);

    }
    */


    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Campana> getCampanas() {
        System.out.println("getCampanas()");
        return campanaRepository.findAll();
    }


}