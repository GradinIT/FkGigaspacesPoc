package se.fk.party.common;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;

@Builder
@Getter
@EqualsAndHashCode
@ToString
public class PartyId implements Serializable {
    private final Long id;
}
