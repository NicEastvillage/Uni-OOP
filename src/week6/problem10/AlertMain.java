package week6.problem10;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class AlertMain extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        // Root component
        HBox root = new HBox();
        root.setAlignment(Pos.CENTER);

        // Button
        Button button = new Button("Click me!");
        root.getChildren().add(button);
        button.setOnMouseClicked(e -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "You clicked the button!");
            alert.showAndWait();
        });

        // Scene and show
        Scene scene = new Scene(root, 350, 210);
        stage.setScene(scene);
        stage.setTitle("Problem 10 - Alert");
        stage.show();
    }
}