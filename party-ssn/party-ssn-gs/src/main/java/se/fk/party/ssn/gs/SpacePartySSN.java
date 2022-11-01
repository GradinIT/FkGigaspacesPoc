package se.fk.party.ssn.gs;

import com.gigaspaces.annotation.pojo.SpaceClass;
import com.gigaspaces.annotation.pojo.SpaceId;
import com.gigaspaces.annotation.pojo.SpaceRouting;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import se.fk.party.common.PartyId;
import se.fk.party.ssn.common.NationalPersonId;

import java.io.Serializable;

@SpaceClass
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class SpacePartySSN implements Serializable {
    private PartyId partyId;
    private NationalPersonId nationalPersonId;
    @SpaceId
    @SpaceRouting
    public PartyId getPartyId(){
        return this.partyId;
    }
}
