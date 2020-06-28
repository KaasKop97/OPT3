package OPT3.Helpers;

import OPT3.Controllers.CustomerDetailsController;
import OPT3.Models.Customer;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MiscHelper {

    public static HttpURLConnection setupRequest(String full_url_and_path) throws IOException {
        // This sets up the request and also returns the stream.
        URL url = new URL(full_url_and_path);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setDoOutput(true);
        conn.setRequestProperty("api_key", ApiInterface.ApiKey);
        // Cache be an evil mistress yarr...
        conn.setUseCaches(false);
        return conn;
    }
    public static String readContentFromRequest(InputStream data) throws IOException {
        BufferedReader in = new BufferedReader(
                new InputStreamReader(data));
        String inputLine;
        StringBuilder content = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();
        return content.toString();
    }
}
