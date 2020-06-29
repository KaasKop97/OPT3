package OPT3.Helpers;

import OPT3.Models.Address;
import OPT3.Models.Customer;
import javafx.stage.Stage;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

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

    public static void updateCustomer(Customer customer) throws IOException, ParseException {
        PostRequest postRequest = new PostRequest();
        String[][] headers = {{"Content-Type", "application/json"}};

        // This doesn't really sit well with me in terms of feeling,
        // It feels messy and it is, i could've implemented an solution to make it look more elegant but that'd have taken ages.
        // And i couldn't find a library to do it for me since somehow java hates json :(
        String body = "{\n\t\"ID\": \"" + customer.getID() + "\",\n" +
                "\t\"name\": \"" + customer.name + "\",\n" +
                "\t\"email_address\": \"" + customer.email_address + "\",\n" +
                "\t\"telephone_number\": \"" + customer.telephone_number + "\"\n" +
                "}";
        postRequest.makeRequest("customer/consumer/edit", headers, body);
    }

    public static void updateCustomer(Customer customer, Address address) throws IOException, ParseException {
        PostRequest postRequest = new PostRequest();
        String[][] headers = {{"Content-Type", "application/json"}};
        // Why redo when you can re-use :)
        MiscHelper.updateCustomer(customer);
        String body = "{\n\t\"ID\": \"" + address.id + "\",\n" +
                "\t\"street\": \"" + address.street_name + "\",\n" +
                "\t\"street_number\": \"" + address.street_number + "\",\n" +
                "\t\"city\": \"" + address.city + "\",\n" +
                "\t\"postal_code\": \"" + address.postal_code + "\"\n}";
        postRequest.makeRequest("customer/address/edit", headers, body);
    }

    public static Address getAddressInfo(String id) throws IOException, ParseException {
        GetRequest getRequest = new GetRequest();
        JSONObject getAddressInfo = getRequest.makeRequest("/customer/address/" + id);
        ArrayList addressResult = (ArrayList) getAddressInfo.get("result");
        addressResult = (ArrayList) addressResult.get(0);
        return new Address(Integer.parseInt(addressResult.get(0).toString()), addressResult.get(1).toString(), addressResult.get(2).toString(), addressResult.get(4).toString(), addressResult.get(3).toString(), addressResult.get(5).toString());
    }
}
