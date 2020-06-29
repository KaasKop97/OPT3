package OPT3.Helpers;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class PostRequest extends ApiInterface implements PostRequestInterface {
    @Override
    public JSONObject makeRequest(String path) {
        return null;
    }

    @Override
    public JSONObject makeRequest(String path, String[][] headers) throws IOException, ParseException {
        // Code Smells, setting up the request is always the same, better to house the logic in a separate class and method.
        HttpURLConnection conn = MiscHelper.setupRequest(ApiUrl + path);
        conn.setRequestMethod("POST");
        for (String[] header : headers) {
            conn.setRequestProperty(header[0], header[1]);
        }
        conn.connect();
        // Code smells, added a new class which handles reading from the input stream as that is a common method to execute.
        // And it'd just result into duplicate code and we always need to keep DRY :)
        String content = MiscHelper.readContentFromRequest(conn.getInputStream());
        conn.disconnect();
        JSONParser parser = new JSONParser();
        Object jsonObj = parser.parse(content);

        return (JSONObject) jsonObj;
    }

    @Override
    public JSONObject makeRequest(String path, String[][] headers, String body) throws IOException, ParseException {
        // Code Smells, setting up the request is always the same, better to house the logic in a separate class and method.
        HttpURLConnection conn = MiscHelper.setupRequest(ApiUrl + path);
        conn.setRequestMethod("POST");
        for (String[] header : headers) {
            conn.setRequestProperty(header[0], header[1]);
        }

        OutputStream os = conn.getOutputStream();
        os.write(body.getBytes(StandardCharsets.UTF_8));
        conn.connect();

        String content = MiscHelper.readContentFromRequest(conn.getInputStream());
        conn.disconnect();
        JSONParser parser = new JSONParser();
        Object jsonObj = parser.parse(content);

        return (JSONObject) jsonObj;
    }
}
