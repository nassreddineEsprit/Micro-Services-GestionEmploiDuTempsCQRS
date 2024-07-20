package tn.esprit.mspresence.client;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import tn.esprit.mspresence.dto.JustificationDTO;
import tn.esprit.dto.JustificationDTO;
import tn.esprit.mspresence.config.FeignConfig;

//@FeignClient(name = "ms-justification",url = "http://localhost:9091",configuration = FeignConfig.class)
@FeignClient(name = "ms-justification",configuration = FeignConfig.class)
public interface JustificationClient {
    Logger logger = LoggerFactory.getLogger(JustificationClient.class);
    @GetMapping("/api/justifications/getJustification/{justificationId}")
    @CircuitBreaker(name = "justificationService", fallbackMethod = "getJustificationByIdFallback")
    JustificationDTO getJustificationById(@PathVariable("justificationId") String justificationId);
    default JustificationDTO getJustificationByIdFallback(String justificationId, Throwable t) {

        logger.error("Fallback triggered for getJustificationById with id {}: {}", justificationId, t.getMessage());

        JustificationDTO defaultJustification = new JustificationDTO();
        defaultJustification.setIdJustification(justificationId);
        defaultJustification.setJustificationName("Default Justification Name");
        defaultJustification.setJustificationReason("Justification Service is not running or Broken");
        return defaultJustification;
    }
}
