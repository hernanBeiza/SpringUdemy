package cl.hiperactivo.javapi.Repositorys;

import cl.hiperactivo.javapi.Models.ContactoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactoRepository extends JpaRepository<ContactoModel,Long>,
        ContactoRepositoryCustom {


}
