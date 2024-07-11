package org.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        // URL of the webpage to fetch
        String url = "https://www.primerevenue.com";

        try {
            // Connect to the webpage and fetch the HTML document
            Document document = Jsoup.connect(url).get();

            // Print the title of the webpage
            System.out.println("Title of the page: " + document.title());
        } catch (IOException e) {
            // Print any exceptions (such as network issues)
            e.printStackTrace();
        }
    }
}