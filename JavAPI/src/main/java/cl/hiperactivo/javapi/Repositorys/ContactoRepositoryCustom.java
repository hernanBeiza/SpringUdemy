package cl.hiperactivo.javapi.Repositorys;

import cl.hiperactivo.javapi.Models.Campana;
import cl.hiperactivo.javapi.Models.ContactoModel;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactoRepositoryCustom {
    public List<ContactoModel> obtenerConCampana(ContactoModel model);
}