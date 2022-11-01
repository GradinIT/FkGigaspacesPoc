import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import se.fk.party.common.PartyId;
import se.fk.party.service.PartyService;

import java.util.stream.Collectors;

@RestController
public class PartyRestController {
    @Autowired
    PartyService partyService;

    @GetMapping("/party")
    private ResponseEntity<String> getAllParties() {
        return ResponseEntity.ok(partyService.getAllPartyIds().stream()
                .map(PartyId::getId)
                .map(Object::toString).collect(Collectors.joining("-", "{", "}")));
    }
}
