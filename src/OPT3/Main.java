package OPT3;

import OPT3.Controllers.MainController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("OPT3");
        stage.setScene(createScene(loadMainPane()));
        stage.show();
    }

    private Pane loadMainPane() {
        FXMLLoader loader = new FXMLLoader();
        Pane mainPane = null;
        ViewNavigator vwn = ViewNavigator.getInstance();
        try {
            mainPane = (Pane) loader.load(getClass().getResourceAsStream(vwn.MainScreen));
        } catch (IOException e) {
            System.out.println("IOException, cannot load mainScreen");
            e.printStackTrace();
        }

        MainController mainController = loader.getController();

        vwn.setMainController(mainController);
        vwn.showView(vwn.LoginScreen);
        return mainPane;
    }

    private Scene createScene(Pane mainPane)    {
        return new Scene(mainPane, 800, 600);
    }

    public static void main(String[] args) {
        launch(args);
    }

}
