package FirstScript;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class PlaywrightBasic {
    public static void main(String[] args) {

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch();
        Page page = browser.newPage();
        page.navigate("https:\\www.google.com");

        String title = page.title();
        System.out.println("Page title is: "+title);
        String url = page.url();
        System.out.println("URL is: "+url);

        browser.close();
        playwright.close();
    }
}
