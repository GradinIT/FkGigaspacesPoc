package se.fk.contact.information.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
@EqualsAndHashCode(callSuper = true)
public class CoAddressContactInformation extends AddressContactInformation{
    private final String co;
}
