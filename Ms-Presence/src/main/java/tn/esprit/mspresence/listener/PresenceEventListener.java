package tn.esprit.mspresence.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import tn.esprit.mspresence.entities.PresenceView;
import tn.esprit.mspresence.event.PresenceCreatedEvent;
import tn.esprit.mspresence.repositories.PresenceViewRepository;

@Service
public class PresenceEventListener {

    private static final Logger logger = LoggerFactory.getLogger(PresenceEventListener.class);

    @Autowired
    private PresenceViewRepository presenceViewRepository;

    @EventListener
    public void on(PresenceCreatedEvent event) {
        // Update the read model based on the event
        PresenceView presenceView = new PresenceView();
        presenceView.setIdPresence(event.getIdPresence());
        presenceView.setEtatPresence(event.getEtatPresence());
        presenceView.setDatePresence(event.getDatePresence());
        presenceView.setHeureDebut(event.getHeureDebut());
        presenceView.setHeureFin(event.getHeureFin());
        presenceView.setJustificationName(event.getJustificationName());
        presenceViewRepository.save(presenceView);

        logger.info("PresenceView saved: {}", presenceView);
    }
}
