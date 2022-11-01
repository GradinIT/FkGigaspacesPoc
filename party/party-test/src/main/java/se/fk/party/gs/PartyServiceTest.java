package se.fk.party.gs;

import com.j_spaces.core.IJSpace;
import org.openspaces.core.GigaSpace;
import org.openspaces.core.GigaSpaceConfigurer;
import org.openspaces.core.space.UrlSpaceConfigurer;
import org.openspaces.remoting.ExecutorRemotingProxyConfigurer;
import se.fk.party.common.PartyId;
import se.fk.party.service.PartyService;

import java.util.List;

public class PartyServiceTest {


    public static void main(String[] args) {
        PartyService partyService = null;
        IJSpace space = null;
        GigaSpace gigaSpace = null;
        space = (new UrlSpaceConfigurer("jini://*/*/partySpace")).lookupLocators("localhost").space();
        gigaSpace = (new GigaSpaceConfigurer(space)).gigaSpace();
        partyService = (PartyService) (new ExecutorRemotingProxyConfigurer(gigaSpace, PartyService.class)).proxy();
        for (long i = 0; i < 10000; ++i) {
            System.out.println(partyService.createParty(SpaceParty.builder()
                            .partyId(PartyId.builder().id(i).build())
                            .familyName("Gradin")
                            .givenName("Joakim")
                            .build()
                    )
            );
            SpaceParty spaceParty = partyService.getPartyById(PartyId.builder().id(i).build());
            System.out.println(spaceParty);
            if (spaceParty.getPartyId().getId() % 2 == 0)
                partyService.deleteParty(spaceParty);
        }
        System.out.println(gigaSpace.count(SpaceParty.builder().build()));
        List<PartyId> partyIdsInSpace = partyService.getAllPartyIds();
        System.out.println(partyService.deletePartiesById(partyIdsInSpace));
    }
}
