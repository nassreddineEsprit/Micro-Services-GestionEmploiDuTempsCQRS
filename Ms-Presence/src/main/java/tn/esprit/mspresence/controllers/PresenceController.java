package tn.esprit.mspresence.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.dto.JustificationDTO;
import tn.esprit.dto.PresenceDTO;
import tn.esprit.mspresence.services.IPresenceService;

import java.util.List;

@RestController
@RequestMapping("/api/presences")
public class PresenceController {

    @Autowired
    private IPresenceService presenceService;

    @PostMapping("/addPresence")
    public ResponseEntity<PresenceDTO> createPresence(@RequestBody PresenceDTO presenceDTO) {
        PresenceDTO savedPresence = presenceService.savePresence(presenceDTO);
        return ResponseEntity.ok(savedPresence);
    }

    @PutMapping("/updatePresence/{id}")
    public ResponseEntity<PresenceDTO> updatePresence(@PathVariable Long id, @RequestBody PresenceDTO presenceDTO) {
        presenceDTO.setIdPresence(id);
        PresenceDTO updatedPresence = presenceService.updatePresence(presenceDTO);
        return ResponseEntity.ok(updatedPresence);
    }

    @DeleteMapping("/deletePresence/{id}")
    public ResponseEntity<Void> deletePresence(@PathVariable Long id) {
        presenceService.deletePresence(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/getPresence/{id}")
    public ResponseEntity<PresenceDTO> getPresenceById(@PathVariable Long id) {
        PresenceDTO presenceDTO = presenceService.getPresenceById(id);
        return ResponseEntity.ok(presenceDTO);
    }

    @GetMapping("/getAllPresences")
    public ResponseEntity<List<PresenceDTO>> getAllPresences() {
        List<PresenceDTO> presences = presenceService.getAllPresences();
        return ResponseEntity.ok(presences);
    }

    @GetMapping("/justifications/getJustification/{justificationId}")
    public ResponseEntity<JustificationDTO> getJustificationForPresence(@PathVariable String justificationId) {
        JustificationDTO justificationDTO = presenceService.getJustificationForPresence(justificationId);
        return ResponseEntity.ok(justificationDTO);
    }

    @GetMapping("/justifications/getJustificationRT/{justificationId}")
    public ResponseEntity<JustificationDTO> getJustificationForPresenceRT(@PathVariable String justificationId) {
        JustificationDTO justificationDTO = presenceService.getJustificationForPresenceRT(justificationId);
        return ResponseEntity.ok(justificationDTO);
    }
    @PostMapping("/addJustification/{presenceId}/{justificationId}")
    public ResponseEntity<PresenceDTO> addJustificationToPresence(@PathVariable Long presenceId, @PathVariable String justificationId) {
        PresenceDTO updatedPresence = presenceService.addJustificationToPresence(presenceId, justificationId);
        return ResponseEntity.ok(updatedPresence);
    }
    @GetMapping("/byJustificationName/{justificationName}")
    public ResponseEntity<List<PresenceDTO>> getPresencesByJustificationName(@PathVariable String justificationName) {
        List<PresenceDTO> presences = presenceService.getPresencesByJustificationName(justificationName);
        return ResponseEntity.ok(presences);
    }
}
