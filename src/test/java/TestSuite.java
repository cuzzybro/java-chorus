import Chorus.Chorus;
import org.testng.annotations.Test;

public class TestSuite extends TestBase {

    @Test
    public void firstTest() {
        page.navigate(Url);
        Chorus chorus = new Chorus(page);
        chorus.broadbandCheckerPage()
                .enterAddress("220 Tinakori Road, Thorndon, Wellington")
                .clickFoundAddress()
                .getAvailableOptions();
    }
}
