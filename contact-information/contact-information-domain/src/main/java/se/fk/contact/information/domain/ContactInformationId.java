package se.fk.contact.information.domain;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
@SuperBuilder
@Getter
@EqualsAndHashCode
@ToString
public class ContactInformationId implements Serializable {
    @NonNull
    private final Long id;
}
