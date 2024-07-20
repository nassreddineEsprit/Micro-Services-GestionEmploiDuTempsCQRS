package tn.esprit.mspresence.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.mspresence.entities.PresenceCommand;
import tn.esprit.mspresence.event.PresenceCreatedEvent;
import tn.esprit.mspresence.publisher.EventPublisher;

@Service
public class PresenceCommandHandler {

    private static final Logger logger = LoggerFactory.getLogger(PresenceCommandHandler.class);

    @Autowired
    private EventPublisher eventPublisher;

    public void handle(PresenceCommand command) {
        logger.info("Handling Presence Command: {}", command);
        // Business logic for creating a presence
        PresenceCreatedEvent event = new PresenceCreatedEvent(command.getIdPresence(), command.getEtatPresence(), command.getDatePresence(), command.getHeureDebut(), command.getHeureFin(), command.getJustificationName());
        eventPublisher.publish(event);
    }
}
