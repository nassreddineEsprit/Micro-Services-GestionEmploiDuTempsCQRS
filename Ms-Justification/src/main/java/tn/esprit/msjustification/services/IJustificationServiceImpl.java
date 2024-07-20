package tn.esprit.msjustification.services;

import org.springframework.stereotype.Service;
import tn.esprit.msjustification.client.PresenceClient;
//import tn.esprit.msjustification.dto.JustificationDTO;
//import tn.esprit.msjustification.dto.PresenceDTO;
import tn.esprit.dto.JustificationDTO;
import tn.esprit.dto.PresenceDTO;
import tn.esprit.msjustification.entities.Justification;
import tn.esprit.msjustification.mappers.JustificationMapper;
import tn.esprit.msjustification.repositories.JustificationRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IJustificationServiceImpl implements IJustificationService {

    private final JustificationRepository justificationRepository;
    private final PresenceClient presenceClient;

    public IJustificationServiceImpl(JustificationRepository justificationRepository, PresenceClient presenceClient) {
        this.justificationRepository = justificationRepository;
        this.presenceClient = presenceClient;
    }

    @Override
    public JustificationDTO saveJustification(JustificationDTO justificationDTO) {
        Justification justification = JustificationMapper.maptoEntity(justificationDTO);
        justification = justificationRepository.save(justification);
        return JustificationMapper.maptoDto(justification);
    }

    @Override
    public JustificationDTO updateJustification(JustificationDTO justificationDTO) {
        Justification justification = JustificationMapper.maptoEntity(justificationDTO);
        justification = justificationRepository.save(justification);
        return JustificationMapper.maptoDto(justification);
    }

    @Override
    public void deleteJustification(String id) {
        justificationRepository.deleteById(id);
    }

    @Override
    public JustificationDTO getJustificationById(String id) {
        Justification justification = justificationRepository.findById(id).orElse(null);
        return JustificationMapper.maptoDto(justification);
    }

    @Override
    public List<JustificationDTO> getAllJustifications() {
        List<Justification> justifications = justificationRepository.findAll();
        return justifications.stream()
                .map(JustificationMapper::maptoDto)
                .collect(Collectors.toList());
    }

    @Override
    public PresenceDTO getPresenceById(Long id) {
        return presenceClient.getPresenceById(id);
    }
    @Override
    public List<PresenceDTO> getPresencesByJustificationName(String justificationName) {
        return presenceClient.getPresencesByJustificationName(justificationName);
    }
}
