import org.testng.annotations.Test;

public class TestSuite extends TestBase {

    @Test
    public void firstTest() {
        page.navigate(Url);
        page.waitForTimeout(2000);
    }
}
