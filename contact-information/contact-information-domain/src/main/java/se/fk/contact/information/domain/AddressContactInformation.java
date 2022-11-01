package se.fk.contact.information.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
@EqualsAndHashCode(callSuper = true)
public class AddressContactInformation extends ContactInformation {
    private final String street;
    private final Integer number;
    private final String city;
    private final Long postNumber;
}
