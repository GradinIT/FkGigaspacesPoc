package se.fk.contact.information.domain.fixture;

import se.fk.contact.information.domain.ContactInformation;
import se.fk.contact.information.domain.ContactInformationId;
import se.fk.contact.information.domain.EmailContactInformation;

public class EmailContactInformationTestFixture {
    private static final EmailContactInformation.EmailContactInformationBuilder builder = EmailContactInformation.builder();

    public static EmailContactInformation build() {
        return (EmailContactInformation) builder.email("test@test.com").contactInformationId(ContactInformationId.builder().id(1L).build()).build();
    }

}
