package tn.esprit.mspresence.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.mspresence.entities.PresenceCommand;
import tn.esprit.mspresence.entities.PresenceView;
import tn.esprit.mspresence.handler.PresenceCommandHandler;
import tn.esprit.mspresence.handler.PresenceQueryHandler;

@RestController
@RequestMapping("/api/cqrs/presences")
public class PresenceControllerCqrs {

    private static final Logger logger = LoggerFactory.getLogger(PresenceControllerCqrs.class);

    @Autowired
    private PresenceCommandHandler commandHandler;

    @Autowired
    private PresenceQueryHandler queryHandler;

    @PostMapping
    public ResponseEntity<Void> createPresence(@RequestBody PresenceCommand command) {
        logger.info("Creating Presence: {}", command);
        commandHandler.handle(command);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{idPresence}")
    public ResponseEntity<PresenceView> getPresence(@PathVariable Long idPresence) {
        PresenceView presence = queryHandler.handle(idPresence);
        if (presence == null) {
            logger.info("Presence with ID {} not found", idPresence);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        logger.info("Retrieved Presence: {}", presence);
        return ResponseEntity.ok(presence);
    }
}
