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

        // Scene and Keyboard listener
        Scene scene = new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT);
        setupKeyboardListener(scene);

        // Show
        stage.setScene(scene);
        stage.setTitle("Calculator");
        stage.setResizable(false);
        stage.show();
    }

    /** Update the label show the current calculation or result. */
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

    /** Construct the grid of buttons. */
    private GridPane constructGrid() {
        GridPane grid = new GridPane();

        // Numbers
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

        // Operators
        Button plusButton = createGridButton(grid, "+", 3, 1);
        Button minusButton = createGridButton(grid, "-", 3, 2);
        Button timesButton = createGridButton(grid, "*", 3, 3);
        Button divideButton = createGridButton(grid, "/", 3, 4);
        plusButton.setOnMouseClicked(e -> addChar('+'));
        minusButton.setOnMouseClicked(e -> addChar('-'));
        timesButton.setOnMouseClicked(e -> addChar('*'));
        divideButton.setOnMouseClicked(e -> addChar('/'));

        Button resButton = createGridButton(grid, "=", 2, 4);
        resButton.setOnMouseClicked(ev -> finishCalculation());

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

    /** Calculate the result if possible. */
    private void finishCalculation() {
        try {
            double res = inputManager.calculate();
            lastCalculation = Optional.of("" + res);
            inputManager.clear();
            updateExpressionLabel();
        } catch (Exception ex) {
            // Do nothing
        }
    }

    /** Helper function to add a char to the input manager and update label. */
    private void addChar(char ch) {
        inputManager.addCharacter(ch);
        updateExpressionLabel();
    }

    /** Create and setup button for the grid. */
    private Button createGridButton(GridPane grid, String label, int col, int row) {
        Button but = new Button(label);
        but.setMinSize(BUTTON_WIDTH, BUTTON_HEIGHT);
        but.setFont(BUTTON_FONT);
        but.setFocusTraversable(false);

        grid.add(but, col, row);
        return but;
    }

    /** Add the keyboard event handler to the scene. */
    private void setupKeyboardListener(Scene scene) {
        scene.setOnKeyPressed(event -> {
            switch (event.getCode()) {
                case NUMPAD0: case DIGIT0:        addChar('0'); return;
                case NUMPAD1: case DIGIT1:        addChar('1'); return;
                case NUMPAD2: case DIGIT2:        addChar('2'); return;
                case NUMPAD3: case DIGIT3:        addChar('3'); return;
                case NUMPAD4: case DIGIT4:        addChar('4'); return;
                case NUMPAD5: case DIGIT5:        addChar('5'); return;
                case NUMPAD6: case DIGIT6:        addChar('6'); return;
                case NUMPAD7: case DIGIT7:        addChar('7'); return;
                case NUMPAD8: case DIGIT8:        addChar('8'); return;
                case NUMPAD9: case DIGIT9:        addChar('9'); return;
                case COMMA: case PERIOD:          addChar('.'); return;

                case PLUS: case ADD:              addChar('+'); return;
                case MINUS: case SUBTRACT:        addChar('-'); return;
                case STAR: case ASTERISK: case MULTIPLY:     addChar('*'); return; // FIXME Neither of these are the star next to enter :(
                case SLASH: case DIVIDE:          addChar('/'); return;

                case ENTER:                       finishCalculation(); return;
                case BACK_SPACE:                  inputManager.removeChar(); updateExpressionLabel(); return;
                case ESCAPE: case C: case DELETE:
                    inputManager.clear();
                    lastCalculation = Optional.empty();
                    updateExpressionLabel();
                    return;
            }
        });
    }
}
