package week6.assignment;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Calculator extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        // Root component
        HBox root = new HBox();
        root.setAlignment(Pos.CENTER);

        // Top label
        Label statusLabel = new Label("Res:");
        root.getChildren().add(statusLabel);
        statusLabel.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, null, null)));

        // Number grid
        GridPane grid = constructGrid();
        root.getChildren().add(grid);

        // Scene and show
        Scene scene = new Scene(root, 350, 210);
        stage.setScene(scene);
        stage.setTitle("Calculator");
        stage.show();
    }

    private GridPane constructGrid() {
        GridPane grid = new GridPane();

        for (int i = 0; i < 10; i++) {
            Button button = new Button("" + i);
            int col, row;
            if (i == 0) {
                col = 1;
                row = 3;
            } else {
                col = (i - 1) % 3;
                row = 2 - ((i - 1) / 3);
            }
            grid.add(button, col, row);
        }

        Button commaButton = new Button(".");
        grid.add(commaButton, 0, 3);
        Button resButton = new Button("=");
        grid.add(resButton, 2, 3);

        return grid;
    }
}
