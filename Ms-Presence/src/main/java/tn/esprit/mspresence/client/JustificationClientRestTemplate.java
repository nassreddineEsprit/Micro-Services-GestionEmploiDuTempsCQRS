package tn.esprit.mspresence.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import tn.esprit.dto.JustificationDTO;

@Component
public class JustificationClientRestTemplate {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${justification.service.url}")
    private String justificationServiceUrl;

    public JustificationDTO getJustificationById(String justificationId) {
        String url = justificationServiceUrl + "/api/justifications/getJustification/" + justificationId;
        return restTemplate.getForObject(url, JustificationDTO.class);
    }
}
