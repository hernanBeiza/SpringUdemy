package cl.hiperactivo.javapi.Imp;

import cl.hiperactivo.javapi.Models.Campana;
import cl.hiperactivo.javapi.Models.ContactoModel;
import cl.hiperactivo.javapi.Repositorys.ContactoRepository;
import cl.hiperactivo.javapi.Repositorys.ContactoRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public class ContactoRepositoryImp implements ContactoRepositoryCustom {

    public List<ContactoModel> obtenerConCampana(ContactoModel model) {
        //TODO Ir a buscar a la DB filtrados por idcampana
        return null;
    }

}
