package OPT3.Controllers;

import OPT3.Helpers.GetRequest;
import OPT3.Models.Company;
import OPT3.Models.Consumer;
import OPT3.Models.Customer;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.ArrayList;

public class MainMenuScreen {
    public Button openCompanyDetailsButton;
    public TableView<Company> CompanyTableView;
    public TableView<Customer> ConsumerTableView;

    public void initialize() throws IOException, ParseException {
        GetRequest test = new GetRequest();
        JSONObject getAllCompanies = test.makeRequest("/customer/company/get_all");
        ArrayList companyResults = (ArrayList) getAllCompanies.get("result");
        ObservableList<Company> companyList = CompanyTableView.getItems();
        for (int i = 0; i < companyResults.size(); i++) {
            System.out.println(companyResults.get(i));
            ArrayList temp = (ArrayList) companyResults.get(i);
            companyList.add(new Company(temp.get(0).toString(), temp.get(1).toString(), temp.get(2).toString(), temp.get(3).toString()));
        }

        GetRequest idk = new GetRequest();
        JSONObject getAllConsumers = idk.makeRequest("/customer/consumer/get_all");
        ArrayList consumerResults = (ArrayList) getAllConsumers.get("result");
        System.out.println(consumerResults);
        ObservableList<Customer> customerList = ConsumerTableView.getItems();
        System.out.println(customerList.size());
        for (int i = 0; i < consumerResults.size(); i++) {
            System.out.println(consumerResults.get(i));
            ArrayList xd = (ArrayList) consumerResults.get(i);
            customerList.add(new Customer(
                            Integer.parseInt(xd.get(0).toString()),
                            xd.get(1).toString(),
                            xd.get(2).toString(),
                            xd.get(3).toString(),
                            xd.get(4).toString())
            );
        }
    }
}
