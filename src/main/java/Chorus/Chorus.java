package Chorus;


import com.microsoft.playwright.Page;

public class Chorus {
    // create persistent page object
    Page page;

    // Page object selectors
    String broadbandChecker = "//h3[text()='Broadband checker']";


    // constructor requires page object - set page
    public Chorus(Page page) {
        this.page = page;
    }

    // method
    public BroadbandCheckerPage broadbandCheckerPage() {
        page.click(broadbandChecker);
        return new BroadbandCheckerPage(page);
    }

    public BroadbandResults broadbandResults() {
        return new BroadbandResults(page);
    }


}
