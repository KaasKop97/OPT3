package OPT3.Helpers;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.net.MalformedURLException;

public interface PostRequestInterface {
    JSONObject makeRequest(String path);
    JSONObject makeRequest(String path, String[][] headers) throws IOException, ParseException;
    JSONObject makeRequest(String path, String[][] headers, String body) throws IOException, ParseException;
}
