package OPT3.Controllers;

import OPT3.Helpers.MiscHelper;
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
import java.util.regex.Pattern;

public class CustomerDetailsController {
    // Original customer so we can check locally if the user has done any changes to any field
    Customer originalCustomer;
    Customer customer;
    @FXML
    public TextField nameTextField;
    public TextField emailTextField;
    public TextField telephoneTextField;
    public TextField streetNameTextField;
    public TextField streetNumberTextField;
    public TextField cityTextField;
    public TextField postalCodeTextField;

    public Button cancelButton;

    public CustomerDetailsController() {
    }

    public void initData(Customer customer) {
        this.customer = customer;
        originalCustomer = customer;
        nameTextField.setText(customer.name);
        emailTextField.setText(customer.email_address);
        telephoneTextField.setText(customer.telephone_number);
        streetNameTextField.setText(customer.address.street_name);
        streetNumberTextField.setText(customer.address.street_number);
        cityTextField.setText(customer.address.city);
        postalCodeTextField.setText(customer.address.postal_code);
    }

    @FXML
    public void okButtonPressed() throws IOException, ParseException {
        Boolean addressUpdate = false;
        if (!nameTextField.getText().equals(originalCustomer.name)) {
            customer.setName(nameTextField.getText());
        }
        if (!emailTextField.getText().equals(originalCustomer.email_address)) {
            customer.setEmail_address(emailTextField.getText());
        }
        if (!telephoneTextField.getText().equals(originalCustomer.telephone_number)) {
            customer.setTelephone_number(telephoneTextField.getText());
        }

        if (!streetNameTextField.getText().equals(originalCustomer.address.street_name)) {
            addressUpdate = true;
            customer.address.setStreet_name(streetNameTextField.getText());
        }
        if (!streetNumberTextField.getText().equals(originalCustomer.address.street_number)) {
            addressUpdate = true;
            customer.address.setStreet_number(streetNumberTextField.getText());
        }
        if (!cityTextField.getText().equals(originalCustomer.address.city)) {
            addressUpdate = true;
            customer.address.setCity(cityTextField.getText());
        }
        if (!postalCodeTextField.getText().equals(originalCustomer.address.postal_code)) {
            addressUpdate = true;
            customer.address.setPostal_code(postalCodeTextField.getText());
        }
        if (addressUpdate) {
            if (!streetNameTextField.getText().isEmpty() && Pattern.matches("[0-9]+", streetNumberTextField.getText())
                    && !cityTextField.getText().isEmpty() && Pattern.matches("\\d{4} [a-zA-Z]{2}", postalCodeTextField.getText())) {
                MiscHelper.updateCustomer(customer, customer.address);
            }
        } else {
            MiscHelper.updateCustomer(customer);
        }

        MiscHelper.updateCustomer(customer);
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void cancelButtonPressed() {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }
}
