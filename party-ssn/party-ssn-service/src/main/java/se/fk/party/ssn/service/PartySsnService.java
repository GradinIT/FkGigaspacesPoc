package se.fk.party.ssn.service;

import se.fk.party.common.PartyId;
import se.fk.party.ssn.common.NationalPersonId;

public interface PartySsnService {
    PartyId getPartyId(NationalPersonId nationalPersonId);

    NationalPersonId getNationalPersonId(PartyId partyId);

    PartyId addPartyIdNationalPersonId(PartyId partyId, NationalPersonId nationalPersonId);
}
