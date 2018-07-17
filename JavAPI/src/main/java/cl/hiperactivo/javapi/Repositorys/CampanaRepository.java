package cl.hiperactivo.javapi.Repositorys;

import cl.hiperactivo.javapi.Models.Campana;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CampanaRepository extends JpaRepository<Campana,Long>{

}
