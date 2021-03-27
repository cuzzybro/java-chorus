import Chorus.Chorus;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class BroadBandCheckerTests extends TestBase {

    protected List<String> options;

    @Test
    public void testCheckBroadBandServicesAtAddress() {
        page.navigate(Url);
        options = chorus.broadbandCheckerPage()
                .enterAddress("220 Tinakori Road, Thorndon, Wellington")
                .clickFoundAddress()
                .getAvailableOptions();

        options.forEach(System.out::println);
        try {
            assert options.contains("Fibre Pro");
            assert options.contains("Hyperfibre");
            assert options.contains("Fibre");
        } catch (AssertionError err) {
            err.printStackTrace();
        }
    }
}
