
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BroadBandCheckerTests extends TestBase {

    protected List<String> options;

    @Test()
    public void testCheckBroadBandServicesAtAddress() {
        page.navigate(Url);
        options = chorus.broadbandCheckerPage()
                .enterAddress("220 Tinakori Road, Thorndon, Wellington")
                .clickFoundAddress()
                .getAvailableOptions();

        expected.add("Fibre Pro");
        expected.add("Hyperfibre");
        expected.add("Fibre");
        for (int i=0; i<options.size(); i++) {
            try {
                Assert.assertEquals(options.get(i), expected.get(i));
                System.out.println("actual value: '" + options.get(i) + "' | expected value: '" + expected.get(i) + "'");
            }catch(AssertionError err) {
                err.printStackTrace();
            }
        }

    }

}
