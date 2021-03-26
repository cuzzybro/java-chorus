import com.microsoft.playwright.*;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class TestBase {

    protected Playwright playwright;
    protected Browser browser;
    protected BrowserContext context;
    protected Page page;

    @BeforeSuite
    public void build() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
            .withHeadless(false)
        );
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
    public void close() throws Exception{
        browser.close();
        playwright.close();

    }


}
