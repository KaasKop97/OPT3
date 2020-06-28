package OPT3.Controllers;

import OPT3.Helpers.PostRequest;
import OPT3.Models.Customer;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.ArrayList;

public class CustomerDetailsController {
    // Original customer so we can check locally if the user has done any changes to any field
    Customer originalCustomer;
    @FXML
    public TextField nameTextField;
    public TextField emailTextField;
    public TextField telephoneTextField;

    public Button cancelButton;

    public CustomerDetailsController() {
    }

    public void initData(Customer customer)  {
        originalCustomer = customer;
        nameTextField.setText(customer.name);
        emailTextField.setText(customer.email_address);
        telephoneTextField.setText(customer.telephone_number);
    }

    @FXML
    public void okButtonPressed() throws IOException, ParseException {
        System.out.println("Saving changes...");
        ArrayList<String> values_to_update = new ArrayList<>();
        if (!nameTextField.getText().equals(originalCustomer.name))    {
            values_to_update.add("name");
        }
        if (!emailTextField.getText().equals(originalCustomer.email_address))   {
            values_to_update.add("email_address");
        }
        if (!telephoneTextField.getText().equals(originalCustomer.telephone_number))    {
            values_to_update.add("telephone_number");
        }
        PostRequest postRequest = new PostRequest();
        String[][] headers = {{"Content-Type", "application/json"}};
        StringBuilder body = new StringBuilder();
        body.append("{\n\t\"ID\": \"" + originalCustomer.getID() + "\",\n");
        for (String value : values_to_update) {
            String bodyValue = "";
            if (value.equals("name"))    {
                bodyValue = nameTextField.getText();
            } else if (value.equals("email_address"))   {
                bodyValue = emailTextField.getText();
            } else if (value.equals("telephone_number"))   {
                bodyValue = telephoneTextField.getText();
            }
            body.append("\t\""+ value + "\": \"" + bodyValue + "\"");

            // This is to prevent a possible JSON parser error for a trailing comma.
            if (!value.equals(values_to_update.get(values_to_update.size() - 1)))    {
                body.append(",");
            }
            body.append("\n");
        }
        body.append("}");
        postRequest.makeRequest("customer/consumer/edit", headers, body.toString());
        Stage stage = (Stage)cancelButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void cancelButtonPressed()   {
        System.out.println("NOT saving changes...");
        Stage stage = (Stage)cancelButton.getScene().getWindow();
        stage.close();
    }
}
