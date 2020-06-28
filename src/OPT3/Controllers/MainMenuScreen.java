package OPT3.Controllers;

import OPT3.Helpers.GetRequest;
import OPT3.Models.Address;
import OPT3.Models.Company;
import OPT3.Models.Consumer;
import OPT3.Models.Customer;
import OPT3.ViewNavigator;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.ArrayList;

public class MainMenuScreen {
    public Button openCompanyDetailsButton;
    public Button openConsumerDetailsButton;
    public TableView<Company> CompanyTableView;
    public TableView<Customer> ConsumerTableView;
    private CustomerDetailsController customerDetailsController;

    public void initialize() throws IOException, ParseException {
        GetRequest test = new GetRequest();
        JSONObject getAllCompanies = test.makeRequest("/customer/company/get_all");
        ArrayList companyResults = (ArrayList) getAllCompanies.get("result");
        ObservableList<Company> companyList = CompanyTableView.getItems();
        for (int i = 0; i < companyResults.size(); i++) {
            System.out.println(companyResults.get(i));
            ArrayList tempCompanyList = (ArrayList) companyResults.get(i);
            JSONObject getAddressInfo = test.makeRequest("/customer/address/" + tempCompanyList.get(4).toString());
            ArrayList addressResult = (ArrayList) getAddressInfo.get("result");
            addressResult = (ArrayList) addressResult.get(0);
            Address address = new Address(addressResult.get(1).toString(), addressResult.get(2).toString(), addressResult.get(4).toString(), addressResult.get(3).toString(), addressResult.get(5).toString());
            companyList.add(new Company(tempCompanyList.get(0).toString(), tempCompanyList.get(1).toString(), tempCompanyList.get(2).toString(), tempCompanyList.get(3).toString(), address));
        }

        GetRequest getRequestGetConsumers = new GetRequest();
        JSONObject getAllConsumers = getRequestGetConsumers.makeRequest("/customer/consumer/get_all");
        ArrayList consumerResults = (ArrayList) getAllConsumers.get("result");
        System.out.println(consumerResults);
        ObservableList<Customer> customerList = ConsumerTableView.getItems();
        System.out.println(customerList.size());
        for (int i = 0; i < consumerResults.size(); i++) {
            System.out.println(consumerResults.get(i));
            ArrayList tempConsumerResults = (ArrayList) consumerResults.get(i);
            System.out.println(tempConsumerResults);
            JSONObject getAddressInfo = getRequestGetConsumers.makeRequest("/customer/address/" + tempConsumerResults.get(4).toString());
            ArrayList addressResult = (ArrayList) getAddressInfo.get("result");
            addressResult = (ArrayList) addressResult.get(0);
            System.out.println(addressResult);
            Address address = new Address(addressResult.get(1).toString(), addressResult.get(2).toString(), addressResult.get(4).toString(), addressResult.get(3).toString(), addressResult.get(5).toString());

            customerList.add(new Customer(
                            Integer.parseInt(tempConsumerResults.get(0).toString()),
                            tempConsumerResults.get(1).toString(),
                            tempConsumerResults.get(2).toString(),
                            tempConsumerResults.get(3).toString(),
                            tempConsumerResults.get(4).toString(),
                            address
                    )
            );
        }
    }

    public void openCustomerDetailsButtonPressed() {

    }

    public void openConsumerDetailsButtonPressed() throws IOException {
        Customer customer = ConsumerTableView.getSelectionModel().getSelectedItem();
        System.out.println("Customer name: " + customer.name);
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../Views/CustomerDetails.fxml"));
        Parent root = fxmlLoader.load();
        CustomerDetailsController controller = fxmlLoader.getController();
        controller.initData(customer);
        Scene scene = new Scene(root, 600, 400);
        Stage stage = new Stage();
        stage.setTitle("Customer details");
        stage.setScene(scene);
        stage.show();
    }
}
