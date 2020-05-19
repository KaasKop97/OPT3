package OPT3;

import OPT3.Controllers.MainController;
import javafx.fxml.FXMLLoader;

import java.io.IOException;

public class ViewNavigator {
    public static final String MainScreen = "Views/MainScreen.fxml";
    public static final String MainMenuScreen = "Views/MainMenuScreen.fxml";
    public static final String LoginScreen = "Views/LoginScreen.fxml";

    private static MainController mainController;

    public static String currentView = "";

    public static void setMainController(MainController mainController) {
        ViewNavigator.mainController = mainController;
    }

    public static void showView(String fxml_name) {
        System.out.println("Showing: " + fxml_name);
        try {
            mainController.setView(
                    FXMLLoader.load(
                            ViewNavigator.class.getResource(fxml_name)
                    )
            );
            ViewNavigator.currentView = fxml_name;
        } catch (IOException e) {
            System.out.println("IOException occurred.");
            e.printStackTrace();
        }
    }
}
