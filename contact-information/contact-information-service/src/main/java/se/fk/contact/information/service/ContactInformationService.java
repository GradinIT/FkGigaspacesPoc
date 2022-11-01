package se.fk.contact.information.service;

import se.fk.contact.information.domain.ContactInformation;
import se.fk.contact.information.domain.ContactInformationId;
import se.fk.party.common.PartyId;

import java.util.List;

public interface ContactInformationService {
    List<ContactInformation> getContactInformationByPartyId(PartyId partyId);
    ContactInformation getContactInformationById(ContactInformationId contactInformationId);
    ContactInformationId addContactInformation(ContactInformation contactInformation,PartyId partyId);
    ContactInformation removeContactInformation(ContactInformationId contactInformationId,PartyId partyId);
}
