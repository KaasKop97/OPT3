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
    public String ApiKey = "";

    private static final ApiInterface singleton = new ApiInterface();

    public static ApiInterface getInstance()    {
        return singleton;
    }

    private ApiInterface() {
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

    public JSONObject post(String path, String[][] headers) throws IOException, ParseException {
        URL url = new URL(ApiUrl + path);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setDoOutput(true);
        conn.setRequestMethod("POST");
        for (String[] header : headers) {
            System.out.println(header[0] + " " + header[1]);
            conn.setRequestProperty(header[0], header[1]);
        }

        conn.setRequestProperty("api_key", ApiKey);
        conn.setUseCaches(false);
        conn.connect();

        BufferedReader in = new BufferedReader(
                new InputStreamReader(conn.getInputStream()));
        String inputLine;
        StringBuilder content = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();
        conn.disconnect();
        JSONParser parser = new JSONParser();
        Object jsonObj = parser.parse(content.toString());

        JSONObject jsonObject = (JSONObject) jsonObj;
        System.out.println(((JSONObject) jsonObj).get("result"));
        return new JSONObject();
    }
}
