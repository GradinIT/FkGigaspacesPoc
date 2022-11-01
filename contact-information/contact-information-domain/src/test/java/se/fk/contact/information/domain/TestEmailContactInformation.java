package se.fk.contact.information.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import se.fk.contact.information.domain.fixture.EmailContactInformationTestFixture;

class TestEmailContactInformation {
    @Test
    void testBuildEmailContactInformation() {
        EmailContactInformation expected = EmailContactInformationTestFixture.build();
        EmailContactInformation actual = EmailContactInformation.builder()
                .email("test@test.com")
                .contactInformationId(ContactInformationId.builder()
                        .id(1L)
                        .build())
                .build();
        Assertions.assertAll(
                () -> Assertions.assertEquals(expected, actual),
                () -> Assertions.assertEquals(expected.getContactInformationId(), actual.getContactInformationId()),
                () -> Assertions.assertEquals(expected.getEmail(), actual.getEmail())
        );
    }
}
