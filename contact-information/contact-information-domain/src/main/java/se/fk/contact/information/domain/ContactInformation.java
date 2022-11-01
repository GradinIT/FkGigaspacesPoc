package se.fk.contact.information.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@SuperBuilder
@EqualsAndHashCode
@Getter
@ToString
public class ContactInformation implements Serializable {
    @NonNull
    private ContactInformationId contactInformationId;
}
