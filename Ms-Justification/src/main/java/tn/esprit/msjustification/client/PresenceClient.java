package tn.esprit.msjustification.client;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import tn.esprit.msjustification.dto.PresenceDTO;
import tn.esprit.dto.PresenceDTO;
import tn.esprit.msjustification.config.FeignConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.List;

//@FeignClient(name = "ms-presence",url = "http://localhost:9090", configuration = FeignConfig.class)
@FeignClient(name = "ms-presence",configuration = FeignConfig.class)

public interface PresenceClient {
    Logger logger = LoggerFactory.getLogger(PresenceClient.class);

    @GetMapping("/api/presences/getPresence/{id}")
    @CircuitBreaker(name = "presenceService", fallbackMethod = "getPresenceByIdFallback")
    PresenceDTO getPresenceById(@PathVariable("id") Long id);

    @GetMapping("/api/presences/byJustificationName/{justificationName}")
    @CircuitBreaker(name = "presenceService", fallbackMethod = "getPresencesByJustificationNameFallback")
    List<PresenceDTO> getPresencesByJustificationName(@PathVariable("justificationName") String justificationName);

    default PresenceDTO getPresenceByIdFallback(Long id, Throwable t) {
        // Log the error
        logger.error("Fallback triggered for getPresenceById with id {}: {}", id, t.getMessage());

        // Return a default or empty instance
        PresenceDTO defaultPresence = new PresenceDTO();
        defaultPresence.setIdPresence(id);
        defaultPresence.setEtatPresence(false);
        defaultPresence.setJustificationName("Presence Service is not running or Broken");
        return defaultPresence;
    }
    default List<PresenceDTO> getPresencesByJustificationNameFallback(String justificationName, Throwable t) {
        // Log the error
        logger.error("Fallback triggered for getPresencesByJustificationName with justificationName {}: {}", justificationName, t.getMessage());

        // Return an empty list
        return Collections.emptyList();
    }
}
