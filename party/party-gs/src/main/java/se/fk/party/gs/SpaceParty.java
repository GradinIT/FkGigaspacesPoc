package se.fk.party.gs;

import com.gigaspaces.annotation.pojo.SpaceClass;
import com.gigaspaces.annotation.pojo.SpaceId;
import com.gigaspaces.annotation.pojo.SpaceRouting;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import se.fk.contact.information.domain.ContactInformationId;
import se.fk.party.common.PartyId;
import se.fk.party.common.domain.RelationType;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@SpaceClass
@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SpaceParty implements Serializable {
    private PartyId partyId;
    private String givenName;
    private String familyName;
    private Map<PartyId, RelationType> relations;
    private List<ContactInformationId> contactInformation;
    @SpaceId
    @SpaceRouting
    public PartyId getPartyId() {
        return this.partyId;
    }
}
