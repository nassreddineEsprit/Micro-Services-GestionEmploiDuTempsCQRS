package tn.esprit.msjustification.services;

//import tn.esprit.msjustification.dto.JustificationDTO;
//import tn.esprit.msjustification.dto.PresenceDTO;
import tn.esprit.dto.JustificationDTO;
import tn.esprit.dto.PresenceDTO;
import java.util.List;

public interface IJustificationService {
    JustificationDTO saveJustification(JustificationDTO justificationDTO);
    JustificationDTO updateJustification(JustificationDTO justificationDTO);
    void deleteJustification(String id);
    JustificationDTO getJustificationById(String id);
    List<JustificationDTO> getAllJustifications();
    PresenceDTO getPresenceById(Long id);
    List<PresenceDTO> getPresencesByJustificationName(String justificationName);
}
