package cl.hiperactivo.javapi;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.hiperactivo.javapi.Campana;

@Repository
public interface CampanaRepository extends JpaRepository<Campana, Integer> {

}