package week6.assignment;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Calculator extends Application {

    private static final double RES_HEIGHT = 82;
    private static final Font RES_FONT = new Font(20);
    private static final Insets RES_PADDING = new Insets(10);

    private static final double BUTTON_WIDTH = 73;
    private static final double BUTTON_HEIGHT = 54;
    private static final Font BUTTON_FONT = new Font(20);

    private static final double WINDOW_WIDTH = BUTTON_WIDTH * 3 + 2;
    private static final double WINDOW_HEIGHT = BUTTON_HEIGHT * 4 + RES_HEIGHT;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        // Root component
        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);

        // Top label
        Label statusLabel = new Label("0");
        statusLabel.setMinSize(WINDOW_WIDTH, RES_HEIGHT);
        statusLabel.setFont(RES_FONT);
        statusLabel.setAlignment(Pos.CENTER_RIGHT);
        statusLabel.setPadding(RES_PADDING);
        root.getChildren().add(statusLabel);
        statusLabel.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, null, null)));

        // Number grid
        GridPane grid = constructGrid();
        root.getChildren().add(grid);

        // Scene and show
        Scene scene = new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT);
        stage.setScene(scene);
        stage.setTitle("Calculator");
        stage.show();
    }

    private GridPane constructGrid() {
        GridPane grid = new GridPane();

        for (int i = 0; i < 10; i++) {
            Button button = new Button("" + i);
            button.setMinSize(BUTTON_WIDTH, BUTTON_HEIGHT);
            button.setFont(BUTTON_FONT);
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
        commaButton.setMinSize(BUTTON_WIDTH, BUTTON_HEIGHT);
        commaButton.setFont(BUTTON_FONT);
        grid.add(commaButton, 0, 3);

        Button resButton = new Button("=");
        resButton.setMinSize(BUTTON_WIDTH, BUTTON_HEIGHT);
        resButton.setFont(BUTTON_FONT);
        grid.add(resButton, 2, 3);

        return grid;
    }
}
