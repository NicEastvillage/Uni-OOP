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
    private static final Font RES_FONT = new Font(24);
    private static final Insets RES_PADDING = new Insets(10);

    private static final double BUTTON_WIDTH = 73;
    private static final double BUTTON_HEIGHT = 54;
    private static final Font BUTTON_FONT = new Font(20);

    private static final double WINDOW_WIDTH = BUTTON_WIDTH * 4;
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
        stage.setResizable(false);
        stage.show();
    }

    private GridPane constructGrid() {
        GridPane grid = new GridPane();

        for (int i = 0; i < 10; i++) {
            int col, row;
            if (i == 0) {
                col = 1;
                row = 3;
            } else {
                col = (i - 1) % 3;
                row = 2 - ((i - 1) / 3);
            }
            Button but = createGridButton(grid, String.valueOf(i).charAt(0), col, row);
        }

        Button commaButton = createGridButton(grid, '.', 0, 3);
        Button resButton = createGridButton(grid, '=', 2, 3);

        Button plusButton = createGridButton(grid, '+', 3, 0);
        Button minusButton = createGridButton(grid, '-', 3, 1);
        Button timesButton = createGridButton(grid, '*', 3, 2);
        Button divideButton = createGridButton(grid, '/', 3, 3);

        return grid;
    }

    private Button createGridButton(GridPane grid, char ch, int col, int row) {
        Button but = new Button("" + ch);
        but.setMinSize(BUTTON_WIDTH, BUTTON_HEIGHT);
        but.setFont(BUTTON_FONT);

        grid.add(but, col, row);
        return but;
    }
}
