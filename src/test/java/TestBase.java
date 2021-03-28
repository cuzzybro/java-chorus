import Chorus.Chorus;
import com.microsoft.playwright.*;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class TestBase {

    protected Playwright playwright;
    protected Browser browser;
    protected BrowserContext context;
    protected Page page;
    protected Chorus chorus;
    protected Properties props;
    protected String Url;
    protected List<String> expected;

    @BeforeSuite
    public void build() {
        // create property object
        try (InputStream stream = new FileInputStream("config.properties")) {
            props = new Properties();
            props.load(stream);
        } catch(IOException e) {
            e.printStackTrace();
        }
        // set property values
        boolean headless = Boolean.getBoolean(props.getProperty("headless"));
        Url = props.getProperty("baseUrl");
        // initialise the playwright instance.
        playwright = Playwright.create();

        browser = playwright.chromium().launch(new BrowserType
                .LaunchOptions()
                .setHeadless(headless)
        );

    }

    @BeforeTest(alwaysRun = true)
    public void launchSession() {
        // create playwright session
        context = browser.newContext();
        page = context.newPage();
        chorus = new Chorus(page);
        expected = new ArrayList<>();
    }

    @AfterTest(alwaysRun = true)
    public void endSession() {
        // close session
        page.close();
        context.close();
    }

    @AfterSuite
    public void tearDown() {
        // end instance
        browser.close();
        playwright.close();
    }


}
