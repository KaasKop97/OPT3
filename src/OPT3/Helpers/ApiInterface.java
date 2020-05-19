package OPT3.Helpers;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class ApiInterface {
    public static final String ApiUrl = "http://127.0.0.1:5000/";
    public static String ApiKey = "";

    public ApiInterface() {
        try {
            File apiKeyFile = new File("src/OPT3/Helpers/ApiKey");
            Scanner reader = new Scanner(apiKeyFile);
            while (reader.hasNext())    {
                ApiKey = reader.nextLine();
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("ERROR: File does not exist.");
        }
    }

    public static void makeRequest() {

    }

//    public JSONObject post(String path, String[][] headers) throws IOException, ParseException {
//        URL url = new URL(ApiUrl + path);
//        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//        conn.setDoOutput(true);
//        conn.setRequestMethod("POST");
//        for (String[] header : headers) {
//            conn.setRequestProperty(header[0], header[1]);
//        }
//        conn.setRequestProperty("api_key", ApiKey);
//        conn.setUseCaches(false);
//        conn.connect();
//        // Code smells, added a new class which handles reading from the input stream as that is a common method to execute.
//        // And it'd just result into duplicate code and we always need to keep DRY :)
//        String content = MiscHelper.readContentFromRequest(conn.getInputStream());
//        conn.disconnect();
//        JSONParser parser = new JSONParser();
//        Object jsonObj = parser.parse(content);
//
//        JSONObject jsonObject = (JSONObject) jsonObj;
//        System.out.println(((JSONObject) jsonObj).get("result"));
//        return new JSONObject();
//    }
}
