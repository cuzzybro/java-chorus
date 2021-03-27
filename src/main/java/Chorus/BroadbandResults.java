package Chorus;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;

import java.util.List;

public class BroadbandResults extends Chorus {

    String notAvailable = "//div[contains(@class, 'not-available')]/following-sibling::div/span";
    String available = "//div[@class='top-label']/following-sibling::div/span";
    String onRequest = "//div[contains(@class,'available-on-request')]/following-sibling::div/span";
    String mightBeAvailable = "//div[contains(@class,'might-be-available')]/following-sibling::div/span";
    String current = "//div[contains(@class, 'current-connection')]/following-sibling::div/span";

    public BroadbandResults(Page page) {
        super(page);
        page.waitForLoadState(LoadState.NETWORKIDLE);
    }

    public void getAvailableOptions() {
        printOptions(available);
        printOptions(current);
    }

    public void getCurrentOptions() {
        printOptions(current);
    }

    private void printOptions(String selector) {
        List<ElementHandle> collection = page.querySelectorAll(selector);
        collection.forEach(element -> System.out.println(element.textContent()));
    }


}
