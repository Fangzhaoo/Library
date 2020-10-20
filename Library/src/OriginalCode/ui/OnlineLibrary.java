package OriginalCode.ui;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class OnlineLibrary implements Serializable{
    public void printHTML(String theURL) throws MalformedURLException, IOException{
        BufferedReader br = null;
        try {
            URL url = new URL(theURL);
            br = new BufferedReader(new InputStreamReader(url.openStream()));

            String line;

            StringBuilder sb = new StringBuilder();

            while ((line = br.readLine()) != null) {

                sb.append(line);
                sb.append(System.lineSeparator());
            }

            System.out.println(sb);
        } finally {

            if (br != null) {
                br.close();
            }
        }
    }
    public  void browse2(String url) throws URISyntaxException, IOException{
        Desktop desktop = Desktop.getDesktop();
        if (Desktop.isDesktopSupported() && desktop.isSupported(Desktop.Action.BROWSE)) {
            URI uri = new URI(url);
            desktop.browse(uri);
        }
    }
    public void browse() throws URISyntaxException, IOException {
        Desktop desktop = Desktop.getDesktop();
        if (Desktop.isDesktopSupported() && desktop.isSupported(Desktop.Action.BROWSE)) {
            URI uri = new URI("http://www.library.ubc.ca");
            desktop.browse(uri);
        }
    }
}

