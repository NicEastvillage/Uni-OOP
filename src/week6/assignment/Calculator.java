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

import java.util.Optional;

public class Calculator extends Application {

    private static final double RES_HEIGHT = 82;
    private static final Font RES_FONT = new Font(24);
    private static final Insets RES_PADDING = new Insets(10);

    private static final double BUTTON_WIDTH = 73;
    private static final double BUTTON_HEIGHT = 54;
    private static final Font BUTTON_FONT = new Font(20);

    private static final double WINDOW_WIDTH = BUTTON_WIDTH * 4;
    private static final double WINDOW_HEIGHT = BUTTON_HEIGHT * 5 + RES_HEIGHT;

    private Optional<String> lastCalculation;
    private Label expLabel;
    private CalculatorInputManager inputManager = new CalculatorInputManager();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        // Root component
        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);

        // Top label
        expLabel = new Label("0");
        expLabel.setMinSize(WINDOW_WIDTH, RES_HEIGHT);
        expLabel.setFont(RES_FONT);
        expLabel.setAlignment(Pos.CENTER_RIGHT);
        expLabel.setPadding(RES_PADDING);
        root.getChildren().add(expLabel);
        expLabel.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, null, null)));
        lastCalculation = Optional.empty();

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

    private void updateExpressionLabel() {
        if (inputManager.getInputString().equals("")) {
            if (lastCalculation.isPresent()) {
                expLabel.setText(lastCalculation.get());
            } else {
                expLabel.setText("0");
            }
        } else {
            expLabel.setText(inputManager.getInputString());
        }
    }

    private GridPane constructGrid() {
        GridPane grid = new GridPane();

        for (int i = 0; i < 10; i++) {
            int col, row;
            if (i == 0) {
                col = 1;
                row = 4;
            } else {
                col = (i - 1) % 3;
                row = 3 - ((i - 1) / 3);
            }
            char ch = (char)('0' + i);
            Button but = createGridButton(grid, "" + i, col, row);
            but.setOnMouseClicked(e -> addChar(ch));
        }

        Button commaButton = createGridButton(grid, ".", 0, 4);
        commaButton.setOnMouseClicked(e -> addChar('.'));

        Button plusButton = createGridButton(grid, "+", 3, 1);
        Button minusButton = createGridButton(grid, "-", 3, 2);
        Button timesButton = createGridButton(grid, "*", 3, 3);
        Button divideButton = createGridButton(grid, "/", 3, 4);
        plusButton.setOnMouseClicked(e -> addChar('+'));
        minusButton.setOnMouseClicked(e -> addChar('-'));
        timesButton.setOnMouseClicked(e -> addChar('*'));
        divideButton.setOnMouseClicked(e -> addChar('/'));

        Button resButton = createGridButton(grid, "=", 2, 4);
        resButton.setOnMouseClicked(ev -> {
            try {
                double res = inputManager.calculate();
                lastCalculation = Optional.of("" + res);
                inputManager.clear();
                updateExpressionLabel();
            } catch (Exception ex) {
                // Do nothing
            }
        });

        Button negateButton = createGridButton(grid, "+/-", 0, 0);
        negateButton.setOnMouseClicked(e -> {
            inputManager.negate();
            updateExpressionLabel();
        });

        Button backspaceButton = createGridButton(grid, "<", 1, 0);
        backspaceButton.setOnMouseClicked(e -> {
            inputManager.removeChar();
            updateExpressionLabel();
        });

        Button clearButton = createGridButton(grid, "C", 2, 0);
        clearButton.setOnMouseClicked(e -> {
            inputManager.clear();
            lastCalculation = Optional.empty();
            updateExpressionLabel();
        });

        return grid;
    }

    private void addChar(char ch) {
        inputManager.addCharacter(ch);
        updateExpressionLabel();
    }

    private Button createGridButton(GridPane grid, String label, int col, int row) {
        Button but = new Button(label);
        but.setMinSize(BUTTON_WIDTH, BUTTON_HEIGHT);
        but.setFont(BUTTON_FONT);
        but.setFocusTraversable(false);

        grid.add(but, col, row);
        return but;
    }
}
