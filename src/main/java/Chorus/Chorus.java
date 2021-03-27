package Chorus;


import com.microsoft.playwright.Page;

public class Chorus {

    Page page;

    public Chorus(Page page) {
        this.page = page;
    }

    public BroadbandCheckerPage broadbandCheckerPage() {
        page.click("//h3[text()='Broadband checker']");
        return new BroadbandCheckerPage(page);
    }


}
