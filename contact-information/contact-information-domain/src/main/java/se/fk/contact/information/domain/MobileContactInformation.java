package se.fk.contact.information.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
@EqualsAndHashCode(callSuper = true)
public class MobileContactInformation extends ContactInformation {
    @NonNull
    private final String mobileNumber;
}
