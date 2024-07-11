import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class PrimeRevenueTests {

    private static Document document;

    @BeforeAll
    public static void setUp() throws IOException {
        document = Jsoup.connect("https://www.primerevenue.com").get();
    }

    @Test
    public void testPageLoadingStatus() throws IOException {
        Connection.Response response = Jsoup.connect("https://www.primerevenue.com").execute();
        assertEquals(200, ((Connection.Response) response).statusCode(), "The page should return a 200 OK status");
    }

    @Test
    public void testLoginPresence() {
        Elements loginElements = document.select("a[href*='login'], a:contains(login), a:contains(Login)");
        assertTrue(loginElements.size() > 0, "The document should contain a login link or element.");
    }


    @Test
    public void testTitle() {
        String title = document.title();
        assertEquals("PrimeRevenue", title, "Page title should be 'PrimeRevenue'");
    }


    @Test
    public void testBasicHtmlStructure() {
        Element head = document.select("head").first();
        assertTrue(head != null, "The document should contain a <head> element.");

        Element body = document.select("body").first();
        assertTrue(body != null, "The document should contain a <body> element.");

        Element title = document.select("title").first();
        assertTrue(title != null && !title.text().isEmpty(), "The document should have a non-empty <title> element.");
    }

    @Test
    public void testMetaTags() {
        Elements metaCharset = document.select("meta[charset]");
        assertTrue(metaCharset.size() > 0, "The document should contain a <meta charset> tag.");

        Elements metaViewport = document.select("meta[name=viewport]");
        assertTrue(metaViewport.size() > 0, "The document should contain a <meta name='viewport'> tag.");
    }

    @Test
    public void testHeaderAndFooterPresence() {
        Elements headers = document.select("header");
        assertTrue(headers.size() > 0, "The document should contain a <header> element.");

        Elements footers = document.select("footer");
        assertTrue(footers.size() > 0, "The document should contain a <footer> element.");
    }

    @Test
    public void testMainNavigationMenuPresence() {
        Elements navElements = document.select("nav[role='navigation']");
        assertTrue(navElements.size() > 0, "The document should contain a main <nav> element with role='navigation'.");
    }


    @Test
    public void testLinksAndImagesPresence() {
        Elements links = document.select("a[href]");
        assertTrue(links.size() > 0, "The document should contain at least one <a> link.");

        Elements images = document.select("img");
        assertTrue(images.size() > 0, "The document should contain at least one <img> image.");
    }

}
