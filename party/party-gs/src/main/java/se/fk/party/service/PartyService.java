package se.fk.party.service;

import se.fk.party.common.PartyId;
import se.fk.party.gs.SpaceParty;

import java.util.List;

public interface PartyService {
    SpaceParty getPartyById(PartyId partyId);

    SpaceParty updateParty(SpaceParty party);
    SpaceParty createParty(SpaceParty party);
    SpaceParty deleteParty(SpaceParty party);
    List<PartyId> getAllPartyIds();
    List<SpaceParty> deletePartiesById(List<PartyId> partyIds);
}
