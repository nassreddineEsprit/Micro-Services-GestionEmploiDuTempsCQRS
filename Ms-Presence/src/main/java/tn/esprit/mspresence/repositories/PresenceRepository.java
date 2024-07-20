package tn.esprit.mspresence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.mspresence.entities.Presence;

import java.util.List;

public interface PresenceRepository extends JpaRepository <Presence, Long> {
    List<Presence> findByJustificationName(String justificationName);
}
