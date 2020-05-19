package OPT3.Controllers;

import OPT3.Helpers.ApiInterface;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.Base64;

public class LoginScreenController {
    @FXML
    public Button loginButton;
    @FXML
    TextField usernameField;

    @FXML
    TextField passwordField;

    private final ApiInterface apiInterface = ApiInterface.getInstance();

    public LoginScreenController() throws IOException {
    }

    @FXML
    public void loginButtonClicked() throws IOException, ParseException {
        Base64.Encoder encodeCredentials = Base64.getEncoder();
        String usernameEncoded = encodeCredentials.encodeToString(usernameField.getText().getBytes());
        String passwordEncoded = encodeCredentials.encodeToString(passwordField.getText().getBytes());
        String[][] headers = {{"Authentication", "Basic " + usernameEncoded + ":" + passwordEncoded}};
        JSONObject response = apiInterface.post("login", headers);
        System.out.println(response);
    }
}
