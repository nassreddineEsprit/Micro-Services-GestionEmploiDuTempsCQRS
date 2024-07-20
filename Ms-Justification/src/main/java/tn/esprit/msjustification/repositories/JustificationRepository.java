package tn.esprit.msjustification.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import tn.esprit.msjustification.entities.Justification;

import java.util.List;

public interface JustificationRepository extends MongoRepository<Justification, String> {
}
