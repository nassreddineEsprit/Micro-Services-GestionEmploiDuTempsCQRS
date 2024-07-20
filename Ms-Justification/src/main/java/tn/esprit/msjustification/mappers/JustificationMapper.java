package tn.esprit.msjustification.mappers;

import org.springframework.stereotype.Component;
//import tn.esprit.msjustification.dto.JustificationDTO;
import tn.esprit.dto.JustificationDTO;
import tn.esprit.msjustification.entities.Justification;
@Component
public class JustificationMapper {
    public static JustificationDTO maptoDto(Justification justification) {
        if (justification == null) {
            return null;
        }

        JustificationDTO justificationDTO = new JustificationDTO();
        justificationDTO.setIdJustification(justification.getIdJustification());
        justificationDTO.setJustificationName(justification.getJustificationName());
        justificationDTO.setJustificationReason(justification.getJustificationReason());
        justificationDTO.setJustificationStatus(justification.getJustificationStatus());
        justificationDTO.setJustificationSubmissionDate(justification.getJustificationSubmissionDate());
        justificationDTO.setJustificationValidationDate(justification.getJustificationValidationDate());
        justificationDTO.setJustificationFilePath(justification.getJustificationFilePath());

        return justificationDTO;
    }

    public static Justification maptoEntity(JustificationDTO justificationDTO) {
        if (justificationDTO == null) {
            return null;
        }

        Justification justification = new Justification();
        justification.setIdJustification(justificationDTO.getIdJustification());
        justification.setJustificationName(justificationDTO.getJustificationName());
        justification.setJustificationReason(justificationDTO.getJustificationReason());
        justification.setJustificationStatus(justificationDTO.getJustificationStatus());
        justification.setJustificationSubmissionDate(justificationDTO.getJustificationSubmissionDate());
        justification.setJustificationValidationDate(justificationDTO.getJustificationValidationDate());
        justification.setJustificationFilePath(justificationDTO.getJustificationFilePath());

        return justification;
    }
}
