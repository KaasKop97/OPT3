package OPT3.Controllers;

import OPT3.Models.Customer;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class CustomerDetailsController {
    @FXML
    public Label nameLabel;

    public CustomerDetailsController() {
    }

    public void initData(Customer customer)  {
        nameLabel.setText(customer.name);
    }
}
