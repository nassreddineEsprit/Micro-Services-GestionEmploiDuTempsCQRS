package tn.esprit.mspresence.publisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import tn.esprit.mspresence.entities.EventStore;
import tn.esprit.mspresence.event.PresenceCreatedEvent;
import tn.esprit.mspresence.repositories.EventStoreRepository;

@Service
public class EventPublisher {

    @Autowired
    private EventStoreRepository eventStoreRepository;

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    public void publish(PresenceCreatedEvent event) {
        // Persist the event
        EventStore eventStore = new EventStore(event.getIdPresence(), event);
        eventStoreRepository.save(eventStore);

        // Notify subscribers
        applicationEventPublisher.publishEvent(event);
    }
}