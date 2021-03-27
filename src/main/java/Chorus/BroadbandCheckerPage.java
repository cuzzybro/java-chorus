package Chorus;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;
import com.microsoft.playwright.options.WaitForSelectorState;

public class BroadbandCheckerPage extends Chorus {

    String addressInputField = "//input[@placeholder='Enter your address here']";
    String addressOption = "//div[@class='address-options-list-container']//li";

    public BroadbandCheckerPage(Page page) {
        super(page);
    }

    public BroadbandCheckerPage enterAddress(String address) {
        page.waitForLoadState(LoadState.DOMCONTENTLOADED);
        page.waitForSelector(addressInputField,
                new Page.WaitForSelectorOptions().setState(WaitForSelectorState.ATTACHED)).click();
        page.type(addressInputField, address, new Page.TypeOptions().setDelay(50));
        return this;
    }

    public BroadbandResults clickFoundAddress() {
        page.waitForSelector(addressOption,
                new Page.WaitForSelectorOptions().setState(WaitForSelectorState.ATTACHED)).click();
        return new BroadbandResults(page);
    }


}
