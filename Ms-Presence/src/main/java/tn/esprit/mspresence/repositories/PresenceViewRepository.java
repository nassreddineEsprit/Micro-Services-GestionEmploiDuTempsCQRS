package tn.esprit.mspresence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.mspresence.entities.PresenceView;

public interface PresenceViewRepository extends JpaRepository<PresenceView, Long> {
}