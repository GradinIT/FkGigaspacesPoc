package se.fk.contact.information.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
@EqualsAndHashCode(callSuper = true)
public class EmailContactInformation extends ContactInformation {
    @NonNull
    private final String email;

    @Override
    public String toString() {
        return "EmailContactInformation{" +
                "email='" + email + '\'' +
                " contactInformation='" + super.toString() + '\'' +
                '}';
    }
}
