package OPT3.Controllers;

import OPT3.Helpers.ApiInterface;
import OPT3.Helpers.PostRequest;
import OPT3.ViewNavigator;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import javax.swing.text.View;
import java.io.IOException;
import java.util.Base64;

public class LoginScreenController {
    @FXML
    public Button loginButton;
    @FXML
    TextField usernameField;

    @FXML
    TextField passwordField;

    Boolean success;
    Boolean result;

    private final PostRequest postRequest = new PostRequest();

    public LoginScreenController() throws IOException {

    }

    @FXML
    public void loginButtonClicked() throws IOException, ParseException {
        Base64.Encoder encodeCredentials = Base64.getEncoder();
        String usernameEncoded = encodeCredentials.encodeToString(usernameField.getText().getBytes());
        String passwordEncoded = encodeCredentials.encodeToString(passwordField.getText().getBytes());
        String[][] headers = {{"Authentication", "Basic " + usernameEncoded + ":" + passwordEncoded}};
        JSONObject response = postRequest.makeRequest("login", headers);
        PostRequest.makeRequest();
        success = Boolean.parseBoolean(String.valueOf(response.get("status").toString().equals("success")));
        result = Boolean.parseBoolean(response.get("result").toString());
        if (success && result) {
            ViewNavigator vwn = ViewNavigator.getInstance();
            vwn.showView(vwn.MainMenuScreen);
        }
    }
}
