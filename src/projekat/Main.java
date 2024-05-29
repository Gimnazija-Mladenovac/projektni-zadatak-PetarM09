package projekat;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {
    public static void main(String[] args) {
        launch();
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        Scene scene = new Scene(new MainView(), 1000, 1000);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Petar Milanovic");
        primaryStage.show();
    }
}
