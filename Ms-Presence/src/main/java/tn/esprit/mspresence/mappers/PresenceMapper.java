package tn.esprit.mspresence.mappers;

import org.springframework.stereotype.Component;

import tn.esprit.dto.PresenceDTO;
import tn.esprit.mspresence.entities.Presence;

@Component
public class PresenceMapper {
    public static PresenceDTO mapToDto(Presence presence) {
        if (presence == null) {
            return null;
        }

        PresenceDTO presenceDTO = new PresenceDTO();
        presenceDTO.setIdPresence(presence.getIdPresence());
        presenceDTO.setEtatPresence(presence.getEtatPresence());
        presenceDTO.setDatePresence(presence.getDatePresence());
        presenceDTO.setHeureDebut(presence.getHeureDebut());
        presenceDTO.setHeureFin(presence.getHeureFin());
        presenceDTO.setJustificationName(presence.getJustificationName());

        return presenceDTO;
    }

    public static Presence mapToEntity(PresenceDTO presenceDTO) {
        if (presenceDTO == null) {
            return null;
        }

        Presence presence = new Presence();
        presence.setIdPresence(presenceDTO.getIdPresence());
        presence.setEtatPresence(presenceDTO.getEtatPresence());
        presence.setDatePresence(presenceDTO.getDatePresence());
        presence.setHeureDebut(presenceDTO.getHeureDebut());
        presence.setHeureFin(presenceDTO.getHeureFin());
        presence.setJustificationName(presenceDTO.getJustificationName());

        return presence;
    }
}
