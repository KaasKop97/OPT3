package OPT3.Controllers;

import OPT3.ViewNavigator;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

public class MainController {
    @FXML
    private StackPane MainScreenStackPane;

    @FXML
    public Button HBoxButtonBack;

    public void setView(Node node) {
        MainScreenStackPane.getChildren().setAll(node);
    }

    @FXML
    public void HBoxButtonBackPressed() {
        //ViewNavigator.showView(ViewNavigator.mainOverviewScreen);
    }

    @FXML
    public void HBoxOnMouseEntered() {

    }

}
