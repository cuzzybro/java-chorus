import com.microsoft.playwright.*;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TestBase {

    protected Playwright playwright;
    protected Browser browser;
    protected BrowserContext context;
    protected Page page;
    protected Properties props;
    protected String Url;

    @BeforeSuite
    public void build() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
            .withHeadless(false)
        );
        try (InputStream stream = new FileInputStream("config.properties")) {
            props = new Properties();
            props.load(stream);
        } catch(IOException e) {
            e.printStackTrace();
        }

        Url = props.getProperty("baseUrl");
        System.out.println(Url);
    }

    @BeforeTest
    public void launchSession() {
        context = browser.newContext();
        page = context.newPage();
    }

    @AfterTest
    public void endSession() {
        page.close();
        context.close();
    }

    @AfterSuite
    public void tearDown() throws Exception{
        browser.close();
        playwright.close();

    }


}
