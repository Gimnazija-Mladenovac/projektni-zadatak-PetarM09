package projekat;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch();
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Petar Milanovic");
        primaryStage.setWidth(300);
        primaryStage.setHeight(200);
        primaryStage.show();
    }
}
