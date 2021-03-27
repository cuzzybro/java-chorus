import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Page;
import org.testng.annotations.Test;

import java.util.List;

public class TestSuite extends TestBase {

    @Test
    public void firstTest() {
        page.navigate(Url);
        page.click("//h3[text()='Broadband checker']");
        page.waitForLoadState(Page.LoadState.DOMCONTENTLOADED);
        page.waitForSelector("//input[@placeholder='Enter your address here']",
                new Page.WaitForSelectorOptions().withState(Page.WaitForSelectorOptions.State.ATTACHED)).click();
        page.type("//input[@placeholder='Enter your address here']", "220 Tinakori Road, Thorndon, Wellington", new Page.TypeOptions().withDelay(50));
        page.waitForSelector("//div[@class='address-options-list-container']//li",
                new Page.WaitForSelectorOptions().withState(Page.WaitForSelectorOptions.State.ATTACHED))
                .click();
        page.waitForLoadState(Page.LoadState.NETWORKIDLE);
        List<ElementHandle> notAvailable = page.querySelectorAll("//div[contains(@class, 'not-available')]/following-sibling::div/span");
        List<ElementHandle> available = page.querySelectorAll("//div[@class='top-label']/following-sibling::div/span");
        List<ElementHandle> onRequest = page.querySelectorAll("//div[contains(@class,'available-on-request')]/following-sibling::div/span");
        List<ElementHandle> mightBeAvailable = page.querySelectorAll("//div[contains(@class,'might-be-available')]/following-sibling::div/span");
        ElementHandle current = page.querySelector("//div[contains(@class, 'current-connection')]/following-sibling::div/span");

        notAvailable.forEach(element -> System.out.println(element.textContent() + " - not available / supported"));
        available.forEach(element -> System.out.println(element.textContent() + " - available!!"));
        onRequest.forEach(element -> System.out.println(element.textContent() + " - available on request..."));
        mightBeAvailable.forEach(element -> System.out.println(element.textContent() + " - might be available..."));

        try {
            System.out.println(current.textContent() + " - current connection type");
        } catch(Exception e) {
            System.out.println("no current chorus connection found...");
        }
    }
}
