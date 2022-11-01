import com.j_spaces.core.IJSpace;
import org.openspaces.core.GigaSpace;
import org.openspaces.core.GigaSpaceConfigurer;
import org.openspaces.core.space.UrlSpaceConfigurer;
import org.openspaces.remoting.ExecutorRemotingProxyConfigurer;
import se.fk.party.common.PartyId;
import se.fk.party.ssn.common.NationalPersonId;
import se.fk.party.ssn.common.SwedishNationalPersonId;
import se.fk.party.ssn.service.PartySsnService;

public class PartySsnTest {
    static IJSpace space = null;
    static GigaSpace gigaSpace = null;
    static PartySsnService partySsnService = null;

    public static void main(String[] args) {
        space = (new UrlSpaceConfigurer("jini://*/*/partySsnSpace")).lookupLocators("localhost").space();
        gigaSpace = (new GigaSpaceConfigurer(space)).gigaSpace();
        partySsnService = (PartySsnService) (new ExecutorRemotingProxyConfigurer(gigaSpace, PartySsnService.class)).proxy();
        NationalPersonId nationalPersonId = SwedishNationalPersonId.builder()
                .id("201701012393")
                .build();
        System.out.println(nationalPersonId.isValid());
        System.out.println(partySsnService.addPartyIdNationalPersonId(
                PartyId.builder().id(1L).build(),
                nationalPersonId
        ));
    }
}

