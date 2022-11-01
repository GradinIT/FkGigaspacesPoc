package se.fk.party.service;

import lombok.extern.slf4j.Slf4j;
import org.openspaces.core.GigaSpace;
import org.openspaces.remoting.RemotingService;
import org.springframework.beans.factory.annotation.Autowired;
import se.fk.party.common.PartyId;
import se.fk.party.gs.SpaceParty;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RemotingService
@Slf4j
public class PartyServiceImpl implements PartyService {
    @Autowired
    GigaSpace partyGigaSpace;


    @Override
    public SpaceParty getPartyById(PartyId partyId) {
        return partyGigaSpace.readById(SpaceParty.class, partyId);
    }

    @Override
    public SpaceParty updateParty(SpaceParty party) {
        if (partyGigaSpace.readById(SpaceParty.class, party.getPartyId()) != null) {
            return partyGigaSpace.write(party).getObject();
        }
        return null;
    }

    @Override
    public SpaceParty createParty(SpaceParty party) {
        partyGigaSpace.write(party);
        return getPartyById(party.getPartyId());
    }

    @Override
    public SpaceParty deleteParty(SpaceParty party) {
        return partyGigaSpace.take(party);
    }

    @Override
    public List<PartyId> getAllPartyIds() {
        return Arrays.stream(partyGigaSpace.readMultiple(SpaceParty.builder().build()))
                .map(party -> {
                    return party.getPartyId();
                })
                .collect(Collectors.toList());

    }

    @Override
    public List<SpaceParty> deletePartiesById(List<PartyId> partyIds) {
        return partyIds.stream().map(this::getPartyById)
                .filter(Objects::nonNull)
                .map(this::deleteParty).collect(Collectors.toList());
    }

}
