package se.fk.party.ssn.service;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.openspaces.core.GigaSpace;
import org.openspaces.remoting.RemotingService;
import org.springframework.beans.factory.annotation.Autowired;
import se.fk.party.common.PartyId;
import se.fk.party.ssn.common.NationalPersonId;
import se.fk.party.ssn.gs.SpacePartySSN;

import java.util.Objects;

@RemotingService
@Slf4j
public class PartySsnServiceImpl implements PartySsnService {
    private final GigaSpace partySsnGigaSpace;
    @Autowired
    public PartySsnServiceImpl(GigaSpace partySsnGigaSpace) {
        log.info("start service using " + partySsnGigaSpace);
        this.partySsnGigaSpace = Objects.requireNonNull(partySsnGigaSpace,"partySsnGigaSpace cant be null");
        log.info("this.partySsnGigaSpace = " + this.partySsnGigaSpace);
    }


    @Override
    public PartyId getPartyId(NationalPersonId nationalPersonId) {
        log.info("getPartyId - {}", nationalPersonId);
        return null;
    }

    @Override
    public NationalPersonId getNationalPersonId(PartyId partyId) {
        log.info("getNationalPersonId - {}", partyId);
        return null;
    }

    @Override
    public PartyId addPartyIdNationalPersonId(PartyId partyId, NationalPersonId nationalPersonId) {
        log.info("calling addPartyIdNationalPersonId {} {}",partyId,nationalPersonId );
        log.info("" + partySsnGigaSpace);
        SpacePartySSN stored = partySsnGigaSpace.write(SpacePartySSN.builder()
                        .nationalPersonId(nationalPersonId)
                        .partyId(partyId)
                        .build())
                .getObject();
        return stored.getPartyId();
    }
}
