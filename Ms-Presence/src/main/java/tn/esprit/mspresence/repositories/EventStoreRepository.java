package tn.esprit.mspresence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.mspresence.entities.EventStore;

public interface EventStoreRepository extends JpaRepository<EventStore, Long> {
}