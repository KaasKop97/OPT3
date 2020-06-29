package OPT3;

import OPT3.Controllers.MainController;
import javafx.fxml.FXMLLoader;

import java.io.IOException;

public class ViewNavigator {
    public final String MainScreen = "Views/MainScreen.fxml";
    public final String MainMenuScreen = "Views/MainMenuScreen.fxml";
    public final String LoginScreen = "Views/LoginScreen.fxml";

    private static MainController mainController;
    public String currentView = "";

    private static ViewNavigator singleton = new ViewNavigator();

    private ViewNavigator() {
    }

    public static ViewNavigator getInstance() {
        return singleton;
    }

    public void setMainController(MainController mainController) {
        ViewNavigator.mainController = mainController;
    }

    public void showView(String fxml_name) {
        System.out.println("Showing: " + fxml_name);
        try {
            mainController.setView(
                    FXMLLoader.load(
                            ViewNavigator.class.getResource(fxml_name)
                    )
            );
            this.currentView = fxml_name;
        } catch (IOException e) {
            System.out.println("IOException occurred.");
            e.printStackTrace();
        }
    }
}
