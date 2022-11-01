package se.fk.contact.information.service;

import com.j_spaces.core.client.SQLQuery;
import org.openspaces.core.GigaSpace;
import org.springframework.beans.factory.annotation.Autowired;
import se.fk.contact.information.SpaceContactInformation;
import se.fk.contact.information.domain.ContactInformation;
import se.fk.contact.information.domain.ContactInformationId;
import se.fk.party.common.PartyId;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ContactInformationServiceImpl implements ContactInformationService {
    @Autowired
    GigaSpace contactInformationSpace;

    @Override
    public List<ContactInformation> getContactInformationByPartyId(PartyId partyId) {
        SQLQuery<SpaceContactInformation> query = new SQLQuery<SpaceContactInformation>(SpaceContactInformation.class, "partyId = ?", partyId);
        return Arrays.stream(contactInformationSpace.readMultiple(query)).toList().stream()
                .filter(Objects::nonNull)
                .map(SpaceContactInformation::getContactInformation)
                .collect(Collectors.toList());

    }

    @Override
    public ContactInformation getContactInformationById(ContactInformationId contactInformationId) {
        return contactInformationSpace.readById(SpaceContactInformation.class, contactInformationId.getId()).getContactInformation();
    }

    @Override
    public ContactInformationId addContactInformation(ContactInformation contactInformation, PartyId partyId) {
        return contactInformationSpace.write(SpaceContactInformation.builder()
                .contactInformation(contactInformation)
                .contactInformationId(contactInformation.getContactInformationId())
                .partyId(partyId)
                .build()).getObject().getContactInformationId();
    }

    @Override
    public ContactInformation removeContactInformation(ContactInformationId contactInformationId, PartyId partyId) {
        SQLQuery<SpaceContactInformation> query = new SQLQuery<SpaceContactInformation>(SpaceContactInformation.class, "partyId = ? and contactInformationId = ? ", partyId,contactInformationId);
        return contactInformationSpace.take(query).getContactInformation();
    }
}
