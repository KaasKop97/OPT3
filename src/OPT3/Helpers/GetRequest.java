package OPT3.Helpers;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.net.HttpURLConnection;

public class GetRequest extends ApiInterface implements GetRequestInterface {

    @Override
    public JSONObject makeRequest(String path) throws IOException, ParseException {
        // Code Smells
        HttpURLConnection conn = MiscHelper.setupRequest(ApiUrl + path);
        conn.setRequestMethod("GET");
        conn.connect();
        String content = MiscHelper.readContentFromRequest(conn.getInputStream());
        conn.disconnect();
        JSONParser parser = new JSONParser();
        Object jsonObj = parser.parse(content);

        return (JSONObject) jsonObj;
    }
}
