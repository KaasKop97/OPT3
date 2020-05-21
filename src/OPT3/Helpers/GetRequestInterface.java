package OPT3.Helpers;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public interface GetRequestInterface {
    JSONObject makeRequest(String path) throws IOException, ParseException;
}
