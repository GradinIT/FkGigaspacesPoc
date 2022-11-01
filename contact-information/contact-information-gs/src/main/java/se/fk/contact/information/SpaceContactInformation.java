package se.fk.contact.information;

import lombok.Builder;
import lombok.Getter;
import se.fk.contact.information.domain.ContactInformation;
import se.fk.contact.information.domain.ContactInformationId;
import se.fk.party.common.PartyId;

import java.io.Serializable;
@Builder
@Getter
public class SpaceContactInformation implements Serializable {
    private PartyId partyId;
    private ContactInformationId contactInformationId;
    private ContactInformation contactInformation;
}
