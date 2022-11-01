package se.fk.contact.information.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
@EqualsAndHashCode(callSuper = true)
public class LandLineContactInformation extends ContactInformation{
    private final String landLineNumber;
}
