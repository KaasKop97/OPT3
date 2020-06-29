package OPT3.Helpers;

import java.io.*;
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
}
