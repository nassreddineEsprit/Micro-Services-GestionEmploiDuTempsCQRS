package tn.esprit.mspresence.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.mspresence.entities.PresenceView;
import tn.esprit.mspresence.repositories.PresenceViewRepository;

@Service
public class PresenceQueryHandler {

    private static final Logger logger = LoggerFactory.getLogger(PresenceQueryHandler.class);

    @Autowired
    private PresenceViewRepository presenceViewRepository;

    public PresenceView handle(Long presenceId) {
        logger.info("Handling Query for Presence ID: {}", presenceId);
        // Fetch from read model
        PresenceView presenceView = presenceViewRepository.findById(presenceId).orElse(null);
        if (presenceView == null) {
            logger.info("Presence with ID {} not found", presenceId);
            return null;
        }
        logger.info("Presence Retrieved: {}", presenceView);
        return presenceView;
    }
}
