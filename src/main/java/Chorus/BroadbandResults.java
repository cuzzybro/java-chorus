package Chorus;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;

import java.util.ArrayList;
import java.util.List;

public class BroadbandResults extends Chorus {

    // page object selectors
    String notAvailable = "//div[contains(@class, 'not-available')]/following-sibling::div/span";
    String available = "//div[@class='top-label']/following-sibling::div/span";
    String onRequest = "//div[contains(@class,'available-on-request')]/following-sibling::div/span";
    String mightBeAvailable = "//div[contains(@class,'might-be-available')]/following-sibling::div/span";
    String current = "//div[contains(@class, 'current-connection')]/following-sibling::div/span";

    // constructor - include navigation logic in here
    public BroadbandResults(Page page) {
        super(page);
        page.waitForLoadState(LoadState.NETWORKIDLE);
    }

    // methods
    // return list of available options
    public List<String> getAvailableOptions() {
        List<String> availableCollection = getCollectionText(page.querySelectorAll(available));
        List<String> currentCollection = getCollectionText(page.querySelectorAll(current));
        availableCollection.addAll(currentCollection);
        return availableCollection;
    }

    // print current option if it exists
    public void getCurrentOptions() {
        printOptions(current);
    }

    // private reusable methods
    private void printOptions(String selector) {
        List<ElementHandle> collection = page.querySelectorAll(selector);
        collection.forEach(element -> System.out.println(element.textContent()));
    }

    private List<String> getCollectionText(List<ElementHandle> collection) {
        List<String> newCollection = new ArrayList<>();
        collection.forEach(element -> newCollection.add(element.textContent().trim()));
        return newCollection;
    }


}
