package se.fk.contact.information.domain;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.vm.VM;
import se.fk.contact.information.domain.fixture.EmailContactInformationTestFixture;

public class TestContactInformation {
    @Test
    void testBuildEmailContactInformation() {
        ContactInformation expected = EmailContactInformationTestFixture.build();
        ContactInformation actual = EmailContactInformation.builder()
                .email("test@test.com")
                .contactInformationId(ContactInformationId.builder()
                        .id(1L)
                        .build())
                .build();
        Assertions.assertAll(
                () -> Assertions.assertEquals(expected, actual),
                () -> Assertions.assertEquals(expected.getContactInformationId(), actual.getContactInformationId())
       );
        System.out.println(actual);
        AddressContactInformation addressContactInformation = AddressContactInformation
                .builder()
                .contactInformationId(ContactInformationId.builder().id(4L).build())
                .city("city")
                .number(3)
                .postNumber(3L)
                .street("street")
                .build();
        System.out.println(VM.current().details());
        System.out.println(VM.current().sizeOf(addressContactInformation));

        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.setPrettyPrinting().create();
        System.out.println(gson.toJson((ContactInformation)addressContactInformation));
        System.out.println(gson.toJson(expected));
    }
}
