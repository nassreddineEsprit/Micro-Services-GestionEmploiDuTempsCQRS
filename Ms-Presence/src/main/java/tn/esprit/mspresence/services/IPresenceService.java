package tn.esprit.mspresence.services;

//import tn.esprit.mspresence.dto.JustificationDTO;
//import tn.esprit.mspresence.dto.PresenceDTO;
import tn.esprit.dto.JustificationDTO;
import tn.esprit.dto.PresenceDTO;

import java.util.List;

public interface IPresenceService {
    PresenceDTO savePresence(PresenceDTO presenceDTO);

    PresenceDTO updatePresence(PresenceDTO presenceDTO);

    void deletePresence(Long id);

    PresenceDTO getPresenceById(Long id);

    List<PresenceDTO> getAllPresences();

    JustificationDTO getJustificationForPresence(String justificationId);

    JustificationDTO getJustificationForPresenceRT(String justificationId);

    PresenceDTO addJustificationToPresence(Long presenceId, String justificationId);
    List<PresenceDTO> getPresencesByJustificationName(String justificationName);
}