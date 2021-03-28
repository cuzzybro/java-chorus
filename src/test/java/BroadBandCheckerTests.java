
import org.testng.Assert;
import org.testng.annotations.Test;
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

        options.forEach(System.out::println);
        try {
            Assert.assertEquals(options.get(0), "Fibre Pro");
            Assert.assertEquals(options.get(1), "Hyperfibre");
            Assert.assertEquals(options.get(2), "Fibre");
        } catch (AssertionError err) {
            err.printStackTrace();
        }
    }

}
